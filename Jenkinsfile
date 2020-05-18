node{
    def ECR_CRD = "ecr:us-east-2:aws-ecr-admin-cred"
    def ECR_URL = "772584673213.dkr.ecr.us-east-2.amazonaws.com/stevenxs/trip-service"
    def MVV_HOME = tool name: 'Maven-3', type: 'maven'
	def MVN_CMD = "${MVV_HOME}/bin/mvn"
	def IMG_DOC = "stevenxs/trip-service:latest"

	stage('git clone'){
		git credentialsId: 'git-creds', url: 'https://github.com/kelwinpa/trip-service'
	}
	stage('maven package'){
		sh "${MVN_CMD} clean compile package"
	}
	stage('build image'){
		sh "docker build -t ${IMG_DOC} ."
	}
	stage('push image'){
		withCredentials([string(credentialsId: 'dockerPassword', variable: 'dockerPass')]) {
 			sh "docker login -u stevenxs -p ${dockerPass}"
		}
		sh "docker push ${IMG_DOC}"
	}
	stage('push in AWS ECR') {
        withDockerRegistry(credentialsId: ECR_CRD, url: ECR_URL) {
            sh "docker push ${IMG_DOC}"
        }
    }
	stage('Deploy to K8s') {
	    sshagent(['k8s-server']) {
            sh "scp -o StrictHostKeyChecking=no trip-service-deployment-manifest.yaml ubuntu@3.19.223.90:/home/ubuntu/"
            script{
        		try{
        			sh "ssh ubuntu@3.19.223.90 kubectl apply -f ."
        		}catch(error){
        			sh "ssh ubuntu@3.19.223.90 kubectl create -f ."
        		}
        	}
        }
    }
}
