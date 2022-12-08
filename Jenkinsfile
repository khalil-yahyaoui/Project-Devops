def gv


pipeline {
	agent any
	stages {
		stage ('init') {
			steps {
				script{
					gv = load "pipeline.groovy"
				}
			}
		}
		stage ('clone git') {
			steps {
				script{
					gv.gitClone()
				}
			} 
		}
		stage ('MVN TEST') {
			steps{
				script{
					gv.runUnitTests()
				}
			}
		}
	}
}

