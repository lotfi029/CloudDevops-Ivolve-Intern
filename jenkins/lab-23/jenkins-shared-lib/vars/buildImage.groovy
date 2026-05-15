def call(String imageName, String tag, String appDir = '.') {
    dir(appDir) {
        sh "docker build -t ${imageName}:${tag} ."
    }
}
