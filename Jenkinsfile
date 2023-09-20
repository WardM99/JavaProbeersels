/* Requires the Docker Pipeline plugin */
pipeline {
    agent { docker { image 'maven:3.9.4-eclipse-temurin-17-alpine' } }
    stages {
        stage('Validate') {
            steps {
                dir('scripts') {
                    sh 'mvn validate'
                }
            }
        }
        stage('Test') {
            steps {
               dir('scripts') {
                    sh 'mvn test'
                }
            }
        }
    }
}
