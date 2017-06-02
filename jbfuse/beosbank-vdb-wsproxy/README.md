Camel Project for Blueprint 
=========================================

To build this project use

    mvn fabric8:zip install

To run the project you can execute the following Maven goal
   Add the beosbank-vdb-wsproxy  profile to a child container.

To deploy the project in OSGi. For example using Apache ServiceMix
or Apache Karaf. You can run the following command from its shell:


Start the databases docker containers
$ cd jbdevg/jbdatavirt/docker/
$ docker-compose up 

# Start the VDB
cd books/jbdevg/BeosBankDataVirtLab/install/dv63
bin/standalone.sh

17:20:24,166 INFO  [org.jboss.as.server] (Controller Boot Thread) JBAS015859: Déploiement de "beosbank.vdb" (runtime-name: "beosbank.vdb


Deploy the application

Standalone Mode
	 JBossFuse:karaf@root> osgi:install -s mvn:com.beosbank.jbdevg.jbfuse/beosbank-vdb-wsproxy/1.0.0-SNAPSHOT

Fabric 
   JBossFuse:karaf@root> profile-import mvn:com.beosbank.jbdevg.jbfuse/beosbank-vdb-wsproxy/1.0.0-SNAPSHOT/zip/profile

For more help see the Apache Camel documentation

    http://camel.apache.org/
    
    
 Testing
 
$ http -a http://127.0.0.1:8185/vdbproxy/Transactions.MoneyTransfer
 
 
    
