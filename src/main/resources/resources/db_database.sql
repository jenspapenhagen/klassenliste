-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Erstellungszeit: 11. Nov 2017 um 12:59
-- Server-Version: 10.1.13-MariaDB
-- PHP-Version: 7.0.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
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

CREATE TABLE `country` (
  `country_id` int(11) NOT NULL,
  `countryname` varchar(100) CHARACTER SET utf32 COLLATE utf32_german2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `country`
--

INSERT INTO `country` (`country_id`, `countryname`) VALUES
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
-- Tabellenstruktur für Tabelle `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `member`
--

CREATE TABLE `member` (
  `id` mediumint(8) UNSIGNED NOT NULL,
  `name` varchar(255) CHARACTER SET utf32 COLLATE utf32_german2_ci DEFAULT NULL,
  `nachname` varchar(255) CHARACTER SET utf32 COLLATE utf32_german2_ci DEFAULT NULL,
  `gender` tinyint(1) DEFAULT NULL,
  `age` mediumint(9) DEFAULT NULL,
  `country_id` int(11) DEFAULT NULL,
  `bemerkung` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `member`
--

INSERT INTO `member` (`id`, `name`, `nachname`, `gender`, `age`, `country_id`, `bemerkung`) VALUES
(1, 'Lev', 'Pate', 0, 10, 6, NULL),
(2, 'Lamar', 'Gamble', 0, 80, 2, NULL),
(3, 'Carlos', 'Rosario', 1, 93, 6, NULL),
(4, 'Chandler', 'Hahn', 0, 15, 0, NULL),
(5, 'Lucius', 'Donovan', 0, 35, 1, NULL),
(6, 'Carson', 'Stafford', 0, 13, 1, NULL),
(7, 'Oliver', 'Martin', 1, 20, 5, NULL),
(8, 'Elton', 'Sykes', 1, 64, 1, NULL),
(9, 'Macon', 'Miranda', 1, 64, 4, NULL),
(10, 'Ezekiel', 'Reilly', 1, 53, 6, NULL),
(11, 'Elton', 'Barron', 0, 57, 6, NULL),
(12, 'William', 'Velez', 1, 57, 4, NULL),
(13, 'Quamar', 'Clarke', 1, 70, 3, NULL),
(14, 'Uriel', 'Simon', 0, 48, 6, NULL),
(15, 'Derek', 'Harvey', 0, 45, 2, NULL),
(16, 'Quinn', 'Wiggins', 1, 69, 4, NULL),
(17, 'Lewis', 'Mercado', 0, 42, 4, NULL),
(18, 'Bruno', 'Montoya', 1, 51, 3, NULL),
(19, 'Zane', 'Crawford', 0, 44, 2, NULL),
(20, 'Ross', 'Sherman', 1, 33, 6, NULL),
(21, 'Murphy', 'Shepherd', 0, 55, 2, NULL),
(22, 'Hashim', 'Jimenez', 1, 80, 0, NULL),
(23, 'Tarik', 'Salinas', 1, 49, 3, NULL),
(24, 'Erich', 'Moore', 1, 31, 4, NULL),
(25, 'Axel', 'Klein', 1, 56, 1, NULL),
(26, 'Lester', 'Chandler', 1, 96, 0, NULL),
(27, 'Oscar', 'Casey', 1, 82, 1, NULL),
(28, 'Hammett', 'Vaughn', 1, 39, 4, NULL),
(29, 'Felix', 'Joyce', 1, 60, 5, NULL),
(30, 'Davis', 'Wilcox', 0, 47, 4, NULL),
(31, 'Oscar', 'Guzman', 0, 99, 3, NULL),
(32, 'Levi', 'Delaney', 0, 66, 6, NULL),
(33, 'Hyatt', 'Cooke', 1, 49, 6, NULL),
(34, 'Yoshio', 'Weiss', 0, 61, 1, NULL),
(35, 'Raymond', 'Brock', 0, 81, 6, NULL),
(36, 'Samson', 'Mathis', 0, 11, 3, NULL),
(37, 'Philip', 'Mosley', 0, 19, 2, NULL),
(38, 'Hedley', 'Calderon', 0, 64, 4, NULL),
(39, 'Bernard', 'Wright', 1, 64, 2, NULL),
(40, 'Grant', 'Ball', 0, 71, 1, NULL),
(41, 'Knox', 'Stanley', 0, 55, 5, NULL),
(42, 'Garth', 'Marquez', 1, 35, 1, NULL),
(43, 'Jared', 'Dillard', 1, 10, 2, NULL),
(44, 'Shad', 'Whitfield', 1, 33, 5, NULL),
(45, 'Reece', 'Henderson', 0, 15, 2, NULL),
(46, 'Baker', 'Randolph', 1, 53, 2, NULL),
(47, 'Lance', 'Haney', 1, 40, 1, NULL),
(48, 'Dane', 'Munoz', 1, 39, 4, NULL),
(49, 'Gary', 'Cote', 0, 16, 5, NULL),
(50, 'Blaze', 'Lester', 1, 90, 1, NULL),
(51, 'Murphy', 'Morrow', 0, 32, 3, NULL),
(52, 'Sean', 'Park', 1, 56, 5, NULL),
(53, 'Kato', 'Valdez', 1, 12, 6, NULL),
(54, 'Theodore', 'Buck', 0, 27, 5, NULL),
(55, 'Trevor', 'Gilmore', 0, 36, 4, NULL),
(56, 'Herman', 'Mcmillan', 0, 90, 6, NULL),
(57, 'Cain', 'Brooks', 1, 76, 1, NULL),
(58, 'Griffin', 'Knapp', 0, 26, 5, NULL),
(59, 'Brennan', 'Wolfe', 1, 90, 4, NULL),
(60, 'Bernard', 'Ford', 0, 41, 5, NULL),
(61, 'Otto', 'Mckinney', 0, 23, 3, NULL),
(62, 'Wesley', 'Thomas', 0, 64, 3, NULL),
(63, 'Brock', 'Travis', 1, 35, 1, NULL),
(64, 'Adrian', 'Martin', 1, 84, 2, NULL),
(65, 'Judah', 'Hutchinson', 1, 103, 5, NULL),
(66, 'Edward', 'Dalton', 0, 92, 3, NULL),
(67, 'Josiah', 'Hawkins', 1, 75, 5, NULL),
(68, 'Jarrod', 'Guerrero', 0, 77, 5, NULL),
(69, 'Branden', 'Rice', 0, 79, 1, NULL),
(70, 'Orson', 'Sykes', 1, 31, 2, NULL),
(71, 'Hedley', 'Mosley', 0, 29, 6, NULL),
(72, 'Jarrod', 'England', 1, 87, 1, NULL),
(73, 'Bruce', 'Brock', 1, 25, 0, NULL),
(74, 'Uriah', 'Burt', 1, 77, 3, NULL),
(75, 'Thaddeus', 'Campos', 1, 20, 6, NULL),
(76, 'Bert', 'Downs', 1, 84, 1, NULL),
(77, 'John', 'Rogers', 0, 70, 4, NULL),
(78, 'Uriel', 'Bowman', 1, 49, 2, NULL),
(79, 'Vladimir', 'Lowery', 1, 25, 6, NULL),
(80, 'Eagan', 'Farley', 1, 35, 1, NULL),
(81, 'Guy', 'Barrera', 1, 65, 5, NULL),
(82, 'Vance', 'Boyd', 1, 76, 3, NULL),
(83, 'Malachi', 'Crosby', 1, 10, 1, NULL),
(84, 'Blake', 'Ewing', 0, 79, 1, NULL),
(85, 'Uriah', 'Hendricks', 1, 42, 6, NULL),
(86, 'Abraham', 'Odom', 0, 59, 0, NULL),
(87, 'Nathaniel', 'Cruz', 1, 17, 3, NULL),
(88, 'Herrod', 'Hubbard', 0, 67, 6, NULL),
(89, 'Jelani', 'Daniels', 0, 91, 1, NULL),
(90, 'Zane', 'Ewing', 0, 98, 2, NULL),
(91, 'Barry', 'Rasmussen', 1, 20, 4, NULL),
(92, 'Omar', 'Roy', 0, 101, 6, NULL),
(93, 'Paul', 'Yang', 0, 67, 2, NULL),
(94, 'Lev', 'Vance', 1, 56, 6, NULL),
(95, 'Driscoll', 'Gallegos', 1, 36, 1, NULL),
(96, 'Colorado', 'Weiss', 1, 63, 0, NULL),
(97, 'Trevor', 'Gaines', 0, 15, 1, NULL),
(98, 'Kadeem', 'Parker', 1, 45, 3, NULL),
(99, 'Brendan', 'Stokes', 1, 88, 2, NULL),
(100, 'Deacon', 'Britt', 1, 49, 5, NULL);

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `country`
--
ALTER TABLE `country`
  ADD PRIMARY KEY (`country_id`),
  ADD KEY `country_id` (`country_id`);

--
-- Indizes für die Tabelle `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`id`),
  ADD KEY `country_id` (`country_id`),
  ADD KEY `id` (`id`);

--
-- Constraints der exportierten Tabellen
--

--
-- Constraints der Tabelle `member`
--
ALTER TABLE `member`
  ADD CONSTRAINT `member_ibfk_1` FOREIGN KEY (`country_id`) REFERENCES `country` (`country_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
