CREATE DATABASE news_portal;
\c news_portal
CREATE TABLE users(id serial PRIMARY KEY, name VARCHAR, department VARCHAR, role VARCHAR);
CREATE TABLE departments(id serial PRIMARY KEY, name VARCHAR, description VARCHAR, employees VARCHAR);
CREATE TABLE news_articles(id serial PRIMARY KEY, name VARCHAR, author VARCHAR, description VARCHAR, time TIMESTAMP);
CREATE DATABASE news_portal_test WITH TEMPLATE news_portal;