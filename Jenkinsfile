#!/usr/bin/env groovy

def label = "worker-${UUID.randomUUID().toString()}"

podTemplate(label: label, containers: [
  containerTemplate(name: 'docker', image: 'docker:18.05-dind', command: 'cat', ttyEnabled: true)
]) {
    node(label) {
        stage('Docker') {
            container('docker') {
                sh """
                docker search docker
                docker pull docker
                """
            }
        }
    }
}