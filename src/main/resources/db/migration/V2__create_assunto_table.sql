CREATE SEQUENCE IF NOT EXISTS forum_hub.assunto_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS forum_hub.assunto (
    id BIGINT DEFAULT nextval('forum_hub.assunto_seq'),
    nome VARCHAR(255)NOT NULL,
    deletado BOOLEAN DEFAULT FALSE,
    data_cadastro DATE DEFAULT now(),
    data_atualizacao DATE,
    PRIMARY KEY (id)
);