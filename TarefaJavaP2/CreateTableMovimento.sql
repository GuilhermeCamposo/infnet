create database movimento;
create table movimento(
id serial,
nome character varying,
data date,
valor double precision
);

insert into movimento (nome,data,valor) values('nome 1',now(),45);
insert into movimento (nome,data,valor) values('guilherme',now(),45000);
insert into movimento (nome,data,valor) values('guilherme',now(),50000);
insert into movimento (nome,data,valor) values('hernand',now(),30000);
insert into movimento (nome,data,valor) values('hernad',now(),20000);
select * from movimento;