create table user_login (
	id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL primary key,
	user_name VARCHAR(100) NOT NULL,
	user_login VARCHAR(100) NOT NULL unique,
	user_password VARCHAR(50) NOT NULL
)

CREATE TABLE permissions (
	perm_id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL primary key,
	perm_funcao VARCHAR(100) NOT NULL unique,
	user_id BIGINT NOT NULL unique
);

ALTER TABLE permissions ADD CONSTRAINT fk_permission_user FOREIGN KEY (user_id) REFERENCES user_login;


--		PAYLOAD
-- insert into user_login(user_name, user_login, user_password) values ('Carlos', 'devcarlosdms@gmamil.com', '123456');
-- insert into user_login(user_name, user_login, user_password) values ('Maria', 'maria@gmamil.com', '123456');
-- insert into user_login(user_name, user_login, user_password) values ('Darci', 'darci@gmamil.com', '123456');
-- INSERT INTO permissions (perm_funcao, user_id) values ('ADMIN', 1);
-- INSERT INTO permissions (perm_funcao, user_id) values ('USER', 2);
-- INSERT INTO permissions (perm_funcao, user_id) values ('VISITOR', 3);

--		CONSULTA DAS TABELAS
-- select * from user_login
-- select * from PERMISSIONS

