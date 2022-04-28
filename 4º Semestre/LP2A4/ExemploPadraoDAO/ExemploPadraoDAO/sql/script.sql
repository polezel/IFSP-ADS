create database exemplodaoLucas;

create table pessoas (
	id serial,
	nome varchar(255) not null,
	endereco varchar(255),
	cep bigint,
	telefone varchar(17),
	renda float,
	situacao smallint,
	constraint pk_pessoas primary key(id)
);

create table pessoasfisicas (
	id int,
	cpf bigint,
	nascto date,
	constraint pk_pessoasfisicas primary key(id),
	constraint fk_pessoasfisicas_pessoas foreign key(id) references pessoas(id)
);

create table pessoasjuridicas (
	id int,
	cnpj bigint,
	nomeFantasia varchar(255),
	constraint pessoasjuridicas primary key(id),
	constraint fk_pessoasjuridicas_pessoas foreign key(id) references pessoas(id)
);

