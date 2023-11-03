pipeline {
    agent any
    environment {
        NEW_VERSION="1.3.0"
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
            }
        }
    }
}
