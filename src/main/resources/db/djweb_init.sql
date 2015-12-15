drop database if exists djweb;
drop user test@'%';

create database if not exists djweb default charset utf8 collate utf8_general_ci;
use djweb;

create user test identified by '123456';
grant all privileges on djweb.* to 'test'@'%' identified by '123456';
flush privileges;

create table user (
	id bigint not null auto_increment,
	loginName varchar(20) not null,
	passwd varchar(20) not null,
	mobile varchar(13),
	primary key (id), unique (loginname)
);

#only for test
insert into user values(1, 'admin', '123456', '18012341234');



