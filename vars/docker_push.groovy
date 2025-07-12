withCredentials([usernamePassword(credentialsId: 'docker', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')]) {
    sh """
      echo \$DOCKER_PASS | docker login -u \$DOCKER_USER --password-stdin
    """
}
