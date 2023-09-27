-- Script para crear la base de datos y las tablas necesarias para el proyecto
CREATE DATABASE mselektraclient;
\c mselektraclient;

-- Se crea la tabla client
create table client (
    id bigserial primary key,
    birth_date date not null,
    email varchar(255) not null,
    first_surname varchar(255) not null,
    gender varchar(255) not null,
    name varchar(255) not null constraint ukdn5jasds5r1j3ewo5k3nhwkkq unique,
    phone varchar(255) not null,
    second_surname varchar(255) not null
);
alter table client owner to postgres;

-- Se crea la tabla library
create table library(
    id bigserial primary key,
    author_client_id bigint not null,
    editorial varchar(255) not null,
    name varchar(255) not null,
    publication_date date not null
);
alter table library owner to postgres;

-- Custom query para obtener los datos de la tabla library y client
select
    l.id as id,
    l.name as name,
    l.editorial as editorial,
    l.publication_date as publication_date,
    c.id as author_id,
    c.name as author_name,
    c.first_surname as author_first_surname,
    c.second_surname as author_second_surname,
    c.gender as author_gender,
    c.birth_date as author_birth_date,
    c.phone as author_phone,
    c.email as author_email
from library l inner join client c on l.author_client_id = c.id where l.id = 1;

-- Inserta el primer registro de la tabla client
INSERT INTO client (name, first_surname, second_surname, birth_date, email, gender, phone)
VALUES ('Pedro', 'Lopez', 'Marquina', '1990-01-01', 'pedro.lopez@gmail.com', 'MALE', '956473827');

-- Inserta el segundo registro de la tabla client
INSERT INTO client (name, first_surname, second_surname, birth_date, email, gender, phone)
VALUES ('María', 'Gómez', 'Pérez', '1995-02-15', 'maria.gomez@gmail.com', 'FEMALE', '956123456');

-- Inserta el tercer registro de la tabla client
INSERT INTO client (name, first_surname, second_surname, birth_date, email, gender, phone)
VALUES ('Juan', 'Martínez', 'López', '1985-07-20', 'juan.martinez@gmail.com', 'MALE', '956987654');

-- Inserta el cuarto registro de la tabla client
INSERT INTO client (name, first_surname, second_surname, birth_date, email, gender, phone)
VALUES ('Luisa', 'Ramírez', 'García', '2000-04-10', 'luisa.ramirez@gmail.com', 'FEMALE', '956789012');

-- Inserta el quinto registro de la tabla client
INSERT INTO client (name, first_surname, second_surname, birth_date, email, gender, phone)
VALUES ('Javier', 'Sánchez', 'Fernández', '1988-11-30', 'javier.sanchez@gmail.com', 'MALE', '956234567');

-- Inserta el primer registro de la tabla library
INSERT INTO library (name, author_client_id, editorial, publication_date)
VALUES ('El señor de los anillos', 1, 'Minotauro', '1954-07-29');

-- Inserta el segundo registro
INSERT INTO library (name, author_client_id, editorial, publication_date)
VALUES ('Harry Potter y la piedra filosofal', 2, 'Salamandra', '1997-06-26');

-- Inserta el tercer registro
INSERT INTO library (name, author_client_id, editorial, publication_date)
VALUES ('Cien años de soledad', 3, 'Editorial Sudamericana', '1967-05-30');

-- Inserta el cuarto registro
INSERT INTO library (name, author_client_id, editorial, publication_date)
VALUES ('1984', 4, 'Secker & Warburg', '1949-06-08');

-- Inserta el quinto registro
INSERT INTO library (name, author_client_id, editorial, publication_date)
VALUES ('Matar a un ruiseñor', 5, 'J. B. Lippincott & Co.', '1960-07-11');