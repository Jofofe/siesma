--CREATE DATABASE SIESMA;

CREATE TABLE NIVEL_ACESSO (
	ID_NIVEL_ACESSO BIGINT PRIMARY KEY NOT NULL,
	NOME_ACESSO VARCHAR(30) NOT NULL
);

INSERT INTO NIVEL_ACESSO (ID_NIVEL_ACESSO, NOME_ACESSO) VALUES (1,'Administrativo');
COMMIT;
INSERT INTO NIVEL_ACESSO (ID_NIVEL_ACESSO, NOME_ACESSO) VALUES (2,'Docente');
COMMIT;
INSERT INTO NIVEL_ACESSO (ID_NIVEL_ACESSO, NOME_ACESSO) VALUES (3,'Aluno');
COMMIT;
INSERT INTO NIVEL_ACESSO (ID_NIVEL_ACESSO, NOME_ACESSO) VALUES (4,'Outros');
COMMIT;

CREATE TABLE USUARIO (
	ID_USUARIO BIGINT PRIMARY KEY NOT NULL,
	NOME VARCHAR(100) NOT NULL,
	CPF VARCHAR(15) NOT NULL,
	RG VARCHAR(20) NOT NULL,
	ORGAO_EXPEDITOR VARCHAR(6) NOT NULL,
	EMAIL VARCHAR(50) NOT NULL,
	TEL_CELULAR VARCHAR(20) NOT NULL,
	SENHA_USUARIO VARCHAR(32) NOT NULL,
	ID_NIVEL_ACESSO BIGINT NOT NULL,
	DT_CADASTRO TIMESTAMP NOT NULL,
	DT_FIM_VINCULO TIMESTAMP,
	FOREIGN KEY (ID_NIVEL_ACESSO) REFERENCES NIVEL_ACESSO (ID_NIVEL_ACESSO)
);

CREATE SEQUENCE USUARIO_ID_SEQ;
ALTER TABLE USUARIO ALTER COLUMN ID_USUARIO SET DEFAULT NEXTVAL('USUARIO_ID_SEQ');

CREATE TABLE FUNCAO (
	ID_FUNCAO BIGINT PRIMARY KEY NOT NULL,
	NOME_FUNCAO VARCHAR(30) NOT NULL
);

INSERT INTO FUNCAO (ID_FUNCAO, NOME_FUNCAO) VALUES (1,'Administrativo');
COMMIT;
INSERT INTO FUNCAO (ID_FUNCAO, NOME_FUNCAO) VALUES (2,'Docente');
COMMIT;

CREATE TABLE EMPREGADO (
	ID_EMPREGADO BIGINT NOT NULL,
	VALOR_HORA NUMERIC(12,2),
	ID_FUNCAO BIGINT NOT NULL
);

ALTER TABLE EMPREGADO ADD CONSTRAINT PK_EMPREGADO PRIMARY KEY(ID_EMPREGADO);
ALTER TABLE EMPREGADO ADD CONSTRAINT FK_EMPREGADO_PESSOA FOREIGN KEY (ID_EMPREGADO) REFERENCES USUARIO (ID_USUARIO);
ALTER TABLE EMPREGADO ADD CONSTRAINT FK_EMPREGADO_FUNCAO FOREIGN KEY (ID_FUNCAO) REFERENCES FUNCAO (ID_FUNCAO);

CREATE TABLE UF (
	ID_UF BIGINT PRIMARY KEY NOT NULL,
	NOME_UF VARCHAR(30) NOT NULL,
	SG_UF VARCHAR(2) NOT NULL
);

INSERT INTO UF (ID_UF, NOME_UF, SG_UF) VALUES (1,'Acre', 'AC');
COMMIT;
INSERT INTO UF (ID_UF, NOME_UF, SG_UF) VALUES (2,'Alagoas', 'AL');
COMMIT;
INSERT INTO UF (ID_UF, NOME_UF, SG_UF) VALUES (3,'Amap�', 'AP');
COMMIT;
INSERT INTO UF (ID_UF, NOME_UF, SG_UF) VALUES (4,'Amazonas', 'AM');
COMMIT;
INSERT INTO UF (ID_UF, NOME_UF, SG_UF) VALUES (5,'Bahia', 'BA');
COMMIT;
INSERT INTO UF (ID_UF, NOME_UF, SG_UF) VALUES (6,'Cear�', 'CE');
COMMIT;
INSERT INTO UF (ID_UF, NOME_UF, SG_UF) VALUES (7,'Distrito Federal', 'DF');
COMMIT;
INSERT INTO UF (ID_UF, NOME_UF, SG_UF) VALUES (8,'Esp�rito Santo', 'ES');
COMMIT;
INSERT INTO UF (ID_UF, NOME_UF, SG_UF) VALUES (9,'Goi�s', 'GO');
COMMIT;
INSERT INTO UF (ID_UF, NOME_UF, SG_UF) VALUES (10,'Maranh�o', 'MA');
COMMIT;
INSERT INTO UF (ID_UF, NOME_UF, SG_UF) VALUES (11,'Mato Grosso', 'MT');
COMMIT;
INSERT INTO UF (ID_UF, NOME_UF, SG_UF) VALUES (12,'Mato Grosso do Sul', 'MS');
COMMIT;
INSERT INTO UF (ID_UF, NOME_UF, SG_UF) VALUES (13,'Minas Gerais', 'MG');
COMMIT;
INSERT INTO UF (ID_UF, NOME_UF, SG_UF) VALUES (14,'Par�', 'PA');
COMMIT;
INSERT INTO UF (ID_UF, NOME_UF, SG_UF) VALUES (15,'Para�ba', 'PB');
COMMIT;
INSERT INTO UF (ID_UF, NOME_UF, SG_UF) VALUES (16,'Paran�', 'PR');
COMMIT;
INSERT INTO UF (ID_UF, NOME_UF, SG_UF) VALUES (17,'Pernambuco', 'PE');
COMMIT;
INSERT INTO UF (ID_UF, NOME_UF, SG_UF) VALUES (18,'Piau�', 'PI');
COMMIT;
INSERT INTO UF (ID_UF, NOME_UF, SG_UF) VALUES (19,'Rio de Janeiro', 'RJ');
COMMIT;
INSERT INTO UF (ID_UF, NOME_UF, SG_UF) VALUES (20,'Rio Grande do Norte', 'RN');
COMMIT;
INSERT INTO UF (ID_UF, NOME_UF, SG_UF) VALUES (21,'Rio Grande do Sul', 'RS');
COMMIT;
INSERT INTO UF (ID_UF, NOME_UF, SG_UF) VALUES (22,'Rond�nia', 'RO');
COMMIT;
INSERT INTO UF (ID_UF, NOME_UF, SG_UF) VALUES (23,'Roraima', 'RR');
COMMIT;
INSERT INTO UF (ID_UF, NOME_UF, SG_UF) VALUES (24,'Santa Catarina', 'SC');
COMMIT;
INSERT INTO UF (ID_UF, NOME_UF, SG_UF) VALUES (25,'S�o Paulo', 'SP');
COMMIT;
INSERT INTO UF (ID_UF, NOME_UF, SG_UF) VALUES (26,'Sergipe', 'SE');
COMMIT;
INSERT INTO UF (ID_UF, NOME_UF, SG_UF) VALUES (27,'Tocantins', 'TO');
COMMIT;

CREATE TABLE GENERO (
	ID_GENERO BIGINT PRIMARY KEY NOT NULL,
	NOME_GENERO VARCHAR(30) NOT NULL
);

INSERT INTO GENERO (ID_GENERO, NOME_GENERO) VALUES (1,'Masculino');
COMMIT;
INSERT INTO GENERO (ID_GENERO, NOME_GENERO) VALUES (2,'Feminino');
COMMIT;
INSERT INTO GENERO (ID_GENERO, NOME_GENERO) VALUES (3,'Outros');
COMMIT;

CREATE TABLE ALUNO (
	ID_ALUNO BIGINT NOT NULL,
	DT_NASCIMENTO TIMESTAMP NOT NULL,
	ID_GENERO BIGINT NOT NULL,
	NATURALIDADE VARCHAR(50) NOT NULL,
	PROFISSAO VARCHAR(50),
	ENDERECO VARCHAR(100) NOT NULL,
	BAIRRO VARCHAR(50) NOT NULL,
	CIDADE VARCHAR(50) NOT NULL,
	ID_UF BIGINT NOT NULL,
	CEP VARCHAR(20) NOT NULL,
	TEL_RESID VARCHAR(20),
	TEL_COMERCIAL VARCHAR(20),
	DT_VENCIMENTO TIMESTAMP NOT NULL,
	IES_GRADUACAO VARCHAR(50) NOT NULL,
	SITUACAO_COMERCIAL VARCHAR(50) NOT NULL
);

ALTER TABLE ALUNO ADD CONSTRAINT PK_ALUNO PRIMARY KEY(ID_ALUNO);
ALTER TABLE ALUNO ADD CONSTRAINT FK_ALUNO_PESSOA FOREIGN KEY (ID_ALUNO) REFERENCES USUARIO (ID_USUARIO);
ALTER TABLE ALUNO ADD CONSTRAINT FK_ALUNO_UF FOREIGN KEY (ID_UF) REFERENCES UF (ID_UF);
ALTER TABLE ALUNO ADD CONSTRAINT FK_ALUNO_GENERO FOREIGN KEY (ID_GENERO) REFERENCES GENERO (ID_GENERO);

--Cadastro do Admin
INSERT INTO USUARIO VALUES (1, 'Nelson Francisco Muniz', '115.418.276-27', '16-031-880', 'SSP/MG', 'nelson@mail.com', 
'61-983004172', 'D79DD0E63C6A67E4F0FA752E61C80FD1', 1, now(), null);
COMMIT;
INSERT INTO EMPREGADO VALUES (1, 200.00, 1);
COMMIT;

CREATE TABLE TURNO (
	ID_TURNO BIGINT PRIMARY KEY NOT NULL,
	NOME_TURNO VARCHAR(30) NOT NULL
);

INSERT INTO TURNO (ID_TURNO, NOME_TURNO) VALUES (1,'Matutino');
COMMIT;
INSERT INTO TURNO (ID_TURNO, NOME_TURNO) VALUES (2,'Vespertino');
COMMIT;
INSERT INTO TURNO (ID_TURNO, NOME_TURNO) VALUES (3,'Noturno');
COMMIT;

CREATE TABLE CURSO (
	ID_CURSO BIGINT PRIMARY KEY NOT NULL,
	NOME_CURSO VARCHAR(100) NOT NULL,
	CARGA_HORARIA INTEGER NOT NULL,
	VALOR_CURSO NUMERIC(12,2) NOT NULL,
	IN_EXCLUIDO VARCHAR(1) NOT NULL,
	DT_INICIO TIMESTAMP NOT NULL,
	DT_FIM TIMESTAMP,
	ID_TURNO BIGINT NOT NULL,
);

CREATE SEQUENCE CURSO_ID_SEQ;
ALTER TABLE CURSO ALTER COLUMN ID_CURSO SET DEFAULT NEXTVAL('CURSO_ID_SEQ');
ALTER TABLE CURSO ADD CONSTRAINT FK_TURNO_CURSO FOREIGN KEY (ID_TURNO) REFERENCES TURNO (ID_TURNO);

CREATE TABLE MODULO (
	ID_MODULO BIGINT PRIMARY KEY NOT NULL,
	ID_CURSO BIGINT NOT NULL,
	NOME_MODULO VARCHAR(100) NOT NULL,
	DT_INICIO TIMESTAMP NOT NULL,
	DT_FIM TIMESTAMP NOT NULL
);

CREATE SEQUENCE MODULO_ID_SEQ;
ALTER TABLE MODULO ALTER COLUMN ID_MODULO SET DEFAULT NEXTVAL('MODULO_ID_SEQ');
ALTER TABLE MODULO ADD CONSTRAINT FK_MODULO_CURSO FOREIGN KEY (ID_CURSO) REFERENCES CURSO (ID_CURSO);

CREATE TABLE DISCIPLINA (
	ID_DISCIPLINA BIGINT PRIMARY KEY NOT NULL,
	ID_MODULO BIGINT NOT NULL,
	NOME_DISCIPLINA VARCHAR(100) NOT NULL,
	DT_INICIO TIMESTAMP NOT NULL,
	DT_FIM TIMESTAMP NOT NULL
);

CREATE SEQUENCE DISCIPLINA_ID_SEQ;
ALTER TABLE DISCIPLINA ALTER COLUMN ID_DISCIPLINA SET DEFAULT NEXTVAL('DISCIPLINA_ID_SEQ');
ALTER TABLE DISCIPLINA ADD CONSTRAINT FK_DISCIPLINA_MODULO FOREIGN KEY (ID_MODULO) REFERENCES MODULO (ID_MODULO);

CREATE TABLE PROFESSOR_DISCIPLINA (
	ID_PROFESSOR_DISCIPLINA BIGINT PRIMARY KEY NOT NULL,
	ID_EMPREGADO BIGINT NOT NULL,
	ID_DISCIPLINA BIGINT NOT NULL,
	DT_INICIO TIMESTAMP NOT NULL,
	DT_FIM TIMESTAMP NOT NULL
);

CREATE SEQUENCE PROFESSOR_DISCIPLINA_ID_SEQ;
ALTER TABLE PROFESSOR_DISCIPLINA ALTER COLUMN ID_PROFESSOR_DISCIPLINA SET DEFAULT NEXTVAL('PROFESSOR_DISCIPLINA_ID_SEQ');
ALTER TABLE PROFESSOR_DISCIPLINA ADD CONSTRAINT FK_PROFESSOR_DISCIPLINA_EMPREGADO FOREIGN KEY (ID_EMPREGADO) REFERENCES EMPREGADO (ID_EMPREGADO);
ALTER TABLE PROFESSOR_DISCIPLINA ADD CONSTRAINT FK_PROFESSOR_DISCIPLINA_DISCIPLINA FOREIGN KEY (ID_DISCIPLINA) REFERENCES DISCIPLINA (ID_DISCIPLINA);


CREATE TABLE MATRICULA (
	ID_MATRICULA BIGINT PRIMARY KEY NOT NULL,
	ID_ALUNO BIGINT NOT NULL,
	ID_CURSO BIGINT NOT NULL,
	ID_MODULO BIGINT NOT NULL,
	DT_MATRICULA TIMESTAMP NOT NULL,
	DT_FIM_PREVISTO TIMESTAMP,
	DT_FIM_EFETIVA TIMESTAMP,
	DT_CANCELAMENTO TIMESTAMP
);

CREATE SEQUENCE MATRICULA_ID_SEQ;
ALTER TABLE MATRICULA ALTER COLUMN ID_MATRICULA SET DEFAULT NEXTVAL('MATRICULA_ID_SEQ');
ALTER TABLE MATRICULA ADD CONSTRAINT FK_MATRICULA_ALUNO FOREIGN KEY (ID_ALUNO) REFERENCES ALUNO (ID_ALUNO);
ALTER TABLE MATRICULA ADD CONSTRAINT FK_MATRICULA_CURSO FOREIGN KEY (ID_CURSO) REFERENCES CURSO (ID_CURSO);
ALTER TABLE MATRICULA ADD CONSTRAINT FK_MATRICULA_MODULO FOREIGN KEY (ID_MODULO) REFERENCES MODULO (ID_MODULO);

CREATE TABLE DESCONTO (
	ID_DESCONTO BIGINT PRIMARY KEY NOT NULL,
	NOME_DESCONTO VARCHAR(30) NOT NULL,
	PERCENTUAL_DESCONTO NUMERIC(5,2) NOT NULL;
	DT_INICIO TIMESTAMP NOT NULL,
	DT_FIM TIMESTAMP NOT NULL
);

CREATE SEQUENCE DESCONTO_ID_SEQ;
ALTER TABLE DESCONTO ALTER COLUMN ID_DESCONTO SET DEFAULT NEXTVAL('DESCONTO_ID_SEQ');

CREATE TABLE TIPO_AVALIACAO (
	ID_TIPO_AVALIACAO BIGINT PRIMARY KEY NOT NULL,
	NOME_TIPO_AVALIACAO VARCHAR(30) NOT NULL
);

INSERT INTO TIPO_AVALIACAO (ID_TIPO_AVALIACAO, NOME_TIPO_AVALIACAO) VALUES (1,'Prova');
COMMIT;
INSERT INTO TIPO_AVALIACAO (ID_TIPO_AVALIACAO, NOME_TIPO_AVALIACAO) VALUES (2,'Trabalho');
COMMIT;

CREATE TABLE AVALIACAO (
	ID_AVALIACAO BIGINT PRIMARY KEY NOT NULL,
	NOME_AVALIACAO VARCHAR(30) NOT NULL,
	OBS_AVALIACAO VARCHAR(100),
	ID_TIPO_AVALIACAO BIGINT NOT NULL,
	ID_DISCIPLINA BIGINT NOT NULL
);

CREATE SEQUENCE AVALIACAO_ID_SEQ;
ALTER TABLE AVALIACAO ALTER COLUMN ID_AVALIACAO SET DEFAULT NEXTVAL('AVALIACAO_ID_SEQ');
ALTER TABLE AVALIACAO ADD CONSTRAINT FK_AVALIACAO_TIPO FOREIGN KEY (ID_TIPO_AVALIACAO) REFERENCES TIPO_AVALIACAO (ID_TIPO_AVALIACAO);
ALTER TABLE AVALIACAO ADD CONSTRAINT FK_AVALIACAO_DISCIPLINA FOREIGN KEY (ID_DISCIPLINA) REFERENCES DISCIPLINA (ID_DISCIPLINA);

CREATE TABLE AVALIACAO_NOTA (
	ID_AVALIACAO_NOTA BIGINT PRIMARY KEY NOT NULL,
	ID_AVALIACAO BIGINT NOT NULL,
	ID_MATRICULA BIGINT NOT NULL,
	NOTA NUMERIC(5,2) NOT NULL,
);

CREATE SEQUENCE AVALIACAO_NOTA_ID_SEQ;
ALTER TABLE AVALIACAO_NOTA ALTER COLUMN ID_AVALIACAO_NOTA SET DEFAULT NEXTVAL('AVALIACAO_NOTA_ID_SEQ');
ALTER TABLE AVALIACAO_NOTA ADD CONSTRAINT AVALIACAO_NOTA_AVA FOREIGN KEY (ID_AVALIACAO) REFERENCES AVALIACAO (ID_AVALIACAO);
ALTER TABLE AVALIACAO_NOTA ADD CONSTRAINT AVALIACAO_NOTA_MAT FOREIGN KEY (ID_MATRICULA) REFERENCES MATRICULA (ID_MATRICULA);

CREATE TABLE DESCONTO_APLICADO (
	ID_DESCONTO_APLICADO BIGINT PRIMARY KEY NOT NULL,
	ID_ALUNO BIGINT NOT NULL,
	ID_MODULO BIGINT NOT NULL,
	ID_DESCONTO BIGINT NOT NULL,
	OBS_DESCONTO_APLICADO VARCHAR(100)
);

CREATE SEQUENCE DESCONTO_APLICADO_ID_SEQ;
ALTER TABLE DESCONTO_APLICADO ALTER COLUMN ID_DESCONTO_APLICADO SET DEFAULT NEXTVAL('DESCONTO_APLICADO_ID_SEQ');
ALTER TABLE DESCONTO_APLICADO ADD CONSTRAINT FK_DESCONTO_APLICADO_ALUNO FOREIGN KEY (ID_ALUNO) REFERENCES ALUNO (ID_ALUNO);
ALTER TABLE DESCONTO_APLICADO ADD CONSTRAINT FK_DESCONTO_APLICADO_MODULO FOREIGN KEY (ID_MODULO) REFERENCES MODULO (ID_MODULO);
ALTER TABLE DESCONTO_APLICADO ADD CONSTRAINT FK_DESCONTO_APLICADO_DESCONTO FOREIGN KEY (ID_DESCONTO) REFERENCES DESCONTO (ID_DESCONTO);

CREATE TABLE CLASSE_PAGAMENTO (
	ID_CLASSE_PAGAMENTO BIGINT PRIMARY KEY NOT NULL,
	NOME_CLASSE_PAGAMENTO VARCHAR(30) NOT NULL
);

INSERT INTO CLASSE_PAGAMENTO (ID_CLASSE_PAGAMENTO, NOME_CLASSE_PAGAMENTO) VALUES (1,'Credito');
COMMIT;
INSERT INTO CLASSE_PAGAMENTO (ID_CLASSE_PAGAMENTO, NOME_CLASSE_PAGAMENTO) VALUES (2,'Debito');
COMMIT;
INSERT INTO CLASSE_PAGAMENTO (ID_CLASSE_PAGAMENTO, NOME_CLASSE_PAGAMENTO) VALUES (3,'Dinheiro');
COMMIT;
INSERT INTO CLASSE_PAGAMENTO (ID_CLASSE_PAGAMENTO, NOME_CLASSE_PAGAMENTO) VALUES (4,'Cheque');
COMMIT;

CREATE TABLE FORMA_PAGAMENTO (
	ID_FORMA_PAGAMENTO BIGINT PRIMARY KEY NOT NULL,
	NOME_PAGAMENTO VARCHAR(50) NOT NULL,
	ID_CLASSE_PAGAMENTO BIGINT NOT NULL,
	QTD_PARCELAS INTEGER NOT NULL,
	DT_INICIO TIMESTAMP NOT NULL,
	DT_FIM TIMESTAMP NOT NULL
);

CREATE SEQUENCE FORMA_PAGAMENTO_ID_SEQ;
ALTER TABLE FORMA_PAGAMENTO ALTER COLUMN ID_FORMA_PAGAMENTO SET DEFAULT NEXTVAL('FORMA_PAGAMENTO_ID_SEQ');
ALTER TABLE FORMA_PAGAMENTO ADD CONSTRAINT FK_FORMA_PAGAMENTO_CLASSE FOREIGN KEY (ID_CLASSE_PAGAMENTO) REFERENCES CLASSE_PAGAMENTO (ID_CLASSE_PAGAMENTO);

CREATE TABLE UNIDADE_MEDIDA (
	ID_UNIDADE_MEDIDA BIGINT PRIMARY KEY NOT NULL,
	NOME_UNIDADE_MEDIDA VARCHAR(30) NOT NULL
);

INSERT INTO UNIDADE_MEDIDA (ID_UNIDADE_MEDIDA, NOME_UNIDADE_MEDIDA) VALUES (1,'M�s');
COMMIT;
INSERT INTO UNIDADE_MEDIDA (ID_UNIDADE_MEDIDA, NOME_UNIDADE_MEDIDA) VALUES (2,'Hora Aula');
COMMIT;
INSERT INTO UNIDADE_MEDIDA (ID_UNIDADE_MEDIDA, NOME_UNIDADE_MEDIDA) VALUES (3,'Unit�rio');
COMMIT;

CREATE TABLE TIPO_PAGAMENTO (
	ID_TIPO_PAGAMENTO BIGINT PRIMARY KEY NOT NULL,
	NOME_TIPO_PAGAMENTO VARCHAR(50) NOT NULL
);

INSERT INTO TIPO_PAGAMENTO (ID_TIPO_PAGAMENTO, NOME_TIPO_PAGAMENTO) VALUES (1,'A pagar para o Aluno');
COMMIT;
INSERT INTO TIPO_PAGAMENTO (ID_TIPO_PAGAMENTO, NOME_TIPO_PAGAMENTO) VALUES (2,'A receber do Aluno');
COMMIT;
INSERT INTO TIPO_PAGAMENTO (ID_TIPO_PAGAMENTO, NOME_TIPO_PAGAMENTO) VALUES (3,'A pagar para o Professor');
COMMIT;
INSERT INTO TIPO_PAGAMENTO (ID_TIPO_PAGAMENTO, NOME_TIPO_PAGAMENTO) VALUES (4,'A receber do Professor');
COMMIT;

CREATE TABLE TIPO_LANCAMENTO (
	ID_TIPO_LANCAMENTO BIGINT PRIMARY KEY NOT NULL,
	DESCRICAO VARCHAR(50) NOT NULL,
	ID_UNIDADE_MEDIDA BIGINT NOT NULL,
	OBS_LANCAMENTO VARCHAR(100) NOT NULL,
	ID_TIPO_PAGAMENTO BIGINT NOT NULL,
	STATUS VARCHAR(20) NOT NULL
);

CREATE SEQUENCE TIPO_LANCAMENTO_ID_SEQ;
ALTER TABLE TIPO_LANCAMENTO ALTER COLUMN ID_TIPO_LANCAMENTO SET DEFAULT NEXTVAL('TIPO_LANCAMENTO_ID_SEQ');
ALTER TABLE TIPO_LANCAMENTO ADD CONSTRAINT FK_TIPO_LANCAMENTO_UND FOREIGN KEY (ID_UNIDADE_MEDIDA) REFERENCES UNIDADE_MEDIDA (ID_UNIDADE_MEDIDA);
ALTER TABLE TIPO_LANCAMENTO ADD CONSTRAINT FK_TIPO_LANCAMENTO_PGTO FOREIGN KEY (ID_TIPO_PAGAMENTO) REFERENCES TIPO_PAGAMENTO (ID_TIPO_PAGAMENTO);

CREATE TABLE LANCAMENTO_COMERCIAL (
	ID_LANCAMENTO_COMERCIAL BIGINT PRIMARY KEY NOT NULL,
	ID_FORMA_PAGAMENTO BIGINT NOT NULL,
	ID_TIPO_LANCAMENTO BIGINT NOT NULL,
	ID_MATRICULA BIGINT,
	ID_EMPREGADO BIGINT,
	ID_DESCONTO BIGINT,
	VALOR_RECEBIMENTO NUMERIC(12,2) NOT NULL,
	DT_PREVISTA TIMESTAMP,
	DT_RECEBIMENTO TIMESTAMP,
	STATUS VARCHAR(20) NOT NULL,
	OBS_RECEBIMENTO VARCHAR(100)
);

CREATE SEQUENCE LANCAMENTO_COMERCIAL_ID_SEQ;
ALTER TABLE LANCAMENTO_COMERCIAL ALTER COLUMN ID_LANCAMENTO_COMERCIAL SET DEFAULT NEXTVAL('LANCAMENTO_COMERCIAL_ID_SEQ');
ALTER TABLE LANCAMENTO_COMERCIAL ADD CONSTRAINT FK_LANCAMENTO_COMERCIAL_FORMA_PAG FOREIGN KEY (ID_FORMA_PAGAMENTO) REFERENCES FORMA_PAGAMENTO (ID_FORMA_PAGAMENTO);
ALTER TABLE LANCAMENTO_COMERCIAL ADD CONSTRAINT FK_LANCAMENTO_COMERCIAL_TIPO FOREIGN KEY (ID_TIPO_LANCAMENTO) REFERENCES TIPO_LANCAMENTO (ID_TIPO_LANCAMENTO);
ALTER TABLE LANCAMENTO_COMERCIAL ADD CONSTRAINT FK_LANCAMENTO_COMERCIAL_MATRICULA FOREIGN KEY (ID_MATRICULA) REFERENCES MATRICULA (ID_MATRICULA);
ALTER TABLE LANCAMENTO_COMERCIAL ADD CONSTRAINT FK_LANCAMENTO_COMERCIAL_EMPREGADO FOREIGN KEY (ID_EMPREGADO) REFERENCES EMPREGADO (ID_EMPREGADO);
ALTER TABLE LANCAMENTO_COMERCIAL ADD CONSTRAINT FK_LANCAMENTO_COMERCIAL_DESCONTO FOREIGN KEY (ID_DESCONTO) REFERENCES DESCONTO (ID_DESCONTO);

CREATE TABLE PRESENCA (
	ID_PRESENCA BIGINT PRIMARY KEY NOT NULL,
	ID_DISCIPLINA BIGINT NOT NULL,
	DATA_PRESENCA TIMESTAMP NOT NULL
);

CREATE SEQUENCE PRESENCA_ID_SEQ;
ALTER TABLE PRESENCA ALTER COLUMN ID_PRESENCA SET DEFAULT NEXTVAL('PRESENCA_ID_SEQ');
ALTER TABLE PRESENCA ADD CONSTRAINT PRESENCA_DISCIPLINA FOREIGN KEY (ID_DISCIPLINA) REFERENCES DISCIPLINA (ID_DISCIPLINA);

CREATE TABLE PRESENCA_MATRICULA (
	ID_PRESENCA_MATRICULA BIGINT PRIMARY KEY NOT NULL,
	ID_PRESENCA BIGINT NOT NULL,
	ID_MATRICULA BIGINT NOT NULL,
	PRESENCA_DIA BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE SEQUENCE PRESENCA_MATRICULA_ID_SEQ;
ALTER TABLE PRESENCA_MATRICULA ALTER COLUMN ID_PRESENCA_MATRICULA SET DEFAULT NEXTVAL('PRESENCA_MATRICULA_ID_SEQ');
ALTER TABLE PRESENCA_MATRICULA ADD CONSTRAINT PRESENCA_MATRICULA_PRE FOREIGN KEY (ID_PRESENCA) REFERENCES PRESENCA (ID_PRESENCA);
ALTER TABLE PRESENCA_MATRICULA ADD CONSTRAINT PRESENCA_MATRICULA_MAT FOREIGN KEY (ID_MATRICULA) REFERENCES MATRICULA (ID_MATRICULA);

CREATE TABLE DOCUMENTO (
	ID_DOCUMENTO BIGINT PRIMARY KEY NOT NULL,
	NOME_DOCUMENTO VARCHAR(50) NOT NULL
);

INSERT INTO DOCUMENTO (ID_DOCUMENTO, NOME_DOCUMENTO) VALUES (1,'D.I.');
COMMIT;
INSERT INTO DOCUMENTO (ID_DOCUMENTO, NOME_DOCUMENTO) VALUES (2,'Certid�o de casamento');
COMMIT;
INSERT INTO DOCUMENTO (ID_DOCUMENTO, NOME_DOCUMENTO) VALUES (3,'Foto');
COMMIT;;
INSERT INTO DOCUMENTO (ID_DOCUMENTO, NOME_DOCUMENTO) VALUES (4,'CPF');
COMMIT;
INSERT INTO DOCUMENTO (ID_DOCUMENTO, NOME_DOCUMENTO) VALUES (5,'RG');
COMMIT;
INSERT INTO DOCUMENTO (ID_DOCUMENTO, NOME_DOCUMENTO) VALUES (6,'Diploma');
COMMIT;
INSERT INTO DOCUMENTO (ID_DOCUMENTO, NOME_DOCUMENTO) VALUES (7,'Certid�o negativa criminal');
COMMIT;
INSERT INTO DOCUMENTO (ID_DOCUMENTO, NOME_DOCUMENTO) VALUES (8,'Comprovante de resid�ncia');
COMMIT;
INSERT INTO DOCUMENTO (ID_DOCUMENTO, NOME_DOCUMENTO) VALUES (9,'Historico escolar');
COMMIT;
INSERT INTO DOCUMENTO (ID_DOCUMENTO, NOME_DOCUMENTO) VALUES (10,'Termo de ades�o do candidato');
COMMIT;
INSERT INTO DOCUMENTO (ID_DOCUMENTO, NOME_DOCUMENTO) VALUES (11,'Termo de voluntariado');
COMMIT;

CREATE TABLE MATRICULA_DOCUMENTO (
	ID_MATRICULA_DOCUMENTO BIGINT PRIMARY KEY NOT NULL,
	ID_MATRICULA BIGINT NOT NULL,
	ID_DOCUMENTO BIGINT NOT NULL,
	ENTREGUE BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE SEQUENCE MATRICULA_DOCUMENTO_ID_SEQ;
ALTER TABLE MATRICULA_DOCUMENTO ALTER COLUMN ID_MATRICULA_DOCUMENTO SET DEFAULT NEXTVAL('MATRICULA_DOCUMENTO_ID_SEQ');
ALTER TABLE MATRICULA_DOCUMENTO ADD CONSTRAINT MATRICULA_DOCUMENTO_MAT FOREIGN KEY (ID_MATRICULA) REFERENCES MATRICULA (ID_MATRICULA);
ALTER TABLE MATRICULA_DOCUMENTO ADD CONSTRAINT MATRICULA_DOCUMENTO_DOC FOREIGN KEY (ID_DOCUMENTO) REFERENCES DOCUMENTO (ID_DOCUMENTO);
