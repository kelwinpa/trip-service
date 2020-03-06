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
	stage('Deploy') {
		sh 'kubectl create -f trip-service-deployment-manifest.yaml'

    }
}