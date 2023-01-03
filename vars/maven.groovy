def build(String command) {
    sh("chmod +x mvnw")
    echo("executing ./mvnw ${command}")
}
