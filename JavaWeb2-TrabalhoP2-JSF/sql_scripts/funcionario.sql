CREATE TABLE funcionario
(
  matricula integer NOT NULL DEFAULT nextval('funcionario_id_funcionario_seq'::regclass),
  nome character varying,
  cpf character varying,
  senha character varying,
  "login" character varying,
  funcao character(25),
  CONSTRAINT pk_funcionario PRIMARY KEY (matricula)
)