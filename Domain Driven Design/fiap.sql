create table t_representante(
    cpf varchar2(14) unique,
    nome varchar2(100)
);

drop table t_representante;

create table t_empresa(
    cnpj varchar2(18) unique,
    nomeFant varchar2(100),
    razaoSoc varchar2(100),
    cpf varchar2(14),
    foreign key (cpf) references t_representante (cpf)
);

select * from t_empresa;
drop table t_empresa;

create table t_contatopf(
    email varchar2(100),
    tel varchar2(15),
    cpf varchar2(14),
    foreign key (cpf) references t_representante (cpf)
);

drop table t_contatopf;

create table t_contatopj(
    email varchar2(100),
    tel varchar2(15),
    cnpj varchar2(18),
    foreign key (cnpj) references t_empresa (cnpj)
);

drop table t_contatopj;

create table t_produto(
    tipo varchar2(100),
    quantidade number(10,2),
    reciclagem varchar2(100),
    cnpj varchar2(18),
    foreign key (cnpj) references t_empresa (cnpj)
);

drop table t_produto;

create table t_endereco(
    numero int,
    cep varchar2(9),
    logradouro varchar2(100),
    complemento varchar2(50),
    bairro varchar2(50),
    localidade varchar2(50),
    uf varchar2(2),
    cnpj varchar2(18),
    foreign key (cnpj) references t_empresa (cnpj)
);

drop table t_endereco;

create table t_cadastropf(
    nome varchar2(100),
    email varchar2(100),
    cep varchar2(9)
);

drop table t_cadastropf;

create table t_cadastropj(
    cnpj varchar2(18),
    nomeFant varchar2(100),
    email varchar2(100),
    cep varchar2(9)
);

drop table t_cadastropj;