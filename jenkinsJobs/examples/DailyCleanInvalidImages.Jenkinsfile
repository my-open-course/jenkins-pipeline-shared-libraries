pipeline {
    agent any
    options {
        timestamps()
        disableConcurrentBuilds()
        timeout(time: 30, unit: 'MINUTES')
        buildDiscarder(logRotator(daysToKeepStr: '30', numToKeepStr: '20'))
    }
    triggers {
        cron('H 0 * * *')
    }
    stages {
        stage('Clean Invalid Images') {
            steps {
                sh 'docker images'
                sh 'docker image prune -f'
            }
        }
    }
}
