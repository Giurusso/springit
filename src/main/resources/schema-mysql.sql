-- CREATE DATABASE  IF NOT EXISTS `springit'
-- USE `springit`;

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `id` bigint(20) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `body` varchar(255) DEFAULT NULL,
  `link_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKoutxw6g1ndh1t6282y0fwvami` (`link_id`),
  CONSTRAINT `FKoutxw6g1ndh1t6282y0fwvami` FOREIGN KEY (`link_id`) REFERENCES `link` (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- DROP TABLE IF EXISTS `hibernate_sequence`;
--
-- CREATE TABLE `hibernate_sequence` (
--   `next_val` bigint(20) DEFAULT NULL
-- ) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
--
-- Table structure for table `link`
--

DROP TABLE IF EXISTS `link`;

CREATE TABLE `link` (
  `id` bigint(20) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `last_modified_by` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Table structure for table `vote`
--

DROP TABLE IF EXISTS `vote`;

CREATE TABLE `vote` (
  `id` bigint(20) NOT NULL,
  `vote` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;