Github repo : https://github.com/khalil-yahyaoui/Project-Devops/

Le projet concerne la création et la construction d'un pipeline en utilisant JENKINS.	

le processus du pipeline :
- cloner le code à partir du repo github
- exécuter des tests de qualité en utilisant Sonarqube
- exécuter les tests unitaires
- construire le jar et le pousser vers le dépôt Nexus
- construire l'image docker pour le backend et les applications de base de données

Tous les processus du pipeline ont été testés dans un environnement local (aucun serveur distant n'a été utilisé).
