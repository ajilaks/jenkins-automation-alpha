def build(String command) {
    sh("chmod +x mvnw")
    sh("./mvnw ${command}")
}
