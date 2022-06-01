drop table racun;
drop table stavka;
drop table proizvod;

CREATE TABLE proizvod (
    id int NOT NULL AUTO_INCREMENT,
    proizvodjac varchar(255) NOT NULL,
    naziv varchar(255) NOT NULL,
    cena int NOT NULL,
    primary key (id)
);
CREATE TABLE stavka (
    id int NOT NULL AUTO_INCREMENT,
    proizvod int NOT NULL,
    kolicina int NOT NULL,
    primary key (id),
    FOREIGN KEY (proizvod) REFERENCES proizvod(id)
);
CREATE TABLE racun (
    id int NOT NULL AUTO_INCREMENT,
    br_racuna int NOT NULL,
    stavka int NOT NULL,
    datum date NOT NULL,
    primary key (id),
    FOREIGN KEY (stavka) REFERENCES stavka(id)
);



INSERT INTO proizvod (proizvodjac, naziv, cena)
VALUES ('veselin', 'prevara', 213);

INSERT INTO proizvod (proizvodjac, naziv, cena)
VALUES ('veselin', 'visa prevara', 213);

INSERT INTO proizvod (proizvodjac, naziv, cena)
VALUES ('JOVAN', 'OOOOO', 213);

INSERT INTO proizvod (proizvodjac, naziv, cena)
VALUES ('JOVAN', 'EEE', 213);

INSERT INTO proizvod (proizvodjac, naziv, cena)
VALUES ('JOVAN', 'III', 213);

INSERT INTO stavka (proizvod, kolicina)
VALUES (1, 1);

INSERT INTO racun (br_racuna, stavka, datum)
VALUES ( 1, 1, "2017-06-15");

