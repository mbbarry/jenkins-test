pipeline {
    agent any
    environment {
        NEW_VERSION="1.3.0"
//         SERVER_CREDENTIALS = credentials('nexus-repo-credentials')
    }
    stages {
        stage('build') {
            steps {
                echo 'Building application ...'
                echo "Version ${NEW_VERSION}"
            }
        }
        stage('test') {
            steps {
                echo 'Testing application ...'
                echo "Version ${NEW_VERSION}"
            }
        }
        stage('deploy') {
            steps {
                echo 'Deploying application ...'
                echo "Version ${NEW_VERSION}"

                withCredentials([
                    usernamePassword(credentials : "nexus-repo-credentials", usernameVariable : USERNAME, passwordVariable : PASSWORD)
                    // usernamePassword() because we are using this type of credentials
                    // USERNAME & PASSWORD are variable we can use inside the bloc
                ]){
                    sh "Some script ${USERNAME} ${PASSWORD}"
                }
            }
        }
    }
}
