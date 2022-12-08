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
def buildJar() {
    echo 'building the application...'
    sh 'mvn -f ./pom.xml clean package'
    sh 'mvn -version'
} 

def pushImageNexus(String NEXUS_VERSION,String NEXUS_PROTOCOL,String NEXUS_URL,String NEXUS_REPOSITORY,String NEXUS_CREDENTIAL_ID) {
  pom = readMavenPom file: "pom.xml";
                    filesByGlob = findFiles(glob: "target/*.${pom.packaging}");
                    echo "${filesByGlob[0].name} ${filesByGlob[0].path} ${filesByGlob[0].directory} ${filesByGlob[0].length} ${filesByGlob[0].lastModified}"
                    artifactPath = filesByGlob[0].path;
                    artifactExists = fileExists artifactPath;
                    if(artifactExists) {
                        echo "*** File: ${artifactPath}, group: ${pom.groupId}, packaging: ${pom.packaging}, version ${pom.version}";
                        nexusArtifactUploader(
                            nexusVersion: NEXUS_VERSION,
                            protocol: NEXUS_PROTOCOL,
                            nexusUrl: NEXUS_URL,
                            groupId: pom.groupId,
                            version: pom.version,
                            repository: NEXUS_REPOSITORY,
                            credentialsId: NEXUS_CREDENTIAL_ID,
                            artifacts: [
                                [artifactId: pom.artifactId,
                                classifier: '',
                                file: artifactPath,
                                type: pom.packaging],
                                [artifactId: pom.artifactId,
                                classifier: '',
                                file: "pom.xml",
                                type: "pom"]
                            ]
                        );
                    } else {
                        error "*** File: ${artifactPath}, could not be found";
                    }
}
return this