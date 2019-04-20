CREATE TABLE especialidade (
    id_especialidade   INT,
    descricao          VARCHAR(30)
);

CREATE SEQUENCE seq_especialidade INCREMENT BY 1 START WITH 1;

INSERT INTO especialidade (
    id_especialidade,
    descricao
) VALUES (
    seq_especialidade.NEXTVAL,
    'Infectologista'
);

INSERT INTO especialidade (
    id_especialidade,
    descricao
) VALUES (
    seq_especialidade.NEXTVAL,
    'Cardiologista'
);

INSERT INTO especialidade (
    id_especialidade,
    descricao
) VALUES (
    seq_especialidade.NEXTVAL,
    'Urologista'
);

INSERT INTO especialidade (
    id_especialidade,
    descricao
) VALUES (
    seq_especialidade.NEXTVAL,
    'Oftalmologista'
);

CREATE SEQUENCE seq_pessoa INCREMENT BY 1 START WITH 1;

CREATE TABLE pessoa (
    id_pessoa   INT,
    nome        VARCHAR(500),
    cpf         NUMBER(11, 0),
    dt_nasc     DATE,
    sexo        CHAR(1)
);

CREATE TABLE medico (
    id_pessoa          INT,
    id_especialidade   INT
);

CREATE TABLE enfermeiro (
    id_pessoa          INT,
    id_carga_horaria   INT
);

CREATE TABLE auxadm (
    id_pessoa   INT,
    salario     NUMBER(10, 2)
);