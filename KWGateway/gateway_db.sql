SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS homeappliance;
DROP TABLE IF EXISTS sensor;
DROP TABLE IF EXISTS service;
DROP TABLE IF EXISTS phone;
DROP TABLE IF EXISTS schedule;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS gateway;




/* Create Tables */

CREATE TABLE gateway
(
	-- gateway ID
	gwid varchar(30) NOT NULL COMMENT 'gateway ID',
	-- building
	bd varchar(30) COMMENT 'building',
	-- floor
	flr varchar(30) COMMENT 'floor',
	-- location
	lct varchar(30) COMMENT 'location',
	-- register time
	rt timestamp NOT NULL COMMENT 'register time',
	PRIMARY KEY (gwid),
	UNIQUE (gwid)
);


CREATE TABLE homeappliance
(
	-- home appliance ID
	haid varchar(30) NOT NULL COMMENT 'home appliance ID',
	-- home appliance name
	hanm varchar(30) COMMENT 'home appliance name',
	-- home appliance type
	hat numeric(5) NOT NULL COMMENT 'home appliance type',
	-- home appliance function
	hafc tinytext COMMENT 'home appliance function',
	-- home appliance manufacturer
	hamf varchar(30) NOT NULL COMMENT 'home appliance manufacturer',
	-- gateway ID
	gwid varchar(30) NOT NULL COMMENT 'gateway ID',
	-- register time
	rt timestamp NOT NULL COMMENT 'register time'
);


CREATE TABLE phone
(
	-- phone number
	phnb varchar(20) NOT NULL COMMENT 'phone number',
	-- latitude
	lat double COMMENT 'latitude',
	-- longitude
	lng double COMMENT 'longitude',
	-- address
	addr tinytext COMMENT 'address',
	-- phone state
	phst varchar(10) COMMENT 'phone state',
	-- sound state
	sdst varchar(10) COMMENT 'sound state',
	-- register time
	rt timestamp NOT NULL COMMENT 'register time',
	-- main phone number
	mphnb varchar(20) NOT NULL COMMENT 'main phone number'
);


CREATE TABLE schedule
(
	-- schedule id
	scdid int NOT NULL AUTO_INCREMENT COMMENT 'schedule id',
	-- schedule title
	scdtl tinytext COMMENT 'schedule title',
	-- schedule date
	scddt varchar(20) COMMENT 'schedule date',
	-- schedule time
	scdtm varchar(20) COMMENT 'schedule time',
	-- schedule memo
	scdmm text COMMENT 'schedule memo',
	-- register time
	rt timestamp NOT NULL COMMENT 'register time',
	-- main phone number
	mphnb varchar(20) NOT NULL COMMENT 'main phone number',
	PRIMARY KEY (scdid)
);


CREATE TABLE sensor
(
	-- sensor ID
	ssid varchar(30) NOT NULL COMMENT 'sensor ID',
	-- sensor name
	ssnm varchar(30) COMMENT 'sensor name',
	-- sensor type
	sst numeric(5) NOT NULL COMMENT 'sensor type',
	-- sensor status
	ssst tinytext COMMENT 'sensor status',
	-- sensor manufacturer
	ssmf varchar(30) NOT NULL COMMENT 'sensor manufacturer',
	-- gateway ID
	gwid varchar(30) NOT NULL COMMENT 'gateway ID',
	-- register time
	rt timestamp NOT NULL COMMENT 'register time'
);


CREATE TABLE service
(
	-- service ID
	svid varchar(30) NOT NULL COMMENT 'service ID',
	-- service name
	svnm varchar(30) COMMENT 'service name',
	-- service version
	svvs varchar(20) COMMENT 'service version',
	-- service information
	svif tinytext COMMENT 'service information',
	-- category
	ctg varchar(20) COMMENT 'category',
	-- register time
	rt timestamp NOT NULL COMMENT 'register time',
	svtp varchar(20),
	-- gateway ID
	gwid varchar(30) NOT NULL COMMENT 'gateway ID'
);


CREATE TABLE user
(
	-- main phone number
	mphnb varchar(20) NOT NULL COMMENT 'main phone number',
	-- name
	name varchar(20) NOT NULL COMMENT 'name',
	-- affiliation
	afl varchar(30) COMMENT 'affiliation',
	-- office
	ofc varchar(10) COMMENT 'office',
	-- user type
	type varchar(10) COMMENT 'user type',
	-- current state
	crst varchar(20) COMMENT 'current state',
	-- current location
	crlt varchar(20) COMMENT 'current location',
	-- register time
	rt timestamp NOT NULL COMMENT 'register time',
	-- tag id
	tagid int COMMENT 'tag id',
	-- gateway ID
	gwid varchar(30) NOT NULL COMMENT 'gateway ID',
	PRIMARY KEY (mphnb)
);



/* Create Foreign Keys */

ALTER TABLE homeappliance
	ADD FOREIGN KEY (gwid)
	REFERENCES gateway (gwid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE sensor
	ADD FOREIGN KEY (gwid)
	REFERENCES gateway (gwid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE service
	ADD FOREIGN KEY (gwid)
	REFERENCES gateway (gwid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE user
	ADD FOREIGN KEY (gwid)
	REFERENCES gateway (gwid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE phone
	ADD FOREIGN KEY (mphnb)
	REFERENCES user (mphnb)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE schedule
	ADD FOREIGN KEY (mphnb)
	REFERENCES user (mphnb)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



