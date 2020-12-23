def pom

pipeline {
    agent {
        label 'master'
    }

    options {
        disableConcurrentBuilds()
        timestamps()
    }

    tools {
        maven 'maven-3.3.9'
    }

    stages {
        stage('Checkout') {
            steps {
                script {
                    echo 'Checkout'
                    pom = this.readMavenPom()
                }
            }
        }
        stage('Build') {
            steps {
                script {
                    echo 'Build'
                    sh 'mvn -version'
                    sh 'mvn clean verify'
                    // https://stackoverflow.com/a/50756301/1939921
//                        configFileProvider([configFile(fileId: 'jenkins-maven-settings', variable: 'MAVEN_SETTINGS_XML')]) {
//                            sh 'mvn clean install -U -X -DskipTests=true -s $MAVEN_SETTINGS_XML'
//                        }
                }
            }
        }
    }
    post {
        always {
            junit '**/target/surefire-reports/*.xml', '**/target/failsafe-reports/*.xml'
        }
        failure {
            script {
                echo "FAILURE"
            }
        }
    }
}
