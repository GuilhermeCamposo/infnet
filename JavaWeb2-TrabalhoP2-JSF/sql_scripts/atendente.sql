
CREATE TABLE atendente
(
  matricula integer NOT NULL,
  turno character(5),
  CONSTRAINT pk_atendente PRIMARY KEY (matricula),
  CONSTRAINT fk_atendente FOREIGN KEY (matricula)
      REFERENCES funcionario (matricula) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)