pipeline{
    agent any
    
    stages{
        stage("Git checkput"){
            steps{
                git credentialsId: 'be50f576-4fe3-4f65-930c-0598d637fb1f', url: 'https://github.com/nkmaurya283/Appium1.git'
            }
            }
        stage("Run maven build from cmd"){
                steps{
                    bat label: '', script: 'mvn clean test'
                }
            
        }
        stage("Generating report"){
            steps{
                bat label: '', script: 'allure serve target/allure-results'
            }
        }
         stage("Stopping Allure Server"){
            steps{
                bat label: '', script: 'Ctrl + C'
            }
        }
    }
}
    
