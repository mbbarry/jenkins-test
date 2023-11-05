def buildApp() {
    echo 'Building application ...'
    echo "Printing environment variable ${NEW_VERSION}"
}

def testApp() {
    echo 'Testing application ...'
    echo "Printing environment variable ${NEW_VERSION}"
}

def deployApp() {
    echo 'Deploying application ...'
    echo "Version ${params.VERSION}"
}

// all importing this file
return this