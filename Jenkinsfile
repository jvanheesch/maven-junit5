// TODO_JORIS: custom steps zonder shared libraries zou toch ook mogelijk moeten zijn?
// kan mss enkel met plugins, gn idee hoe complex plugin automation is voor proprietary plugins
@Library('my-shared-library') _

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
        stage('Build') {
            steps {
                script {
                    sh 'mvn clean package -DskipTests' // testFailureIgnore in surefire plugin
                }
            }
        }
        stage('Unit test') {
            steps {
                script {
                    sh 'mvn test'
                }
            }
        }
        stage('Integration test') {
            steps {
                script {
                    sh 'mvn clean verify -Dmaven.test.failure.ignore'
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
            junit '**/target/surefire-reports/*.xml, **/target/failsafe-reports/*.xml'
            logscript 'shared library custom step example'
        }
        unstable {
            script {
                slackSend channel: '#jenkins', color: 'danger', message: 'ABC', teamDomain: 'sandboxjoris'
            }
        }
        failure {
            script {
                echo "FAILURE"
            }
        }
    }
}
