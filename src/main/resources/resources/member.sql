-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Erstellungszeit: 07. Nov 2017 um 18:05
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
-- Tabellenstruktur für Tabelle `member`
--

CREATE TABLE `member` (
  `id` int(8) UNSIGNED NOT NULL,
  `name` varchar(255) NOT NULL,
  `nachname` varchar(255) NOT NULL,
  `gender` int(11) NOT NULL,
  `age` int(11) NOT NULL,
  `bemerkung` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `member`
--

INSERT INTO `member` (`id`, `name`, `nachname`, `gender`, `age`, `bemerkung`) VALUES
(1, 'Xanthus', 'Hedley Webster', 0, 54, ''),
(2, 'Lee', 'Cruz Dennis', 0, 33, ''),
(3, 'Samuel', 'Yuli Knox', 1, 24, ''),
(4, 'August', 'Kaseem Shepard', 1, 26, ''),
(5, 'Graiden', 'Dolan Casey', 0, 84, ''),
(6, 'Kieran', 'Tyler Fleming', 1, 49, ''),
(7, 'Garrison', 'Grady Allen', 0, 20, ''),
(8, 'Kennan', 'Wesley Rojas', 1, 55, ''),
(9, 'Evan', 'Raja Hahn', 0, 51, ''),
(10, 'Nero', 'Lyle Bowen', 1, 52, ''),
(11, 'Connor', 'Logan Cunningham', 1, 18, ''),
(12, 'Finn', 'Rigel Brady', 0, 21, ''),
(13, 'Alfonso', 'Clark Garrett', 1, 67, ''),
(14, 'Nicholas', 'Joshua Walters', 1, 53, ''),
(15, 'Henry', 'Aidan Walsh', 1, 86, ''),
(16, 'Eaton', 'Devin Pickett', 0, 60, ''),
(17, 'Emery', 'Kevin Mcdowell', 1, 26, ''),
(18, 'Hoyt', 'Berk Sparks', 1, 84, ''),
(19, 'Chase', 'Kaseem Avery', 1, 58, ''),
(20, 'Dylan', 'Peter Mercer', 0, 34, ''),
(21, 'Calvin', 'Branden Maddox', 0, 40, ''),
(22, 'Theodore', 'Uriah Nunez', 1, 18, ''),
(23, 'Tanner', 'Logan Taylor', 0, 84, ''),
(24, 'Kibo', 'Dennis Mcdonald', 0, 75, ''),
(25, 'Jermaine', 'Cain Schroeder', 1, 31, ''),
(26, 'Jerry', 'Raja Phelps', 1, 86, ''),
(27, 'Brenden', 'Clayton Baker', 1, 23, ''),
(28, 'Hyatt', 'Dennis Santos', 1, 60, ''),
(29, 'Magee', 'Troy Cabrera', 1, 57, ''),
(30, 'Ryan', 'Damian Morse', 0, 71, ''),
(31, 'Jeremy', 'Ulric Reese', 0, 20, ''),
(32, 'Caesar', 'Hiram Patel', 1, 65, ''),
(33, 'Joshua', 'Ferdinand Mcdowell', 0, 72, ''),
(34, 'Preston', 'Hayden Wooten', 1, 31, ''),
(35, 'Kermit', 'Gabriel Bolton', 0, 52, ''),
(36, 'Linus', 'Patrick Glover', 0, 27, ''),
(37, 'Caleb', 'Amos Foreman', 0, 36, ''),
(38, 'Dennis', 'Phelan Garza', 1, 22, ''),
(39, 'Perry', 'Emmanuel Bell', 0, 44, ''),
(40, 'Coby', 'Camden Lambert', 1, 48, ''),
(41, 'Knox', 'Carl Orr', 0, 20, ''),
(42, 'Quamar', 'Rigel Lucas', 0, 25, ''),
(43, 'Valentine', 'Allistair Guy', 0, 51, ''),
(44, 'Bernard', 'Forrest Marsh', 1, 52, ''),
(45, 'Aristotle', 'Jonah Mcknight', 1, 71, ''),
(46, 'Keane', 'Cyrus Barron', 0, 58, ''),
(47, 'Beau', 'Kieran Duran', 1, 28, ''),
(48, 'Barry', 'Edward Mckee', 0, 70, ''),
(49, 'Barclay', 'Ralph Stanton', 1, 67, ''),
(50, 'Lucian', 'Yasir Whitfield', 1, 75, ''),
(51, 'Armand', 'Kyle Brock', 1, 79, ''),
(52, 'Samson', 'Mark Jordan', 0, 49, ''),
(53, 'Tanek', 'Jin Hunter', 1, 49, ''),
(54, 'Griffin', 'Gray Buckley', 0, 53, ''),
(55, 'Abraham', 'Ray Bonner', 1, 34, ''),
(56, 'Damian', 'Arthur West', 1, 51, ''),
(57, 'Fritz', 'Ciaran Pace', 1, 77, ''),
(58, 'Nehru', 'Armando Christensen', 0, 56, ''),
(59, 'Cameron', 'Moses Kidd', 1, 62, ''),
(60, 'Gil', 'Rudyard Gordon', 1, 79, ''),
(61, 'Blake', 'Bevis Roy', 1, 29, ''),
(62, 'Clark', 'Noble Gonzalez', 0, 25, ''),
(63, 'Kibo', 'Merritt Hodges', 0, 18, ''),
(64, 'Chandler', 'Kermit Langley', 1, 69, ''),
(65, 'Warren', 'Dennis Cooper', 0, 55, ''),
(66, 'Maxwell', 'Victor Carter', 1, 41, ''),
(67, 'Abraham', 'Lewis Meadows', 0, 46, ''),
(68, 'Gary', 'Kenyon Horton', 1, 19, ''),
(69, 'Bernard', 'Caldwell Boyd', 0, 17, ''),
(70, 'Cadman', 'Arsenio Cole', 1, 51, ''),
(71, 'Abbot', 'Giacomo Diaz', 0, 39, ''),
(72, 'Jerome', 'Stone Johnston', 1, 52, ''),
(73, 'Shad', 'Dennis Webb', 1, 51, ''),
(74, 'Zane', 'Neil Ayers', 0, 28, ''),
(75, 'Raja', 'Ezra Workman', 1, 30, ''),
(76, 'Travis', 'Price Graves', 1, 63, ''),
(77, 'Jackson', 'Edward Ochoa', 1, 56, ''),
(78, 'Simon', 'Aladdin Anderson', 1, 59, ''),
(79, 'Fuller', 'Harlan Delacruz', 0, 28, ''),
(80, 'Lewis', 'Tiger Williamson', 0, 50, ''),
(81, 'Grady', 'Nolan Joyner', 0, 82, ''),
(82, 'Dennis', 'Bert Valentine', 1, 52, ''),
(83, 'Raja', 'Jasper Clarke', 0, 77, ''),
(84, 'Tanek', 'Stuart Terrell', 1, 24, ''),
(85, 'Brady', 'Troy Olson', 0, 49, ''),
(86, 'Addison', 'Gary Workman', 1, 18, ''),
(87, 'Grant', 'Blaze Butler', 0, 17, ''),
(88, 'Noble', 'Walter Conrad', 1, 19, ''),
(89, 'Jordan', 'Norman Gay', 0, 86, ''),
(90, 'Coby', 'Alfonso Harmon', 1, 30, ''),
(91, 'Eric', 'Barrett Pate', 1, 61, ''),
(92, 'Luke', 'Ciaran Barrera', 0, 73, ''),
(93, 'Brent', 'Daquan Stokes', 1, 43, ''),
(94, 'Richard', 'Addison Higgins', 1, 48, ''),
(95, 'Troy', 'Judah Diaz', 0, 77, ''),
(96, 'Anthony', 'Garrison Dejesus', 0, 51, ''),
(97, 'Brandon', 'Nissim Hurst', 1, 42, ''),
(98, 'Basil', 'Fritz Prince', 1, 69, ''),
(99, 'Martin', 'Richard Hartman', 1, 77, ''),
(100, 'Ian', 'Daniel Santiago', 1, 59, '');

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `member`
--
ALTER TABLE `member`
  MODIFY `id` int(8) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=101;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
