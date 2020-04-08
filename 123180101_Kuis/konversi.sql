-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 08 Apr 2020 pada 22.00
-- Versi server: 10.3.16-MariaDB
-- Versi PHP: 7.3.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `konversi`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `nilaimhs`
--

CREATE TABLE `nilaimhs` (
  `nim` int(9) NOT NULL,
  `nama` varchar(40) NOT NULL,
  `mk1` varchar(40) NOT NULL,
  `nilai1` int(3) NOT NULL,
  `mk2` varchar(40) NOT NULL,
  `nilai2` int(3) NOT NULL,
  `nRata` int(3) NOT NULL,
  `nHuruf` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `nilaimhs`
--

INSERT INTO `nilaimhs` (`nim`, `nama`, `mk1`, `nilai1`, `mk2`, `nilai2`, `nRata`, `nHuruf`) VALUES
(123, 'bayu', 'pbo', 78, 'scpk', 90, 0, ''),
(180, 'Sun', 'Scpk', 60, 'Matriks', 90, 75, ''),
(101, 'Sky', 'Opk', 88, 'AA', 90, 89, ''),
(101, 'Sky', 'Opk', 88, 'AA', 90, 89, ''),
(111, 'Rin', 'pbo', 70, 'algo', 90, 80, ''),
(222, 'rizal', 'Sti', 70, 'techno', 88, 79, ''),
(134, 'reza', 'imk', 87, 'scpk', 78, 83, ''),
(345, 'yudha', 'jarkom', 65, 'opk', 50, 58, 'C');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
