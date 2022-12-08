def gitClone(){
	echo "Getting Project from Git";
	git "https://github.com/khalil-yahyaoui/Project-Devops";
}

def runMvnClean(){
	echo "Maven Clean";
	sh 'mvn clean';
}

def runUnitTests(){
	echo "Maven Test JUnit";
	sh 'mvn test';
}