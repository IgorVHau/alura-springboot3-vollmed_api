CREATE TABLE pacientes(
	
	id bigint not null auto_increment,
	nome varchar(200) not null,
	email varchar(200) not null,
	telefone varchar(20) not null,
	cpf varchar(15) not null,
	ativo tinyint,
	logradouro varchar(200) not null,
	bairro varchar(100) not null,
	cep varchar(9) not null,
	complemento varchar(200) not null,
	numero varchar(20) not null,
	uf char(2) not null,
	cidade varchar(100) not null,
	
	primary key(id)
	
);