pipeline {
    agent any
    options {
        timestamps()
    }
    stages {
        stage('Checkout') {
            steps {
                echo('Source code checkout')
            }
        }
        stage('Build') {
            steps {
                echo('Source code compile')
            }
        }
        stage('Quality') {
            parallel {
                stage('Sonar gateway') {
                    steps {
                        echo('Sonarqube quality gateway')
                    }
                }
                stage('Unit testing') {
                    steps {
                        echo('Unit testing')
                    }
                }
            }
        }
        stage('Archive') {
            steps {
                echo('Archiving artifacts')
            }
        }
        stage('Deploy') {
            steps {
                echo('Deploying')
            }
        }
    }
}
