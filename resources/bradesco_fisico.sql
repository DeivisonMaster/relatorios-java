-- Geração de Modelo físico
-- Sql ANSI 2003 - brModelo.



CREATE TABLE contas (
agencia VARCHAR(20),
numero VARCHAR(10),
titular VARCHAR(20),
banco VARCHAR(20),
id_conta INTEGER PRIMARY KEY
)

CREATE TABLE categorias (
id_categoria INTEGER PRIMARY KEY,
nome VARCHAR(30)
)

CREATE TABLE movimentacao (
id_movimentacao INTEGER PRIMARY KEY,
descricao VARCHAR(30),
valor DECIMAL(7,2),
tipo_movimentacao VARCHAR(15),
data DATETIME,
id_categoria INTEGER,
id_conta INTEGER,
FOREIGN KEY(id_categoria) REFERENCES categorias (id_categoria),
FOREIGN KEY(id_conta) REFERENCES contas (id_conta)
)

