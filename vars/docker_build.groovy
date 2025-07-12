def call(String projectName, String imageTag, String dockerHubUser) {
    script {
        def imageFullName = "${dockerHubUser}/${projectName}:${imageTag}"
        echo "🔥 Building image: ${imageFullName}"
        sh "docker build -t ${imageFullName} ."
    }
}
