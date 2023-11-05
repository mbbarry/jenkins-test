def buildApp() {
    echo 'Building application ...'
    echo "Printing environment variable ${NEW_VERSION}"
    sh "mvn -version "
}

def testApp() {
    echo 'Testing application ...'
    echo "Printing environment variable ${NEW_VERSION}"
    sh 'echo credentials script $SERVER_CREDENTIALS_USR:$SERVER_CREDENTIALS_PSW'
}

def deployApp() {
    echo 'Deploying application ...'
    echo "Version ${params.VERSION}"

    withCredentials([
            usernamePassword(credentialsId: "nexus-repo-credentials", usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')
            // usernamePassword() because we are using this type of credentials
            // USERNAME & PASSWORD are variable we can use inside the bloc
    ]){
        sh 'echo script $USERNAME $PASSWORD'
    }
}

// all importing this file
return this