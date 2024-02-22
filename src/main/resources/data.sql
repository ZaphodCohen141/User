DROP TABLE IF EXISTS users;

CREATE TABLE users(
    id INT NOT NULL AUTO_INCREMENT,
    first_name varchar(255) NOT NULL DEFAULT '',
    last_name varchar(255) NOT NULL DEFAULT '',
    email varchar(255) NOT NULL DEFAULT '',
    age DOUBLE NOT NULL,
    address varchar(255) NOT NULL DEFAULT '',
    join_date DATE NOT NULL,
    PRIMARY KEY (id)
);


INSERT INTO users (first_name,last_name,email,age,address,join_date)
VALUES ('Marko','Polo','Marco@polo.com',26,'Somewhere over the rainbow','1254-09-15'),
       ('Gordon','Freeman','GFreeman@pblackMesa.valve',42,'Seattle, Washington','2070-05-16');

