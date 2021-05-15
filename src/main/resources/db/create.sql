SET MODE PostgreSQL;

CREATE DATABASE news_portal;
\c news_portal
CREATE TABLE IF NOT EXISTS users(id serial PRIMARY KEY, name VARCHAR, department VARCHAR, role VARCHAR);
CREATE TABLE IF NOT EXISTS departments(id serial PRIMARY KEY, name VARCHAR, description VARCHAR, employees VARCHAR);
CREATE TABLE IF NOT EXISTS news_articles(id serial PRIMARY KEY, name VARCHAR, author VARCHAR, description VARCHAR);
CREATE TABLE IF NOT EXISTS departments_users(id serial PRIMARY KEY, userId INTEGER, departmentId INTEGER);
CREATE DATABASE news_portal_test WITH TEMPLATE news_portal;