-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  jeu. 17 mai 2018 à 08:03
-- Version du serveur :  5.7.21
-- Version de PHP :  5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `marmicon`
--

-- --------------------------------------------------------

--
-- Structure de la table `gateau`
--

DROP TABLE IF EXISTS `gateau`;
CREATE TABLE IF NOT EXISTS `gateau` (
  `id_gateau` int(11) NOT NULL AUTO_INCREMENT,
  `id_recette` int(11) NOT NULL,
  `nom_gateau` varchar(50) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id_gateau`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `gateau`
--

INSERT INTO `gateau` (`id_gateau`, `id_recette`, `nom_gateau`) VALUES
(1, 11, 'Gâteau aux pommes'),
(2, 12, 'Gâteau au chocolat des écoliers'),
(3, 13, 'Tarte au citron');

-- --------------------------------------------------------

--
-- Structure de la table `ingredient`
--

DROP TABLE IF EXISTS `ingredient`;
CREATE TABLE IF NOT EXISTS `ingredient` (
  `id_ingredient` int(11) NOT NULL AUTO_INCREMENT,
  `nom_ingredient` varchar(50) CHARACTER SET utf8 NOT NULL,
  `qte_ingredient` varchar(25) CHARACTER SET utf8 NOT NULL,
  `id_recette` int(11) NOT NULL,
  PRIMARY KEY (`id_ingredient`)
) ENGINE=MyISAM AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `ingredient`
--

INSERT INTO `ingredient` (`id_ingredient`, `nom_ingredient`, `qte_ingredient`, `id_recette`) VALUES
(1, 'beurre', '100g', 11),
(2, 'farine', '100g', 11),
(3, 'citron', '100g', 11),
(4, 'oeufs', '100g', 11),
(5, 'levure chimique', '100g', 11),
(6, 'pommes', '100g', 11),
(7, 'chocolat', '100g', 12),
(8, 'oeufs', '100g', 12),
(9, 'beurre', '100g', 12),
(10, 'sucre', '100g', 12),
(11, 'farine', '100g', 12),
(12, 'levure chimique', '100g', 12),
(13, 'farine', '100g', 13),
(14, 'beurre', '100g', 13),
(15, 'sucre', '100g', 13),
(16, 'sel', '100g', 13),
(17, 'eau', '100g', 13),
(18, 'citrons', '100g', 13),
(19, 'sucre', '100g', 13),
(20, 'crème fraîche', '100g', 13),
(21, 'oeufs', '100g', 13);

-- --------------------------------------------------------

--
-- Structure de la table `instruction`
--

DROP TABLE IF EXISTS `instruction`;
CREATE TABLE IF NOT EXISTS `instruction` (
  `id_instruction` int(11) NOT NULL AUTO_INCREMENT,
  `id_recette` int(11) NOT NULL,
  `indication` varchar(500) CHARACTER SET utf8 NOT NULL,
  `id_ordre` int(11) NOT NULL,
  PRIMARY KEY (`id_instruction`)
) ENGINE=MyISAM AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `instruction`
--

INSERT INTO `instruction` (`id_instruction`, `id_recette`, `indication`, `id_ordre`) VALUES
(1, 11, 'Faire fondre le beurre dans le moule au four.', 1),
(2, 11, 'Râper le citron (la peau), ajouter le sucre, les œufs bien fouetter le tout.', 2),
(3, 11, 'Ajouter la farine déjà mélangée à la levure, puis le beurre fondu un peu refroidi.', 3),
(4, 11, 'Bien mélanger le tout et le mettre dans le moule.', 4),
(5, 11, 'Eplucher les pommes, les couper en tranches et les planter dans le gâteau. Pour les pommes utilisez si possible des reinettes ou des golden.', 5),
(6, 11, 'Enfourner à four chaud à 180°C (thermostat 6) pendant 25 minutes.', 6),
(7, 11, 'Soupoudrer de sucre glace une fois refroid.', 7),
(8, 12, 'Préchauffez le four à 180°C (thermostat 6).', 1),
(9, 12, 'Faites fondre le chocolat au bain-marie ou au micro-ondes. Si vous le faites fondre au micro-ondes, ajoutez 3 cuillères à soupe d\'eau pour 200 g de chocolat.', 2),
(10, 12, 'Ajoutez le beurre au chocolat fondu et fouetter énergiquement jusqu\'à ce que le mélange soit lisse et bien fondu.', 3),
(11, 12, 'Dans un saladier, fouettez les oeufs et le sucre jusqu\'à ce que le mélange blanchisse et incorporez la levure puis la farine.', 4),
(12, 12, 'Versez le chocolat et le beurre fondus dans la préparation puis mélangez jusqu\'à l\'obtention d\'une pâte homogène.', 5),
(13, 12, 'Versez la préparation dans un moule à manqué beurré et fariné.', 6),
(14, 12, 'Faites cuire environ 25 minutes (adaptez le temps de cuisson pour obtenir un cœur plus ou moins fondant).', 7),
(15, 13, 'Faire la pâte : mélanger dans une terrine la farine, le sucre et le sel.', 1),
(16, 13, 'Faire un puits et y verser le beurre presque fondu (pas trop chaud) et l\'eau froide.', 2),
(17, 13, 'Faire \'imbiber\' la farine du liquide en remuant le moins possible, verser le mélange dans un torchon (propre) et laisser au repos 2 h au frigo.', 3),
(18, 13, 'Pendant ce temps, préparer la garniture : prélever un peu de zeste de citron (bio) et le garder.', 4),
(19, 13, 'Eplucher les citrons, les couper en deux et prélever seulement la chair sans les peaux blanches. Les mixer, mélanger avec le sucre, la crême fraiche épaisse et le zeste.', 5),
(20, 13, 'Ajouter les deux oeufs en battant bien. Le mélange doit être crémeux.', 6),
(21, 13, 'Verser sur la pâte abaissée, et faire cuire four chaud 30 mn.', 7);

-- --------------------------------------------------------

--
-- Structure de la table `recette`
--

DROP TABLE IF EXISTS `recette`;
CREATE TABLE IF NOT EXISTS `recette` (
  `id_recette` int(11) NOT NULL AUTO_INCREMENT,
  `id_gateau` int(11) NOT NULL,
  `temps_prep` varchar(25) NOT NULL,
  PRIMARY KEY (`id_recette`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `recette`
--

INSERT INTO `recette` (`id_recette`, `id_gateau`, `temps_prep`) VALUES
(11, 1, '45m'),
(12, 2, '35m'),
(13, 3, '2h30');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
