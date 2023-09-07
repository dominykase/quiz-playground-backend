--liquibase formatted sql

--changeset dominykas:2023_06_19_22_03_create_quizzes_table
CREATE TABLE quizzes (
    id BIGINT UNSIGNED AUTO_INCREMENT,
    name VARCHAR(255),
    description VARCHAR(1023),
    PRIMARY KEY (id)
);

--changeset dominykas:2023_06_19_22_04_create_questions_table
CREATE TABLE questions (
    id BIGINT UNSIGNED AUTO_INCREMENT,
    quiz_id BIGINT UNSIGNED,
    text VARCHAR(255),
    PRIMARY KEY (id),
    FOREIGN KEY (quiz_id) REFERENCES quizzes(id)
);

--changeset dominykas:2023_09_04_18_55_create_categories_table
CREATE TABLE categories (
    id BIGINT UNSIGNED AUTO_INCREMENT,
    name VARCHAR(255),
    quiz_id BIGINT UNSIGNED,
    description VARCHAR(1023),
    PRIMARY KEY (id),
    FOREIGN KEY (quiz_id) REFERENCES quizzes(id)
)

--changeset dominykas:2023_09_07_20_47_create_answers_table
CREATE TABLE answers (
    id BIGINT UNSIGNED AUTO_INCREMENT,
    text VARCHAR(255),
    question_id BIGINT UNSIGNED,
    PRIMARY KEY (id),
    FOREIGN KEY (question_id) REFERENCES questions(id)
)
