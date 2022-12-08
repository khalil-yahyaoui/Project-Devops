def gv

pipeline {
	agent any
	stages {
		stage ('init') {
			steps {
				script{
					gv = load "scripts.groovy"
				}
			}
		}
		stage ('Git Clone') {
			steps {
				script{
					gv.gitClone()
				}
			} 
		}
		stage ('Mvn clean') {
			steps {
				script{
					gv.runMvnClean()
				}
			} 
		}
		stage ('Running Unit Tests') {
			steps{
				script{
					gv.runUnitTests()
				}
			}
		}
	}
}
