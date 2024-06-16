CREATE SEQUENCE IF NOT EXISTS forum_hub.post_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE IF NOT EXISTS forum_hub.post (
    id BIGINT DEFAULT nextval('forum_hub.post_seq'),
    titulo VARCHAR NOT NULL,
    texto VARCHAR NOT NULL,
    deletado BOOLEAN DEFAULT FALSE,
    data_cadastro DATE DEFAULT now(),
    data_atualizacao DATE,
    fk_assunto_id BIGINT,
    CONSTRAINT fk_assunto FOREIGN KEY (fk_assunto_id) REFERENCES forum_hub.assunto(id),
    PRIMARY KEY (id)
);

