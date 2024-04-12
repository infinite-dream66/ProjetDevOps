pipeline {
    agent any

    stages {
        stage('Compilation') {
            steps {
                sh 'mvn clean compile'
            }
        }
        stage('Tests unitaires') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Tests d\'intégration') {
            steps {
                sh 'mvn verify'
            }
        }
        stage('Construction de l\'image Docker') {
            steps {
                sh 'docker build -t monapp .'
            }
        }
        stage('Publication de l\'image Docker') {
            steps {
                sh 'docker push monapp:latest'
            }
        }
        stage('Déploiement') {
            steps {
                // Ajoutez vos commandes de déploiement ici
                // Exemple de déploiement SSH
                sshagent(credentials: ['votre_identifiant_ssh']) {
                    sh 'ssh utilisateur@serveur "mkdir -p /chemin/vers/deploiement && scp -r /chemin/local/* utilisateur@serveur:/chemin/vers/deploiement"'
                }

                // Exemple de déploiement sur un serveur distant via le plugin SSH
                // sshPublisher(
                //     publishers: [
                //         sshPublisherDesc(
                //             configName: 'votre_configuration_ssh', 
                //             transfers: [
                //                 sshTransfer(
                //                     sourceFiles: '/chemin/local/*', 
                //                     removePrefix: '/chemin/local/', 
                //                     remoteDirectory: '/chemin/vers/deploiement/', 
                //                     execCommand: 'mkdir -p /chemin/vers/deploiement/'
                //                 )
                //             ]
                //         )
                //     ]
                // )

                // Exemple de déploiement Docker
                // docker.withRegistry('https://votre-registry-docker.com', 'votre_credentials_docker') {
                //     sh 'docker pull monapp:latest'
                //     sh 'docker run -d --name monapp-container monapp:latest'
                // }
            }
        }
    }
}
