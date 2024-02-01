-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 01, 2024 at 09:22 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dss`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_employee`
--

CREATE TABLE `tbl_employee` (
  `id` bigint(20) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `group_id` bigint(20) DEFAULT NULL,
  `nama` varchar(255) DEFAULT NULL,
  `saldo_id` bigint(20) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `tgl_lahir` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_employee`
--

INSERT INTO `tbl_employee` (`id`, `created_at`, `group_id`, `nama`, `saldo_id`, `status`, `tgl_lahir`, `updated_at`) VALUES
(6, '2024-02-01 18:32:46.000000', 1, 'Syahrul Ilham', 1, 1, '1997-09-11 09:46:23.000000', NULL),
(7, '2024-02-01 19:08:26.000000', 1, 'Syahrul Ilham M', 1, 1, '1997-09-10 07:00:00.000000', NULL),
(8, '2024-02-01 19:37:09.000000', 1, 'Syahrul Ilham Mu', 1, 1, '1997-09-11 00:00:00.000000', NULL),
(11, '2024-02-02 00:07:54.000000', 3, 'Syahrul ild', 1, 1, '0017-02-18 00:00:00.000000', NULL),
(12, '2024-02-02 00:09:52.000000', 3, 'Syahrul ilsayaaaasdasdsadasdasdasd', 1, 0, '1998-09-11 00:00:00.000000', '2024-02-02 01:51:50.000000');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_group`
--

CREATE TABLE `tbl_group` (
  `id` bigint(20) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `nama` varchar(255) DEFAULT NULL,
  `tgl_join` datetime(6) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_group`
--

INSERT INTO `tbl_group` (`id`, `created_at`, `nama`, `tgl_join`, `updated_at`) VALUES
(3, '2024-02-01 12:32:40.000000', 'capital lifae', '2024-02-01 12:32:40.000000', '2024-02-01 13:00:18.000000'),
(4, '2024-02-01 13:10:09.000000', 'test11', '2024-02-01 13:10:09.000000', NULL),
(5, '2024-02-01 13:10:09.000000', 'test11', '2024-02-01 13:10:09.000000', NULL),
(6, '2024-02-01 13:10:09.000000', 'test11', '2024-02-01 13:10:09.000000', NULL),
(7, '2024-02-01 13:10:09.000000', 'test11', '2024-02-01 13:10:09.000000', NULL),
(8, '2024-02-01 13:10:09.000000', 'test11', '2024-02-01 13:10:09.000000', NULL),
(9, '2024-02-01 13:10:09.000000', 'test11', '2024-02-01 13:10:09.000000', NULL),
(10, '2024-02-01 13:10:09.000000', 'test11', '2024-02-01 13:10:09.000000', NULL),
(11, '2024-02-01 13:10:09.000000', 'test11', '2024-02-01 13:10:09.000000', NULL),
(12, '2024-02-01 13:10:09.000000', 'test11', '2024-02-01 13:10:09.000000', NULL),
(13, '2024-02-01 13:10:09.000000', 'test11', '2024-02-01 13:10:09.000000', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_saldo`
--

CREATE TABLE `tbl_saldo` (
  `id` bigint(20) NOT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `jenis` varchar(255) DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `amount` decimal(38,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tbl_saldo`
--

INSERT INTO `tbl_saldo` (`id`, `created_at`, `jenis`, `updated_at`, `amount`) VALUES
(1, '2024-02-01 17:53:02.000000', 'Asuransi', NULL, 9000000.00);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_employee`
--
ALTER TABLE `tbl_employee`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_group`
--
ALTER TABLE `tbl_group`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tbl_saldo`
--
ALTER TABLE `tbl_saldo`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_employee`
--
ALTER TABLE `tbl_employee`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `tbl_group`
--
ALTER TABLE `tbl_group`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `tbl_saldo`
--
ALTER TABLE `tbl_saldo`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
