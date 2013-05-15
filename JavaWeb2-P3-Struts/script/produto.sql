
CREATE TABLE produto
(
  id serial NOT NULL,
  nome character varying,
  modelo character varying,
  preco real,
  CONSTRAINT pk_produto PRIMARY KEY (id)
)

