-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 09, 2021 at 05:19 PM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.4.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bankmanagement1`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `id` int(11) NOT NULL,
  `acc_id` varchar(255) NOT NULL,
  `cust_id` varchar(255) NOT NULL,
  `acc_type` varchar(255) NOT NULL,
  `balance` int(11) NOT NULL,
  `opened_datetime` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`id`, `acc_id`, `cust_id`, `acc_type`, `balance`, `opened_datetime`) VALUES
(6, 'AC001', 'CS001', 'Fix', 7050, '2021-09-09T18:06:10.605'),
(7, 'AC002', 'CS002', 'Saving', 9000, '2021-09-09T18:07:26.047'),
(8, 'AC003', 'CS003', 'Fix', 16500, '2021-09-09T18:08:30.500');

-- --------------------------------------------------------

--
-- Table structure for table `branch`
--

CREATE TABLE `branch` (
  `id` int(11) NOT NULL,
  `branch` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `branch`
--

INSERT INTO `branch` (`id`, `branch`) VALUES
(1, 'branch_1'),
(2, 'branch_2');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id` int(11) NOT NULL,
  `cust_id` varchar(255) NOT NULL,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `street` varchar(255) NOT NULL,
  `city` varchar(255) NOT NULL,
  `branch` varchar(255) NOT NULL,
  `phone` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `cust_id`, `firstname`, `lastname`, `street`, `city`, `branch`, `phone`) VALUES
(6, 'CS001', 'Bob', 'Black', 'xyz', 'London', 'branch_1', 123456),
(7, 'CS002', 'John', 'Cash', 'abc', 'Paris', 'branch_1', 789456),
(8, 'CS003', 'Brock', 'Lesnar', 'def', 'New York', 'branch_1', 456987);

-- --------------------------------------------------------

--
-- Table structure for table `deposit`
--

CREATE TABLE `deposit` (
  `id` int(11) NOT NULL,
  `acc_id` varchar(255) NOT NULL,
  `cust_id` varchar(255) NOT NULL,
  `datetime` varchar(255) NOT NULL,
  `balance` int(11) NOT NULL,
  `deposit` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `deposit`
--

INSERT INTO `deposit` (`id`, `acc_id`, `cust_id`, `datetime`, `balance`, `deposit`) VALUES
(29, 'AC001', 'CS001', '2021-09-09T18:08:49.723', 5000, 200),
(30, 'AC002', 'CS002', '2021-09-09T18:09:19.485', 8000, 2000),
(31, 'AC001', 'CS001', '2021-09-09T18:09:55.068', 5200, 1800),
(32, 'AC003', 'CS003', '2021-09-09T18:10:14.356', 15000, 2200);

-- --------------------------------------------------------

--
-- Table structure for table `loans`
--

CREATE TABLE `loans` (
  `loan_id` int(11) NOT NULL,
  `acc_id` varchar(255) NOT NULL,
  `int_rate` double NOT NULL,
  `num_of_years` double NOT NULL,
  `amount_of_loan` double NOT NULL,
  `monthly_payment` double NOT NULL,
  `total_payment` double NOT NULL,
  `datetime` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `loans`
--

INSERT INTO `loans` (`loan_id`, `acc_id`, `int_rate`, `num_of_years`, `amount_of_loan`, `monthly_payment`, `total_payment`, `datetime`) VALUES
(10, 'AC002', 5, 2, 1200, 55.25, 1325.93, '2021-09-09T18:14:01.401'),
(11, 'AC003', 4.7, 3, 4000, 127.9, 4604.43, '2021-09-09T18:14:24.042'),
(12, 'AC001', 4.6, 1.5, 3000, 178.55, 3213.88, '2021-09-09T18:14:55.018'),
(13, 'AC003', 4.85, 2.5, 5000, 188.11, 5643.16, '2021-09-09T18:15:45.993');

-- --------------------------------------------------------

--
-- Table structure for table `transfer`
--

CREATE TABLE `transfer` (
  `id` int(11) NOT NULL,
  `f_account` varchar(255) NOT NULL,
  `to_account` varchar(255) NOT NULL,
  `Balance` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  `datetime` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transfer`
--

INSERT INTO `transfer` (`id`, `f_account`, `to_account`, `Balance`, `amount`, `datetime`) VALUES
(7, 'AC001', 'AC003', 6850, 500, '2021-09-09T18:11:39.925'),
(8, 'AC002', 'AC001', 9700, 700, '2021-09-09T18:12:10.809');

-- --------------------------------------------------------

--
-- Table structure for table `withdraw`
--

CREATE TABLE `withdraw` (
  `id` int(11) NOT NULL,
  `acc_id` varchar(255) NOT NULL,
  `cust_id` varchar(255) NOT NULL,
  `datetime` varchar(255) NOT NULL,
  `balance` int(11) NOT NULL,
  `withdraw` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `withdraw`
--

INSERT INTO `withdraw` (`id`, `acc_id`, `cust_id`, `datetime`, `balance`, `withdraw`) VALUES
(7, 'AC001', 'CS001', '2021-09-09T18:10:31.331', 7000, 150),
(8, 'AC002', 'CS002', '2021-09-09T18:10:48.603', 10000, 300),
(9, 'AC003', 'CS003', '2021-09-09T18:11:04.411', 17200, 1200);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `branch`
--
ALTER TABLE `branch`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `deposit`
--
ALTER TABLE `deposit`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `loans`
--
ALTER TABLE `loans`
  ADD PRIMARY KEY (`loan_id`);

--
-- Indexes for table `transfer`
--
ALTER TABLE `transfer`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `withdraw`
--
ALTER TABLE `withdraw`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `account`
--
ALTER TABLE `account`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `branch`
--
ALTER TABLE `branch`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `deposit`
--
ALTER TABLE `deposit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT for table `loans`
--
ALTER TABLE `loans`
  MODIFY `loan_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `transfer`
--
ALTER TABLE `transfer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `withdraw`
--
ALTER TABLE `withdraw`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
