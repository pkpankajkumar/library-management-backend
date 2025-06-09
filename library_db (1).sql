-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jun 09, 2025 at 03:23 AM
-- Server version: 8.0.31
-- PHP Version: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library_db`
--

-- --------------------------------------------------------

--
-- Stand-in structure for view `available_books_view`
-- (See below for the actual view)
--
DROP VIEW IF EXISTS `available_books_view`;
CREATE TABLE IF NOT EXISTS `available_books_view` (
`available_book_count` bigint
,`id` bigint
,`title` varchar(255)
,`author` varchar(255)
,`isbn` varchar(255)
,`published_year` int
);

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
CREATE TABLE IF NOT EXISTS `book` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `author` varchar(255) NOT NULL,
  `isbn` varchar(255) DEFAULT NULL,
  `published_year` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`id`, `title`, `author`, `isbn`, `published_year`) VALUES
(1, 'Test Book1', 'author1', NULL, 2022),
(2, 'Test Book3', 'author2', NULL, 2022),
(3, 'Test Book3', 'author3', NULL, 2025);

-- --------------------------------------------------------

--
-- Table structure for table `book_issue`
--

DROP TABLE IF EXISTS `book_issue`;
CREATE TABLE IF NOT EXISTS `book_issue` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `book_id` bigint NOT NULL,
  `issued_to` bigint NOT NULL,
  `from_date` date DEFAULT NULL,
  `to_date` date DEFAULT NULL,
  `issue_date` date DEFAULT NULL,
  `return_date` date DEFAULT NULL,
  `purpose` int DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `status` enum('Issued','Request','Returned','Rejected') DEFAULT NULL,
  `is_book_issued` enum('NO','YES') DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_issue_book` (`book_id`),
  KEY `fk_issue_user` (`issued_to`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `book_issue`
--

INSERT INTO `book_issue` (`id`, `book_id`, `issued_to`, `from_date`, `to_date`, `issue_date`, `return_date`, `purpose`, `title`, `author`, `status`, `is_book_issued`) VALUES
(1, 1, 1, '2025-06-07', '2025-06-07', '2025-06-07', '2025-06-08', 1, NULL, NULL, 'Returned', 'NO'),
(2, 2, 1, '2025-06-07', '2025-06-07', '2025-06-07', NULL, 5, NULL, NULL, 'Issued', 'YES');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `mobile_no` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `roll_no` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `name`, `password`, `email`, `mobile_no`, `role`, `roll_no`) VALUES
(1, 'Test user1', 'test@123', 'test1@lib.com', NULL, 'user', '1'),
(2, 'Test user2', 'test@123', 'test2@lib.com', NULL, 'user', '1'),
(3, 'Test user3', 'test@123', 'test3@lib.com', NULL, 'user', '1'),
(4, 'Test user4', 'test@123', 'test4@lib.com', '7676767676', 'user', '4'),
(5, 'admin', 'test@123', 'admin@lib.com', '', 'admin', '4');

-- --------------------------------------------------------

--
-- Structure for view `available_books_view`
--
DROP TABLE IF EXISTS `available_books_view`;

DROP VIEW IF EXISTS `available_books_view`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `available_books_view`  AS SELECT count(0) OVER () AS `available_book_count`, `b`.`id` AS `id`, `b`.`title` AS `title`, `b`.`author` AS `author`, `b`.`isbn` AS `isbn`, `b`.`published_year` AS `published_year` FROM (`book` `b` left join `book_issue` `bi` on(((`bi`.`book_id` = `b`.`id`) and (`bi`.`status` = 'Issued') and (`bi`.`is_book_issued` = 'YES')))) WHERE (`bi`.`id` is null)  ;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
