#!/usr/bin/env groovy

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
		stage ('clone') {
			steps {
				script{
					gv.gitClone()
				}
			} 
		}
		stage ('unit tests') {
			steps{
				script{
					gv.runUnitTests()
				}
			}
		}
		stage ('SonarQube Tests') {
			steps{
				script{
					gv.sonarQubeTest()
				}
			}
		}
		stage ('Push to Nexus') {
			steps{
				script{
					gv.pushToNexus()
				}
			}
		}
		stage ('Docker Image Build') {
			steps{
				script{
					gv.dockerBuild()
				}
			}
		}
	}
}

