def call(String ProjectName, String ImageTag, String DockerHubUser) {
  script {
    echo "⚠️ Using DockerHub user: ${DockerHubUser}"
    def fullTag = "${DockerHubUser}/${ProjectName}:${ImageTag}"
    echo "🔨 Building Docker image: ${fullTag}"
    sh "docker build -t ${fullTag} ."
  }
}
