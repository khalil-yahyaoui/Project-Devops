pipeline {
	agent any
	stages {
		stage ('GIT') {
			steps {
				echo "Getting Project from Git"
				git clone "https://github.com/khalil-yahyaoui/Project-Devops" 
			}
		}
		stage ('MVN CLEAN') {
			steps {
				echo "Maven Clean";
				sh 'mvn clean';
			} 
		}
		stage ('MVN TEST') {
			steps{
				echo "Maven Test JUnit";
				sh 'mvn test';
			}
		}
	}
}

