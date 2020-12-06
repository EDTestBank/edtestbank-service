-- --------------------------------------------------------
-- Host:                         192.168.0.201
-- Server version:               10.3.22-MariaDB-0+deb10u1 - Raspbian 10
-- Server OS:                    debian-linux-gnueabihf
-- HeidiSQL Version:             11.1.0.6116
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for edtestbank
CREATE DATABASE IF NOT EXISTS `edtestbank` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `edtestbank`;

-- Dumping structure for table edtestbank.QIndex
CREATE TABLE IF NOT EXISTS `QIndex` (
                                        `id` bigint(20) NOT NULL AUTO_INCREMENT,
                                        `questions` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL DEFAULT '',
                                        `dateC` datetime NOT NULL,
                                        `dateM` datetime NOT NULL,
                                        `uuid` varchar(64) NOT NULL,
                                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8mb4;

-- Data exporting was unselected.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
