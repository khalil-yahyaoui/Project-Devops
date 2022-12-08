pipeline {
	agent any
	stages {
		stage ('GIT') {
			steps {
				script{
					echo "Getting Project from Git"
					git "https://github.com/khalil-yahyaoui/Project-Devops"
				}
			}
		}
		stage ('MVN CLEAN') {
			steps {
				script{
					echo "Maven Clean"
					sh 'mvn clean'
				}
			} 
		}
		stage ('MVN TEST') {
			steps{
				script{
					echo "Maven Test JUnit"
					sh 'mvn test'
				}
			}
		}
	}
}

