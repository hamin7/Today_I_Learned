Last login: Mon May 30 10:12:41 on ttys003
leehamin@leeui-MacBookPro ~ % docker exec -it db3c283c7da7fb44868ae2fba33894c11521256f5e8434a396534e04da072c4b /bin/sh
/ # ls
bin    dev    etc    home   kafka  lib    lib64  media  mnt    opt    proc   root   run    sbin   srv    sys    tmp    usr    var
/ # pwd
/
/ # cd kafka
/kafka # ls
kafka-logs-db3c283c7da7
/kafka # cd ..
/ # 
/ # 
/ # 
/ # 
/ # cd bin
/bin # ls
arch           chgrp          dmesg          fatattr        gzip           link           makemime       mpstat         pipe_progress  rmdir          stat           umount
ash            chmod          dnsdomainname  fdflush        hostname       linux32        mkdir          mv             printenv       run-parts      stty           uname
base64         chown          dumpkmap       fgrep          ionice         linux64        mknod          netstat        ps             sed            su             usleep
bash           cp             echo           fsync          iostat         ln             mktemp         nice           pwd            setpriv        sync           watch
bbconfig       date           ed             getopt         ipcalc         login          more           pidof          reformime      setserial      tar            zcat
busybox        dd             egrep          grep           kbd_mode       ls             mount          ping           rev            sh             touch
cat            df             false          gunzip         kill           lzop           mountpoint     ping6          rm             sleep          true
/bin # 
/bin # pwd
/bin
/bin # cd ..
/ # ls
bin    dev    etc    home   kafka  lib    lib64  media  mnt    opt    proc   root   run    sbin   srv    sys    tmp    usr    var
/ # cd usr
/usr # ls
bin           glibc-compat  lib           local         sbin          share
/usr # cd local
/usr/local # ls
bin    lib    share
/usr/local # cd bin
/usr/local/bin # ls
/usr/local/bin # cd ..
/usr/local # cd ..
/usr # ps -ef | grep kafka
    1 root      0:16 /usr/lib/jvm/zulu8-ca/bin/java -Xmx1G -Xms1G -server -XX:+UseG1GC -XX:MaxGCPauseMillis=20 -XX:InitiatingHeapOccupancyPercent=35 -XX:+ExplicitGCInvokesConcurrent -XX:MaxInlineLevel=15 -Djava.awt.headless=true -Xloggc:/opt/kafka/bin/../logs/kafkaServer-gc.log -verbose:gc -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintGCTimeStamps -XX:+UseGCLogFileRotation -XX:NumberOfGCLogFiles=10 -XX:GCLogFileSize=100M -Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false -Dkafka.logs.dir=/opt/kafka/bin/../logs -Dlog4j.configuration=file:/opt/kafka/bin/../config/log4j.properties -cp /opt/kafka/bin/../libs/activation-1.1.1.jar:/opt/kafka/bin/../libs/aopalliance-repackaged-2.6.1.jar:/opt/kafka/bin/../libs/argparse4j-0.7.0.jar:/opt/kafka/bin/../libs/audience-annotations-0.5.0.jar:/opt/kafka/bin/../libs/commons-cli-1.4.jar:/opt/kafka/bin/../libs/commons-lang3-3.8.1.jar:/opt/kafka/bin/../libs/connect-api-2.8.1.jar:/opt/kafka/bin/../libs/connect-basic-auth-extension-2.8.1.jar:/opt/kafka/bin/../libs/connect-file-2.8.1.jar:/opt/kafka/bin/../libs/connect-json-2.8.1.jar:/opt/kafka/bin/../libs/connect-mirror-2.8.1.jar:/opt/kafka/bin/../libs/connect-mirror-client-2.8.1.jar:/opt/kafka/bin/../libs/connect-runtime-2.8.1.jar:/opt/kafka/bin/../libs/connect-transforms-2.8.1.jar:/opt/kafka/bin/../libs/hk2-api-2.6.1.jar:/opt/kafka/bin/../libs/hk2-locator-2.6.1.jar:/opt/kafka/bin/../libs/hk2-utils-2.6.1.jar:/opt/kafka/bin/../libs/jackson-annotations-2.10.5.jar:/opt/kafka/bin/../libs/jackson-core-2.10.5.jar:/opt/kafka/bin/../libs/jackson-databind-2.10.5.1.jar:/opt/kafka/bin/../libs/jackson-dataformat-csv-2.10.5.jar:/opt/kafka/bin/../libs/jackson-datatype-jdk8-2.10.5.jar:/opt/kafka/bin/../libs/jackson-jaxrs-base-2.10.5.jar:/opt/kafka/bin/../libs/jackson-jaxrs-json-provider-2.10.5.jar:/opt/kafka/bin/../libs/jackson-module-jaxb-annotations-2.10.5.jar:/opt/kafka/bin/../libs/jackson-module-paranamer-2.10.5.jar:/opt/kafka/bin/../libs/jackson-module-scala_2.13-2.10.
  935 root      0:00 grep kafka
/usr # cd ..
/ # ls
bin    dev    etc    home   kafka  lib    lib64  media  mnt    opt    proc   root   run    sbin   srv    sys    tmp    usr    var
/ # cd opt
/opt # ls
kafka             kafka_2.13-2.8.1  overrides
/opt # cd kafka
/opt/kafka_2.13-2.8.1 # ls
LICENSE    NOTICE     bin        config     libs       licenses   logs       site-docs
/opt/kafka_2.13-2.8.1 # cd bin
/opt/kafka_2.13-2.8.1/bin # ls
connect-distributed.sh               kafka-console-producer.sh            kafka-log-dirs.sh                    kafka-server-start.sh                windows
connect-mirror-maker.sh              kafka-consumer-groups.sh             kafka-metadata-shell.sh              kafka-server-stop.sh                 zookeeper-security-migration.sh
connect-standalone.sh                kafka-consumer-perf-test.sh          kafka-mirror-maker.sh                kafka-storage.sh                     zookeeper-server-start.sh
kafka-acls.sh                        kafka-delegation-tokens.sh           kafka-preferred-replica-election.sh  kafka-streams-application-reset.sh   zookeeper-server-stop.sh
kafka-broker-api-versions.sh         kafka-delete-records.sh              kafka-producer-perf-test.sh          kafka-topics.sh                      zookeeper-shell.sh
kafka-cluster.sh                     kafka-dump-log.sh                    kafka-reassign-partitions.sh         kafka-verifiable-consumer.sh
kafka-configs.sh                     kafka-features.sh                    kafka-replica-verification.sh        kafka-verifiable-producer.sh
kafka-console-consumer.sh            kafka-leader-election.sh             kafka-run-class.sh                   trogdor.sh
/opt/kafka_2.13-2.8.1/bin # 
/opt/kafka_2.13-2.8.1/bin # 
/opt/kafka_2.13-2.8.1/bin # 
/opt/kafka_2.13-2.8.1/bin # 
/opt/kafka_2.13-2.8.1/bin # 
/opt/kafka_2.13-2.8.1/bin # sh kafka-topics.sh 
Create, delete, describe, or change a topic.
Option                                   Description                            
------                                   -----------                            
--alter                                  Alter the number of partitions,        
                                           replica assignment, and/or           
                                           configuration for the topic.         
--at-min-isr-partitions                  if set when describing topics, only    
                                           show partitions whose isr count is   
                                           equal to the configured minimum. Not 
                                           supported with the --zookeeper       
                                           option.                              
--bootstrap-server <String: server to    REQUIRED: The Kafka server to connect  
  connect to>                              to. In case of providing this, a     
                                           direct Zookeeper connection won't be 
                                           required.                            
--command-config <String: command        Property file containing configs to be 
  config property file>                    passed to Admin Client. This is used 
                                           only with --bootstrap-server option  
                                           for describing and altering broker   
                                           configs.                             
--config <String: name=value>            A topic configuration override for the 
                                           topic being created or altered. The  
                                           following is a list of valid         
                                           configurations:                      
                                         	cleanup.policy                        
                                         	compression.type                      
                                         	delete.retention.ms                   
                                         	file.delete.delay.ms                  
                                         	flush.messages                        
                                         	flush.ms                              
                                         	follower.replication.throttled.       
                                           replicas                             
                                         	index.interval.bytes                  
                                         	leader.replication.throttled.replicas 
                                         	max.compaction.lag.ms                 
                                         	max.message.bytes                     
                                         	message.downconversion.enable         
                                         	message.format.version                
                                         	message.timestamp.difference.max.ms   
                                         	message.timestamp.type                
                                         	min.cleanable.dirty.ratio             
                                         	min.compaction.lag.ms                 
                                         	min.insync.replicas                   
                                         	preallocate                           
                                         	retention.bytes                       
                                         	retention.ms                          
                                         	segment.bytes                         
                                         	segment.index.bytes                   
                                         	segment.jitter.ms                     
                                         	segment.ms                            
                                         	unclean.leader.election.enable        
                                         See the Kafka documentation for full   
                                           details on the topic configs. It is  
                                           supported only in combination with --
                                           create if --bootstrap-server option  
                                           is used (the kafka-configs CLI       
                                           supports altering topic configs with 
                                           a --bootstrap-server option).        
--create                                 Create a new topic.                    
--delete                                 Delete a topic                         
--delete-config <String: name>           A topic configuration override to be   
                                           removed for an existing topic (see   
                                           the list of configurations under the 
                                           --config option). Not supported with 
                                           the --bootstrap-server option.       
--describe                               List details for the given topics.     
--disable-rack-aware                     Disable rack aware replica assignment  
--exclude-internal                       exclude internal topics when running   
                                           list or describe command. The        
                                           internal topics will be listed by    
                                           default                              
--force                                  Suppress console prompts               
--help                                   Print usage information.               
--if-exists                              if set when altering or deleting or    
                                           describing topics, the action will   
                                           only execute if the topic exists.    
--if-not-exists                          if set when creating topics, the       
                                           action will only execute if the      
                                           topic does not already exist.        
--list                                   List all available topics.             
--partitions <Integer: # of partitions>  The number of partitions for the topic 
                                           being created or altered (WARNING:   
                                           If partitions are increased for a    
                                           topic that has a key, the partition  
                                           logic or ordering of the messages    
                                           will be affected). If not supplied   
                                           for create, defaults to the cluster  
                                           default.                             
--replica-assignment <String:            A list of manual partition-to-broker   
  broker_id_for_part1_replica1 :           assignments for the topic being      
  broker_id_for_part1_replica2 ,           created or altered.                  
  broker_id_for_part2_replica1 :                                                
  broker_id_for_part2_replica2 , ...>                                           
--replication-factor <Integer:           The replication factor for each        
  replication factor>                      partition in the topic being         
                                           created. If not supplied, defaults   
                                           to the cluster default.              
--topic <String: topic>                  The topic to create, alter, describe   
                                           or delete. It also accepts a regular 
                                           expression, except for --create      
                                           option. Put topic name in double     
                                           quotes and use the '\' prefix to     
                                           escape regular expression symbols; e.
                                           g. "test\.topic".                    
--topics-with-overrides                  if set when describing topics, only    
                                           show topics that have overridden     
                                           configs                              
--unavailable-partitions                 if set when describing topics, only    
                                           show partitions whose leader is not  
                                           available                            
--under-min-isr-partitions               if set when describing topics, only    
                                           show partitions whose isr count is   
                                           less than the configured minimum.    
                                           Not supported with the --zookeeper   
                                           option.                              
--under-replicated-partitions            if set when describing topics, only    
                                           show under replicated partitions     
--version                                Display Kafka version.                 
--zookeeper <String: hosts>              DEPRECATED, The connection string for  
                                           the zookeeper connection in the form 
                                           host:port. Multiple hosts can be     
                                           given to allow fail-over.            
/opt/kafka_2.13-2.8.1/bin # set
GLIBC_VERSION='2.31-r0'
HISTFILE='/root/.ash_history'
HOME='/root'
HOSTNAME='db3c283c7da7'
IFS=' 	
'
JAVA_HOME='/usr/lib/jvm/zulu8-ca'
KAFKA_ADVERTISED_HOST_NAME='127.0.0.1'
KAFKA_CREATE_TOPICS='test:1:1'
KAFKA_HOME='/opt/kafka'
KAFKA_VERSION='2.8.1'
KAFKA_ZOOKEEPER_CONNECT='zookeeper:2181'
LANG='en_US.UTF-8'
LANGUAGE='en_US:en'
LC_ALL='en_US.UTF-8'
LINENO=''
OLDPWD='/opt/kafka'
OPTIND='1'
PATH='/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/opt/kafka/bin'
PPID='0'
PS1='\w \$ '
PS2='> '
PS4='+ '
PWD='/opt/kafka/bin'
SCALA_VERSION='2.13'
SHLVL='1'
TERM='xterm'
_='kafka-topics.sh'
/opt/kafka_2.13-2.8.1/bin # cat /etc/host
cat: can't open '/etc/host': No such file or directory
/opt/kafka_2.13-2.8.1/bin # cat /etc/hosts
127.0.0.1	localhost
::1	localhost ip6-localhost ip6-loopback
fe00::0	ip6-localnet
ff00::0	ip6-mcastprefix
ff02::1	ip6-allnodes
ff02::2	ip6-allrouters
172.18.0.3	db3c283c7da7
/opt/kafka_2.13-2.8.1/bin # sh kafka.sh
sh: can't open 'kafka.sh': No such file or directory
/opt/kafka_2.13-2.8.1/bin # sh kafka-topics.sh 
Create, delete, describe, or change a topic.
Option                                   Description                            
------                                   -----------                            
--alter                                  Alter the number of partitions,        
                                           replica assignment, and/or           
                                           configuration for the topic.         
--at-min-isr-partitions                  if set when describing topics, only    
                                           show partitions whose isr count is   
                                           equal to the configured minimum. Not 
                                           supported with the --zookeeper       
                                           option.                              
--bootstrap-server <String: server to    REQUIRED: The Kafka server to connect  
  connect to>                              to. In case of providing this, a     
                                           direct Zookeeper connection won't be 
                                           required.                            
--command-config <String: command        Property file containing configs to be 
  config property file>                    passed to Admin Client. This is used 
                                           only with --bootstrap-server option  
                                           for describing and altering broker   
                                           configs.                             
--config <String: name=value>            A topic configuration override for the 
                                           topic being created or altered. The  
                                           following is a list of valid         
                                           configurations:                      
                                         	cleanup.policy                        
                                         	compression.type                      
                                         	delete.retention.ms                   
                                         	file.delete.delay.ms                  
                                         	flush.messages                        
                                         	flush.ms                              
                                         	follower.replication.throttled.       
                                           replicas                             
                                         	index.interval.bytes                  
                                         	leader.replication.throttled.replicas 
                                         	max.compaction.lag.ms                 
                                         	max.message.bytes                     
                                         	message.downconversion.enable         
                                         	message.format.version                
                                         	message.timestamp.difference.max.ms   
                                         	message.timestamp.type                
                                         	min.cleanable.dirty.ratio             
                                         	min.compaction.lag.ms                 
                                         	min.insync.replicas                   
                                         	preallocate                           
                                         	retention.bytes                       
                                         	retention.ms                          
                                         	segment.bytes                         
                                         	segment.index.bytes                   
                                         	segment.jitter.ms                     
                                         	segment.ms                            
                                         	unclean.leader.election.enable        
                                         See the Kafka documentation for full   
                                           details on the topic configs. It is  
                                           supported only in combination with --
                                           create if --bootstrap-server option  
                                           is used (the kafka-configs CLI       
                                           supports altering topic configs with 
                                           a --bootstrap-server option).        
--create                                 Create a new topic.                    
--delete                                 Delete a topic                         
--delete-config <String: name>           A topic configuration override to be   
                                           removed for an existing topic (see   
                                           the list of configurations under the 
                                           --config option). Not supported with 
                                           the --bootstrap-server option.       
--describe                               List details for the given topics.     
--disable-rack-aware                     Disable rack aware replica assignment  
--exclude-internal                       exclude internal topics when running   
                                           list or describe command. The        
                                           internal topics will be listed by    
                                           default                              
--force                                  Suppress console prompts               
--help                                   Print usage information.               
--if-exists                              if set when altering or deleting or    
                                           describing topics, the action will   
                                           only execute if the topic exists.    
--if-not-exists                          if set when creating topics, the       
                                           action will only execute if the      
                                           topic does not already exist.        
--list                                   List all available topics.             
--partitions <Integer: # of partitions>  The number of partitions for the topic 
                                           being created or altered (WARNING:   
                                           If partitions are increased for a    
                                           topic that has a key, the partition  
                                           logic or ordering of the messages    
                                           will be affected). If not supplied   
                                           for create, defaults to the cluster  
                                           default.                             
--replica-assignment <String:            A list of manual partition-to-broker   
  broker_id_for_part1_replica1 :           assignments for the topic being      
  broker_id_for_part1_replica2 ,           created or altered.                  
  broker_id_for_part2_replica1 :                                                
  broker_id_for_part2_replica2 , ...>                                           
--replication-factor <Integer:           The replication factor for each        
  replication factor>                      partition in the topic being         
                                           created. If not supplied, defaults   
                                           to the cluster default.              
--topic <String: topic>                  The topic to create, alter, describe   
                                           or delete. It also accepts a regular 
                                           expression, except for --create      
                                           option. Put topic name in double     
                                           quotes and use the '\' prefix to     
                                           escape regular expression symbols; e.
                                           g. "test\.topic".                    
--topics-with-overrides                  if set when describing topics, only    
                                           show topics that have overridden     
                                           configs                              
--unavailable-partitions                 if set when describing topics, only    
                                           show partitions whose leader is not  
                                           available                            
--under-min-isr-partitions               if set when describing topics, only    
                                           show partitions whose isr count is   
                                           less than the configured minimum.    
                                           Not supported with the --zookeeper   
                                           option.                              
--under-replicated-partitions            if set when describing topics, only    
                                           show under replicated partitions     
--version                                Display Kafka version.                 
--zookeeper <String: hosts>              DEPRECATED, The connection string for  
                                           the zookeeper connection in the form 
                                           host:port. Multiple hosts can be     
                                           given to allow fail-over.            
/opt/kafka_2.13-2.8.1/bin # sh kafka-topics.sh --list --zookeeper KAFKA_ZOOKEEPER_CONNECT
[2022-05-30 01:18:23,206] ERROR Unable to resolve address: KAFKA_ZOOKEEPER_CONNECT:2181 (org.apache.zookeeper.client.StaticHostProvider)
java.net.UnknownHostException: KAFKA_ZOOKEEPER_CONNECT: Name does not resolve
	at java.net.Inet4AddressImpl.lookupAllHostAddr(Native Method)
	at java.net.InetAddress$2.lookupAllHostAddr(InetAddress.java:929)
	at java.net.InetAddress.getAddressesFromNameService(InetAddress.java:1324)
	at java.net.InetAddress.getAllByName0(InetAddress.java:1277)
	at java.net.InetAddress.getAllByName(InetAddress.java:1193)
	at java.net.InetAddress.getAllByName(InetAddress.java:1127)
	at org.apache.zookeeper.client.StaticHostProvider$1.getAllByName(StaticHostProvider.java:92)
	at org.apache.zookeeper.client.StaticHostProvider.resolve(StaticHostProvider.java:147)
	at org.apache.zookeeper.client.StaticHostProvider.next(StaticHostProvider.java:375)
	at org.apache.zookeeper.ClientCnxn$SendThread.run(ClientCnxn.java:1137)
[2022-05-30 01:18:23,211] WARN Session 0x0 for server KAFKA_ZOOKEEPER_CONNECT:2181, unexpected error, closing socket connection and attempting reconnect (org.apache.zookeeper.ClientCnxn)
java.lang.IllegalArgumentException: Unable to canonicalize address KAFKA_ZOOKEEPER_CONNECT:2181 because it's not resolvable
	at org.apache.zookeeper.SaslServerPrincipal.getServerPrincipal(SaslServerPrincipal.java:71)
	at org.apache.zookeeper.SaslServerPrincipal.getServerPrincipal(SaslServerPrincipal.java:39)
	at org.apache.zookeeper.ClientCnxn$SendThread.startConnect(ClientCnxn.java:1087)
	at org.apache.zookeeper.ClientCnxn$SendThread.run(ClientCnxn.java:1139)
[2022-05-30 01:18:24,318] ERROR Unable to resolve address: KAFKA_ZOOKEEPER_CONNECT:2181 (org.apache.zookeeper.client.StaticHostProvider)
java.net.UnknownHostException: KAFKA_ZOOKEEPER_CONNECT
	at java.net.InetAddress.getAllByName0(InetAddress.java:1281)
	at java.net.InetAddress.getAllByName(InetAddress.java:1193)
	at java.net.InetAddress.getAllByName(InetAddress.java:1127)
	at org.apache.zookeeper.client.StaticHostProvider$1.getAllByName(StaticHostProvider.java:92)
	at org.apache.zookeeper.client.StaticHostProvider.resolve(StaticHostProvider.java:147)
	at org.apache.zookeeper.client.StaticHostProvider.next(StaticHostProvider.java:375)
	at org.apache.zookeeper.ClientCnxn$SendThread.run(ClientCnxn.java:1137)
[2022-05-30 01:18:24,319] WARN Session 0x0 for server KAFKA_ZOOKEEPER_CONNECT:2181, unexpected error, closing socket connection and attempting reconnect (org.apache.zookeeper.ClientCnxn)
java.lang.IllegalArgumentException: Unable to canonicalize address KAFKA_ZOOKEEPER_CONNECT:2181 because it's not resolvable
	at org.apache.zookeeper.SaslServerPrincipal.getServerPrincipal(SaslServerPrincipal.java:71)
	at org.apache.zookeeper.SaslServerPrincipal.getServerPrincipal(SaslServerPrincipal.java:39)
	at org.apache.zookeeper.ClientCnxn$SendThread.startConnect(ClientCnxn.java:1087)
	at org.apache.zookeeper.ClientCnxn$SendThread.run(ClientCnxn.java:1139)
[2022-05-30 01:18:25,422] ERROR Unable to resolve address: KAFKA_ZOOKEEPER_CONNECT:2181 (org.apache.zookeeper.client.StaticHostProvider)
java.net.UnknownHostException: KAFKA_ZOOKEEPER_CONNECT
	at java.net.InetAddress.getAllByName0(InetAddress.java:1281)
	at java.net.InetAddress.getAllByName(InetAddress.java:1193)
	at java.net.InetAddress.getAllByName(InetAddress.java:1127)
	at org.apache.zookeeper.client.StaticHostProvider$1.getAllByName(StaticHostProvider.java:92)
	at org.apache.zookeeper.client.StaticHostProvider.resolve(StaticHostProvider.java:147)
	at org.apache.zookeeper.client.StaticHostProvider.next(StaticHostProvider.java:375)
	at org.apache.zookeeper.ClientCnxn$SendThread.run(ClientCnxn.java:1137)
[2022-05-30 01:18:25,423] WARN Session 0x0 for server KAFKA_ZOOKEEPER_CONNECT:2181, unexpected error, closing socket connection and attempting reconnect (org.apache.zookeeper.ClientCnxn)
java.lang.IllegalArgumentException: Unable to canonicalize address KAFKA_ZOOKEEPER_CONNECT:2181 because it's not resolvable
	at org.apache.zookeeper.SaslServerPrincipal.getServerPrincipal(SaslServerPrincipal.java:71)
	at org.apache.zookeeper.SaslServerPrincipal.getServerPrincipal(SaslServerPrincipal.java:39)
	at org.apache.zookeeper.ClientCnxn$SendThread.startConnect(ClientCnxn.java:1087)
	at org.apache.zookeeper.ClientCnxn$SendThread.run(ClientCnxn.java:1139)
[2022-05-30 01:18:26,525] ERROR Unable to resolve address: KAFKA_ZOOKEEPER_CONNECT:2181 (org.apache.zookeeper.client.StaticHostProvider)
java.net.UnknownHostException: KAFKA_ZOOKEEPER_CONNECT
	at java.net.InetAddress.getAllByName0(InetAddress.java:1281)
	at java.net.InetAddress.getAllByName(InetAddress.java:1193)
	at java.net.InetAddress.getAllByName(InetAddress.java:1127)
	at org.apache.zookeeper.client.StaticHostProvider$1.getAllByName(StaticHostProvider.java:92)
	at org.apache.zookeeper.client.StaticHostProvider.resolve(StaticHostProvider.java:147)
	at org.apache.zookeeper.client.StaticHostProvider.next(StaticHostProvider.java:375)
	at org.apache.zookeeper.ClientCnxn$SendThread.run(ClientCnxn.java:1137)
[2022-05-30 01:18:26,526] WARN Session 0x0 for server KAFKA_ZOOKEEPER_CONNECT:2181, unexpected error, closing socket connection and attempting reconnect (org.apache.zookeeper.ClientCnxn)
java.lang.IllegalArgumentException: Unable to canonicalize address KAFKA_ZOOKEEPER_CONNECT:2181 because it's not resolvable
	at org.apache.zookeeper.SaslServerPrincipal.getServerPrincipal(SaslServerPrincipal.java:71)
	at org.apache.zookeeper.SaslServerPrincipal.getServerPrincipal(SaslServerPrincipal.java:39)
	at org.apache.zookeeper.ClientCnxn$SendThread.startConnect(ClientCnxn.java:1087)
	at org.apache.zookeeper.ClientCnxn$SendThread.run(ClientCnxn.java:1139)
[2022-05-30 01:18:27,631] ERROR Unable to resolve address: KAFKA_ZOOKEEPER_CONNECT:2181 (org.apache.zookeeper.client.StaticHostProvider)
java.net.UnknownHostException: KAFKA_ZOOKEEPER_CONNECT
	at java.net.InetAddress.getAllByName0(InetAddress.java:1281)
	at java.net.InetAddress.getAllByName(InetAddress.java:1193)
	at java.net.InetAddress.getAllByName(InetAddress.java:1127)
	at org.apache.zookeeper.client.StaticHostProvider$1.getAllByName(StaticHostProvider.java:92)
	at org.apache.zookeeper.client.StaticHostProvider.resolve(StaticHostProvider.java:147)
	at org.apache.zookeeper.client.StaticHostProvider.next(StaticHostProvider.java:375)
	at org.apache.zookeeper.ClientCnxn$SendThread.run(ClientCnxn.java:1137)
[2022-05-30 01:18:27,632] WARN Session 0x0 for server KAFKA_ZOOKEEPER_CONNECT:2181, unexpected error, closing socket connection and attempting reconnect (org.apache.zookeeper.ClientCnxn)
java.lang.IllegalArgumentException: Unable to canonicalize address KAFKA_ZOOKEEPER_CONNECT:2181 because it's not resolvable
	at org.apache.zookeeper.SaslServerPrincipal.getServerPrincipal(SaslServerPrincipal.java:71)
	at org.apache.zookeeper.SaslServerPrincipal.getServerPrincipal(SaslServerPrincipal.java:39)
	at org.apache.zookeeper.ClientCnxn$SendThread.startConnect(ClientCnxn.java:1087)
	at org.apache.zookeeper.ClientCnxn$SendThread.run(ClientCnxn.java:1139)
[2022-05-30 01:18:28,736] ERROR Unable to resolve address: KAFKA_ZOOKEEPER_CONNECT:2181 (org.apache.zookeeper.client.StaticHostProvider)
java.net.UnknownHostException: KAFKA_ZOOKEEPER_CONNECT
	at java.net.InetAddress.getAllByName0(InetAddress.java:1281)
	at java.net.InetAddress.getAllByName(InetAddress.java:1193)
	at java.net.InetAddress.getAllByName(InetAddress.java:1127)
	at org.apache.zookeeper.client.StaticHostProvider$1.getAllByName(StaticHostProvider.java:92)
	at org.apache.zookeeper.client.StaticHostProvider.resolve(StaticHostProvider.java:147)
	at org.apache.zookeeper.client.StaticHostProvider.next(StaticHostProvider.java:375)
	at org.apache.zookeeper.ClientCnxn$SendThread.run(ClientCnxn.java:1137)
[2022-05-30 01:18:28,737] WARN Session 0x0 for server KAFKA_ZOOKEEPER_CONNECT:2181, unexpected error, closing socket connection and attempting reconnect (org.apache.zookeeper.ClientCnxn)
java.lang.IllegalArgumentException: Unable to canonicalize address KAFKA_ZOOKEEPER_CONNECT:2181 because it's not resolvable
	at org.apache.zookeeper.SaslServerPrincipal.getServerPrincipal(SaslServerPrincipal.java:71)
	at org.apache.zookeeper.SaslServerPrincipal.getServerPrincipal(SaslServerPrincipal.java:39)
	at org.apache.zookeeper.ClientCnxn$SendThread.startConnect(ClientCnxn.java:1087)
	at org.apache.zookeeper.ClientCnxn$SendThread.run(ClientCnxn.java:1139)
[2022-05-30 01:18:29,839] ERROR Unable to resolve address: KAFKA_ZOOKEEPER_CONNECT:2181 (org.apache.zookeeper.client.StaticHostProvider)
java.net.UnknownHostException: KAFKA_ZOOKEEPER_CONNECT
	at java.net.InetAddress.getAllByName0(InetAddress.java:1281)
	at java.net.InetAddress.getAllByName(InetAddress.java:1193)
	at java.net.InetAddress.getAllByName(InetAddress.java:1127)
	at org.apache.zookeeper.client.StaticHostProvider$1.getAllByName(StaticHostProvider.java:92)
	at org.apache.zookeeper.client.StaticHostProvider.resolve(StaticHostProvider.java:147)
	at org.apache.zookeeper.client.StaticHostProvider.next(StaticHostProvider.java:375)
	at org.apache.zookeeper.ClientCnxn$SendThread.run(ClientCnxn.java:1137)
[2022-05-30 01:18:29,840] WARN Session 0x0 for server KAFKA_ZOOKEEPER_CONNECT:2181, unexpected error, closing socket connection and attempting reconnect (org.apache.zookeeper.ClientCnxn)
java.lang.IllegalArgumentException: Unable to canonicalize address KAFKA_ZOOKEEPER_CONNECT:2181 because it's not resolvable
	at org.apache.zookeeper.SaslServerPrincipal.getServerPrincipal(SaslServerPrincipal.java:71)
	at org.apache.zookeeper.SaslServerPrincipal.getServerPrincipal(SaslServerPrincipal.java:39)
	at org.apache.zookeeper.ClientCnxn$SendThread.startConnect(ClientCnxn.java:1087)
	at org.apache.zookeeper.ClientCnxn$SendThread.run(ClientCnxn.java:1139)
^C/opt/kafka_2.13-2.8.1/bin # 
/opt/kafka_2.13-2.8.1/bin # 
/opt/kafka_2.13-2.8.1/bin # 
/opt/kafka_2.13-2.8.1/bin # 
/opt/kafka_2.13-2.8.1/bin # 
/opt/kafka_2.13-2.8.1/bin # sh kafka-topics.sh --list --zookeeper zookeeper:2181
__consumer_offsets
app
contract
dynamic_policy
emergency
instance
log
policy
purge_instance
purge_synchronization
sudden
synchronization
test
voc
/opt/kafka_2.13-2.8.1/bin # sh kafka-topics.sh help
Command must include exactly one action: --list, --describe, --create, --alter or --delete
Option                                   Description                            
------                                   -----------                            
--alter                                  Alter the number of partitions,        
                                           replica assignment, and/or           
                                           configuration for the topic.         
--at-min-isr-partitions                  if set when describing topics, only    
                                           show partitions whose isr count is   
                                           equal to the configured minimum. Not 
                                           supported with the --zookeeper       
                                           option.                              
--bootstrap-server <String: server to    REQUIRED: The Kafka server to connect  
  connect to>                              to. In case of providing this, a     
                                           direct Zookeeper connection won't be 
                                           required.                            
--command-config <String: command        Property file containing configs to be 
  config property file>                    passed to Admin Client. This is used 
                                           only with --bootstrap-server option  
                                           for describing and altering broker   
                                           configs.                             
--config <String: name=value>            A topic configuration override for the 
                                           topic being created or altered. The  
                                           following is a list of valid         
                                           configurations:                      
                                         	cleanup.policy                        
                                         	compression.type                      
                                         	delete.retention.ms                   
                                         	file.delete.delay.ms                  
                                         	flush.messages                        
                                         	flush.ms                              
                                         	follower.replication.throttled.       
                                           replicas                             
                                         	index.interval.bytes                  
                                         	leader.replication.throttled.replicas 
                                         	max.compaction.lag.ms                 
                                         	max.message.bytes                     
                                         	message.downconversion.enable         
                                         	message.format.version                
                                         	message.timestamp.difference.max.ms   
                                         	message.timestamp.type                
                                         	min.cleanable.dirty.ratio             
                                         	min.compaction.lag.ms                 
                                         	min.insync.replicas                   
                                         	preallocate                           
                                         	retention.bytes                       
                                         	retention.ms                          
                                         	segment.bytes                         
                                         	segment.index.bytes                   
                                         	segment.jitter.ms                     
                                         	segment.ms                            
                                         	unclean.leader.election.enable        
                                         See the Kafka documentation for full   
                                           details on the topic configs. It is  
                                           supported only in combination with --
                                           create if --bootstrap-server option  
                                           is used (the kafka-configs CLI       
                                           supports altering topic configs with 
                                           a --bootstrap-server option).        
--create                                 Create a new topic.                    
--delete                                 Delete a topic                         
--delete-config <String: name>           A topic configuration override to be   
                                           removed for an existing topic (see   
                                           the list of configurations under the 
                                           --config option). Not supported with 
                                           the --bootstrap-server option.       
--describe                               List details for the given topics.     
--disable-rack-aware                     Disable rack aware replica assignment  
--exclude-internal                       exclude internal topics when running   
                                           list or describe command. The        
                                           internal topics will be listed by    
                                           default                              
--force                                  Suppress console prompts               
--help                                   Print usage information.               
--if-exists                              if set when altering or deleting or    
                                           describing topics, the action will   
                                           only execute if the topic exists.    
--if-not-exists                          if set when creating topics, the       
                                           action will only execute if the      
                                           topic does not already exist.        
--list                                   List all available topics.             
--partitions <Integer: # of partitions>  The number of partitions for the topic 
                                           being created or altered (WARNING:   
                                           If partitions are increased for a    
                                           topic that has a key, the partition  
                                           logic or ordering of the messages    
                                           will be affected). If not supplied   
                                           for create, defaults to the cluster  
                                           default.                             
--replica-assignment <String:            A list of manual partition-to-broker   
  broker_id_for_part1_replica1 :           assignments for the topic being      
  broker_id_for_part1_replica2 ,           created or altered.                  
  broker_id_for_part2_replica1 :                                                
  broker_id_for_part2_replica2 , ...>                                           
--replication-factor <Integer:           The replication factor for each        
  replication factor>                      partition in the topic being         
                                           created. If not supplied, defaults   
                                           to the cluster default.              
--topic <String: topic>                  The topic to create, alter, describe   
                                           or delete. It also accepts a regular 
                                           expression, except for --create      
                                           option. Put topic name in double     
                                           quotes and use the '\' prefix to     
                                           escape regular expression symbols; e.
                                           g. "test\.topic".                    
--topics-with-overrides                  if set when describing topics, only    
                                           show topics that have overridden     
                                           configs                              
--unavailable-partitions                 if set when describing topics, only    
                                           show partitions whose leader is not  
                                           available                            
--under-min-isr-partitions               if set when describing topics, only    
                                           show partitions whose isr count is   
                                           less than the configured minimum.    
                                           Not supported with the --zookeeper   
                                           option.                              
--under-replicated-partitions            if set when describing topics, only    
                                           show under replicated partitions     
--version                                Display Kafka version.                 
--zookeeper <String: hosts>              DEPRECATED, The connection string for  
                                           the zookeeper connection in the form 
                                           host:port. Multiple hosts can be     
                                           given to allow fail-over.            
/opt/kafka_2.13-2.8.1/bin # sh kafka-topics.sh --topic dynamic_policy
Command must include exactly one action: --list, --describe, --create, --alter or --delete
Option                                   Description                            
------                                   -----------                            
--alter                                  Alter the number of partitions,        
                                           replica assignment, and/or           
                                           configuration for the topic.         
--at-min-isr-partitions                  if set when describing topics, only    
                                           show partitions whose isr count is   
                                           equal to the configured minimum. Not 
                                           supported with the --zookeeper       
                                           option.                              
--bootstrap-server <String: server to    REQUIRED: The Kafka server to connect  
  connect to>                              to. In case of providing this, a     
                                           direct Zookeeper connection won't be 
                                           required.                            
--command-config <String: command        Property file containing configs to be 
  config property file>                    passed to Admin Client. This is used 
                                           only with --bootstrap-server option  
                                           for describing and altering broker   
                                           configs.                             
--config <String: name=value>            A topic configuration override for the 
                                           topic being created or altered. The  
                                           following is a list of valid         
                                           configurations:                      
                                         	cleanup.policy                        
                                         	compression.type                      
                                         	delete.retention.ms                   
                                         	file.delete.delay.ms                  
                                         	flush.messages                        
                                         	flush.ms                              
                                         	follower.replication.throttled.       
                                           replicas                             
                                         	index.interval.bytes                  
                                         	leader.replication.throttled.replicas 
                                         	max.compaction.lag.ms                 
                                         	max.message.bytes                     
                                         	message.downconversion.enable         
                                         	message.format.version                
                                         	message.timestamp.difference.max.ms   
                                         	message.timestamp.type                
                                         	min.cleanable.dirty.ratio             
                                         	min.compaction.lag.ms                 
                                         	min.insync.replicas                   
                                         	preallocate                           
                                         	retention.bytes                       
                                         	retention.ms                          
                                         	segment.bytes                         
                                         	segment.index.bytes                   
                                         	segment.jitter.ms                     
                                         	segment.ms                            
                                         	unclean.leader.election.enable        
                                         See the Kafka documentation for full   
                                           details on the topic configs. It is  
                                           supported only in combination with --
                                           create if --bootstrap-server option  
                                           is used (the kafka-configs CLI       
                                           supports altering topic configs with 
                                           a --bootstrap-server option).        
--create                                 Create a new topic.                    
--delete                                 Delete a topic                         
--delete-config <String: name>           A topic configuration override to be   
                                           removed for an existing topic (see   
                                           the list of configurations under the 
                                           --config option). Not supported with 
                                           the --bootstrap-server option.       
--describe                               List details for the given topics.     
--disable-rack-aware                     Disable rack aware replica assignment  
--exclude-internal                       exclude internal topics when running   
                                           list or describe command. The        
                                           internal topics will be listed by    
                                           default                              
--force                                  Suppress console prompts               
--help                                   Print usage information.               
--if-exists                              if set when altering or deleting or    
                                           describing topics, the action will   
                                           only execute if the topic exists.    
--if-not-exists                          if set when creating topics, the       
                                           action will only execute if the      
                                           topic does not already exist.        
--list                                   List all available topics.             
--partitions <Integer: # of partitions>  The number of partitions for the topic 
                                           being created or altered (WARNING:   
                                           If partitions are increased for a    
                                           topic that has a key, the partition  
                                           logic or ordering of the messages    
                                           will be affected). If not supplied   
                                           for create, defaults to the cluster  
                                           default.                             
--replica-assignment <String:            A list of manual partition-to-broker   
  broker_id_for_part1_replica1 :           assignments for the topic being      
  broker_id_for_part1_replica2 ,           created or altered.                  
  broker_id_for_part2_replica1 :                                                
  broker_id_for_part2_replica2 , ...>                                           
--replication-factor <Integer:           The replication factor for each        
  replication factor>                      partition in the topic being         
                                           created. If not supplied, defaults   
                                           to the cluster default.              
--topic <String: topic>                  The topic to create, alter, describe   
                                           or delete. It also accepts a regular 
                                           expression, except for --create      
                                           option. Put topic name in double     
                                           quotes and use the '\' prefix to     
                                           escape regular expression symbols; e.
                                           g. "test\.topic".                    
--topics-with-overrides                  if set when describing topics, only    
                                           show topics that have overridden     
                                           configs                              
--unavailable-partitions                 if set when describing topics, only    
                                           show partitions whose leader is not  
                                           available                            
--under-min-isr-partitions               if set when describing topics, only    
                                           show partitions whose isr count is   
                                           less than the configured minimum.    
                                           Not supported with the --zookeeper   
                                           option.                              
--under-replicated-partitions            if set when describing topics, only    
                                           show under replicated partitions     
--version                                Display Kafka version.                 
--zookeeper <String: hosts>              DEPRECATED, The connection string for  
                                           the zookeeper connection in the form 
                                           host:port. Multiple hosts can be     
                                           given to allow fail-over.            
/opt/kafka_2.13-2.8.1/bin # sh kafka-topics.sh --topic dynamic_policy --delete --zookeeper zookeeper:2181
Topic dynamic_policy is marked for deletion.
Note: This will have no impact if delete.topic.enable is not set to true.
/opt/kafka_2.13-2.8.1/bin # 
/opt/kafka_2.13-2.8.1/bin # 
/opt/kafka_2.13-2.8.1/bin # 
/opt/kafka_2.13-2.8.1/bin # 
/opt/kafka_2.13-2.8.1/bin # ls
connect-distributed.sh               kafka-console-producer.sh            kafka-log-dirs.sh                    kafka-server-start.sh                windows
connect-mirror-maker.sh              kafka-consumer-groups.sh             kafka-metadata-shell.sh              kafka-server-stop.sh                 zookeeper-security-migration.sh
connect-standalone.sh                kafka-consumer-perf-test.sh          kafka-mirror-maker.sh                kafka-storage.sh                     zookeeper-server-start.sh
kafka-acls.sh                        kafka-delegation-tokens.sh           kafka-preferred-replica-election.sh  kafka-streams-application-reset.sh   zookeeper-server-stop.sh
kafka-broker-api-versions.sh         kafka-delete-records.sh              kafka-producer-perf-test.sh          kafka-topics.sh                      zookeeper-shell.sh
kafka-cluster.sh                     kafka-dump-log.sh                    kafka-reassign-partitions.sh         kafka-verifiable-consumer.sh
kafka-configs.sh                     kafka-features.sh                    kafka-replica-verification.sh        kafka-verifiable-producer.sh
kafka-console-consumer.sh            kafka-leader-election.sh             kafka-run-class.sh                   trogdor.sh
/opt/kafka_2.13-2.8.1/bin # cd ..
/opt/kafka_2.13-2.8.1 # ls
LICENSE    NOTICE     bin        config     libs       licenses   logs       site-docs
/opt/kafka_2.13-2.8.1 # cd ..
/opt # cd kafka
/opt/kafka_2.13-2.8.1 # ls
LICENSE    NOTICE     bin        config     libs       licenses   logs       site-docs
/opt/kafka_2.13-2.8.1 # cd config
/opt/kafka_2.13-2.8.1/config # ls
connect-console-sink.properties    connect-file-source.properties     consumer.properties                server.properties
connect-console-source.properties  connect-log4j.properties           kraft                              tools-log4j.properties
connect-distributed.properties     connect-mirror-maker.properties    log4j.properties                   trogdor.conf
connect-file-sink.properties       connect-standalone.properties      producer.properties                zookeeper.properties
/opt/kafka_2.13-2.8.1/config # vi server.properties 
/opt/kafka_2.13-2.8.1/config # 
/opt/kafka_2.13-2.8.1/config # 
/opt/kafka_2.13-2.8.1/config # 
/opt/kafka_2.13-2.8.1/config # cd ..
/opt/kafka_2.13-2.8.1 # cd bin
/opt/kafka_2.13-2.8.1/bin # ls
connect-distributed.sh               kafka-console-producer.sh            kafka-log-dirs.sh                    kafka-server-start.sh                windows
connect-mirror-maker.sh              kafka-consumer-groups.sh             kafka-metadata-shell.sh              kafka-server-stop.sh                 zookeeper-security-migration.sh
connect-standalone.sh                kafka-consumer-perf-test.sh          kafka-mirror-maker.sh                kafka-storage.sh                     zookeeper-server-start.sh
kafka-acls.sh                        kafka-delegation-tokens.sh           kafka-preferred-replica-election.sh  kafka-streams-application-reset.sh   zookeeper-server-stop.sh
kafka-broker-api-versions.sh         kafka-delete-records.sh              kafka-producer-perf-test.sh          kafka-topics.sh                      zookeeper-shell.sh
kafka-cluster.sh                     kafka-dump-log.sh                    kafka-reassign-partitions.sh         kafka-verifiable-consumer.sh
kafka-configs.sh                     kafka-features.sh                    kafka-replica-verification.sh        kafka-verifiable-producer.sh
kafka-console-consumer.sh            kafka-leader-election.sh             kafka-run-class.sh                   trogdor.sh
/opt/kafka_2.13-2.8.1/bin # sh kafka-topics.sh 
Create, delete, describe, or change a topic.
Option                                   Description                            
------                                   -----------                            
--alter                                  Alter the number of partitions,        
                                           replica assignment, and/or           
                                           configuration for the topic.         
--at-min-isr-partitions                  if set when describing topics, only    
                                           show partitions whose isr count is   
                                           equal to the configured minimum. Not 
                                           supported with the --zookeeper       
                                           option.                              
--bootstrap-server <String: server to    REQUIRED: The Kafka server to connect  
  connect to>                              to. In case of providing this, a     
                                           direct Zookeeper connection won't be 
                                           required.                            
--command-config <String: command        Property file containing configs to be 
  config property file>                    passed to Admin Client. This is used 
                                           only with --bootstrap-server option  
                                           for describing and altering broker   
                                           configs.                             
--config <String: name=value>            A topic configuration override for the 
                                           topic being created or altered. The  
                                           following is a list of valid         
                                           configurations:                      
                                         	cleanup.policy                        
                                         	compression.type                      
                                         	delete.retention.ms                   
                                         	file.delete.delay.ms                  
                                         	flush.messages                        
                                         	flush.ms                              
                                         	follower.replication.throttled.       
                                           replicas                             
                                         	index.interval.bytes                  
                                         	leader.replication.throttled.replicas 
                                         	max.compaction.lag.ms                 
                                         	max.message.bytes                     
                                         	message.downconversion.enable         
                                         	message.format.version                
                                         	message.timestamp.difference.max.ms   
                                         	message.timestamp.type                
                                         	min.cleanable.dirty.ratio             
                                         	min.compaction.lag.ms                 
                                         	min.insync.replicas                   
                                         	preallocate                           
                                         	retention.bytes                       
                                         	retention.ms                          
                                         	segment.bytes                         
                                         	segment.index.bytes                   
                                         	segment.jitter.ms                     
                                         	segment.ms                            
                                         	unclean.leader.election.enable        
                                         See the Kafka documentation for full   
                                           details on the topic configs. It is  
                                           supported only in combination with --
                                           create if --bootstrap-server option  
                                           is used (the kafka-configs CLI       
                                           supports altering topic configs with 
                                           a --bootstrap-server option).        
--create                                 Create a new topic.                    
--delete                                 Delete a topic                         
--delete-config <String: name>           A topic configuration override to be   
                                           removed for an existing topic (see   
                                           the list of configurations under the 
                                           --config option). Not supported with 
                                           the --bootstrap-server option.       
--describe                               List details for the given topics.     
--disable-rack-aware                     Disable rack aware replica assignment  
--exclude-internal                       exclude internal topics when running   
                                           list or describe command. The        
                                           internal topics will be listed by    
                                           default                              
--force                                  Suppress console prompts               
--help                                   Print usage information.               
--if-exists                              if set when altering or deleting or    
                                           describing topics, the action will   
                                           only execute if the topic exists.    
--if-not-exists                          if set when creating topics, the       
                                           action will only execute if the      
                                           topic does not already exist.        
--list                                   List all available topics.             
--partitions <Integer: # of partitions>  The number of partitions for the topic 
                                           being created or altered (WARNING:   
                                           If partitions are increased for a    
                                           topic that has a key, the partition  
                                           logic or ordering of the messages    
                                           will be affected). If not supplied   
                                           for create, defaults to the cluster  
                                           default.                             
--replica-assignment <String:            A list of manual partition-to-broker   
  broker_id_for_part1_replica1 :           assignments for the topic being      
  broker_id_for_part1_replica2 ,           created or altered.                  
  broker_id_for_part2_replica1 :                                                
  broker_id_for_part2_replica2 , ...>                                           
--replication-factor <Integer:           The replication factor for each        
  replication factor>                      partition in the topic being         
                                           created. If not supplied, defaults   
                                           to the cluster default.              
--topic <String: topic>                  The topic to create, alter, describe   
                                           or delete. It also accepts a regular 
                                           expression, except for --create      
                                           option. Put topic name in double     
                                           quotes and use the '\' prefix to     
                                           escape regular expression symbols; e.
                                           g. "test\.topic".                    
--topics-with-overrides                  if set when describing topics, only    
                                           show topics that have overridden     
                                           configs                              
--unavailable-partitions                 if set when describing topics, only    
                                           show partitions whose leader is not  
                                           available                            
--under-min-isr-partitions               if set when describing topics, only    
                                           show partitions whose isr count is   
                                           less than the configured minimum.    
                                           Not supported with the --zookeeper   
                                           option.                              
--under-replicated-partitions            if set when describing topics, only    
                                           show under replicated partitions     
--version                                Display Kafka version.                 
--zookeeper <String: hosts>              DEPRECATED, The connection string for  
                                           the zookeeper connection in the form 
                                           host:port. Multiple hosts can be     
                                           given to allow fail-over.            
/opt/kafka_2.13-2.8.1/bin # sh kafka-topics.sh --list
Exception in thread "main" java.lang.IllegalArgumentException: Only one of --bootstrap-server or --zookeeper must be specified
	at kafka.admin.TopicCommand$TopicCommandOptions.checkArgs(TopicCommand.scala:743)
	at kafka.admin.TopicCommand$.main(TopicCommand.scala:53)
	at kafka.admin.TopicCommand.main(TopicCommand.scala)
/opt/kafka_2.13-2.8.1/bin # sh kafka-topics.sh --list --zookeeper zookeeper:2181
__consumer_offsets
app
contract
emergency
instance
log
policy
purge_instance
purge_synchronization
sudden
synchronization
test
voc
/opt/kafka_2.13-2.8.1/bin # 
/opt/kafka_2.13-2.8.1/bin # 
/opt/kafka_2.13-2.8.1/bin # 
/opt/kafka_2.13-2.8.1/bin # 
/opt/kafka_2.13-2.8.1/bin # 
