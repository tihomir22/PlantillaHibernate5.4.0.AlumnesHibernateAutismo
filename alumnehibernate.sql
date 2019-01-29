-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Temps de generació: 29-01-2019 a les 10:15:47
-- Versió del servidor: 10.1.36-MariaDB
-- Versió de PHP: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de dades: `alumnehibernate`
--

-- --------------------------------------------------------

--
-- Estructura de la taula `alumnes`
--

CREATE TABLE `alumnes` (
  `nexp` int(11) NOT NULL,
  `nif` varchar(255) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `telefon` varchar(255) NOT NULL,
  `sexe` tinyint(1) NOT NULL,
  `datanaix` date NOT NULL,
  `susp` int(11) NOT NULL,
  `grup` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Bolcament de dades per a la taula `alumnes`
--

INSERT INTO `alumnes` (`nexp`, `nif`, `nom`, `telefon`, `sexe`, `datanaix`, `susp`, `grup`) VALUES
(2, 'X5345344353', 'ESTEVE ROIG MAS', '965530205', 1, '2019-01-26', 1, 'B1A'),
(3, '4564654645X', 'EMPAR ROMA PRIM', '965531122', 0, '2019-01-26', 2, 'F1V'),
(4, 'X543563463', 'MARIA ARMAT GRAU', '966502211', 0, '2019-01-26', 3, 'G1V'),
(5, 'X4325345344', 'JOSEP BAS FERRER', '965591145', 1, '2019-01-26', 2, 'I1M'),
(6, 'X2143432432', 'FOAQUIM FAUS PLA', '965510066', 1, '1980-01-26', 0, 'R1V'),
(7, 'X5514136R', 'Tihomir', 'Stoychev', 1, '2019-01-27', 0, NULL),
(9, 'X5514136R', 'Tihomir', 'Stoychev', 1, '2019-01-27', 0, NULL),
(13, 'X5514136R', 'MechetoTopcho', 'Stoychev', 1, '2019-01-27', 0, NULL),
(19, 'X5514136R', 'MechetoTopcho', 'Stoychev', 1, '2019-01-27', 0, 'F1V'),
(28, 'X5514136R', 'MechetoTopcho', 'Stoychev', 1, '2019-01-27', 0, NULL),
(29, 'X5514136R', 'MechetoTopcho', 'Stoychev', 1, '2019-01-29', 0, NULL);

-- --------------------------------------------------------

--
-- Estructura de la taula `aula`
--

CREATE TABLE `aula` (
  `codi` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `nombre` varchar(255) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Bolcament de dades per a la taula `aula`
--

INSERT INTO `aula` (`codi`, `nombre`) VALUES
('DAM', 'Desarollo de Aplicaciones Multiplataforma');

-- --------------------------------------------------------

--
-- Estructura de la taula `grups`
--

CREATE TABLE `grups` (
  `codi` varchar(20) NOT NULL,
  `nivel` varchar(30) NOT NULL,
  `delegat` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Bolcament de dades per a la taula `grups`
--

INSERT INTO `grups` (`codi`, `nivel`, `delegat`) VALUES
('B1A', 'Batxiller', 3),
('B2A', 'Batxiller', 2),
('DAM', 'CF', 29),
('DAM2', 'CF', 9),
('F1V', 'CF', 3),
('G1V', 'CF', 4),
('I1M', 'CF', 5),
('R1V', 'CF', 6);

--
-- Índexs per a les taules bolcades
--

--
-- Índexs per a la taula `alumnes`
--
ALTER TABLE `alumnes`
  ADD PRIMARY KEY (`nexp`),
  ADD KEY `grup` (`grup`);

--
-- Índexs per a la taula `aula`
--
ALTER TABLE `aula`
  ADD PRIMARY KEY (`codi`);

--
-- Índexs per a la taula `grups`
--
ALTER TABLE `grups`
  ADD PRIMARY KEY (`codi`),
  ADD KEY `delegat` (`delegat`);

--
-- AUTO_INCREMENT per les taules bolcades
--

--
-- AUTO_INCREMENT per la taula `alumnes`
--
ALTER TABLE `alumnes`
  MODIFY `nexp` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- Restriccions per a les taules bolcades
--

--
-- Restriccions per a la taula `alumnes`
--
ALTER TABLE `alumnes`
  ADD CONSTRAINT `alumnes_ibfk_1` FOREIGN KEY (`grup`) REFERENCES `grups` (`codi`);

--
-- Restriccions per a la taula `grups`
--
ALTER TABLE `grups`
  ADD CONSTRAINT `grups_ibfk_1` FOREIGN KEY (`delegat`) REFERENCES `alumnes` (`nexp`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
