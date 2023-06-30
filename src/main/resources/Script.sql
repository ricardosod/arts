
drop schema obra;



create schema obra;

use obra;
create table country(
id_country int not null auto_increment primary key,
country_name varchar(30) not null

);

create table art(
id_art int not null auto_increment  primary key,
art_name varchar (50) not null,
art_description varchar(240) not null,
date_publication date null default null,
date_exposition date null default null

);


-- drop table art;


create table author(
id_author int not null auto_increment primary key,
author_name varchar(50) not null,
cpf varchar(11) unique null,
sex char (1) null,
email varchar(30) unique null,
birth date not null,
country_origin int not null,
constraint fk_country_author foreign key (country_origin) references country(id_country)

);

create table art_author(

author_id int not null,
art_id int not null,


primary key (author_id, art_id),

constraint fk_author_art foreign key (author_id) references author(id_author),
constraint fk_art_author foreign key (art_id) references art(id_art)

);



-- drop table art_author;


insert into author(author_name, cpf, sex, email, birth, country_origin) values
('Ricardo Mendes','11111111111', 'M', 'ric@gmail.com','1990-11-15', '1'),
('Paulo Alecio', '22222222222', 'M', 'paulo@gmail.com', '1999-10-18', 1),
('Joana Silva', '33333333333','F', 'joana@gmail.com', '2000-10-10', 2)

;


insert into art (art_name, art_description, date_publication, date_exposition)values
-- ('O Senhor dos Aneis', 'Historia legal', '1990-11-10','2023-05-30'),
-- ('Harry Potter', 'Aventura', '1999-12-10');
('Código da Vinci' ,'Drama', '1992-09-10', null);

;

insert into art_author(author_id, art_id) values
(1,2);


------------------------------------------------------------------------------------------------------------------------------------------------------------------------
SELECT * FROM obra.country;
insert into obra.country (country_name) values

('Bélgica'),
('Canadá'),
('Dinamarca'),
('Israel'),
('Grécia'),
('Inglaterra'),
('Itália'),
('Egito'),
('Holanda'),
('França'),
('Russia'),
('Japão'),
('Turquia'),
('Polônnia'),
('Índia')

;

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
create schema obra;
drop schema Obra;
use obra;

create table country(
id_country int not null auto_increment primary key,
country_name varchar(30) not null

);

create table art(
id_art int not null auto_increment  primary key,
art_name varchar (50) not null,
art_description varchar(240) not null,
date_publication date null default null,
date_exposition date null default null

);


drop table art;


create table author(
id_author int not null auto_increment primary key,
author_name varchar(50) not null,
cpf varchar(11) unique null,
sex char (1) null,
email varchar(30) unique null,
birth date not null,
country_origin int not null,
constraint fk_country_author foreign key (country_origin) references country(id_country)

);

create table art_author(

author_id int not null,
art_id int not null,

primary key (author_id, art_id),

constraint fk_author_art foreign key (author_id) references author(id_author),
constraint fk_art_author foreign key (art_id) references art(id_art)

);



drop table art_author;


insert into author(author_name, cpf, sex, email, birth, country_origin) values
-- ('Ricardo Mendes','11111111111', 'M', 'ric@gmail.com','1990-11-15', '1'),
-- ('Paulo Alecio', '22222222222', 'M', 'paulo@gmail.com', '1999-10-18', 1),
-- ('Joana Silva', '33333333333','F', 'joana@gmail.com', '2000-10-10', 2)
('Steve Jobs','44444444444', 'M', 'steve@gmail.com', '1956-10-02','3'),
('Bill Gates','12345678911','M',' bill@gamail.com','1954-10-09','11'),
('Ada Lovelace','33333333344','F', 'ada@gmail.com', '1977-09-10','2'),
('Paulo Coelho', 'null', 'M', 'pau@gmail.com','1967-12-18', '1'),
('Eric Ries', '33333333343', 'M', 'eric@gmail.com', '1978-11-10','11')
;


insert into art (art_name, art_description, date_publication, date_exposition)values
 ('O Senhor dos Aneis', 'Historia legal', '1990-11-10','2023-05-30');
-- ('Harry Potter', 'Aventura', '1999-12-10');
-- ('Código da Vinci' ,'Drama', '1992-09-10', null);
-- ('A Startup Enxuta', 'História que detalha quais são os passos que precisam ser tomados para construir uma empresa inovadora', '1990-10-10', null);,
('21 Lições para o Século 21', 'Obra para refletir sobre o presente, e como melhorar o nosso mundo', '2018-11-10', null),
('Inteligência Artificial', 'Obra que mostra como a revolução das máquinas nos tornará mais humanos', '2019-02-10',' 2023-10-05'),
('Guerra e Paz', 'História que conta milhões de práticas de traições, roubos, fraudes, falsficações de dinheiro e muito mais, ', '1869-10-10', null),
('A Montanha Mágica', 'História de romance com conflitos espirituais', '1924-10-10', null),
('O Senhor dos Anéis', 'História sobre o condado', '2021-10-10', null),
('Harry Potter', 'História sobre um mago', '2022-10-10', null),
('O código da Vinci', 'História sobre da Vinci', '2015-02-10', null),
('O Livro Vermelho', 'História legal', '1990-02-20', '2020-03-11');

;

insert into art_author(author_id, art_id) values
-- (1,2);
(2,1);

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------

SELECT * FROM autores.Obras;

insert into Obras (nomeObra, descricao, dataPublicacao, idAutor) values
('A Volta dos que não foram', 'História legal', '2021-10-10','9');

alter table Obras add column idAutor  int not null;

insert into Obras (nomeObra, descricao, dataPublicacao, idAutor) values
('A Startup Enxuta', 'História que detalha quais são os passos que precisam ser tomados para construir uma empresa inovadora', '2019-10-10','9'),
('21 Lições para o Século 21', 'Obra para refletir sobre o presente, e como melhorar o nosso mundo', '2018-11-10','12'),
('Inteligência Artificial', 'Obra que mostra como a revolução das máquinas nos tornará mais humanos', '2019-02-10','7'),
('Guerra e Paz', 'História que conta milhões de práticas de traições, roubos, fraudes, falsficações de dinheiro e muito mais, ', '1869-10-10','10'),
('A Montanha Mágica', 'História de romance com conflitos espirituais', '1924-10-10','4'),
('O Senhor dos Anéis', 'História sobre o condado', '2021-10-10','9'),
('Harry Potter', 'História sobre um mago', '2022-10-10','5'),
('O código da Vinci', 'História sobre da Vinci', '2015-02-10','1'),
('O Livro Vermelho', 'História legal', '1990-02-20','2');

;
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------


