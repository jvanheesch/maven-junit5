def pom

pipeline {
    agent {
        label 'master'
    }

    options {
        disableConcurrentBuilds()
    }

    tools {
        maven 'jenkins-maven-installation-3.5.4'
    }

    stages {
        stage('Checkout') {
            steps {
                timestamps {
                    script {
                        echo 'Checkout'
                        checkoutFromGithub(this, 'site-parent-pom', 'master')
                        pom = this.readMavenPom()
                    }
                }
            }
        }
        stage('Build') {
            steps {
                timestamps {
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
    }
    post {
        failure {
            script {
                echo "FAILURE"
            }
        }
    }
}
