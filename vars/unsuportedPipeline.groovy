def call (){
    pipeline {
        agent any
        stages {
            stage("Unsuported Pipeline") {
                steps {
                    echo("Unsuported Pipeline Type")
                }
            }
        }
    }
}
