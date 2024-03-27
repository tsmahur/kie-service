Business App Initial Content
=============================

This app is created using kie-service-spring-boot-archetype (https://www.jbpm.org/businessapps/gettingStarted.html)
also spring version and kie version upgraded
```
mvn archetype:generate -B -DarchetypeGroupId=org.kie -DarchetypeArtifactId=kie-service-spring-boot-archetype -DarchetypeVersion=7.52.0.Final -DgroupId=com.tsm -DartifactId=tsm-service -Dversion=1.0-SNAPSHOT -Dpackage=com.tsm.service -DappType=bpm
```


https://www.jbpm.org/learn/gettingStartedUsingSingleZipDistribution.html

Download jBPM 7.74.1.Final server (single zip) distribution
Just download, unzip and run

On Unix/Linux:
`jbpm-server/bin/standalone.sh`

On Windows:
`jbpm-server\bin\standalone.bat`

Generating backend apps and getting started
https://www.jbpm.org/businessapps/gettingStarted.html

Documentation(opensource jbpmn):
https://docs.jbpm.org/7.74.1.Final/jbpm-docs/html_single/

Docker imager:
https://www.jbpm.org/learn/gettingStartedUsingDocker.html
```
docker run -p 8080:8080 -p 8001:8001 -d --name jbpm-server-full jboss/jbpm-server-full:latest
```

Examples:
https://download.jboss.org/jbpm/release/7.74.1.Final/jbpm-7.74.1.Final-examples.zip

jbpm-examples -> [jbpm-7.74.1.Final-examples](https://github.com/tsmahur/jbpm-7.74.1.Final-examples)

JBPMN