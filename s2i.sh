#!/bin/sh

unset MAVEN_CONFIG

if [ ! -d "${CHE_PROJECTS_ROOT}/oc_client" ]
then	
	cd ${CHE_PROJECTS_ROOT}	
	mkdir oc_client
	wget https://github.com/rohitralhan/occlient/raw/main/oc-4.6.3-linux.tar.gz
	tar -xvf oc-4.6.3-linux.tar.gz -C oc_client
	rm -rf oc-4.6.3-linux.tar.gz
	export PATH=$PATH:/projects/oc_client
fi

export PATH=$PATH:${CHE_PROJECTS_ROOT}/oc_client 

cd ${CHE_PROJECTS_ROOT}/quarkus-serverless-client 

oc login -u user1 -p user1 --server=https://api.cluster-838f.838f.example.opentlc.com:6443  --insecure-skip-tls-verify=true  > /dev/null 2>&1

./mvnw clean package -Dquarkus.kubernetes.deploy=true -Dquarkus.kubernetes-client.trust-certs=true
