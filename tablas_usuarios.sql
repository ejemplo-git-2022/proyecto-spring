create table groups (
    id number(5) primary key,
    group_name NVARCHAR2(128) not null
);

create table group_authorities (
    group_id number(5) not null,
    authority NVARCHAR2(128) not null,
    constraint fk_group_authorities_group foreign key(group_id) references groups(id)
);

create table group_members (
    id number(5) primary key,
    username NVARCHAR2(128) not null,
    group_id number(5) not null,
    constraint fk_group_members_group foreign key(group_id) references groups(id)
);

create sequence groups_seq
minvalue 0
maxvalue 99999
start with 0
increment by 1
cache 20;

create sequence group_members_seq
minvalue 0
maxvalue 99999
start with 0
increment by 1
cache 20;

CREATE TABLE USERS (
    USERNAME NVARCHAR2(128) PRIMARY KEY,
    PASSWORD NVARCHAR2(128) NOT NULL,
    ENABLED CHAR(1) CHECK (ENABLED IN ('Y','N') ) NOT NULL
);


CREATE TABLE AUTHORITIES (
    USERNAME NVARCHAR2(128) NOT NULL,
    AUTHORITY NVARCHAR2(128) NOT NULL
);
ALTER TABLE AUTHORITIES ADD CONSTRAINT AUTHORITIES_UNIQUE UNIQUE (USERNAME, AUTHORITY);
ALTER TABLE AUTHORITIES ADD CONSTRAINT AUTHORITIES_FK1 FOREIGN KEY (USERNAME) REFERENCES USERS (USERNAME) ENABLE;