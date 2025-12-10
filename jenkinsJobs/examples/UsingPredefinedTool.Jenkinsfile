pipeline {
    agent any
    options {
        timestamps()
    }
    tools {
        git 'Default'
        jdk 'jdk-11.0.20'
        maven 'maven-3.9.4'
        gradle 'gradle-4.10.3'
    }
    stages {
        stage('Build') {
            steps {
                sh 'git --version'
                sh 'java -version'
                sh 'mvn -version'
                sh 'gradle -version'
            }
        }
        stage('jdk8') {
            tools {
                jdk('jdk8')
            }
            steps {
                sh 'java -version'
            }
        }
        stage('jdk17') {
            tools {
                jdk('jdk17')
            }
            steps {
                sh 'java -version'
            }
        }
        stage('jdk21') {
            tools {
                jdk('jdk21')
            }
            steps {
                sh 'java -version'
            }
        }
    }
}
