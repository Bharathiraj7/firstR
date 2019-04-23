-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 22, 2019 at 03:32 PM
-- Server version: 5.5.8
-- PHP Version: 5.3.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `spring_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `collection`
--

CREATE TABLE IF NOT EXISTS `collection` (
  `coll_id` int(11) NOT NULL AUTO_INCREMENT,
  `coll_sharCode` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`coll_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `collection`
--

INSERT INTO `collection` (`coll_id`, `coll_sharCode`) VALUES
(3, 'Emp001');

-- --------------------------------------------------------

--
-- Table structure for table `country`
--

CREATE TABLE IF NOT EXISTS `country` (
  `country_id` int(11) NOT NULL AUTO_INCREMENT,
  `country_name` varchar(50) NOT NULL,
  `country_status` char(1) NOT NULL,
  PRIMARY KEY (`country_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=32 ;

--
-- Dumping data for table `country`
--

INSERT INTO `country` (`country_id`, `country_name`, `country_status`) VALUES
(10, 'India', 'Y'),
(11, 'Pakistan', 'Y'),
(12, 'Japan', 'Y'),
(13, 'Sri Lanka', 'Y'),
(14, 'United States Of America', 'Y'),
(15, 'Canada', 'Y'),
(16, 'Bangaladesh', 'Y'),
(17, 'Singapor', 'Y'),
(18, 'Malaysia', 'Y'),
(19, 'Bhutan', 'Y'),
(20, 'Nepal', 'Y'),
(21, 'South America', 'Y'),
(22, 'United Kingdom', 'Y'),
(23, 'France', 'Y'),
(24, 'German', 'Y'),
(25, 'German', 'Y'),
(26, 'Greence Land', 'Y'),
(27, 'China', 'Y'),
(28, 'South Africa', 'Y'),
(29, 'Newzeland', 'Y'),
(30, 'Nanthini', 'Y'),
(31, 'Andra_Vijaykumar', 'Y');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE IF NOT EXISTS `employee` (
  `emp_id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_name` varchar(50) NOT NULL,
  `emp_fname` varchar(50) NOT NULL,
  `emp_dob` date NOT NULL,
  `emp_desig` varchar(50) NOT NULL,
  `emp_adddesig` varchar(50) NOT NULL,
  `emp_email` varchar(50) NOT NULL,
  `emp_contact` varchar(15) NOT NULL,
  `emp_photo` varchar(50) DEFAULT NULL,
  `emp_status` char(1) NOT NULL,
  PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=45 ;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`emp_id`, `emp_name`, `emp_fname`, `emp_dob`, `emp_desig`, `emp_adddesig`, `emp_email`, `emp_contact`, `emp_photo`, `emp_status`) VALUES
(2, 'Saravanan', 'Jayaraman', '1977-04-13', 'PHP Developer', 'Software Graphics Designer', 'saranitmail@gmail.com', '9994841837', 'laxmimennan.jpg', 'Y'),
(3, 'Yuvraj', 'Kulasekaran', '1982-05-20', 'PHP Developer', 'Senior Developer', 'yuvraj@gmail.com', '9998822355', 'skiappsattai.jpg', 'Y'),
(4, 'R.Sumathi', 'Shanmugam', '1978-07-21', 'Accountant', 'Senior Accountant', 'sumathi@gmail.com', '9092177334', 'sara6.jpg', 'Y'),
(6, 'Velmurugan', 'sundar', '1987-09-22', 'Accountant', 'Senior Account', 'vel2@rediffmail.com', '1122338877', 'sara4.jpg', 'Y'),
(7, 'Dhanalaxmi', 'Vijaya Kumar', '1992-03-23', 'Programmer', 'Fresher', 'dhan@gmail.com', '9988332277', 'saree_girl.jpg', 'Y'),
(8, 'Laxmi Devi', 'Muruga Kumar reddy', '1993-04-04', 'Developer', 'TL', 'laxmidevi@gmail.com', '9922334412', 'sridivya.jpg', 'Y'),
(10, 'Kannan', 'Siva Rama Krishnan', '1995-02-01', 'Software engineer', 'Team Leader', 'sivaram@gmail.com', '3322114455', 'image_83e83.jpg', 'Y'),
(12, 'James Pralal', 'Kurshii', '1987-09-23', 'Accountant', 'Semior Accountat', 'james@gmail.com', '3344221155', 'sara2.jpg', 'Y'),
(13, 'Sukumar', 'Nanthitha', '1988-02-23', 'Professor', 'Dean', 'nasuku@gmail.com', '9988334477', 'Bindu_de4ec.png', 'Y'),
(14, 'Sumathi', 'Narayanan', '1988-09-09', 'Telecom Cashier', 'Semor Officer', 'sumathi@gmail.com', '9922334455', 'sree2_0d281.jpg', 'Y'),
(15, 'Malar', 'Saravanan', '1988-03-21', 'Accountant', 'Semior Accountant', 'malar@telecome.com', '3388554433', 'sree.jpg', 'Y'),
(16, 'Mukillan', 'Manthangopal', '1998-08-23', 'Driver', 'Driver', 'mukillan@gamil.com', '2211334455', 'sara3.jpg', 'Y'),
(17, 'Kuruvi', 'kumal', '1977-01-13', 'Software', 'Developer', 'kurivi@gmail.com', '9988323455', 'glass_girl.jpg', 'Y'),
(18, 'Hellowstepen', 'Vincent', '1998-04-02', 'Programmer', 'Semior', 'vinc@gmail.com', '2299887766', 'sara1.jpg', 'Y'),
(19, 'Kulasemaran', 'Malarmathivanan', '1987-02-23', 'Developer', 'Testing team', 'kula@gmail.com', '8636523459', 'messai.jpg', 'Y'),
(20, 'Kulasemaran', 'Malarmathivanan', '1987-02-23', 'Developer', 'Testing team', 'kula@gmail.com', '8636523459', 'karuupppu.jpg', 'Y'),
(21, 'Gun', 'Test', '1988-09-23', 'Test', 'Test', 'test@gmail.com', '2139806543', 'twitter.png', 'Y'),
(22, 'Rani', 'Sulochan', '1973-10-02', 'Shop owner', 'Shop business', 'rani@gmail.com', '9988223344', 'blue_girl.jpg', 'Y'),
(23, 'Rani', 'Sulochan', '1973-10-02', 'Shop owner', 'Shop business', 'rani@gmail.com', '9988223344', 'blue_girl2.jpg', 'Y'),
(24, 'Sekar', 'Muniswamy', '1987-09-22', 'Software DEveloper', 'Testing', 'sekar@gmail.com', '9988776655', 'raja.jpg', 'Y'),
(25, 'Sekar', 'Muniswamy', '1987-09-22', 'Software DEveloper', 'Testing', 'sekar@gmail.com', '9988776655', 'raja.jpg', 'Y'),
(26, 'Kumaran', 'Madhavan', '1987-09-21', 'Developer', 'SEnior Developer', 'kumaran@gmail.com', '99886655443', 'subha_298e6.png', 'Y'),
(27, 'Kumaran', 'Madhavan', '1987-09-21', 'Developer', 'SEnior Developer', 'kumaran@gmail.com', '99886655443', 'glass_girl.jpg', 'N'),
(28, 'Vijaylaxmi', 'Gunasekaran', '1992-05-02', 'Software Developer', 'Semior Developer', 'viji@gmail.com', '9992376543', 'devi.jpg', 'Y'),
(29, 'Vijaylaxmi', 'Gunasekaran', '1992-05-02', 'Software Developer', 'Semior Developer', 'viji@gmail.com', '9992376543', 'girl.jpg', 'Y'),
(30, 'Vijaylaxmi', 'Gunasekaran', '1992-05-02', 'Software Developer', 'Semior Developer', 'viji@gmail.com', '9992376543', 'girl3.jpg', 'Y'),
(31, 'Nanthini', 'Shanmugaraj', '1989-08-12', 'Designation', 'Additional Designation', 'design@gmail.com', '9988776655', 'nanthini.jpg', 'Y'),
(33, 'Muthulaxmi', 'Lingadurai', '1995-04-11', 'Software developer', 'Fresher', 'muthulaxmi@thinksynq.in', '9791278915', 'indu.jpg', 'Y'),
(34, 'Muthulaxmi', 'Lingadurai', '1995-04-11', 'Software developer', 'Fresher', 'muthulaxmi@thinksynq.in', '9791278915', 'indu.jpg', 'Y'),
(35, 'grfdg', 'xvfgfdh', '1998-09-09', 'vcxvcx', 'vcvc', 'bsf@hm.nj', '6565757', 'divya2.jpg', 'Y'),
(36, 'Kumaran', 'Pillival', '1988-08-23', 'dEveloper', 'Fresher', 'kumaran@gmail.com', '2211776655', 'dhak.jpg', 'Y'),
(37, 'Kumaran', 'Pillival', '1988-08-23', 'dEveloper', 'Fresher', 'kumaran@gmail.com', '2211776655', 'dhak.jpg', 'Y'),
(38, 'S.Nanthini', 'Shanmugarajan', '1987-03-03', 'Software Developer', 'Java programmer', 'nanthini@thinksynq.in', '8877665544', 'manju.jpg', 'Y'),
(39, 'Testing', 'fjdsff', '1987-03-02', 'Designation', 'additonal designation', 'test@gmail.com', '11223344556', 'sridivya.jpg', 'Y'),
(40, 'sdfds', 'sdfdsf', '1988-09-23', 'dfds', 'sdsf', 'sdf@gmail.com', '22223333333', 'sridivya.jpg', 'Y'),
(41, 'Rajan', 'Kumaresan', '1987-09-23', 'Tester', 'Senior Tester', 'test@gmal.com', '2233445566', 'sivakumar.jpg', 'Y'),
(42, 'fdf', 'gdfg', '1998-08-08', 'bvb', 'bvb', 'bv@gmail.com', '5475354646', 'sivakumar.jpg', 'Y'),
(43, 'fdf', 'gdfg', '1998-08-08', 'bvb', 'bvb', 'bv@gmail.com', '5475354646', 'sivakumar.jpg', 'Y'),
(44, 'Laxmi Menan', 'Menan Narayanan', '1995-08-08', 'Actrees', 'Actress', 'laxmi@gmail.com', '1100996754', 'laxm1.jpg', 'Y');

-- --------------------------------------------------------

--
-- Table structure for table `excel_data`
--

CREATE TABLE IF NOT EXISTS `excel_data` (
  `excelDat_id` int(11) NOT NULL AUTO_INCREMENT,
  `excelDat_code` varchar(50) NOT NULL,
  `excelDat_date` date NOT NULL,
  `excelDat_amount` decimal(6,2) NOT NULL,
  `excelDat_status` char(1) NOT NULL,
  PRIMARY KEY (`excelDat_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Dumping data for table `excel_data`
--


-- --------------------------------------------------------

--
-- Table structure for table `member_info`
--

CREATE TABLE IF NOT EXISTS `member_info` (
  `memInfo_id` int(11) NOT NULL AUTO_INCREMENT,
  `memInfo_fname` varchar(50) NOT NULL,
  `memInfo_fathname` varchar(50) NOT NULL,
  `memInfo_age` int(11) NOT NULL,
  `memInfo_occup` varchar(50) NOT NULL,
  `memInfo_contno` varchar(15) NOT NULL,
  `memInfo_status` char(1) NOT NULL,
  PRIMARY KEY (`memInfo_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=22 ;

--
-- Dumping data for table `member_info`
--

INSERT INTO `member_info` (`memInfo_id`, `memInfo_fname`, `memInfo_fathname`, `memInfo_age`, `memInfo_occup`, `memInfo_contno`, `memInfo_status`) VALUES
(5, 'Kumar', 'Vijarajan', 37, 'Software Engineer', '999837652', 'Y'),
(7, 'Balaji', 'Dhakshana Moorthy', 27, 'Software Developer', '445522339988', 'Y'),
(9, 'Arizhvazhagan', 'Arasan', 45, 'Hair Cutter', '88776655443', 'Y'),
(19, 'Muthukumaran', 'Raja', 24, 'Govt Employee', '2233445566', 'Y'),
(21, 'James Patrick', 'Thomas', 22, 'Business', '9988665533', 'Y');

-- --------------------------------------------------------

--
-- Table structure for table `place`
--

CREATE TABLE IF NOT EXISTS `place` (
  `place_id` int(11) NOT NULL AUTO_INCREMENT,
  `place_name` varchar(50) NOT NULL,
  `state_id` int(11) NOT NULL,
  `place_status` char(1) NOT NULL,
  PRIMARY KEY (`place_id`),
  KEY `state_id` (`state_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `place`
--

INSERT INTO `place` (`place_id`, `place_name`, `state_id`, `place_status`) VALUES
(1, 'Chennai', 1, 'Y'),
(2, 'Cuddalore', 1, 'Y'),
(3, 'Puducherry', 7, 'Y'),
(4, 'Karikal', 7, 'Y'),
(5, 'Mahe', 7, 'Y'),
(6, 'Yanem', 7, 'Y'),
(7, 'Lahoor', 6, 'Y'),
(8, 'Dupakkur', 9, 'Y');

-- --------------------------------------------------------

--
-- Table structure for table `states`
--

CREATE TABLE IF NOT EXISTS `states` (
  `state_id` int(11) NOT NULL AUTO_INCREMENT,
  `state_name` varchar(50) NOT NULL,
  `country_id` int(11) NOT NULL,
  `state_status` char(1) NOT NULL,
  PRIMARY KEY (`state_id`),
  KEY `country_id` (`country_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `states`
--

INSERT INTO `states` (`state_id`, `state_name`, `country_id`, `state_status`) VALUES
(1, 'Tamil Nadu', 10, 'Y'),
(2, 'Karnataka', 10, 'Y'),
(3, 'Kerala', 10, 'Y'),
(4, 'Andrapradesh', 10, 'Y'),
(5, 'Maharashtra', 10, 'Y'),
(6, 'Lagore Dst', 11, 'Y'),
(7, 'Pondicherry', 10, 'Y'),
(8, 'Himachal Pradesh', 10, 'Y'),
(9, 'Kurnool', 31, 'Y');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `place`
--
ALTER TABLE `place`
  ADD CONSTRAINT `place_ibfk_1` FOREIGN KEY (`state_id`) REFERENCES `states` (`state_id`);

--
-- Constraints for table `states`
--
ALTER TABLE `states`
  ADD CONSTRAINT `states_ibfk_1` FOREIGN KEY (`country_id`) REFERENCES `country` (`country_id`);
