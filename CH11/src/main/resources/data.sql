CREATE TABLE users (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(255),
                       email VARCHAR(255)
);

INSERT INTO users (name, email) VALUES ('User01', 'user01@example.com');
INSERT INTO users (name, email) VALUES ('User02', 'user02@example.com');
