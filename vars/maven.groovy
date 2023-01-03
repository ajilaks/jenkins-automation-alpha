def build(String command) {
    sh("./mvnw ${command}")
}
