CREATE SCHEMA IF NOT EXISTS public;
SET search_path = public;

CREATE TABLE department
(
    id   BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE course
(
    id            BIGSERIAL PRIMARY KEY,
    department_id BIGINT,
    name          VARCHAR(100) NOT NULL,
    credit_hours  INT,
    FOREIGN KEY (department_id) REFERENCES department (id)
);

CREATE TABLE student
(
    id            BIGSERIAL PRIMARY KEY,
    first_name    VARCHAR(50) NOT NULL,
    last_name     VARCHAR(50) NOT NULL,
    email         VARCHAR(100),
    department_id BIGINT,
    FOREIGN KEY (department_id) REFERENCES department (id)
);

CREATE TABLE instructor
(
    id         BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name  VARCHAR(50) NOT NULL,
    email      VARCHAR(100)
);
