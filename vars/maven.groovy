def build(String command) {
    sh("chmod +x mvnw")
    echo("executing ./mvnw ${command}")
}

def buildMultiple(List commands) {
    for (command in commands) {
        echo("executing ./mvnw ${command}")
        sleep 5
    }

}
