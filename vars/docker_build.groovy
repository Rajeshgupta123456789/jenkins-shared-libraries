def call(String ProjectName, String ImageTag, String DockerHubUser) {
  script {
    echo "⚠️ Using DockerHub user: ${DockerHubUser}"
    def fullTag = "${DockerHubUser}/${ProjectName}:${ImageTag}"
    echo "🔨 Building Docker image: ${fullTag}"
    echo "🧪 DEBUG: docker_build.groovy latest version"
    sh "docker build -t ${fullTag} ."
  }
}
