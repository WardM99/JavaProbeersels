/* Requires the Docker Pipeline plugin */
pipeline {
    agent { docker { image 'maven:3.9.4-eclipse-temurin-17-alpine' } }
    stages {
        stage('Validate') {
            steps {
                dir('my-app') {
                    sh 'mvn validate'
                }
            }
        }
        stage('Test') {
            steps {
               dir('my-app') {
                    sh 'mvn test'
                }
            }
        }
    }
}
