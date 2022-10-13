/* 
Project homework04 (https://github.com/Aberezhnoy1980/java-core/tree/interview03/interview/src/main/java/ru/aberezhnoy/homework04)
DBMS: MySQL
IDEs: Workbench 8.0/IntelliJ IDEA 2021.3.2 (Ultimate Edition)
date: 13.10.2022 
developer: Aleksandr Berezhnoy 
*/

DROP DATABASE IF EXISTS `cinema`;
CREATE DATABASE `cinema`;

USE `cinema`;

DROP TABLE IF EXISTS `movies` CASCADE;
CREATE TABLE `movies` (
`id` SERIAL PRIMARY KEY,
`title` VARCHAR(255) NOT NULL COMMENT 'название',
`length` INT UNSIGNED NOT NULL COMMENT 'Продолжительность'
) COMMENT = 'Каталог фильмов';

DROP TABLE IF EXISTS `sessions` CASCADE;
CREATE TABLE `session` (
`id` SERIAL PRIMARY KEY,
`film_id` BIGINT UNSIGNED NOT NULL,
`price` DECIMAL(5, 2) COMMENT 'цена показа',
`show_start` TIME NOT NULL COMMENT 'время показа',
KEY `idx_of_film_id`(`film_id`),
CONSTRAINT `fk_films_id`
FOREIGN KEY (`film_id`) REFERENCES `movies` (`id`)
) COMMENT ='сеансы';

DROP TABLE IF EXISTS `tickets` CASCADE;
CREATE TABLE `tickets` (
`id` SERIAL PRIMARY KEY,
`place_number` INT UNSIGNED NOT NULL COMMENT 'место',
`session_id` BIGINT UNSIGNED NOT NULL,
KEY `idx_of_session_id`(`session_id`),
CONSTRAINT `fk_session_id`
FOREIGN KEY (`session_id`) REFERENCES `session` (`id`)
) COMMENT ='билеты';

INSERT INTO `movies` (`title`, `length`) VALUES 
('film1', 60),
('film2', 90),
('film3', 120),
('film4', 90),
('film5', 60);

INSERT INTO `session` (`film_id`, `price`, `show_start`) VALUES 
('1', 100, '09:00:00'),
('2', 200, '10:30:00'),
('3', 200, '12:00:00'),
('4', 200, '14:00:00'),
('5', 300, '15:00:00'),
('1', 300, '16:30:00'),
('2', 300, '17:30:00'),
('3', 300, '18:30:00'),
('4', 400, '20:10:00'),
('5', 400, '20:30:00');

INSERT INTO `tickets` (`place_number`, `session_id`) VALUES 
(1, 1),
(2, 2),
(3, 3),
(4, 4),
(5, 5),
(6, 6),
(7, 7),
(8, 8),
(9, 9),
(10, 10),
(11, 1),
(12, 2),
(13, 3),
(14, 4),
(15, 5),
(16, 6),
(17, 7),
(18, 8),
(19, 9),
(20, 10);

CREATE VIEW SessionDetails AS
SELECT id, film_id, show_start, LEAD(show_start, 1) OVER (ORDER BY show_start)
AS next_show_start,
LEAD(film_id, 1) OVER (ORDER BY show_start) AS next_film_id,
date_add(show_start, INTERVAL (SELECT length FROM movies
WHERE movies.id=sessions.film_id) MINUTE) AS show_end
FROM sessions;

SELECT movies.title AS film_1, SessionDetails.show_start AS show_1_start,
movies.length AS length_1,
(SELECT title FROM movies WHERE SessionDetails.next_film_id=movies.id) AS film_2,
SessionDetails.next_show_start AS show_2_start,
(SELECT length FROM movies WHERE SessionDetails.next_film_id=films.id) AS length_2
FROM SessionDetails
INNER JOIN movies ON
SessionDetails.film_id = movies.id
WHERE show_end > next_show_start;

