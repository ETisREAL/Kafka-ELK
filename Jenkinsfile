pipeline {
  agent any
  stages {
    stage('Checkout Code') {
      steps {
        git(url: 'https://github.com/ETisREAL/Kafka-ELK.git', branch: 'integration')
      }
    }

    stage('log') {
      steps {
        sh 'ls -la'
      }
    }

  }
}