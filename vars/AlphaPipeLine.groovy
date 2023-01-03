def call(){
    pipeline {
        parameters {
            choice(name:"BUILD_TYPE", choices:['BUILD', 'SNAPSHOT', 'RELEASE'])
        }

        environment {
            INITIATING_MSG = "Initiate Job...."
            STARTING_MSG = "Starting Job...."
        }
        agent any
        stages {
            stage("Prepare") {
                environment {
                    APP = credentials("userrahasia")
                }
                steps {
                    echo("${INITIATING_MSG}")
                    script {
                        hello.world()
                        echo(author.name())
                        echo(author.site())
                    }
                    echo("Building App Start on Branch ${env.BRANCH_NAME}")
                }
            }
            stage("Build") {
                steps {
                    echo("${STARTING_MSG}")
                    echo("Build type: ${params.BUILD_TYPE}")
                    echo("Building App Start on Branch ${env.BRANCH_NAME}")
                    script {
                        hello.world()
                        maven.buildMultiple(
                                [type:"java", version:"current"],
                                ["clean", "test", "clean compile"])
                    }
                }
            }

            stage("Release") {
                when {
                    expression{
                        return params.BUILD_TYPE == 'RELEASE'
                    }
                }
                steps {
                    echo("EXECUTING RELEASE....")
                    sleep 20
                    echo("VERSION RELEASED")
                }
            }
        }
        post {
            always {
                echo "BUILD ADAAJA"
            }
            success {
                echo "BUILD SUCCESS"

            }
        }
    }

}
