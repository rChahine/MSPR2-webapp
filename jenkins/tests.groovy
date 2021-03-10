pipeline {
    agent any

    stages {
      
        stage('Install latests dependencies') {
            steps {
                bat '''
                    npm i
                '''
            }
        }
              
        stage('testing app') {
            steps {
                bat '''
                    npm run test
                '''
            }
        }
    }
    
    post {
        always {
            echo 'Delete directory'
            deleteDir()
        }
    }
}
