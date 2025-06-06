pipeline {
    agent any

    tools {
        jdk 'jdk-21'
        gradle 'gradle-8.14.1'
    }

    environment {
        JAVA_HOME = "${tool 'jdk-21'}"
        PATH = "${env.JAVA_HOME}/bin:${env.PATH}"
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Run TDD Tests') {
            steps {
                sh './gradlew test'
            }
        }

        stage('Run BDD Tests') {
            steps {
                sh './gradlew cucumber'
            }
        }
    }

    post {
        always {
            junit 'build/test-results/test/*.xml'
        }
    }
}
