@Library('jenkins-pipeline-shared-libraries') _

pipeline {
    agent any
    stages {
        stage('Print Log') {
            steps {
                logUtility('这是Debug日志', 'debug')
                logUtility('这是Info日志', 'info')
                logUtility('这是Warn日志', 'warn')
                logUtility('这是Error日志', 'error')
            }
        }
    }
}
