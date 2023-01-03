def build(String command) {
    sh("chmod +x mvnw")
    echo("executing ./mvnw ${command}")
    sh("_JAVA_OPTIONS=\"-Xmx512m\" ./mvnw ${command}")
}
