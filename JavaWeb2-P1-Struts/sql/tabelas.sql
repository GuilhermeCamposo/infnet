CREATE TABLE funcionario
(
  matricula integer NOT NULL DEFAULT nextval('funcionario_id_funcionario_seq'::regclass),
  nome character varying,
  cpf character varying,
  senha character varying,
  "login" character varying,
  CONSTRAINT pk_funcionario PRIMARY KEY (matricula)
)

CREATE TABLE atendente
(
  matricula integer NOT NULL,
  turno character(5),
  CONSTRAINT pk_atendente PRIMARY KEY (matricula),
  CONSTRAINT fk_atendente FOREIGN KEY (matricula)
      REFERENCES funcionario (matricula) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)

CREATE TABLE medico
(
  especialidade character varying,
  matricula integer NOT NULL,
  CONSTRAINT pk_medico PRIMARY KEY (matricula),
  CONSTRAINT fk_medico FOREIGN KEY (matricula)
      REFERENCES funcionario (matricula) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)