def buildApp() {
    echo 'Building application ...'
//    echo "Printing environment variable ${NEW_VERSION}"
//    sh "mvn build"
}

def testApp() {
    echo 'Testing application ...'
//    echo "Printing environment variable ${NEW_VERSION}"
//    sh 'echo credentials script $SERVER_CREDENTIALS_USR:$SERVER_CREDENTIALS_PSW'
}

def buildJar() {
    echo 'Building jar file ...'
    sh "mvn package"
}

def deployApp() {
    echo 'Deploying application ...'
//    echo "Version ${params.VERSION}"
    withCredentials([
            usernamePassword(credentialsId: "nexus-repo-credentials", usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')
            // usernamePassword() because we are using this type of credentials
            // USERNAME & PASSWORD are variable we can use inside the bloc
    ]){
        sh 'docker build -t 143.198.46.19:8083/jenkins-test:1.1 .'
        sh 'echo $PASSWORD | docker login -u $USERNAME --password-stdin 143.198.46.19:8083'
        sh 'docker push 143.198.46.19:8083/jenkins-test:1.1d'
    }
}

return this