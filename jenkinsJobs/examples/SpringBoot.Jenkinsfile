pipeline {
    agent any
    triggers {
        pollSCM 'H/2 * * * *'
    }
    options {
        timestamps()
        timeout(time: 30, unit: 'MINUTES')
        buildDiscarder(logRotator(daysToKeepStr: '30', numToKeepStr: '20'))
    }
    parameters {
        string(name: 'docker_image_tag', defaultValue: 'latest', description: 'Docker Image Tag')
        string(name: 'docker_image_name', defaultValue: 'smart-health-backend', description: 'Docker Image Name')
        string(name: 'docker_container_port', defaultValue: '60000:60000', description: 'Docker Container Port')
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
                sh "docker rm ${params.docker_image_name} || true"
                sh "docker run -d -p ${params.docker_container_port} --name ${params.docker_image_name} ${params.docker_image_name}:${params.docker_image_tag}"
            }
        }
        stage('Health Check') {
            steps {
                script {
                    def healthStatus = "000"
                    def retryAttempt = 0
                    retry(5) {
                        if (retryAttempt > 0) {
                            sleep(30 + 20 * retryAttempt)
                        }
                        retryAttempt = retryAttempt + 1
                        def response = httpRequest consoleLogResponseBody: true, timeout: 3, url: "http://localhost:60000/actuator/health", httpMode: 'GET', quiet: true
                        healthStatus = "${response.status}"
                    }

                    if (healthStatus != "200") {
                        echo("Failed with status code: ${healthStatus}")
                        sh "docker logs ${params.docker_image_name}"
                    }
                }
            }
        }
    }
}
