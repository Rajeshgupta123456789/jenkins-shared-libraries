def call(String Project, String ImageTag, String dockerhubuserParam) {
  withCredentials([
    usernamePassword(
      credentialsId: 'docker',
      usernameVariable: 'DOCKER_USER',
      passwordVariable: 'DOCKER_PASS'
    )
  ]) {
    sh """
      echo \$DOCKER_PASS | docker login -u \$DOCKER_USER --password-stdin
      docker push ${dockerhubuserParam}/${Project}:${ImageTag}
    """
  }
}
