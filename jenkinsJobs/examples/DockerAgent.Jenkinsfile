pipeline {
    agent {
        docker 'openjdk:17-jdk-alpine'
    }
    options {
        timestamps()
        disableConcurrentBuilds()
        timeout(time: 30, unit: 'MINUTES')
        buildDiscarder(logRotator(daysToKeepStr: '30', numToKeepStr: '20'))
    }
    stages {
        stage('Build') {
            steps {
                sh 'java -version'
            }
        }
    }
}
