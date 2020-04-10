-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : ven. 10 avr. 2020 à 02:54
-- Version du serveur :  10.4.11-MariaDB
-- Version de PHP : 7.2.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `hacene_anis`
--

-- --------------------------------------------------------

--
-- Structure de la table `compte`
--

CREATE TABLE `compte` (
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `compte`
--

INSERT INTO `compte` (`username`, `password`) VALUES
('ANISAknouche', 'Anis1111'),
('Hacene', 'Hacene98'),
('MAXI', 'MAXI98');

-- --------------------------------------------------------

--
-- Structure de la table `friends`
--

CREATE TABLE `friends` (
  `user1` varchar(30) NOT NULL,
  `user2` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `session`
--

CREATE TABLE `session` (
  `username` varchar(30) NOT NULL,
  `h_cle` varchar(32) NOT NULL,
  `date_expiration` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `session`
--

INSERT INTO `session` (`username`, `h_cle`, `date_expiration`) VALUES
('ANISAknouche', '[C@54e1c68b', '2020-04-10T01:45:45.738729300'),
('Hacene', '[C@54e1c68b', '2020-04-10T02:54:53.129123'),
('Hacene', '[C@54e1c68b', '2020-04-10T02:57:37.226992100'),
('MAXI', '[C@54e1c68b', '2020-04-10T03:01:02.634045400'),
('MAXI', '[C@54e1c68b', '2020-04-10T03:05:34.029949900'),
('MAXI', '[C@54e1c68b', '2020-04-10T03:13:09.642027900'),
('MAXI', '[C@54e1c68b', '2020-04-10T03:13:54.730373300');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `username` varchar(30) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `dateNaiss` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`username`, `nom`, `prenom`, `email`, `dateNaiss`) VALUES
('ANISAknouche', 'AKNOUCHE', 'Anis', 'anisaknouche98@gmail.com', '1998-05-30'),
('Hacene', 'Haddadi', 'Hacene', 'hacenehaddadi98@gmail.com', '1998-05-30'),
('MAXI', 'MAX', 'MAX', 'MAX98@gmail.com', '1998-05-30');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `compte`
--
ALTER TABLE `compte`
  ADD KEY `username` (`username`) USING BTREE;

--
-- Index pour la table `session`
--
ALTER TABLE `session`
  ADD KEY `username` (`username`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`username`);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `compte`
--
ALTER TABLE `compte`
  ADD CONSTRAINT `compte_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE;

--
-- Contraintes pour la table `session`
--
ALTER TABLE `session`
  ADD CONSTRAINT `session_ibfk_1` FOREIGN KEY (`username`) REFERENCES `user` (`username`),
  ADD CONSTRAINT `session_ibfk_2` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
