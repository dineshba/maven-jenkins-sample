#!/usr/bin/env groovy

pipeline {
    agent any
    stages {
        stage('Validations') {
            parallel {
                stage('Testing') {
                    stages {
                        stage('Download Dependencies') {
                            steps {
                                sh './mvnw dependency:resolve'
                            }
                        }
                        stage('Test DB Setup') {
                            steps {
                                sh 'echo "Clean and setup TestDB for unit tests"'
                            }
                        }
                        stage('Junit') {
                            steps {
                                sh './mvnw clean test'
                                junit 'target/surefire-reports/*.xml'
                            }
                        }
                    }
                }

                stage('SonarQube') {
                    steps {
//                        sh '''./mvnw sonar:sonar \\
//                              -Dsonar.projectKey=sample-app \\
//                              -Dsonar.host.url=http://sonarqube:9000 \\
//                              -Dsonar.login=c784f4408fa11ee1918fbb098ad8101450d26747'''
                        sh 'echo "SonarQube"'
                    }
                }

            }
        }

        stage('build') {
            steps {
                sh './mvnw clean package -DskipTests'
                stash includes: 'target/*.jar', name: 'app'
            }
        }
        stage('docker build') {
            // agent {
            //    label 'with-docker'
            // }
            steps {
                unstash 'app'
                script {
                    def imageTag = "registry.gitlab.com/devops-venice/sample-app:${GIT_BRANCH}-${BUILD_NUMBER}"
                    sh "docker build -f docker/Dockerfile . -t ${imageTag} --label vcs-url:${GIT_URL} --label vcs-ref:${GIT_COMMIT}"
                }
            }
        }
    }
}