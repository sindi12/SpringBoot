pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                echo 'Checkout-ing project'
                git 'https://github.com/sindi12/SpringBoot.git'
                echo 'Checkout Success!'
            }
        }
        stage('Build Artifact') {
            steps {
                echo 'Building artifact...'
                sh 'mvn clean install'
                echo 'Success'
            }
        }

        stage('Create artifact copy') {
            steps {
                sh 'cp target/SpringBoot-*.jar target/SpringBoot-RELEASE.jar'
            }
        }
        
        stage('Create Docker Image') {
            steps {
                sh 'docker build -t SpringBoot_image .'
            }
        }
        stage('Run Container') {
            steps {
                sh 'docker stop SpringBoot'
                sh 'docker rm SpringBoot'
                sh 'docker run -d -p 8080:8080 --link config_service:config_service --name SpringBoot SpringBoot_image'
            }
        }
    }
}