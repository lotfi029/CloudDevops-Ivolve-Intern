def call(String manifestPath) {
    sh "kubectl apply -f ${manifestPath}"
}
