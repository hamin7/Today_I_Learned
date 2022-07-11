Last login: Thu Jul  7 10:31:57 on ttys009
leehamin@leeui-MacBookPro ~ % docker exec -it db3c283c7da7fb44868ae2fba33894c11521256f5e8434a396534e04da072c4b /bin/sh
/ # ls
bin    dev    etc    home   kafka  lib    lib64  media  mnt    opt    proc   root   run    sbin   srv    sys    tmp    usr    var
/ # cd opt
/opt # ls
kafka             kafka_2.13-2.8.1  overrides
/opt # cd kafka
/opt/kafka_2.13-2.8.1 # ls
LICENSE    NOTICE     bin        config     libs       licenses   logs       site-docs
/opt/kafka_2.13-2.8.1 # cd bin
/opt/kafka_2.13-2.8.1/bin # sh kafka-topics.sh --list --zookeeper zookeeper:2181
__consumer_offsets
app
contract
emergency
green_policy
instance
log
policy
purge_instance
purge_synchronization
sudden
synchronization
test
voc
/opt/kafka_2.13-2.8.1/bin # sh kafka-topics.sh --list --zookeeper zookeeper:2181
__consumer_offsets
app
contract
emergency
green_policy
instance
log
policy
purge_instance
purge_synchronization
sudden
synchronization
test
voc
/opt/kafka_2.13-2.8.1/bin # sh kafka-topics.sh --list --zookeeper zookeeper:2181
__consumer_offsets
app
contract
emergency
green_policy
instance
log
policy
purge_instance
purge_synchronization
sudden
synchronization
test
voc
/opt/kafka_2.13-2.8.1/bin # sh kafka-topics.sh --topic green_policy --delete --zookeeper zookeeper:2181
Topic green_policy is marked for deletion.
Note: This will have no impact if delete.topic.enable is not set to true.
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
/opt/kafka_2.13-2.8.1/bin # sh kafka-topics.sh --topic green_policy --delete --zookeeper zookeeper:2181
Topic green_policy is marked for deletion.
Note: This will have no impact if delete.topic.enable is not set to true.
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
/opt/kafka_2.13-2.8.1/bin # sh kafka-topics.sh --list --zookeeper zookeeper:2181
__consumer_offsets
app
contract
emergency
green_policy
instance
log
policy
purge_instance
purge_synchronization
sudden
synchronization
test
voc
/opt/kafka_2.13-2.8.1/bin # sh kafka-topics.sh --topic green_policy --delete --zookeeper zookeeper:2181
Topic green_policy is marked for deletion.
Note: This will have no impact if delete.topic.enable is not set to true.
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
/opt/kafka_2.13-2.8.1/bin # sh kafka-topics.sh --topic green_policy --delete --zookeeper zookeeper:2181
Topic green_policy is marked for deletion.
Note: This will have no impact if delete.topic.enable is not set to true.
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
/opt/kafka_2.13-2.8.1/bin # sh kafka-topics.sh --topic green_policy --delete --zookeeper z
ookeeper:2181
Topic green_policy is marked for deletion.
Note: This will have no impact if delete.topic.enable is not set to true.
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
/opt/kafka_2.13-2.8.1/bin # sh kafka-topics.sh --list --zookeeper zookeeper:2181
__consumer_offsets
app
contract
emergency
green_policy
instance
log
policy
purge_instance
purge_synchronization
sudden
synchronization
test
voc
/opt/kafka_2.13-2.8.1/bin # sh kafka-topics.sh --topic green_policy --delete --zookeeper z
ookeeper:2181
Topic green_policy is marked for deletion.
Note: This will have no impact if delete.topic.enable is not set to true.
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
/opt/kafka_2.13-2.8.1/bin # sh kafka-topics.sh --list --zookeeper zookeeper:2181
__consumer_offsets
app
contract
emergency
green_policy
instance
log
policy
purge_instance
purge_synchronization
sudden
synchronization
test
voc
/opt/kafka_2.13-2.8.1/bin # sh kafka-topics.sh --topic green_policy --delete --zookeeper z
ookeeper:2181
Topic green_policy is marked for deletion.
Note: This will have no impact if delete.topic.enable is not set to true.
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
/opt/kafka_2.13-2.8.1/bin # %                                                    leehamin@leeui-MacBookPro ~ % 
  [복원됨 2022. 7. 11. 오후 1:59:50]
Last login: Mon Jul 11 13:59:49 on ttys002
Restored session: 2022년 7월  7일 목요일 18시 03분 27초 KST
leehamin@leeuiMacBookPro ~ % 
leehamin@leeuiMacBookPro ~ % 
leehamin@leeuiMacBookPro ~ % psql postgres                                                                           
psql (14.3)
Type "help" for help.

postgres=# \connect camsdb
You are now connected to database "camsdb" as user "leehamin".
camsdb=# select * from cams.tb_cams_green_traffic;
 id | region_code | start_time | end_time |    app_start_dt     |     app_end_dt      |           upd_dt           |           ins_dt           | upd_id | ins_id | valid_yn 
----+-------------+------------+----------+---------------------+---------------------+----------------------------+----------------------------+--------+--------+----------
 15 | 1           | 0500       | 2100     | 2022-06-01 00:00:00 | 2022-06-10 00:00:00 | 2022-06-09 13:33:08.196201 | 2022-06-09 13:33:08.196201 | 123    | 123    | Y
 17 | 1           | 0800       | 1800     | 2022-06-15 00:00:00 |                     | 2022-06-09 13:34:14.758811 | 2022-06-09 13:34:14.758811 | 123    | 123    | Y
(2 rows)

camsdb=# delete from cams.tb_cams_green_traffic where id=15;
DELETE 1
camsdb=# select * from cams.tb_cams_green_traffic;
 id | region_code | start_time | end_time |    app_start_dt     | app_end_dt |           upd_dt           |           ins_dt           | upd_id | ins_id | valid_yn 
----+-------------+------------+----------+---------------------+------------+----------------------------+----------------------------+--------+--------+----------
 17 | 1           | 0800       | 1800     | 2022-06-15 00:00:00 |            | 2022-06-09 13:34:14.758811 | 2022-06-09 13:34:14.758811 | 123    | 123    | Y
(1 row)

...skipping...
 id | region_code | start_time | end_time |    app_start_dt     | app_end_dt |           upd_dt           |           ins_dt           | upd_id | ins_id | valid_yn 
----+-------------+------------+----------+---------------------+------------+----------------------------+----------------------------+--------+--------+----------
 17 | 1           | 0800       | 1800     | 2022-06-15 00:00:00 |            | 2022-06-09 13:34:14.758811 | 2022-06-09 13:34:14.758811 | 123    | 123    | Y
(1 row)

camsdb=# delete from cams.tb_cams_green_traffic where id=17;
DELETE 1
camsdb=# select * from cams.tb_cams_green_traffic;
 id | region_code | start_time | end_time | app_start_dt | app_end_dt | upd_dt | ins_dt | upd_id | ins_id | valid_yn 
----+-------------+------------+----------+--------------+------------+--------+--------+--------+--------+----------
(0 rows)

camsdb=# INSERT INTO cams.tb_cams_green_traffic(id, region_code, start_time, end_time, app_start_dt, upd_dt, ins_dt, upd_id, ins_id, valid_yn) VALUES (1, '1', '0500', '2100', '2022-07-10 00:00:00+09', current_timestamp, current_timestamp, 123, 123,'y');
INSERT 0 1
camsdb=# select * from cams.tb_cams_green_traffic;
 id | region_code | start_time | end_time |    app_start_dt     | app_end_dt |           upd_dt           |           ins_dt           | upd_id | ins_id | valid_yn 
----+-------------+------------+----------+---------------------+------------+----------------------------+----------------------------+--------+--------+----------
  1 | 1           | 0500       | 2100     | 2022-07-10 00:00:00 |            | 2022-07-11 14:02:39.962589 | 2022-07-11 14:02:39.962589 | 123    | 123    | y
(1 row)

...skipping...
 id | region_code | start_time | end_time |    app_start_dt     | app_end_dt |           upd_dt           |           ins_dt           | upd_id | ins_id | valid_yn 
----+-------------+------------+----------+---------------------+------------+----------------------------+----------------------------+--------+--------+----------
  1 | 1           | 0500       | 2100     | 2022-07-10 00:00:00 |            | 2022-07-11 14:02:39.962589 | 2022-07-11 14:02:39.962589 | 123    | 123    | y
(1 row)

camsdb=# 
camsdb=# INSERT INTO cams.tb_cams_green_traffic(id, region_code, start_time, end_time, app_start_dt, upd_dt, ins_dt, upd_id, ins_id, valid_yn) VALUES (2, '1', '0900', '1800', '2022-07-15 00:00:00+09', current_timestamp, current_timestamp, 123, 123,'y');
INSERT 0 1
camsdb=# select * from cams.tb_cams_green_traffic;
 id | region_code | start_time | end_time |    app_start_dt     | app_end_dt |           upd_dt           |           ins_dt           | upd_id | ins_id | valid_yn 
----+-------------+------------+----------+---------------------+------------+----------------------------+----------------------------+--------+--------+----------
  1 | 1           | 0500       | 2100     | 2022-07-10 00:00:00 |            | 2022-07-11 14:02:39.962589 | 2022-07-11 14:02:39.962589 | 123    | 123    | y
  2 | 1           | 0900       | 1800     | 2022-07-15 00:00:00 |            | 2022-07-11 14:03:11.091189 | 2022-07-11 14:03:11.091189 | 123    | 123    | y
(2 rows)

(END)
