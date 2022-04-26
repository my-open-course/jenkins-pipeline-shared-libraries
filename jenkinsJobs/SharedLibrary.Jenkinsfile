@Library('shared-library') _

pipeline {
    agent any
    stages {
        stage('Test Shared Library') {
            steps {
                script {
                    println("Result: " + mathArithmetic.add(1, 3))
                }
            }
        }
    }
}
