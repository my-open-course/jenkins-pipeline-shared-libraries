pipeline {
    agent any
    options {
        timestamps()
    }
    tools {
        jdk 'jdk-11.0.20'
    }
    stages {
        stage('Build') {
            steps {
                sh 'java -version'
            }
        }
    }
}
