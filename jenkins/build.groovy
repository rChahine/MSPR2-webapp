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
              
        stage('Build app') {
            steps {
                bat '''
                    npm run build
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
