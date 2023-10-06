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
    }
}
