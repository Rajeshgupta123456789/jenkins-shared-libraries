def call(String ProjectName, String ImageTag, String DockerHubUser) {
  script {
    def fullTag = "${DockerHubUser}/${ProjectName}:${ImageTag}"
    echo "🔨 Building Docker image: ${fullTag}"
    sh "docker build -t ${fullTag} ."
  }
}
