

CREATE DATABASE quizDb;
CREATE USER 'user1' IDENTIFIED BY 'pass';
GRANT ALL on quizDb.* TO 'user1';


CREATE TABLE multichoiceQuiz (
    Id int,
    Question varchar(255),
    AnswerA varchar(255),
    AnswerB varchar(255),
    AnswerC varchar(255),
    AnswerD varchar(255),
    CorrectAnswer varchar(10)
);


CREATE TABLE binaryQuiz (
    Id int,
    Question varchar(255),
    CorrectAnswer varchar(10)
);


CREATE TABLE scoreHistory (
    Id int,
    User varchar(255),
    score int,
    topic varchar(255)
);


CREATE TABLE Users (
    Id int,
    Username varchar(255)

);