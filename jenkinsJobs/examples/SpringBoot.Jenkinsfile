pipeline {
    agent any
    triggers {
        pollSCM 'H/5 * * * *'
    }
    options {
        timestamps()
        timeout(time: 30, unit: 'MINUTES')
        buildDiscarder(logRotator(daysToKeepStr: '30', numToKeepStr: '20'))
    }
    parameters {
        string(name: 'docker_image_tag', defaultValue: 'latest', description: 'Docker Image Tag')
        string(name: 'docker_image_name', defaultValue: 'springboot-jenkins-demo', description: 'Docker Image Name')
        string(name: 'docker_container_port', defaultValue: '8080:8080', description: 'Docker Container Port')
    }
    stages {
        stage('Build Jar File') {
            tools {
                jdk('jdk17')
            }
            steps {
                sh 'chmod +x gradlew && ./gradlew clean assemble'
            }
        }
        stage('Build Docker Image') {
            steps {
                sh "docker build -t ${params.docker_image_name}:${params.docker_image_tag} ."
            }
        }
        stage('Run Docker Image') {
            steps {
                sh "docker stop ${params.docker_image_name} || true"
                sh "docker run -d -p ${params.docker_container_port} --name ${params.docker_image_name} ${params.docker_image_name}:${params.docker_image_tag}"
            }
        }
    }
}
