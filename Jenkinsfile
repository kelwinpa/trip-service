node{
	stage('git clone'){
		git credentialsId: 'git-creds', url: 'https://github.com/kelwinpa/trip-service'
	}
	stage('maven package'){
		def MVV_HOME = tool name: 'Maven-3', type: 'maven'
		def MVN_CMD = "${MVV_HOME}/bin/mvn"
		sh "${MVN_CMD} clean compile package"
	}
	stage('build image'){
		sh 'docker build -t stevenxs/trip-service:latest .'
	}
	stage('push image'){
		withCredentials([string(credentialsId: 'dockerPassword', variable: 'dockerPass')]) {
 			sh "docker login -u stevenxs -p ${dockerPass}"
		}
		sh 'docker push stevenxs/trip-service:latest'
	}
	stage('Deploy to K8s') {
	    sshagent(['k8s-server']) {
            sh "scp -o StrictHostKeyChecking=no trip-service-deployment-manifest.yml ubuntu@18.222.252.18"
        }
        script{
        		try{
        			sh "sh ubuntu@18.222.252.18 kubectl apply -f ."
        		}catch(error){
        			sh "sh ubuntu@18.222.252.18 kubectl create -f ."
        		}
        }
    }
}
