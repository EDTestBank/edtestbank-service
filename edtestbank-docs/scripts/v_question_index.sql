-- --------------------------------------------------------
-- Host:                         158.69.254.99
-- Server version:               10.5.8-MariaDB - MariaDB Server
-- Server OS:                    Linux
-- HeidiSQL Version:             11.1.0.6116
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for edtestbank
CREATE DATABASE IF NOT EXISTS `edtestbank` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_bin */;
USE `edtestbank`;

-- Dumping structure for view edtestbank.QUESTION_INDEX
-- Creating temporary table to overcome VIEW dependency errors
CREATE TABLE `QUESTION_INDEX` (
                                  `id` BIGINT(20) NOT NULL,
                                  `uuid` VARCHAR(64) NOT NULL COLLATE 'utf8mb4_general_ci',
                                  `date_created` DATETIME NOT NULL,
                                  `date_modified` DATETIME NOT NULL
) ENGINE=MyISAM;

-- Dumping structure for view edtestbank.QUESTION_INDEX
-- Removing temporary table and create final VIEW structure
DROP TABLE IF EXISTS `QUESTION_INDEX`;
CREATE ALGORITHM=UNDEFINED SQL SECURITY DEFINER VIEW `QUESTION_INDEX` AS select `t`.`id` AS `id`,`t`.`uuid` AS `uuid`,`t`.`date_created` AS `date_created`,`t`.`date_modified` AS `date_modified` from `QUESTION` `t`;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
