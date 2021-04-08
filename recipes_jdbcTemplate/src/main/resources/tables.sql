CREATE TABLE dishes
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE ingredients
(
    id        SERIAL PRIMARY KEY,
    name      VARCHAR(255) NOT NULL,
    count     INT          NOT NULL,
    dish_name VARCHAR      NOT NULL,
    FOREIGN KEY (dish_name) REFERENCES dishes (name) ON DELETE CASCADE
);
