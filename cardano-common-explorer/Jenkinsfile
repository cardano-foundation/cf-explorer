def hostSonarqube
def projectKeyCommonExplorer
def loginCommonExplorer

def COLOR_MAP = [
    'SUCCESS': 'good',
    'FAILURE': 'danger',
]

pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building..'
                sh "mvn -B -DskipTests clean package"
                echo 'Build successfully!!!'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                sh "mvn test"
                echo 'Test successfully!!!'
            }
        }
        stage('Sonarqube Scan') {
		    when {
                branch 'develop'
            }
            steps {
                script {
                    def envFile
                    if (env.BRANCH_NAME == 'develop') {
                        envFile = readProperties file: '/tmp/env-dev.properties'
                    }
                    hostSonarqube = envFile.hostSonarqube
                    projectKeyCommonExplorer = envFile.projectKeyCommonExplorer
                    loginCommonExplorer = envFile.loginCommonExplorer
                }
                echo 'Sonarqube scanning...'
                sh "mvn sonar:sonar -Dsonar.projectKey=${projectKeyCommonExplorer} -Dsonar.analysisCache.enabled=false -Dsonar.host.url=${hostSonarqube} -Dsonar.login=${loginCommonExplorer} -Dsonar.sources=src/main/java/ -Dsonar.java.binaries=target/classes"
                echo 'Sonarqube scan successfully!!!'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
                sh "mvn deploy"
                echo 'Deployment Done!!!'
            }
        }
    }
    post {
        always {
            script {
                Author_ID = sh(script: "git show -s --pretty=%an", returnStdout: true).trim()
                Author_Name = sh(script: "git show -s --pretty=%ae", returnStdout: true).trim()
            }
            slackSend channel: "#build-group-test",
                    color: COLOR_MAP[currentBuild.currentResult],
                    message: "*${currentBuild.currentResult}:* ${env.JOB_NAME} build ${env.BUILD_NUMBER} by commit author: ${Author_ID} \n More information at: ${env.BUILD_URL}"
        }
    }
}
