-- MySQL Windows (x86, 32-bit), MSI Installer
--
-- Host: 127.0.0.1    Database: employeemanagementsystem
-- ------------------------------------------------------
-- Server version	8.0.35

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `FIRST_NAME` varchar(50) DEFAULT NULL,
  `LAST_NAME` varchar(50) DEFAULT NULL,
  `EMAIL` varchar(50) NOT NULL,
  `PHONE_NUMBER` varchar(50) NOT NULL,
  `DOJ` DATETIME(50) NOT NULL,
  `SALARY` DOUBLE NOT NULL,
  PRIMARY KEY (`ID`)
);

--
-- Inserting data for table `employee`
--

--We can insert through /api/employees
