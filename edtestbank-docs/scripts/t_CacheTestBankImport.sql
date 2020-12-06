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
DROP DATABASE IF EXISTS `edtestbank`;
CREATE DATABASE IF NOT EXISTS `edtestbank` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `edtestbank`;

-- Dumping structure for table edtestbank.CacheTestBankImport
DROP TABLE IF EXISTS `CacheTestBankImport`;
CREATE TABLE IF NOT EXISTS `CacheTestBankImport` (
    `id` bigint(20) NOT NULL AUTO_INCREMENT,
    `parentId` bigint(20) DEFAULT NULL,
    `description` varchar(1024) DEFAULT '',
    `title` varchar(1024) DEFAULT '',
    `questionA` varchar(1024) DEFAULT '',
    `questionB` varchar(1024) DEFAULT '',
    `questionC` varchar(1024) DEFAULT '',
    `questionD` varchar(1024) DEFAULT '',
    `questionE` varchar(1024) DEFAULT '',
    `questionF` varchar(1024) DEFAULT '',
    `answer` varchar(1024) DEFAULT '',
    `answerNote` varchar(1024) DEFAULT '',
    `csvFileName` varchar(256) NOT NULL,
    `dateC` datetime NOT NULL,
    `dateM` datetime NOT NULL,
    `uuid` varchar(64) NOT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=407 DEFAULT CHARSET=utf8mb4 COMMENT='Cache Import CSV file';

-- Data exporting was unselected.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
