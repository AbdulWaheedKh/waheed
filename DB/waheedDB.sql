-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.11-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for waheed
CREATE DATABASE IF NOT EXISTS `waheed` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `waheed`;

-- Dumping structure for table waheed.employe
CREATE TABLE IF NOT EXISTS `employe` (
  `id` bigint(20) NOT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `salary` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table waheed.employe: 11 rows
/*!40000 ALTER TABLE `employe` DISABLE KEYS */;
INSERT INTO `employe` (`id`, `firstname`, `lastname`, `salary`) VALUES
	(13, '321', '123', 234),
	(18, 'mosa', 'khan', 789),
	(10, 'dfdr', 'dfd', 454),
	(11, 'dfgdg', 'dfgd', 5656),
	(12, 'fad', 'adsf', 312),
	(2, '687', '8977', 897),
	(1, '789n', 'hkjh', 7987),
	(14, '223', '123123', 13211),
	(15, '9th', '9th', 9311),
	(16, 'pakistan', 'Zindabad', 921111),
	(17, 'waheed ', 'khan', 3232);
/*!40000 ALTER TABLE `employe` ENABLE KEYS */;

-- Dumping structure for table waheed.hibernate_sequence
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- Dumping data for table waheed.hibernate_sequence: 1 rows
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` (`next_val`) VALUES
	(19);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;

-- Dumping structure for table waheed.institute
CREATE TABLE IF NOT EXISTS `institute` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ProfileId` int(11) NOT NULL,
  `InstituteName` varchar(50) NOT NULL,
  `InstituteCode` varchar(50) NOT NULL,
  `Address` varchar(100) NOT NULL,
  `CreatedDate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `ModifiedDate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`Id`),
  KEY `FK` (`ProfileId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table waheed.institute: ~0 rows (approximately)
/*!40000 ALTER TABLE `institute` DISABLE KEYS */;
/*!40000 ALTER TABLE `institute` ENABLE KEYS */;

-- Dumping structure for table waheed.profile
CREATE TABLE IF NOT EXISTS `profile` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(50) NOT NULL DEFAULT '0',
  `LastName` varchar(50) NOT NULL DEFAULT '0',
  `CreatedDate` timestamp NOT NULL DEFAULT current_timestamp(),
  `ModifiedDate` timestamp NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table waheed.profile: ~0 rows (approximately)
/*!40000 ALTER TABLE `profile` DISABLE KEYS */;
/*!40000 ALTER TABLE `profile` ENABLE KEYS */;

-- Dumping structure for table waheed.student
CREATE TABLE IF NOT EXISTS `student` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(50) DEFAULT NULL,
  `LastName` varchar(50) DEFAULT NULL,
  `RollNumber` varchar(50) DEFAULT NULL,
  `Deleted` bit(1) NOT NULL DEFAULT b'0',
  `CreatedDate` timestamp NOT NULL DEFAULT current_timestamp(),
  `ModifiedDate` timestamp NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Dumping data for table waheed.student: ~0 rows (approximately)
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` (`ID`, `FirstName`, `LastName`, `RollNumber`, `Deleted`, `CreatedDate`, `ModifiedDate`) VALUES
	(1, 'Muhammad', 'Waleed', '01', b'0', '2022-01-05 18:32:20', '2022-01-05 18:32:21');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
