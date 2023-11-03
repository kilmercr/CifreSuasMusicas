TRUNCATE TABLE TB_USERS_ROLES RESTART IDENTITY;
TRUNCATE TABLE TB_ROLE RESTART IDENTITY;
TRUNCATE TABLE TB_USER RESTART IDENTITY;

-- admin, admin123
INSERT INTO TB_USER (username, password, cpf, name, sex, email, naturality, nacionality, dt_birthday)
VALUES ('admin', '$2a$10$9/Sj7fzfbcfT/2i3UNNdMuHQr01WPBtQyR.bB09WP3ZU6YxIVMRsG', '33007748534', 'Administrador',
        'M', 'admin@csm.com.br', 'Joao Pessoa', 'Brasil', '1978-05-18');
-- moderator, moderator123
INSERT INTO TB_USER (username, password, cpf, name, sex, email, naturality, nacionality, dt_birthday)
VALUES ('moderator', '$2a$12$kQN82WVFDLYPwN.1f9z45OKS21683E5pfMBkQ3TQH/0slG6eoPzp2', '05687999094', 'Moderador',
        'F', 'moderator@csm.com.br', 'Curitiba', 'Brasil', '1980-03-02');
-- user, user123
INSERT INTO TB_USER (username, password, cpf, name, sex, email, naturality, nacionality, dt_birthday)
VALUES ('user', '$2a$10$L.AXNeXq5kV1YwrYAQqWKeTTBJCYc5PSfXmVRmzgGHDc1rT6cBq3y', '91606820516', 'Usuario',
        'F', 'usuario@csm.com.br', 'Curitiba', 'Brasil', '2015-05-25');

INSERT INTO TB_ROLE (name) VALUES ('ROLE_ADMIN');
INSERT INTO TB_ROLE (name) VALUES ('ROLE_MODERATOR');
INSERT INTO TB_ROLE (name) VALUES ('ROLE_USER');

INSERT INTO TB_USERS_ROLES (user_id, role_id) VALUES (1, 1);
INSERT INTO TB_USERS_ROLES (user_id, role_id) VALUES (2, 2);
INSERT INTO TB_USERS_ROLES (user_id, role_id) VALUES (2, 3);
INSERT INTO TB_USERS_ROLES (user_id, role_id) VALUES (3, 3);