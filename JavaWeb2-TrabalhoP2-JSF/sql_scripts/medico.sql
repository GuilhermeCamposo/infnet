CREATE TABLE medico
(
  especialidade character varying,
  mat_func integer NOT NULL,
  CONSTRAINT pk_medico PRIMARY KEY (mat_func),
  CONSTRAINT fk_medico FOREIGN KEY (mat_func)
      REFERENCES funcionario (matricula) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)