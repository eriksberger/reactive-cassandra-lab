# Lab on persistence using Cassandra #  
  
  
  
### What is this repository for? ###  
  
* Just for test purposes and a template  
  
### How do I get set up? ###  
First get Cassandra up and running on a server or locally
  
* Install on local machine, OR  
* Run as a docker  
  
#### To run docker (single instance. For clustering read provided links below)  
  

    docker run --name cassandra1 -p "7191:7191" -p "7000:7000" -p "7001:7001" -p "9160:9160" -p "9042:9042" -e CASSANDRA\_BROADCAST\_ADDRESS=127.0.0.1 cassandra:latest 

 
  
To use commandtool in your cassandra you just started:  
  

    docker exec -it cassandra1 cqlsh  

  
<https://hub.docker.com/_/cassandra/>  
<https://yurisubach.com/2016/03/24/cassandra-docker-test-cluster/>
