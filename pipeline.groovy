def gitClone(){
	echo "Getting Project from Git";
	git 'https://github.com/khalil-yahyaoui/Project-Devops';
}
def runMvnClean(){
	echo "Maven Clean";
	sh 'mvn clean';
}
def runUnitTests(){
	echo "Maven Test JUnit";
	sh 'mvn test';
}
def sonarQubeTest(){
	sh "mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=devops123"
}
def pushToNexus() {
    echo 'pushing to nexus...'
    sh 'mvn clean package -Dmaven.test.skip=true deploy:deploy-file -DgroupId=com.example -DartifactId=devops-project -Dversion=1.0 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://localhost:8081/repository/maven-releases/ -Dfile=target/devops-project-0.0.1-SNAPSHOT.jar'
} 
def dockerBuild(){
	sh "docker build -t DEVOPS ."
}
return this