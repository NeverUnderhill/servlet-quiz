#!/bin/bash

echo   "DROP DATABASE IF EXISTS quiz;
        CREATE DATABASE quiz;
        USE quiz;
        CREATE TABLE IF NOT EXISTS admins(id VARCHAR(20) PRIMARY KEY, password VARCHAR(50) NOT NULL);
        LOAD DATA LOCAL INFILE 'admins.txt' INTO TABLE admins FIELDS TERMINATED BY '|';

        CREATE TABLE IF NOT EXISTS editors(id VARCHAR(20) PRIMARY KEY, password VARCHAR(50) NOT NULL);
        LOAD DATA LOCAL INFILE 'editors.txt' INTO TABLE editors FIELDS TERMINATED BY '|';

        CREATE TABLE IF NOT EXISTS users(email VARCHAR(50) PRIMARY KEY, username VARCHAR(50) NOT NULL, password VARCHAR(20) NOT NULL);
        LOAD DATA LOCAL INFILE 'users.txt' INTO TABLE users FIELDS TERMINATED BY '|';
        
        CREATE TABLE IF NOT EXISTS quizzes(id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(50) NOT NULL, editor VARCHAR(20) NOT NULL,
            FOREIGN KEY(editor) REFERENCES editors (id) ON DELETE CASCADE);
        CREATE TABLE IF NOT EXISTS questions(id INT PRIMARY KEY AUTO_INCREMENT, quiz_id INT NOT NULL, text VARCHAR(255) NOT NULL, time INT,
            answer1 VARCHAR(255), correct1 BOOLEAN, 
            answer2 VARCHAR(255), correct2 BOOLEAN, 
            answer3 VARCHAR(255), correct3 BOOLEAN, 
            answer4 VARCHAR(255), correct4 BOOLEAN, 
            answer5 VARCHAR(255), correct5 BOOLEAN, 
            answer6 VARCHAR(255), correct6 BOOLEAN, 
            answer7 VARCHAR(255), correct7 BOOLEAN, 
            answer8 VARCHAR(255), correct8 BOOLEAN, 
            order_no INT NOT NULL,
            FOREIGN KEY(quiz_id) REFERENCES quizzes (id) ON DELETE CASCADE);
        CREATE TABLE IF NOT EXISTS results(
            email VARCHAR(254) NOT NULL,
            quiz_id INT NOT NULL,
            name VARCHAR(64) NOT NULL,
            surname VARCHAR(64) NOT NULL,
            points INT NOT NULL,
            max_points INT NOT NULL,
            PRIMARY KEY(email, quiz_id),
            FOREIGN KEY(quiz_id) REFERENCES quizzes(id) ON DELETE CASCADE
        );
        " | mysql -u root -p -h localhost
        
        #CREATE TABLE IF NOT EXISTS answers(id INT PRIMARY KEY AUTO_INCREMENT, question_id INT NOT NULL, text VARCHAR(255) NOT NULL, correct BOOLEAN NOT NULL,
        #    FOREIGN KEY(question_id) REFERENCES questions (id) ON DELETE CASCADE);
