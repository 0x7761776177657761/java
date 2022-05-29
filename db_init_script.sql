CREATE TABLE racun (
    id int NOT NULL AUTO_INCREMENT,
    br_racuna int,
    stavka int,
    datum date,
    primary key (id),
    FOREIGN KEY (stavka) REFERENCES stavka(id)
);
CREATE TABLE stavka (
    id int NOT NULL AUTO_INCREMENT,
    proizvod int,
    kolicina int,
    primary key (id),
    FOREIGN KEY (proizvod) REFERENCES proizvod(id)
);
CREATE TABLE proizvod (
    id int NOT NULL AUTO_INCREMENT,
    proizvodjac varchar(255),
    naziv varchar(255),
    cena int,
    primary key (id)
);

INSERT INTO proizvod (proizvodjac, naziv, cena)
VALUES ('veselin', 'prevara', 213);

INSERT INTO proizvod (proizvodjac, naziv, cena)
VALUES ('veselin', 'visa prevara', 213);

INSERT INTO stavka (proizvod, kolicina)
VALUES ( 1, 1);

INSERT INTO racun (br_racuna, stavka)
VALUES ( 1, 1);

