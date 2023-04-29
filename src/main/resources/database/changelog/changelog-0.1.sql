-- liquibase formatted sql

-- changeset liquibase:1
CREATE TABLE IF NOT EXISTS public.user (
    id serial PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL
);