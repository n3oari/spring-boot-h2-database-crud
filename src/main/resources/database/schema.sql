DROP TABLE IF EXISTS comments;
DROP TABLE IF EXISTS tutorials;
DROP TABLE IF EXISTS authors;
DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS users;

CREATE TABLE authors (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         name VARCHAR(255) NOT NULL,
                         last_name VARCHAR(255) NOT NULL,
                         email VARCHAR(255) NOT NULL,
                         age INT
);

CREATE TABLE categories (
                            id INT AUTO_INCREMENT PRIMARY KEY,
                            name VARCHAR(255) NOT NULL,
                            description VARCHAR(255)
);

CREATE TABLE users (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(255) NOT NULL UNIQUE,
                       email VARCHAR(255) NOT NULL UNIQUE,
                       fullname VARCHAR(255)
);

CREATE TABLE tutorials (
                           id INT AUTO_INCREMENT PRIMARY KEY,
                           title VARCHAR(255) NOT NULL,
                           description VARCHAR(255),
                           published BOOLEAN DEFAULT FALSE,
                           created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                           author_id INT NOT NULL,
                           category_id INT NOT NULL,
                           CONSTRAINT fk_author FOREIGN KEY (author_id) REFERENCES authors(id),
                           CONSTRAINT fk_category FOREIGN KEY (category_id) REFERENCES categories(id)
);

CREATE TABLE comments (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          content VARCHAR(255) NOT NULL,
                          created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                          tutorial_id INT NOT NULL,
                          user_id INT NOT NULL,
                          CONSTRAINT fk_comment_tutorial FOREIGN KEY (tutorial_id) REFERENCES tutorials(id),
                          CONSTRAINT fk_comment_user FOREIGN KEY (user_id) REFERENCES users(id)
);