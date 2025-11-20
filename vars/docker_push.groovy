def call(String Project, String ImageTag, String dockerhubuser){
withCredentials([usernamePassword(credentialsId: 'DockerHub',
                                  usernameVariable: 'DOCKER_USER',
                                  passwordVariable: 'DOCKER_PASS')]) {

    sh """
        echo "$DOCKER_PASS" | docker login -u "$DOCKER_USER" --password-stdin
        docker push trainwithshubham/notes-app:latest
    """
}


  sh "docker push ${dockerhubuser}/${Project}:${ImageTag}"
}
