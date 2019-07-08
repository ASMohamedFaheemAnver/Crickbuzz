-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jul 08, 2019 at 06:31 AM
-- Server version: 10.3.16-MariaDB
-- PHP Version: 7.3.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `Crickbuzz`
--

-- --------------------------------------------------------

--
-- Table structure for table `MATCHBATTING`
--

CREATE TABLE `MATCHBATTING` (
  `MATCHID` int(11) NOT NULL,
  `NAME` varchar(50) NOT NULL,
  `RUN` int(11) NOT NULL,
  `BALL` int(11) NOT NULL,
  `FOUR` int(11) NOT NULL,
  `SIX` int(11) NOT NULL,
  `SR` float NOT NULL,
  `INNINGS` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `MATCHBATTING`
--

INSERT INTO `MATCHBATTING` (`MATCHID`, `NAME`, `RUN`, `BALL`, `FOUR`, `SIX`, `SR`, `INNINGS`) VALUES
(1, 'Zazai', 10, 24, 1, 0, 41.67, 'FIRST'),
(1, 'Naib', 27, 42, 2, 0, 64.29, 'FIRST'),
(1, 'Shah', 36, 63, 3, 0, 57.14, 'FIRST'),
(1, 'Shahidi', 21, 45, 2, 0, 46.67, 'FIRST'),
(1, 'Afghan', 8, 19, 0, 0, 42.11, 'FIRST'),
(1, 'Nabi', 52, 55, 4, 1, 94.55, 'FIRST'),
(1, 'Zadran', 21, 23, 2, 0, 91.3, 'FIRST'),
(1, 'Khan', 14, 16, 1, 0, 87.5, 'FIRST'),
(1, 'Ali Khil', 7, 10, 0, 0, 70, 'FIRST'),
(1, 'Alam', 0, 1, 0, 0, 0, 'FIRST'),
(1, 'Ur Rahman', 0, 1, 0, 0, 0, 'FIRST'),
(1, 'Rahul', 30, 53, 2, 0, 56.6, 'SECOND'),
(1, 'Sharma', 1, 10, 0, 0, 10, 'SECOND'),
(1, 'Kohli', 67, 63, 5, 0, 106.35, 'SECOND'),
(1, 'Shankar', 29, 41, 2, 0, 70.73, 'SECOND'),
(1, 'Dhoni', 28, 52, 3, 0, 53.85, 'SECOND'),
(1, 'Jadhav', 52, 68, 3, 1, 76.47, 'SECOND'),
(1, 'Pandya', 7, 9, 0, 0, 77.78, 'SECOND'),
(1, 'Shami', 1, 2, 0, 0, 50, 'SECOND'),
(1, 'Yadav', 1, 1, 0, 0, 100, 'SECOND'),
(1, 'Bumrah', 1, 1, 0, 0, 100, 'SECOND'),
(2, 'Karunaratne', 10, 17, 2, 0, 58.82, 'FIRST'),
(2, 'Perera', 18, 14, 3, 0, 128.57, 'FIRST'),
(2, 'Fernando', 20, 21, 4, 0, 95.24, 'FIRST'),
(2, 'Mendis', 3, 13, 0, 0, 23.08, 'FIRST'),
(2, 'Mathews', 113, 128, 10, 2, 88.28, 'FIRST'),
(2, 'Thirimanne', 53, 68, 4, 0, 77.94, 'FIRST'),
(2, 'Silva', 29, 36, 1, 0, 80.56, 'FIRST'),
(2, 'Udana', 1, 1, 0, 0, 100, 'FIRST'),
(2, 'Rahul', 111, 118, 11, 1, 94.07, 'SECOND'),
(2, 'Sharma', 103, 94, 14, 2, 109.57, 'SECOND'),
(2, 'Kohli', 34, 41, 3, 0, 82.93, 'SECOND'),
(2, 'Pant', 4, 4, 1, 0, 100, 'SECOND'),
(2, 'Pandya', 7, 4, 1, 0, 175, 'SECOND');

-- --------------------------------------------------------

--
-- Table structure for table `MATCHBOWLING`
--

CREATE TABLE `MATCHBOWLING` (
  `MATCHID` int(11) NOT NULL,
  `NAME` varchar(50) NOT NULL,
  `MOVER` double NOT NULL,
  `MAIDEN` int(11) NOT NULL,
  `RUN` int(11) NOT NULL,
  `WICKET` int(11) NOT NULL,
  `ECON` float NOT NULL,
  `INNINGS` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `MATCHBOWLING`
--

INSERT INTO `MATCHBOWLING` (`MATCHID`, `NAME`, `MOVER`, `MAIDEN`, `RUN`, `WICKET`, `ECON`, `INNINGS`) VALUES
(1, 'Shami', 9.5, 1, 40, 4, 4.07, 'FIRST'),
(1, 'Bumrah', 10, 1, 39, 2, 3.9, 'FIRST'),
(1, 'Chahal', 10, 0, 36, 2, 3.36, 'FIRST'),
(1, 'Pandya', 10, 1, 36, 2, 5.1, 'FIRST'),
(1, 'Yadav', 10, 0, 39, 0, 3.9, 'FIRST'),
(1, 'Ur Rahman', 10, 0, 26, 1, 2.6, 'SECOND'),
(1, 'Alam', 7, 1, 54, 1, 7.71, 'SECOND'),
(1, 'Naib', 9, 0, 51, 2, 5.67, 'SECOND'),
(1, 'Nabi', 9, 0, 33, 2, 3.67, 'SECOND'),
(1, 'Khan', 10, 0, 38, 1, 3.8, 'SECOND'),
(1, 'Shah', 5, 0, 22, 1, 4.4, 'SECOND'),
(2, 'Kumar', 10, 0, 73, 1, 7.3, 'FIRST'),
(2, 'Bumrah', 10, 2, 37, 3, 3.7, 'FIRST'),
(2, 'Pandya', 10, 0, 50, 1, 5, 'FIRST'),
(2, 'Jadeja', 10, 0, 40, 1, 4, 'FIRST'),
(2, 'Yadav', 10, 0, 58, 1, 5.8, 'FIRST'),
(2, 'Malinga', 10, 1, 82, 1, 8.2, 'SECOND'),
(2, 'Rajitha', 8, 0, 47, 1, 5.88, 'SECOND'),
(2, 'Udana', 9.3, 0, 50, 1, 5.26, 'SECOND'),
(2, 'Perera', 10, 0, 34, 0, 3.4, 'SECOND'),
(2, 'Silva', 6, 0, 51, 0, 8.5, 'SECOND');

-- --------------------------------------------------------

--
-- Table structure for table `MATCHOVERVIEW`
--

CREATE TABLE `MATCHOVERVIEW` (
  `MATCHID` int(11) NOT NULL,
  `TEAM` varchar(100) NOT NULL,
  `OVERVIEW` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `MATCHOVERVIEW`
--

INSERT INTO `MATCHOVERVIEW` (`MATCHID`, `TEAM`, `OVERVIEW`) VALUES
(1, 'INDIA     VS     AFGHANISTAN', '* India win thriller by 11 runs, <br><br>\r\n\r\n* Kohli (67), Jadhav (52) hit fifties but Afghan spinners restrict India to 224/8, <br><br>\r\n* Bumrah takes two wickets in an over after partnership between Rahmat (36) and Hashmatullah (21), <br><br>\r\n* Mohammad Nabi (52) is dismissed as part of Shami hattrick in final over.'),
(2, 'SRILANKA VS INDIA', '* India 265 for 3 (Rahul 111, Rohit 103) beat Sri Lanka 264 for 7 (Mathews 113, Thirimanne 53, Bumrah 3-37) by seven wickets.');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `MATCHOVERVIEW`
--
ALTER TABLE `MATCHOVERVIEW`
  ADD PRIMARY KEY (`MATCHID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `MATCHOVERVIEW`
--
ALTER TABLE `MATCHOVERVIEW`
  MODIFY `MATCHID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
