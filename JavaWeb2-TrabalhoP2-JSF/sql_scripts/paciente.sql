CREATE TABLE paciente
(
  id serial NOT NULL,
  nome character varying,
  cpf character varying,
  telefone character varying,
  CONSTRAINT pk_paciente PRIMARY KEY (id),
  CONSTRAINT unique_cpf UNIQUE (cpf)
)