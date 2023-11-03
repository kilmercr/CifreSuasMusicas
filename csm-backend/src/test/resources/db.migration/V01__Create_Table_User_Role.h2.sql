CREATE TABLE IF NOT EXISTS TB_USER (
    user_id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(100) UNIQUE,
    password VARCHAR(200),
    name VARCHAR(255),
    cpf VARCHAR(11) UNIQUE,
    phone VARCHAR(15),
    sex VARCHAR(1),
    email VARCHAR(100),
    naturality VARCHAR(40),
    nacionality VARCHAR(40),
    dt_birthday DATE NOT NULL,
    dt_create TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    dt_update TIMESTAMP,
    PRIMARY KEY (user_id)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS TB_ROLE (
    role_id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(40),
    PRIMARY KEY (role_id)
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS TB_USERS_ROLES (
    user_role_id INT
    user_id INT,
    role_id INT,
    PRIMARY KEY (user_role_id),
    UNIQUE (user_id, role_id)
) ENGINE = InnoDB;

CREATE USER IF NOT EXISTS dbuser PASSWORD dbuser;
GRANT ALL ON TB_USER TO dbuser;
GRANT ALL ON TB_ROLE TO dbuser;
GRANT ALL ON TB_USERS_ROLES TO dbuser;
