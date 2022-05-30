leehamin@leeui-MacBookPro ~ % psql postgres -U postgres
psql (14.3)
Type "help" for help.

postgres=> INSERT INTO cams.tb_cams_manager_info(
        idx, manager_id, manager_name, email, admin_type, regist_dt, alarm_yn, last_login_date, manager_type, auth, del_yn, ins_dt, ins_id, upd_dt, upd_id, company_cd, company_name, dept_cd, dept_name, client_ip, login_fail_dt, login_fail_cnt)
        VALUES (1, '123', '김은아', 'testEmail', '00', '2022-04-29 13:57:31.47053', 'N', '2022-04-29 13:57:31.47053', '00', null, 'N', '2022-04-29 13:57:31.47053', '123', '2022-04-29 13:57:31.47053', '123', 'testCompanyCD', null, '', null, '0:0:0:0:0:0:0:1', null, 0);
ERROR:  relation "cams.tb_cams_manager_info" does not exist
LINE 1: INSERT INTO cams.tb_cams_manager_info(
                    ^
postgres=> 
CREATE TABLE cams.tb_cams_manager_info (
    idx integer NOT NULL,
    manager_id character varying(27) NOT NULL,
    manager_name character varying(100),
    email character varying(100),
    admin_type character varying(27),
    regist_dt timestamp without time zone NOT NULL,
    alarm_yn character varying(3),
    last_login_date timestamp without time zone,
    manager_type character varying(27),
    auth character varying(3),
    del_yn character varying(3),
    ins_dt timestamp without time zone NOT NULL,
    ins_id character varying(27),
    upd_dt timestamp without time zone,
    upd_id character varying(27),
    company_cd character varying(27),
    company_name character varying(100),
    dept_cd character varying(27),
    dept_name character varying(100),
    client_ip character varying(27),
    login_fail_dt timestamp without time zone,
    login_fail_cnt integer
);
ERROR:  schema "cams" does not exist
LINE 1: CREATE TABLE cams.tb_cams_manager_info (
                     ^
postgres=> 

CREATE SCHEMA aggregate;


ALTER SCHEMA aggregate OWNER TO postgres;

--
-- Name: cams; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA cams;


ALTER SCHEMA cams OWNER TO postgres;

--
-- Name: dimension; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA dimension;


ALTER SCHEMA dimension OWNER TO postgres;

--
-- Name: fact; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA fact;


ALTER SCHEMA fact OWNER TO postgres;

--
-- Name: security; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA security;


ALTER SCHEMA security OWNER TO postgres;

--
-- Name: topology; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA topology;


ALTER SCHEMA topology OWNER TO postgres;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

-- Name: fn_masking(character varying, character); Type: FUNCTION; Schema: cams; Owner: postgresions';
ERROR:  permission denied for database postgres
ERROR:  schema "aggregate" does not exist
ERROR:  permission denied for database postgres
ERROR:  schema "cams" does not exist
ERROR:  permission denied for database postgres
ERROR:  schema "dimension" does not exist
ERROR:  permission denied for database postgres
ERROR:  schema "fact" does not exist
ERROR:  permission denied for database postgres
ERROR:  schema "security" does not exist
ERROR:  permission denied for database postgres
ERROR:  schema "topology" does not exist
NOTICE:  extension "plpgsql" already exists, skipping
CREATE EXTENSION
ERROR:  must be owner of extension plpgsql
ERROR:  permission denied to create extension "pgcrypto"
HINT:  Must have CREATE privilege on current database to create this extension.
ERROR:  extension "pgcrypto" does not exist
ERROR:  could not open extension control file "/usr/local/share/postgresql/extension/postgis.control": No such file or directory
ERROR:  extension "postgis" does not exist
ERROR:  could not open extension control file "/usr/local/share/postgresql/extension/postgis_topology.control": No such file or directory
ERROR:  extension "postgis_topology" does not exist
postgres=> ALTER ROLE postgres CREATEDB;
ERROR:  permission denied
postgres=> \du
                                   List of roles
 Role name |                         Attributes                         | Member of 
-----------+------------------------------------------------------------+-----------
 leehamin  | Superuser, Create role, Create DB, Replication, Bypass RLS | {}
 postgres  |                                                            | {}

postgres=> ALTER ROLE postgres createdb;
ERROR:  permission denied
postgres=> ALTER DATABASE camsdb OWNER TO postgres;
ALTER DATABASE
postgres=>                              

CREATE SCHEMA aggregate;


ALTER SCHEMA aggregate OWNER TO postgres;

--
-- Name: cams; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA cams;


ALTER SCHEMA cams OWNER TO postgres;

--
-- Name: dimension; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA dimension;


ALTER SCHEMA dimension OWNER TO postgres;

--
-- Name: fact; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA fact;


ALTER SCHEMA fact OWNER TO postgres;

--
-- Name: security; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA security;


ALTER SCHEMA security OWNER TO postgres;

--
-- Name: topology; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA topology;


ALTER SCHEMA topology OWNER TO postgres;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

-- Name: fn_masking(character varying, character); Type: FUNCTION; Schema: cams; Owner: postgresions';
ERROR:  permission denied for database postgres
ERROR:  schema "aggregate" does not exist
ERROR:  permission denied for database postgres
ERROR:  schema "cams" does not exist
ERROR:  permission denied for database postgres
ERROR:  schema "dimension" does not exist
ERROR:  permission denied for database postgres
ERROR:  schema "fact" does not exist
ERROR:  permission denied for database postgres
ERROR:  schema "security" does not exist
ERROR:  permission denied for database postgres
ERROR:  schema "topology" does not exist
NOTICE:  extension "plpgsql" already exists, skipping
CREATE EXTENSION
ERROR:  must be owner of extension plpgsql
ERROR:  permission denied to create extension "pgcrypto"
HINT:  Must have CREATE privilege on current database to create this extension.
ERROR:  extension "pgcrypto" does not exist
ERROR:  could not open extension control file "/usr/local/share/postgresql/extension/postgis.control": No such file or directory
ERROR:  extension "postgis" does not exist
ERROR:  could not open extension control file "/usr/local/share/postgresql/extension/postgis_topology.control": No such file or directory
ERROR:  extension "postgis_topology" does not exist
postgres=> \connect camsdb
You are now connected to database "camsdb" as user "postgres".
camsdb=> ALTER DATABASE camsdb OWNER TO postgres;
               ROLE cams_user createdb;
ERROR:  role "cams_user" does not exist
camsdb=> ALTER DATABASE camsdb OWNER TO postgres;
         \du
                                   List of roles
 Role name |                         Attributes                         | Member of 
-----------+------------------------------------------------------------+-----------
 leehamin  | Superuser, Create role, Create DB, Replication, Bypass RLS | {}
 postgres  |                                                            | {}

camsdb=> \q
leehamin@leeui-MacBookPro ~ % psql postgres -U leehamin
psql (14.3)
Type "help" for help.

postgres=# 
ALTER DATABASE camsdb OWNER TO postgres;

\connect camsdb

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: aggregate; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA aggregate;


ALTER SCHEMA aggregate OWNER TO postgres;

--
-- Name: cams; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA cams;


ALTER SCHEMA cams OWNER TO postgres;

--
-- Name: dimension; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA dimension;


ALTER SCHEMA dimension OWNER TO postgres;

--
-- Name: fact; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA fact;


ALTER SCHEMA fact OWNER TO postgres;

--
-- Name: security; Type: SCHEMA; Schema: -; Owner: postgres
--

-- PostgreSQL database dump completems IN SCHEMA cams GRANT SELECT ON TABLES  TO cams_select;BLES  TO cams_dml;on.ktt_dim_voc_statuses(voc_status);ry_no);acturer_no);job_group);name, trigger_group);
ALTER DATABASE
invalid integer value "=" for connection option "port"
Previous connection kept
postgres=# 
ALTER DATABASE camsdb OWNER TO postgres;

\connect camsdb

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: aggregate; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA aggregate;


ALTER SCHEMA aggregate OWNER TO postgres;

--
-- Name: cams; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA cams;


ALTER SCHEMA cams OWNER TO postgres;

--
-- Name: dimension; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA dimension;


ALTER SCHEMA dimension OWNER TO postgres;

--
-- Name: fact; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA fact;


ALTER SCHEMA fact OWNER TO postgres;

--
-- Name: security; Type: SCHEMA; Schema: -; Owner: postgres
--

-- PostgreSQL database dump completems IN SCHEMA cams GRANT SELECT ON TABLES  TO cams_select;BLES  TO cams_dml;on.ktt_dim_voc_statuses(voc_status);ry_no);acturer_no);job_group);name, trigger_group);
ALTER DATABASE
invalid integer value "=" for connection option "port"
Previous connection kept
postgres=# ALTER DATABASE camsdb OWNER TO postgres;
ALTER DATABASE
postgres=# 
\connect camsdb
You are now connected to database "camsdb" as user "leehamin".
camsdb=# 
SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: aggregate; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA aggregate;


ALTER SCHEMA aggregate OWNER TO postgres;

--
-- Name: cams; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA cams;


ALTER SCHEMA cams OWNER TO postgres;
SET
SET
SET
SET
SET
 set_config 
------------
 
(1 row)

SET
SET
SET
SET
ERROR:  schema "aggregate" already exists
ALTER SCHEMA
ERROR:  schema "cams" already exists
ALTER SCHEMA
camsdb=# INSERT INTO cams.tb_cams_manager_info(
        idx, manager_id, manager_name, email, admin_type, regist_dt, alarm_yn, last_login_date, manager_type, auth, del_yn, ins_dt, ins_id, upd_dt, upd_id, company_cd, company_name, dept_cd, dept_name, client_ip, login_fail_dt, login_fail_cnt)
        VALUES (1, '123', '김은아', 'testEmail', '00', '2022-04-29 13:57:31.47053', 'N', '2022-04-29 13:57:31.47053', '00', null, 'N', '2022-04-29 13:57:31.47053', '123', '2022-04-29 13:57:31.47053', '123', 'testCompanyCD', null, '', null, '0:0:0:0:0:0:0:1', null, 0);
INSERT 0 1
camsdb=# CREATE TABLE IF NOT EXISTS cams.tb_cams_green_traffic
(
    id integer NOT NULL DEFAULT nextval('cams.tb_cams_green_traffic_id_seq'::regclass),
    region_code character varying(5) COLLATE pg_catalog."default" NOT NULL,
    start_time character varying(20) COLLATE pg_catalog."default" NOT NULL,
    end_time character varying(20) COLLATE pg_catalog."default" NOT NULL,
    app_start_dt timestamp without time zone NOT NULL,
    app_end_dt timestamp without time zone,
    upd_dt timestamp without time zone NOT NULL,
    CONSTRAINT tb_cams_green_traffic_pkey PRIMARY KEY (id)
);
ERROR:  relation "cams.tb_cams_green_traffic_id_seq" does not exist
LINE 3:     id integer NOT NULL DEFAULT nextval('cams.tb_cams_green_...
                                                ^
camsdb=# grant usage, select on sequence cams.tb_cams_green_id_seq TO leehamin;
ERROR:  relation "cams.tb_cams_green_id_seq" does not exist
camsdb=# grant usage, select on sequence cams.tb_cams_green TO leehamin;
ERROR:  relation "cams.tb_cams_green" does not exist
camsdb=# grant usage, select on sequence cams.tb_cams_green_traffic_id_seq TO leehamin;
ERROR:  relation "cams.tb_cams_green_traffic_id_seq" does not exist
camsdb=# CREATE TABLE cams.tb_cams_green_traffic (
    id serial NOT NULL PRIMARY KEY,
    region_code varchar(5) NOT NULL,
    start_time varchar(20) NOT NULL,
    end_time varchar(20) NOT NULL,
    app_start_dt timestamp NOT NULL,
    app_end_dt timestamp,
    upd_dt timestamp NOT NULL
);
 
INSERT INTO cams.tb_cams_green_traffic(region_code, start_time, end_time, app_start_dt, upd_dt)
VALUES ('1', '0600', '2100', '2022-05-08 00:00:00+09', current_timestamp);
 
grant usage, select on sequence cams.tb_cams_green_traffic_id_seq to cams_user;
CREATE TABLE
INSERT 0 1
ERROR:  role "cams_user" does not exist
camsdb=# CREATE TABLE cams.tb_cams_green_traffic (
    id serial NOT NULL PRIMARY KEY,
    region_code varchar(5) NOT NULL,
    start_time varchar(20) NOT NULL,
    end_time varchar(20) NOT NULL,
    app_start_dt timestamp NOT NULL,
    app_end_dt timestamp,
    upd_dt timestamp NOT NULL
);
 
INSERT INTO cams.tb_cams_green_traffic(region_code, start_time, end_time, app_start_dt, upd_dt)
VALUES ('1', '0600', '2100', '2022-05-08 00:00:00+09', current_timestamp);
 
grant usage, select on sequence cams.tb_cams_green_traffic_id_seq to leehamin;
ERROR:  relation "tb_cams_green_traffic" already exists
INSERT 0 1
GRANT
camsdb=# CREATE TABLE cams.tb_cams_green_traffic_history (
    id serial NOT NULL PRIMARY KEY,
    instance_id integer,
    region_code varchar(5) NOT NULL,
    start_time varchar(20),
    end_time varchar(20),
    app_start_dt timestamp,
    app_end_dt timestamp,
    upd_dt timestamp NOT NULL,
    upd_id varchar(15),
    operation_method varchar(10) NOT NULL,
    reason varchar(30)
)
 
GRANT USAGE, SELECT ON SEQUENCE cams.tb_cams_green_traffic_history_id_seq TO leehamin 
camsdb-# ;
ERROR:  syntax error at or near "GRANT"
LINE 15: GRANT USAGE, SELECT ON SEQUENCE cams.tb_cams_green_traffic_h...
         ^
camsdb=# CREATE TABLE cams.tb_cams_green_traffic_history (
    id serial NOT NULL PRIMARY KEY,
    instance_id integer,
    region_code varchar(5) NOT NULL,
    start_time varchar(20),
    end_time varchar(20),
    app_start_dt timestamp,
    app_end_dt timestamp,
    upd_dt timestamp NOT NULL,
    upd_id varchar(15),
    operation_method varchar(10) NOT NULL,
    reason varchar(30)
);
 
GRANT USAGE, SELECT ON SEQUENCE cams.tb_cams_green_traffic_history_id_seq TO leehamin
;
CREATE TABLE
GRANT
camsdb=# create USER cams_user WITH ENCRYPTED PASSWORD 'cams#2018';
CREATE ROLE
camsdb=# GRANT CONNECT ON DATABASE camsdb TO cams_user;
GRANT USAGE ON SCHEMA cams TO cams_user ;
GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA cams TO cams_user;
GRANT USAGE, SELECT, UPDATE ON ALL SEQUENCES IN SCHEMA cams TO cams_user;
GRANT
GRANT
GRANT
GRANT
camsdb=# drop table cams.tb_cams_green_traffic
camsdb-# ;
DROP TABLE
camsdb=# CREATE TABLE cams.tb_cams_green_traffic ( id serial NOT NULL PRIMARY KEY, region_code varchar(5) NOT NULL, start_time varchar(20) NOT NULL, end_time varchar(20) NOT NULL, app_start_dt timestamp NOT NULL, app_end_dt timestamp, upd_dt timestamp NOT NULL,
ins_dt timestamp NOT NULL,
upd_id varchar(27),
ins_id varchar(27) );
CREATE TABLE
camsdb=# select * from cams.tb_cams_green_traffic
camsdb-# INSERT INTO cams.tb_cams_green_traffic(region_code, start_time, end_time, app_start_dt, upd_dt) VALUES ('1', '0600', '2100', '2022-05-20 00:00:00+09', current_timestamp, 123, 123, 123);
ERROR:  syntax error at or near "INTO"
LINE 2: INSERT INTO cams.tb_cams_green_traffic(region_code, start_ti...
               ^
camsdb=# select * from cams.tb_cams_green_traffic
INSERT INTO cams.tb_cams_green_traffic(region_code, start_time, end_time, app_start_dt, upd_dt) VALUES ('1', '0600', '2100', '2022-05-20 00:00:00+09', current_timestamp, 123, 123, 123);
ERROR:  syntax error at or near "INTO"
LINE 2: INSERT INTO cams.tb_cams_green_traffic(region_code, start_ti...
               ^
camsdb=# ;
camsdb=# 
camsdb=# 
camsdb=# 
camsdb=# INSERT INTO cams.tb_cams_green_traffic(region_code, start_time, end_time, app_start_dt, upd_dt) VALUES ('1', '0600', '2100', '2022-05-08 00:00:00+09', current_timestamp, 123, 123, 123);
ERROR:  INSERT has more expressions than target columns
LINE 1: ...00', '2022-05-08 00:00:00+09', current_timestamp, 123, 123, ...
                                                             ^
camsdb=# INSERT INTO cams.tb_cams_green_traffic(region_code, start_time, end_time, app_start_dt, upd_dt, ins_dt, upd_id, ins_id) VALUES ('1', '0600', '2100', '2022-05-08 00:00:00+09', current_timestamp, 123, 123, 123);
ERROR:  column "ins_dt" is of type timestamp without time zone but expression is of type integer
LINE 1: ...00', '2022-05-08 00:00:00+09', current_timestamp, 123, 123, ...
                                                             ^
HINT:  You will need to rewrite or cast the expression.
camsdb=# INSERT INTO cams.tb_cams_green_traffic(region_code, start_time, end_time, app_start_dt, upd_dt, ins_dt, upd_id, ins_id) VALUES ('1', '0600', '2100', '2022-05-20 00:00:00+09', current_timestamp, current_timestamp, 123, 123);
INSERT 0 1
camsdb=# GRANT SELECT ON TABLE scm1.testTable TO leehamin;
ERROR:  schema "scm1" does not exist
camsdb=# GRANT SELECT ON TABLE cams.tb_cams_green_traffic TO leehamin;
GRANT
camsdb=# select * from cams.tb_cams_green_traffic
camsdb-# 
camsdb-# 
camsdb-# 
camsdb-# psql postgres -U postgres
camsdb-# psql postgres -U postgres
camsdb-# 
camsdb-# 
camsdb-# 
camsdb-# \du
                                   List of roles
 Role name |                         Attributes                         | Member of 
-----------+------------------------------------------------------------+-----------
 cams_user |                                                            | {}
 leehamin  | Superuser, Create role, Create DB, Replication, Bypass RLS | {}
 postgres  |                                                            | {}

camsdb-# ALTER ROLE cams_user CREATEDB;
ERROR:  syntax error at or near "postgres"
LINE 2: psql postgres -U postgres
             ^
camsdb=# 
camsdb=# 
camsdb=# 
camsdb=# ;
camsdb=# ALTER ROLE cams_user CREATEDB;
ALTER ROLE
camsdb=# ALTER ROLE cams_user CREATEROLE;
ALTER ROLE
camsdb=# GRANT ALL PRIVILIEGES ON TABLE cams.tb_cams_green_traffic to cams_user;
ERROR:  syntax error at or near "PRIVILIEGES"
LINE 1: GRANT ALL PRIVILIEGES ON TABLE cams.tb_cams_green_traffic to...
                  ^
camsdb=# 
camsdb=# 
camsdb=# ;
camsdb=# GRANT ALL PRIVILIEGES ON TABLE cams.tb_cams_green_traffic to cams_user;
ERROR:  syntax error at or near "PRIVILIEGES"
LINE 1: GRANT ALL PRIVILIEGES ON TABLE cams.tb_cams_green_traffic to...
                  ^
camsdb=# GRANT ALL PRIVILIEGES ON TABLE cams.tb_cams_green_traffic to cams_use;
ERROR:  syntax error at or near "PRIVILIEGES"
LINE 1: GRANT ALL PRIVILIEGES ON TABLE cams.tb_cams_green_traffic to...
                  ^
camsdb=# 
camsdb=# 
camsdb=# GRANT ALL PRIVILEGES ON TABLE cams.tb_cams_green_traffic to cams_user;
GRANT
camsdb=# select * from cams.tb_cams_green_traffic to cams_user;
ERROR:  syntax error at or near "to"
LINE 1: select * from cams.tb_cams_green_traffic to cams_user;
                                                 ^
camsdb=# select * from cams.tb_cams_green_traffic;
 id | region_code | start_time | end_time |    app_start_dt     | app_end_dt |           upd_dt           |           ins_dt           | upd_id | ins_id 
----+-------------+------------+----------+---------------------+------------+----------------------------+----------------------------+--------+--------
  1 | 1           | 0600       | 2100     | 2022-05-20 00:00:00 |            | 2022-05-30 20:03:40.468451 | 2022-05-30 20:03:40.468451 | 123    | 123
(1 row)

camsdb=# 
camsdb=# 
camsdb=# 
camsdb=# 
camsdb=# 
camsdb=# 
camsdb=# 
