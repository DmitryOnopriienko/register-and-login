DROP TABLE IF EXISTS `user`;

DROP SCHEMA IF EXISTS `user_db`;

CREATE SCHEMA IF NOT EXISTS `user_db`;

USE `user_db`;

CREATE TABLE IF NOT EXISTS user(
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
);

INSERT INTO user(username, password)
VALUES('admin', 'admin'),
      ('user', 'user'),
      ('guest', 'guest');
