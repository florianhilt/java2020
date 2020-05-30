-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  sam. 30 mai 2020 à 22:55
-- Version du serveur :  10.4.10-MariaDB
-- Version de PHP :  7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `java2020`
--

-- --------------------------------------------------------

--
-- Structure de la table `cours`
--

DROP TABLE IF EXISTS `cours`;
CREATE TABLE IF NOT EXISTS `cours` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `cours`
--

INSERT INTO `cours` (`id`, `nom`) VALUES
(1, 'Thermodynamique'),
(2, 'Electromagnetisme'),
(3, 'Analyse de Fourier'),
(4, 'Mathematiques'),
(5, 'POO Java');

-- --------------------------------------------------------

--
-- Structure de la table `enseignant`
--

DROP TABLE IF EXISTS `enseignant`;
CREATE TABLE IF NOT EXISTS `enseignant` (
  `id_utilisateur` int(11) NOT NULL,
  `id_cours` int(11) NOT NULL,
  PRIMARY KEY (`id_utilisateur`,`id_cours`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `enseignant`
--

INSERT INTO `enseignant` (`id_utilisateur`, `id_cours`) VALUES
(13, 1),
(13, 2),
(14, 3),
(14, 4),
(15, 1),
(15, 2);

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

DROP TABLE IF EXISTS `etudiant`;
CREATE TABLE IF NOT EXISTS `etudiant` (
  `id_utilisateur` int(11) NOT NULL,
  `numero` int(11) NOT NULL,
  `id_groupe` int(11) NOT NULL,
  PRIMARY KEY (`id_utilisateur`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `etudiant`
--

INSERT INTO `etudiant` (`id_utilisateur`, `numero`, `id_groupe`) VALUES
(1, 1, 1),
(2, 2, 1),
(3, 3, 2),
(4, 4, 2),
(5, 5, 3),
(6, 6, 3),
(7, 7, 4),
(8, 8, 4),
(9, 9, 5),
(10, 10, 5),
(11, 11, 6),
(12, 12, 6);

-- --------------------------------------------------------

--
-- Structure de la table `groupe`
--

DROP TABLE IF EXISTS `groupe`;
CREATE TABLE IF NOT EXISTS `groupe` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `id_promotion` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `groupe`
--

INSERT INTO `groupe` (`id`, `nom`, `id_promotion`) VALUES
(1, 'TD01', 1),
(2, 'TD02', 1),
(3, 'TD01', 2),
(4, 'TD02', 2),
(5, 'TD01', 3),
(6, 'TD02', 3);

-- --------------------------------------------------------

--
-- Structure de la table `promotion`
--

DROP TABLE IF EXISTS `promotion`;
CREATE TABLE IF NOT EXISTS `promotion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `promotion`
--

INSERT INTO `promotion` (`id`, `nom`) VALUES
(1, 'ING1'),
(2, 'ING2'),
(3, 'ING3');

-- --------------------------------------------------------

--
-- Structure de la table `salle`
--

DROP TABLE IF EXISTS `salle`;
CREATE TABLE IF NOT EXISTS `salle` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `capacite` int(11) NOT NULL,
  `id_site` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `salle`
--

INSERT INTO `salle` (`id`, `nom`, `capacite`, `id_site`) VALUES
(1, 'EM009', 200, 1),
(2, 'SC210', 35, 1),
(3, 'P445', 100, 2),
(4, 'P417', 35, 2),
(5, 'G002', 100, 3),
(6, 'G006', 35, 3);

-- --------------------------------------------------------

--
-- Structure de la table `seance`
--

DROP TABLE IF EXISTS `seance`;
CREATE TABLE IF NOT EXISTS `seance` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `semaine` int(11) NOT NULL,
  `jour` varchar(255) NOT NULL,
  `heure_debut` varchar(255) NOT NULL,
  `heure_fin` varchar(255) NOT NULL,
  `etat` int(11) NOT NULL,
  `id_cours` int(11) NOT NULL,
  `id_type` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `seance`
--

INSERT INTO `seance` (`id`, `semaine`, `jour`, `heure_debut`, `heure_fin`, `etat`, `id_cours`, `id_type`) VALUES
(1, 1, 'Lundi', '9h00', '11h00', 1, 1, 1);

-- --------------------------------------------------------

--
-- Structure de la table `seance_enseignants`
--

DROP TABLE IF EXISTS `seance_enseignants`;
CREATE TABLE IF NOT EXISTS `seance_enseignants` (
  `id_seance` int(11) NOT NULL,
  `id_enseignant` int(11) NOT NULL,
  PRIMARY KEY (`id_seance`,`id_enseignant`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `seance_groupes`
--

DROP TABLE IF EXISTS `seance_groupes`;
CREATE TABLE IF NOT EXISTS `seance_groupes` (
  `id_seance` int(11) NOT NULL,
  `id_groupe` int(11) NOT NULL,
  PRIMARY KEY (`id_seance`,`id_groupe`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `seance_salles`
--

DROP TABLE IF EXISTS `seance_salles`;
CREATE TABLE IF NOT EXISTS `seance_salles` (
  `id_seance` int(11) NOT NULL,
  `id_salle` int(11) NOT NULL,
  PRIMARY KEY (`id_seance`,`id_salle`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `site`
--

DROP TABLE IF EXISTS `site`;
CREATE TABLE IF NOT EXISTS `site` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `site`
--

INSERT INTO `site` (`id`, `nom`) VALUES
(1, 'E1'),
(2, 'E2'),
(3, 'E4');

-- --------------------------------------------------------

--
-- Structure de la table `type_cours`
--

DROP TABLE IF EXISTS `type_cours`;
CREATE TABLE IF NOT EXISTS `type_cours` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `type_cours`
--

INSERT INTO `type_cours` (`id`, `nom`) VALUES
(1, 'Amphi'),
(2, 'TP'),
(3, 'TD'),
(4, 'Demi-Groupe'),
(5, 'DS');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `droit` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `email`, `password`, `nom`, `prenom`, `droit`) VALUES
(1, 'florian.hilt@edu.ece.fr', 'fh', 'Hilt', 'Florian', 1),
(2, 'valentin.boucher@edu.ece.fr', 'vb', 'Boucher', 'Valentin', 1),
(3, 'mickael.gremy@edu.ece.fr', 'mg', 'Gremy', 'Mickael', 1),
(4, 'illyas.boudjemai@edu.ece.fr', 'ib', 'Boudjemai', 'Illyas', 1),
(5, 'dominik.carbon@edu.ece.fr', 'dc', 'Carbon', 'Dominik', 1),
(6, 'gabriel.attal@edu.ece.fr', 'ga', 'Attal', 'Gabriel', 1),
(7, 'thomas.popielski@edu.ece.fr', 'tp', 'Popielski', 'Thomas', 1),
(8, 'paul.coutiere@edu.ece.fr', 'pc', 'Coutiere', 'Paul', 1),
(9, 'jordan.kujundzik@edu.ece.fr', 'jk', 'Kujundzik', 'Jordan', 1),
(10, 'charles.lefort@edu.ece.fr', 'cl', 'Lefort', 'Charles', 1),
(11, 'ayoub.ouboujemaa@edu.ece.fr', 'ao', 'Ouboujemaa', 'Ayoub', 1),
(12, 'collin.ferret@edu.ece.fr', 'cf', 'Ferret', 'Collin', 1),
(13, 'thomas.guillemot@ece.fr', 'tg', 'Guillemot', 'Thomas', 2),
(14, 'fabienne.coudray@ece.fr', 'fc', 'Coudray', 'Fabienne', 2),
(15, 'christine.crambes@ece.fr', 'cc', 'Crambes', 'Christine', 2);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
