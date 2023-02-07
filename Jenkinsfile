pipeline {
  agent any
  stages {
    stage('Checkout Code') {
      steps {
        git(url: 'https://github.com/ETisREAL/Kafka-ELK.git', branch: 'integration')
      }
    }

    stage('Test Log') {
      steps {
        sh 'ls -la'
      }
    }

  }
}