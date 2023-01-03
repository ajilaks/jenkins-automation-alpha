def call(Map app, List commands){
    if (app.type == "java") {
        mavenPipeline(app, commands)
    } else {
        unsuportedPipeline()
    }

}
