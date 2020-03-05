#!/usr/bin/env groovy

pipeline {
    agent any
    stages {
        stage('docker build') {
            steps {
                script {
                    sh "docker pull dineshba/jenkins-ssh-slave-with-docker"
                }
            }
        }
    }
}