#!/usr/bin/env groovy

def gv 

pipeline {
	agent any
	
	environment {
        NEXUS_URL="127.0.0.1:8081"
        NEXUS_VERSION = "nexus3"
        NEXUS_PROTOCOL = "http"
        NEXUS_REPOSITORY = "devops"
        NEXUS_CREDENTIAL_ID = "nexus-user-credentials"
        }
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
		stage ('JAR build') {
			steps{
				script{
					gv.buildJar()
				}
			}
		}
		stage ('Push Image to Nexus') {
			steps{
				script{
					gv.pushImageNexus(env.NEXUS_VERSION,env.NEXUS_PROTOCOL,env.NEXUS_URL,env.NEXUS_REPOSITORY,env.NEXUS_CREDENTIAL_ID)
				}
			}
		}
	}
}

