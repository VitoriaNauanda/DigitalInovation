CREATE database vitoria_digital;
USE vitoria_digital;

CREATE TABLE aluno(
id integer primary key auto_increment,
nome varchar(80) not null,
idade integer not null,
estado varchar(2) not null
);

INSERT INTO aluno(nome, idade, estado) VALUES ("Paola", 19 , "PA"); 
INSERT INTO aluno(nome, idade, estado) VALUES ("Paulina", 19 , "PA");
INSERT INTO aluno(nome, idade, estado) VALUES ("Marimar", 20 , "PA");
INSERT INTO aluno(nome, idade, estado) VALUES ("Maria Hernands", 16 , "PA");

SELECT * FROM aluno;