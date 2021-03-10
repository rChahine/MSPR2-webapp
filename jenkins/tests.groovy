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
                    npm run unit
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
