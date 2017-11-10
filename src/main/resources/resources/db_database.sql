-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Erstellungszeit: 10. Nov 2017 um 14:12
-- Server-Version: 10.1.13-MariaDB
-- PHP-Version: 7.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `db_database`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `country`
--

CREATE TABLE IF NOT EXISTS `country` (
  `ID` int(11) NOT NULL,
  `countryname` varchar(100) CHARACTER SET utf32 COLLATE utf32_german2_ci NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `ID_2` (`ID`),
  KEY `ID` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- RELATIONEN DER TABELLE `country`:
--   `ID`
--       `member` -> `country`
--

--
-- Daten für Tabelle `country`
--

INSERT INTO `country` (`ID`, `countryname`) VALUES
(0, 'germany'),
(1, 'usa'),
(2, 'greece'),
(3, 'kenya'),
(4, 'panama'),
(5, 'sweden'),
(6, 'turkey'),
(7, 'zambia');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `member`
--

CREATE TABLE IF NOT EXISTS `member` (
  `id` mediumint(8) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf32 COLLATE utf32_german2_ci DEFAULT NULL,
  `nachname` varchar(255) CHARACTER SET utf32 COLLATE utf32_german2_ci DEFAULT NULL,
  `gender` tinyint(1) DEFAULT NULL,
  `age` mediumint(9) DEFAULT NULL,
  `country` mediumint(9) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_2` (`id`),
  KEY `id` (`id`),
  KEY `id_3` (`id`),
  KEY `country` (`country`),
  KEY `country_2` (`country`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=latin1;

--
-- RELATIONEN DER TABELLE `member`:
--

--
-- Daten für Tabelle `member`
--

INSERT INTO `member` (`id`, `name`, `nachname`, `gender`, `age`, `country`) VALUES
(1, 'Lev', 'Pate', 0, 10, 6),
(2, 'Lamar', 'Gamble', 0, 80, 2),
(3, 'Carlos', 'Rosario', 1, 93, 6),
(4, 'Chandler', 'Hahn', 0, 15, 0),
(5, 'Lucius', 'Donovan', 0, 35, 1),
(6, 'Carson', 'Stafford', 0, 13, 1),
(7, 'Oliver', 'Martin', 1, 20, 5),
(8, 'Elton', 'Sykes', 1, 64, 1),
(9, 'Macon', 'Miranda', 1, 64, 4),
(10, 'Ezekiel', 'Reilly', 1, 53, 6),
(11, 'Elton', 'Barron', 0, 57, 6),
(12, 'William', 'Velez', 1, 57, 4),
(13, 'Quamar', 'Clarke', 1, 70, 3),
(14, 'Uriel', 'Simon', 0, 48, 6),
(15, 'Derek', 'Harvey', 0, 45, 2),
(16, 'Quinn', 'Wiggins', 1, 69, 4),
(17, 'Lewis', 'Mercado', 0, 42, 4),
(18, 'Bruno', 'Montoya', 1, 51, 3),
(19, 'Zane', 'Crawford', 0, 44, 2),
(20, 'Ross', 'Sherman', 1, 33, 6),
(21, 'Murphy', 'Shepherd', 0, 55, 2),
(22, 'Hashim', 'Jimenez', 1, 80, 0),
(23, 'Tarik', 'Salinas', 1, 49, 3),
(24, 'Erich', 'Moore', 1, 31, 4),
(25, 'Axel', 'Klein', 1, 56, 1),
(26, 'Lester', 'Chandler', 1, 96, 0),
(27, 'Oscar', 'Casey', 1, 82, 1),
(28, 'Hammett', 'Vaughn', 1, 39, 4),
(29, 'Felix', 'Joyce', 1, 60, 5),
(30, 'Davis', 'Wilcox', 0, 47, 4),
(31, 'Oscar', 'Guzman', 0, 99, 3),
(32, 'Levi', 'Delaney', 0, 66, 6),
(33, 'Hyatt', 'Cooke', 1, 49, 6),
(34, 'Yoshio', 'Weiss', 0, 61, 1),
(35, 'Raymond', 'Brock', 0, 81, 6),
(36, 'Samson', 'Mathis', 0, 11, 3),
(37, 'Philip', 'Mosley', 0, 19, 2),
(38, 'Hedley', 'Calderon', 0, 64, 4),
(39, 'Bernard', 'Wright', 1, 64, 2),
(40, 'Grant', 'Ball', 0, 71, 1),
(41, 'Knox', 'Stanley', 0, 55, 0),
(42, 'Garth', 'Marquez', 1, 35, 1),
(43, 'Jared', 'Dillard', 1, 10, 2),
(44, 'Shad', 'Whitfield', 1, 33, 5),
(45, 'Reece', 'Henderson', 0, 15, 2),
(46, 'Baker', 'Randolph', 1, 53, 2),
(47, 'Lance', 'Haney', 1, 40, 1),
(48, 'Dane', 'Munoz', 1, 39, 4),
(49, 'Gary', 'Cote', 0, 16, 5),
(50, 'Blaze', 'Lester', 1, 90, 1),
(51, 'Murphy', 'Morrow', 0, 32, 3),
(52, 'Sean', 'Park', 1, 56, 5),
(53, 'Kato', 'Valdez', 1, 12, 6),
(54, 'Theodore', 'Buck', 0, 27, 5),
(55, 'Trevor', 'Gilmore', 0, 36, 4),
(56, 'Herman', 'Mcmillan', 0, 90, 6),
(57, 'Cain', 'Brooks', 1, 76, 1),
(58, 'Griffin', 'Knapp', 0, 26, 5),
(59, 'Brennan', 'Wolfe', 1, 90, 4),
(60, 'Bernard', 'Ford', 0, 41, 5),
(61, 'Otto', 'Mckinney', 0, 23, 3),
(62, 'Wesley', 'Thomas', 0, 64, 3),
(63, 'Brock', 'Travis', 1, 35, 1),
(64, 'Adrian', 'Martin', 1, 84, 2),
(65, 'Judah', 'Hutchinson', 1, 103, 5),
(66, 'Edward', 'Dalton', 0, 92, 3),
(67, 'Josiah', 'Hawkins', 1, 75, 5),
(68, 'Jarrod', 'Guerrero', 0, 77, 5),
(69, 'Branden', 'Rice', 0, 79, 1),
(70, 'Orson', 'Sykes', 1, 31, 2),
(71, 'Hedley', 'Mosley', 0, 29, 6),
(72, 'Jarrod', 'England', 1, 87, 1),
(73, 'Bruce', 'Brock', 1, 25, 0),
(74, 'Uriah', 'Burt', 1, 77, 3),
(75, 'Thaddeus', 'Campos', 1, 20, 6),
(76, 'Bert', 'Downs', 1, 84, 1),
(77, 'John', 'Rogers', 0, 70, 4),
(78, 'Uriel', 'Bowman', 1, 49, 2),
(79, 'Vladimir', 'Lowery', 1, 25, 6),
(80, 'Eagan', 'Farley', 1, 35, 1),
(81, 'Guy', 'Barrera', 1, 65, 5),
(82, 'Vance', 'Boyd', 1, 76, 3),
(83, 'Malachi', 'Crosby', 1, 10, 1),
(84, 'Blake', 'Ewing', 0, 79, 1),
(85, 'Uriah', 'Hendricks', 1, 42, 6),
(86, 'Abraham', 'Odom', 0, 59, 0),
(87, 'Nathaniel', 'Cruz', 1, 17, 3),
(88, 'Herrod', 'Hubbard', 0, 67, 6),
(89, 'Jelani', 'Daniels', 0, 91, 1),
(90, 'Zane', 'Ewing', 0, 98, 2),
(91, 'Barry', 'Rasmussen', 1, 20, 4),
(92, 'Omar', 'Roy', 0, 101, 6),
(93, 'Paul', 'Yang', 0, 67, 2),
(94, 'Lev', 'Vance', 1, 56, 6),
(95, 'Driscoll', 'Gallegos', 1, 36, 1),
(96, 'Colorado', 'Weiss', 1, 63, 0),
(97, 'Trevor', 'Gaines', 0, 15, 1),
(98, 'Kadeem', 'Parker', 1, 45, 3),
(99, 'Brendan', 'Stokes', 1, 88, 2),
(100, 'Deacon', 'Britt', 1, 49, 5);


--
-- Metadaten
--
USE `phpmyadmin`;

--
-- Metadaten für country
--

--
-- Metadaten für member
--

--
-- Metadaten für db_database
--

--
-- Daten für Tabelle `pma__relation`
--

INSERT INTO `pma__relation` (`master_db`, `master_table`, `master_field`, `foreign_db`, `foreign_table`, `foreign_field`) VALUES
('db_database', 'country', 'ID', 'db_database', 'member', 'country');

--
-- Daten für Tabelle `pma__central_columns`
--

INSERT INTO `pma__central_columns` (`db_name`, `col_name`, `col_type`, `col_length`, `col_collation`, `col_isNull`, `col_extra`, `col_default`) VALUES
('db_database', 'country', 'mediumint', '9', '', 1, ',', '');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
