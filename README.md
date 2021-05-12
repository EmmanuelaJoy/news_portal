# FARAJA COMPANY NEWS PORTAL APP

## Author's Information

<p>This project was developed by Emmanuela Joy.</p>

Click on [Emmanuela Joy ](https://github.com/EmmanuelaJoy) to find the link to her Github Site.

## Project Description

<p>News Portal App is an app that displays various news articles for all the employees in Faraja Company and specific news articles for various departments in the company.</p>

<p>The application uses a rest REST API for querying and retrieving scoped news and information.</p>

## User Stories

1. As a user, I want to be able to create a department and a news article.
2. As a user, I want to be able to see other users' details i.e their position in the company, their roles and the departments they are associated with.
3. As a user, I want to see specific information such as a departments name, description, and number of employees in the department.
4. As a user, I want to see all users from a specific department, the news relating to that department or a link to a page with said news.
5. As a user, I want to be able to post some news relating to a department.

## Project Set Up Instructions

To set up this project:
- Clone the repository by executing the following command in your terminal in the directory of your choice - `git clone https://github.com/EmmanuelaJoy/news_portal.git`
- Navigate into the news-portal directory - `cd news-portal`
- Run `gradle build` to build the project.

## Database Set Up Instructions

1. To set up the database in the cloned project:
- Run `psql < create.sql` in the project terminal.

2. To set up the database in a new project:
- Create a create.sql file in the root project and add the following data:
    - CREATE DATABASE news_portal;
  - -\c news_portal
  - CREATE TABLE users(id serial PRIMARY KEY, name VARCHAR, department VARCHAR, role VARCHAR);
  - CREATE TABLE departments(id serial PRIMARY KEY, name VARCHAR, description VARCHAR, employees VARCHAR);
  - CREATE TABLE news_articles(id serial PRIMARY KEY, name VARCHAR, author VARCHAR, description VARCHAR, time TIMESTAMP);
  - CREATE DATABASE news_portal_test WITH TEMPLATE news_portal;`

- Run `psql < create.sql` in the project terminal.

## Technologies Used:

- Java.
- Javascript.
- Spark.
- Gradle.
- Maven.
- Handlebars.
- CSS.
- Bootstrap.
- Sql2o.
- JUnit.

## Contact Information

- Email : emmajoy81@gmail.com
- Phone : +254 725853727

## [License](https://github.com/EmmanuelaJoy/githubSearch/blob/main/LICENSE)

MIT © [Emmanuela Joy ](https://github.com/EmmanuelaJoy)
