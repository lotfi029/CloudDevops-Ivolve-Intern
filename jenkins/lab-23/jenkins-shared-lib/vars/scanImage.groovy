def call(String imageName, String tag) {
    sh """
        docker run --rm \
          -v /var/run/docker.sock:/var/run/docker.sock \
          aquasec/trivy:latest image --exit-code 0 \
          ${imageName}:${tag}
    """
}
