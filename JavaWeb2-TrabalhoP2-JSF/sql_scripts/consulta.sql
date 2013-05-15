CREATE TABLE consulta
(
  id_consulta serial NOT NULL,
  id_paciente integer,
  id_medico integer,
  precricao character varying,
  status_consulta boolean,
  id_atendente integer,
  CONSTRAINT pk_consulta PRIMARY KEY (id_consulta),
  CONSTRAINT fk_consulta_atendente FOREIGN KEY (id_atendente)
      REFERENCES atendente (matricula) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_medico FOREIGN KEY (id_medico)
      REFERENCES medico (mat_func) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_paciente FOREIGN KEY (id_paciente)
      REFERENCES paciente (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
