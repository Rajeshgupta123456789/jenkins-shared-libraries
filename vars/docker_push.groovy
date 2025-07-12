def call(String projectName, String imageTag, String dockerHubUser) {
    script {
        def imageFullName = "${dockerHubUser}/${projectName}:${imageTag}"

        withCredentials([usernamePassword(
            credentialsId: 'docker',
            usernameVariable: 'DOCKER_USER',
            passwordVariable: 'DOCKER_PASS'
        )]) {
            echo "🔐 Logging into DockerHub as ${DOCKER_USER}"
            sh """
                echo \$DOCKER_PASS | docker login -u \$DOCKER_USER --password-stdin
                docker push ${imageFullName}
            """
        }
    }
}
