CREATE TABLE tb_tag(
    id UUID NOT NULL PRIMARY KEY,
    coordinate VARCHAR(3) NOT NULL UNIQUE,
    color VARCHAR(20),
    is_available BOOLEAN NOT NULL
);

CREATE TABLE tb_motorcycle(
    id UUID NOT NULL PRIMARY KEY,
    license_plate VARCHAR(14) NOT NULL UNIQUE,
    chassis VARCHAR(17) NOT NULL UNIQUE,
    problem_description VARCHAR(255),
    model VARCHAR(12) NOT NULL,
    problem VARCHAR(15) NOT NULL,
    tag_id UUID NOT NULL REFERENCES tb_tag(id),
    CONSTRAINT chk_model CHECK (model in ('MOTTUPOP', 'MOTTUSPORT', 'MOTTUE')),
    CONSTRAINT chk_problem CHECK (problem in ('MECHANICAL', 'ELECTRICAL', 'DOCUMENTATION', 'AESTHETIC', 'SAFETY', 'MULTIPLE', 'COMPLIANT'))
);

CREATE TABLE tb_user (
    id UUID NOT NULL PRIMARY KEY,
    login VARCHAR(20) NOT NULL UNIQUE,
    password VARCHAR(300) NOT NULL,
    roles VARCHAR[]
);