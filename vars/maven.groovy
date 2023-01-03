def build(String command) {
    sh("chmod +x mvnw")
    echo("executing ./mvnw ${command}")
}

def buildMultiple(Map app, List commands) {
    echo("app type ${app.type}")
    echo("app version ${app.version}")
    for (command in commands) {
        echo("executing ./mvnw ${command}")
        sleep 5
    }

}
