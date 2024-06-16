CREATE SCHEMA IF NOT EXISTS forum_hub;

CREATE SEQUENCE IF NOT EXISTS forum_hub.usuario_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS forum_hub.usuario (
    id BIGINT DEFAULT nextval('forum_hub.usuario_seq'),
    username VARCHAR(255)NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    deletado BOOLEAN DEFAULT FALSE,
    data_cadastro DATE DEFAULT now(),
    data_atualizacao DATE,
    PRIMARY KEY (id)
);