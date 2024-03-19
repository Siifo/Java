## contraseña encriptada 
* ('1234')
* $2a$04$5uOZS8ntKSckkL7c6ts0eOWGuhtFJYDC78hSyWHncA6jlgJvifnSW

## Crear una base de datos llamada loginprueba
* CREATE DATABASE loginprueba;
## Usar la base datos antes de ejecutar cualquier tipo de procedimientos
* USE loginprueba;
## El mismo codigo base crea las tablas (por ende no hay necesidad de crearlas)
## Copiar y pegar el siguiente codigo para relacionar las tablas y hcaer la inserción de datos

INSERT INTO user (enabled, password, username)
VALUES (0b1, "$2a$04$5uOZS8ntKSckkL7c6ts0eOWGuhtFJYDC78hSyWHncA6jlgJvifnSW", "admin");
INSERT INTO user (enabled, password, username)
VALUES (0b1, "$2a$04$5uOZS8ntKSckkL7c6ts0eOWGuhtFJYDC78hSyWHncA6jlgJvifnSW", "user");

select * from user;

INSERT INTO authority (id, authority) VALUES (1, "ROLE_ADMIN");
INSERT INTO authority (id, authority) VALUES (2, "ROLE_USER");

select * from authority;

INSERT INTO  authorities_users (usuario_id, authority_id) VALUES (1,1);
INSERT INTO  authorities_users (usuario_id, authority_id) VALUES (1,2);
INSERT INTO  authorities_users (usuario_id, authority_id) VALUES (2,1);
