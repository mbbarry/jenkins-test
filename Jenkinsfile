def gv
pipeline {
    agent any
    tools {
        maven "maven-3.9.5"
    }
    parameters {
        string(name : "STATEMENT", defaultValue : "hello ; ls", description : "Just for testing")
        choice(name : "VERSION", choices: ['1.1', '1.2', '1.3'], description : '')
        booleanParam(name : "executeTests", defaultValue : true, description : '')
    }
    environment {
        NEW_VERSION="1.3.0"
        SERVER_CREDENTIALS = credentials('nexus-repo-credentials')
    }
    stages {
        stage('init') {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage('build') {
            steps {
                script {
                    gv.buildApp()
                }
            }
        }
        stage('test') {
            when {
                expression {
                    params.executeTests // It can be also params.executeTests == true
                }
            }
            steps {
                script {
                    gv.testApp()
                }
            }
        }
        stage('buildJar') {
            steps {
                script {
                    gv.buildJar()
                }
            }
        }
        stage('deploy') {
//             input {
//                 message "Select the environment you want to deploy to"
//                 ok "Done"
//                 parameters {
//                         choice(name : "ENV", choices: ['DEV', 'STAGE', 'PROD'], description : '')
//                         // If wanna have multiple environments, just to duplicate the line choice
//                         // and give different name to your choices
//                     }
//             }
            steps {
                script {
                    // We also can use this instead of the attribute
                    env.ENV = input message: "Select the environment you want to deploy to", ok: "Done", parameters: [choice(name : "ENV", choices: ['DEV', 'STAGE', 'PROD'], description : '')]
                    gv.deployApp()
                    echo "Deploying to ${ENV}"
                }
            }
        }
    }
}
