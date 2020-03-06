# Trip-Service

The goal of this application is to perform the next task.

- Implement the specified REST Endpoint
- Protect the API with BasicAuth
- Use Docker to run your application
- Use one of the following languages&#58; Go, Java, Python, C++
- Automate the infrastructure rollout
- Use an external service to determine the city name for depature and destination
- Upload your solution to a private GitHub repository
- Provide a link to the secured hosted instance of your solution
- Provide the following files together with your code&#58;
      * Dockerfile
      * Build-Script
      * Deployment-Script
      * Kubernetes deployment YAML (if Kubernetes is used)
      * Infrastructure automation scripts
      * README.md with documentation how to deploy the infrastructure and the application

## Devops Workflow

![alt text](images/Devops-workflow.jpg?raw=true "Devops Workflow")

## Technologies

* [SpringBoot] - Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can "just run".!
* [H2] - H2 is a relational database management system written in Java. It can be embedded in Java applications or run in client-server mode
* [Maven] - Maven is a build automation tool used primarily for Java projects.
* [Junit] - JUnit is a unit testing framework for the Java programming language
* [Swagger] - Swagger is an open-source software framework backed by a large ecosystem of tools that helps developers design, build, document, and consume RESTful Web services
* [Git] - Git is a distributed version-control system for tracking changes in source code during software development.
* [Docker] - Docker is a set of coupled software-as-a-service and platform-as-a-service products that use operating-system-level virtualization to develop and deliver software in packages called containers
* [Jenkins] - Jenkins is an open source automation server written in Java. Jenkins helps to automate the non-human part of the software development process, with continuous integration and facilitating technical aspects of continuous delivery.
* [Kubernetes] - Kubernetes (K8s) is an open-source system for automating deployment, scaling, and management of containerized applications 

## Endpoint to test

After running you can test the endpoints.

```sh
$ http://localhost:8180/swagger-ui.html#/
```

__Note:__ 
* Swagger basic auth parameter. __format:__ test __password:__ test

## How to run it

There are three different ways to run the project.
 1) run with an IDE, for example Spring Tools 4.
 2) By using Docker engine.
 3) By using Kubernetes (Deployment is provided)

### Run it with Docker

__Note__: Docker engine must be installed.

Run the container with the following command.
```sh
$ docker run -p 8180:8180 --name trip-service stevenxs/trip-service:latest
```
## Deploying with Jenkins

Jenkins server is already deployed in an Amazon EC2 Instance full secure.

```sh
http://3.15.43.48:8080/
```
#### Jenkins Workflow

As soon you made a push of your code in Github, Jenkins will scan your repository, and the Pipeline will start, the Jenkins Pipeline follows the next stages.

1) git clone: Clone the project from the private gitHub.
2) maven package: Clean, Compile and Package the project.
3) build image: Package the project into a docker image.
4) push image: Push the image into the DockerHub repository.
5) Deploy: Run K8S deploy in local cluster as follow.
```sh
kubectl create -f trip-service-deployment-manifest.yaml
```
## Check all with K8S

__note__: Kubectl must be installed, Docker for desktop include a K8S installation.

The __trip-service-deployment-manifest.yml__ included a service and a deployment, the service acts as a load balancer of 3 replicas specified in the deployment.

__note__: verify the context of your K8S.
```sh
kubectl config get-contexts
```
Expected output: * docker-for-desktop or docker-desktop according to your docker installation.

Finally run the next command to check if everything went well.
```sh
kubectl get svc,deployment,pod
```
Expected output:

| NAME              | TYPE       | CLUSTER-IP   |EXTERNAL-IP| PORT(S) | AGE |
| ------            | ------     | ------       | ------    | ------  | --- |
|service/kubernetes | ClusterIP  | 10.96.0.1    | <none>    | 443/TCP |3m13s|
|service/trip-service|LoadBalancer|10.105.152.174| localhost |8180:30943/TCP|47s|

| NAME                              | READY | UP-TO-DATE| AVAILABLE | AGE |
| --------------------------------- | ----- | --------- | --------- | --- |
| deployment.extensions/trip-service | 3/3   | 3         | 3         | 47s |

| NAME                           |  READY  | STATUS  |  RESTARTS |  AGE |
| ------------------------------ | ------  | ------  | --------- | ---- |
|pod/trip-service-889b68887-6wklq |  1/1    | Running |  0        |  47s |
|pod/trip-service-889b68887-7m44k |  1/1    | Running |  0        |  47s |
|pod/trip-service-889b68887-qmxc8 |  1/1    | Running |  0        |  47s |

After it, the application will be ready to test it.

## Problem Founds

The main problem found was related to the deployment, since my AWS account cannot create more than one EC2 instance in the same availability zone.

This was a huge problem because I could not deploy the nodes and the master of Kubernetes to make CD (Continuous Deployment)

I already sent an email to AWS support team, but this takes between 3 and 5 business days.

So the deployment with Kubernetes was testing locally.

That is the main reason why I did not provide any secure host to test.

Look at the image in /image folder to see the DevOps flow.

***
This file was generated by https://dillinger.io/

   [SpringBoot]: <https://spring.io/projects/spring-boot>
   [H2]: <https://www.h2database.com/>
   [Maven]: <https://maven.apache.org/>
   [Junit]: <https://junit.org/junit5/>
   [Swagger]: <https://swagger.io/>
   [Git]: <https://git-scm.com/>
   [Docker]: <https://www.docker.com/>
   [Jenkins]: <https://jenkins.io/>
   [Kubernetes]: <https://kubernetes.io/>

