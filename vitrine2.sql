-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mer. 30 nov. 2022 à 01:17
-- Version du serveur : 10.4.25-MariaDB
-- Version de PHP : 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `vitrine2`
--

-- --------------------------------------------------------

--
-- Structure de la table `article`
--

CREATE TABLE `article` (
  `ID_ARTICLE` bigint(20) NOT NULL,
  `QTE_STOCK` int(11) DEFAULT NULL,
  `IMAGEFILENAME` varchar(255) DEFAULT NULL,
  `NOM_ARTICLE` varchar(255) DEFAULT NULL,
  `PRIX_ARTICLE` float DEFAULT NULL,
  `ctg_code` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `article`
--

INSERT INTO `article` (`ID_ARTICLE`, `QTE_STOCK`, `IMAGEFILENAME`, `NOM_ARTICLE`, `PRIX_ARTICLE`, `ctg_code`) VALUES
(1, 97, 'tate-logo-black-tshirt-back-g1086 (1).jpg', 'Black t-shirt', 199.99, 1);

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE `categorie` (
  `ID_CTG` bigint(20) NOT NULL,
  `NOM_CTG` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `categorie`
--

INSERT INTO `categorie` (`ID_CTG`, `NOM_CTG`) VALUES
(1, 't-shirts'),
(2, 'pants');

-- --------------------------------------------------------

--
-- Structure de la table `internaute`
--

CREATE TABLE `internaute` (
  `ID_USER` bigint(20) NOT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `NOM` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `PRENOM` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `internaute`
--

INSERT INTO `internaute` (`ID_USER`, `EMAIL`, `NOM`, `PASSWORD`, `PRENOM`) VALUES
(1, 'samiamajdi@gmail.com', 'samia', 'samia', 'majdi');

-- --------------------------------------------------------

--
-- Structure de la table `panier`
--

CREATE TABLE `panier` (
  `ID_PANIER` bigint(20) NOT NULL,
  `PRIX_TOT` float DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `panier`
--

INSERT INTO `panier` (`ID_PANIER`, `PRIX_TOT`, `user_id`) VALUES
(1, 599.97, 1);

-- --------------------------------------------------------

--
-- Structure de la table `panierarticle`
--

CREATE TABLE `panierarticle` (
  `IDPA` bigint(20) NOT NULL,
  `QUANTITE` int(11) DEFAULT NULL,
  `art_code` bigint(20) DEFAULT NULL,
  `pan_code` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `panierarticle`
--

INSERT INTO `panierarticle` (`IDPA`, `QUANTITE`, `art_code`, `pan_code`) VALUES
(1, 3, 1, 1);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `article`
--
ALTER TABLE `article`
  ADD PRIMARY KEY (`ID_ARTICLE`),
  ADD KEY `FK_Article_ctg_code` (`ctg_code`);

--
-- Index pour la table `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`ID_CTG`);

--
-- Index pour la table `internaute`
--
ALTER TABLE `internaute`
  ADD PRIMARY KEY (`ID_USER`);

--
-- Index pour la table `panier`
--
ALTER TABLE `panier`
  ADD PRIMARY KEY (`ID_PANIER`),
  ADD KEY `FK_Panier_user_id` (`user_id`);

--
-- Index pour la table `panierarticle`
--
ALTER TABLE `panierarticle`
  ADD PRIMARY KEY (`IDPA`),
  ADD KEY `FK_PanierArticle_art_code` (`art_code`),
  ADD KEY `FK_PanierArticle_pan_code` (`pan_code`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `article`
--
ALTER TABLE `article`
  MODIFY `ID_ARTICLE` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `categorie`
--
ALTER TABLE `categorie`
  MODIFY `ID_CTG` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `internaute`
--
ALTER TABLE `internaute`
  MODIFY `ID_USER` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `panier`
--
ALTER TABLE `panier`
  MODIFY `ID_PANIER` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `panierarticle`
--
ALTER TABLE `panierarticle`
  MODIFY `IDPA` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `article`
--
ALTER TABLE `article`
  ADD CONSTRAINT `FK_Article_ctg_code` FOREIGN KEY (`ctg_code`) REFERENCES `categorie` (`ID_CTG`);

--
-- Contraintes pour la table `panier`
--
ALTER TABLE `panier`
  ADD CONSTRAINT `FK_Panier_user_id` FOREIGN KEY (`user_id`) REFERENCES `internaute` (`ID_USER`);

--
-- Contraintes pour la table `panierarticle`
--
ALTER TABLE `panierarticle`
  ADD CONSTRAINT `FK_PanierArticle_art_code` FOREIGN KEY (`art_code`) REFERENCES `article` (`ID_ARTICLE`),
  ADD CONSTRAINT `FK_PanierArticle_pan_code` FOREIGN KEY (`pan_code`) REFERENCES `panier` (`ID_PANIER`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
