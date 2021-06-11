CREATE TABLE many_to_many
(
    id_certificate BIGINT NOT NULL,
    id_tag         BIGINT NOT NULL,
    PRIMARY KEY (id_certificate, id_tag)
);