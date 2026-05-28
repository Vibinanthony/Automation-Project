pipeline {

    agent any

    triggers {
        githubPush()
    }

    stages {

        stage('Checkout Code') {

            steps {

                echo 'Checking out code from development branch...'

                git branch: 'development',
                url: 'https://github.com/Vibinanthony/Automation-Project.git'
            }
        }

        stage('Build and Test') {

            steps {

                echo 'Running Maven build using pom.xml...'

                sh 'mvn clean test -f pom.xml'
            }
        }
    }

    post {

        success {
            echo 'Pipeline executed successfully.'
        }

        failure {
            echo 'Pipeline execution failed.'
        }
    }
}