-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 29, 2019 at 07:56 AM
-- Server version: 10.1.29-MariaDB
-- PHP Version: 7.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `feedb`
--

-- --------------------------------------------------------

--
-- Table structure for table `feereport_accountant`
--

CREATE TABLE `feereport_accountant` (
  `id` int(11) NOT NULL,
  `name` varchar(40) NOT NULL,
  `password` varchar(20) NOT NULL,
  `email` varchar(50) NOT NULL,
  `contactno` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `feereport_accountant`
--

INSERT INTO `feereport_accountant` (`id`, `name`, `password`, `email`, `contactno`) VALUES
(1, 'gaurav', 'g123', 'gaurav123@gmail.com', '9057335779'),
(2, 'govyanshi', 'go123', 'govyanshi1201@gmail.com', '9983577291'),
(3, 'himalaya', 'him123', 'him989@gmail.com', '9999233441'),
(4, 'mansi', 'ma123', 'mansi54@gmail.com', '8794437890'),
(5, 'ankit', 'ank123', 'ankit0567@gmail.com', '8790342678'),
(6, 'a1', 'p1', 'abc', '123456788'),
(7, 'accountant2', 'pwd2', 'acc12@gmail.com', '9987645672'),
(8, 'Paridhi', 'password', 'pa789@gmail.com', '983299509'),
(9, 'Aayushi', 'a123', 'aa@gmail.com', '8746899120');

-- --------------------------------------------------------

--
-- Table structure for table `feereport_student`
--

CREATE TABLE `feereport_student` (
  `rollno` int(10) NOT NULL,
  `name` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `course` varchar(100) NOT NULL,
  `fee` int(10) NOT NULL,
  `paid` int(10) NOT NULL,
  `due` int(10) NOT NULL,
  `address` varchar(300) NOT NULL,
  `city` varchar(200) NOT NULL,
  `state` varchar(200) NOT NULL,
  `country` varchar(100) NOT NULL,
  `contactno` varchar(20) NOT NULL,
  `registereddate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `feereport_student`
--

INSERT INTO `feereport_student` (`rollno`, `name`, `email`, `course`, `fee`, `paid`, `due`, `address`, `city`, `state`, `country`, `contactno`, `registereddate`) VALUES
(1, 'ram', 'ram12@gmai.com', 'java', 8000, 6000, 2000, 'D-23, Sec-18, Noida', 'Noida', 'UP', 'India', '9856747640', '2019-02-23 11:47:54'),
(2, 'meeta', 'meetasharma987@gmail.com', 'android', 10000, 8000, 2000, 'malviyanagar,110,Jaipur', 'Jaipur', 'Rajasthan', 'India', '8567475409', '2019-05-26 14:07:01'),
(3, 'prateek', 'prateek@190', 'Java', 8000, 8000, 0, 'house no-112,pari chowk,greater noida', 'Greater Noida', 'UP', 'India', '9087035799', '2019-03-06 18:30:00'),
(4, 'karishma', 'kari543@gmail.com', 'Android', 10000, 6000, 4000, 'sector-45,Noida', 'Noida', 'UP', 'India', '8756003467', '2019-02-23 12:05:04'),
(5, 'itisha', 'ishu123@gmail.com', 'b.com', 40000, 20000, 20000, 'jaipur', 'jaipur', 'rajasthan', 'india', '883929915', '2019-05-26 17:06:48'),
(6, 's1', 's1@gmail.com', 'B.tech', 100000, 100000, 65000, 'MalviyaNagar', 'Jaipur', 'Rajasthan', 'India', '784923002', '2019-05-26 05:40:44'),
(7, 's1', 's1@gmail.com', 'B.tech', 1000000, 70000, 30000, 'Malviya Nagar', 'Jaipur', 'Rajasthan', 'India', '723455555', '2019-05-26 05:42:37'),
(8, 'a', 'aaaaaaaaaaaaaaa', 'das', 144141242, 2334, 4, '32', 'ggg', 'wqad', 'dsds', 'sssssssssss', '2019-05-26 06:37:58'),
(9, 's', 'ss', 'qq', 132311, 2223, 123, 'jllhhhh', 'hhshj', 'ddddddddddddddd', 'dddddddddd', '1222222222222', '2019-05-26 17:08:07');

-- --------------------------------------------------------

--
-- Table structure for table `fee_log`
--

CREATE TABLE `fee_log` (
  `accountant_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `fee` int(11) NOT NULL,
  `due` int(11) NOT NULL,
  `paid` int(11) NOT NULL,
  `due_after_pay` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(200) NOT NULL,
  `password` varchar(100) NOT NULL,
  `email` varchar(200) NOT NULL,
  `mobile_number` char(10) NOT NULL,
  `address` varchar(500) NOT NULL,
  `user_type` varchar(10) NOT NULL,
  `registered_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `name`, `password`, `email`, `mobile_number`, `address`, `user_type`, `registered_date`) VALUES
(1, 'a', '1', 'a@a.a', '1234567890', 'abcdefghijkl', 'accountant', '2019-05-28'),
(2, 's1', '1', '1@gmail.com', '1123456789', 'abcdefghijkl', 'student', '2019-05-28'),
(3, 's2', '1', '2@gmail.com', '2123456789', '2abcdefghijkl', 'student', '2019-05-28'),
(4, 's3', '1', '3@gmail.com', '3123456789', '3abcdefghijkl', 'student', '2019-05-28'),
(5, 's4', '1', '4@gmail.com', '4123456789', '4abcdefghijkl', 'student', '2019-05-28'),
(6, 's5', '1', '5@gmail.com', '5123456789', '5abcdefghijkl', 'student', '2019-05-28'),
(7, 's6', '1', '6@gmail.com', '6123456789', '6abcdefghijkl', 'student', '2019-05-28'),
(8, 's7', '1', '7@gmail.com', '7123456789', '7abcdefghijkl', 'student', '2019-05-28'),
(9, 's8', '1', '8@gmail.com', '8123456789', '8abcdefghijkl', 'student', '2019-05-28'),
(10, 's9', '1', '9@gmail.com', '9123456789', '9abcdefghijkl', 'student', '2019-05-28');

-- --------------------------------------------------------

--
-- Table structure for table `user_course`
--

CREATE TABLE `user_course` (
  `user_id` int(11) NOT NULL,
  `paid` int(11) DEFAULT NULL,
  `due` int(11) DEFAULT NULL,
  `course_name` varchar(100) DEFAULT NULL,
  `fee_type` varchar(100) DEFAULT NULL,
  `fee` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_course`
--

INSERT INTO `user_course` (`user_id`, `paid`, `due`, `course_name`, `fee_type`, `fee`) VALUES
(2, 10000, 0, 'java', 'tution', 10000),
(3, 0, 5000, 'c', 'tution', 5000),
(4, 0, 11000, 'python', 'tution', 11000),
(5, 0, 9000, 'aws', 'tution', 9000),
(6, 0, 11000, 'python', 'tution', 11000),
(7, 0, 9000, 'aws', 'tution', 9000),
(8, 0, 9000, 'aws', 'tution', 9000),
(9, 0, 11000, 'python', 'tution', 11000),
(10, 0, 9000, 'aws', 'tution', 9000),
(2, 0, 11000, 'python', 'course', 11000),
(2, 0, 1000, 'java', 'exam', 1000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `feereport_accountant`
--
ALTER TABLE `feereport_accountant`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `feereport_student`
--
ALTER TABLE `feereport_student`
  ADD PRIMARY KEY (`rollno`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_course`
--
ALTER TABLE `user_course`
  ADD KEY `user_fk` (`user_id`),
  ADD KEY `course_fk` (`course_name`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `feereport_accountant`
--
ALTER TABLE `feereport_accountant`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `feereport_student`
--
ALTER TABLE `feereport_student`
  MODIFY `rollno` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `user_course`
--
ALTER TABLE `user_course`
  ADD CONSTRAINT `user_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
