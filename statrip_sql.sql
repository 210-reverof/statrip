-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema statrip
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `statrip` ;

-- -----------------------------------------------------
-- Schema statrip
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `statrip` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `statrip` ;

-- -----------------------------------------------------
-- Table `statrip`.`sido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `statrip`.`sido` (
  `sido_code` INT NOT NULL,
  `sido_name` VARCHAR(30) NULL DEFAULT NULL,
  PRIMARY KEY (`sido_code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `statrip`.`gugun`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `statrip`.`gugun` (
  `gugun_code` INT NOT NULL,
  `gugun_name` VARCHAR(30) NULL DEFAULT NULL,
  `sido_code` INT NOT NULL,
  PRIMARY KEY (`gugun_code`, `sido_code`),
  INDEX `gugun_to_sido_sido_code_fk_idx` (`sido_code` ASC) VISIBLE,
  CONSTRAINT `gugun_to_sido_sido_code_fk`
    FOREIGN KEY (`sido_code`)
    REFERENCES `statrip`.`sido` (`sido_code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `statrip`.`attraction_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `statrip`.`attraction_info` (
  `content_id` INT NOT NULL,
  `content_type_id` INT NULL DEFAULT NULL,
  `title` VARCHAR(100) NULL DEFAULT NULL,
  `addr1` VARCHAR(100) NULL DEFAULT NULL,
  `addr2` VARCHAR(50) NULL DEFAULT NULL,
  `zipcode` VARCHAR(50) NULL DEFAULT NULL,
  `tel` VARCHAR(50) NULL DEFAULT NULL,
  `first_image` VARCHAR(200) NULL DEFAULT NULL,
  `first_image2` VARCHAR(200) NULL DEFAULT NULL,
  `readcount` INT NULL DEFAULT NULL,
  `sido_code` INT NULL DEFAULT NULL,
  `gugun_code` INT NULL DEFAULT NULL,
  `latitude` DECIMAL(20,17) NULL DEFAULT NULL,
  `longitude` DECIMAL(20,17) NULL DEFAULT NULL,
  `mlevel` VARCHAR(2) NULL DEFAULT NULL,
  PRIMARY KEY (`content_id`),
  INDEX `attraction_to_content_type_id_fk_idx` (`content_type_id` ASC) VISIBLE,
  INDEX `attraction_to_sido_code_fk_idx` (`sido_code` ASC) VISIBLE,
  INDEX `attraction_to_gugun_code_fk_idx` (`gugun_code` ASC) VISIBLE,
  CONSTRAINT `attraction_to_content_type_id_fk`
    FOREIGN KEY (`content_type_id`)
    REFERENCES `statrip`.`content_type` (`content_type_id`),
  CONSTRAINT `attraction_to_gugun_code_fk`
    FOREIGN KEY (`gugun_code`)
    REFERENCES `statrip`.`gugun` (`gugun_code`),
  CONSTRAINT `attraction_to_sido_code_fk`
    FOREIGN KEY (`sido_code`)
    REFERENCES `statrip`.`sido` (`sido_code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `statrip`.`attraction_description`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `statrip`.`attraction_description` (
  `content_id` INT NOT NULL,
  `homepage` VARCHAR(100) NULL DEFAULT NULL,
  `overview` VARCHAR(10000) NULL DEFAULT NULL,
  `telname` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`content_id`),
  CONSTRAINT `attraction_detail_to_attraciton_id_fk`
    FOREIGN KEY (`content_id`)
    REFERENCES `statrip`.`attraction_info` (`content_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `statrip`.`attraction_detail`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `statrip`.`attraction_detail` (
  `content_id` INT NOT NULL,
  `cat1` VARCHAR(3) NULL DEFAULT NULL,
  `cat2` VARCHAR(5) NULL DEFAULT NULL,
  `cat3` VARCHAR(9) NULL DEFAULT NULL,
  `created_time` VARCHAR(14) NULL DEFAULT NULL,
  `modified_time` VARCHAR(14) NULL DEFAULT NULL,
  `booktour` VARCHAR(5) NULL DEFAULT NULL,
  PRIMARY KEY (`content_id`),
  CONSTRAINT `attraction_detail_to_basic_content_id_fk`
    FOREIGN KEY (`content_id`)
    REFERENCES `statrip`.`attraction_info` (`content_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb3;


-- -----------------------------------------------------
-- Table `statrip`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `statrip`.`user` (
  `user_id` VARCHAR(20) NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  `email` VARCHAR(50) NOT NULL,
  `phone` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `statrip`.`route`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `statrip`.`route` (
  `route_id` VARCHAR(20) NOT NULL,
  `user_id` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`route_id`, `user_id`),
  INDEX `user_to_route_user_id_fk_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `user_to_route_user_id_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `statrip`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `statrip`.`route_relation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `statrip`.`route_relation` (
  `route_id` VARCHAR(20) NOT NULL,
  `attraction_id` INT NOT NULL,
  `order` INT NOT NULL DEFAULT 0,
  `visited` TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`route_id`, `attraction_id`),
  INDEX `route_to_relation_route_id_idx` (`route_id` ASC) VISIBLE,
  INDEX `attraction_to_relation_attraction_id_fk_idx` (`attraction_id` ASC) VISIBLE,
  CONSTRAINT `route_to_relation_route_id_fk`
    FOREIGN KEY (`route_id`)
    REFERENCES `statrip`.`route` (`route_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `attraction_to_relation_attraction_id_fk`
    FOREIGN KEY (`attraction_id`)
    REFERENCES `statrip`.`attraction_info` (`content_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `statrip`.`share_article`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `statrip`.`share_article` (
  `share_article_id` INT NOT NULL,
  `user_id` VARCHAR(20) NOT NULL,
  `route_id` VARCHAR(20) NOT NULL,
  `title` VARCHAR(50) NOT NULL,
  `content` TEXT NOT NULL,
  `created_time` TIMESTAMP NOT NULL DEFAULT current_timestamp,
  `like` INT NOT NULL DEFAULT 0,
  `hit` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`share_article_id`),
  INDEX `user_to_share_article_user_id_fk_idx` (`user_id` ASC) VISIBLE,
  INDEX `route_to_share_article_route_id_fk_idx` (`route_id` ASC) VISIBLE,
  CONSTRAINT `user_to_share_article_user_id_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `statrip`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `route_to_share_article_route_id_fk`
    FOREIGN KEY (`route_id`)
    REFERENCES `statrip`.`route` (`route_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `statrip`.`question_article`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `statrip`.`question_article` (
  `question_article_id` INT NOT NULL,
  `user_id` VARCHAR(20) NOT NULL,
  `title` VARCHAR(50) NOT NULL,
  `content` TEXT NOT NULL,
  `created_time` TIMESTAMP NOT NULL DEFAULT current_timestamp,
  `like` INT NOT NULL DEFAULT 0,
  `hit` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`question_article_id`),
  INDEX `user_to_share_article_user_id_fk_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `user_to_share_article_user_id_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `statrip`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `statrip`.`shared_comment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `statrip`.`shared_comment` (
  `shared_article_id` INT NOT NULL,
  `shared_comment_id` INT NOT NULL,
  `user_id` VARCHAR(20) NOT NULL,
  `content` TEXT NOT NULL,
  `created_time` TIMESTAMP NULL,
  PRIMARY KEY (`shared_article_id`, `shared_comment_id`),
  INDEX `user_to_shared_comment_fk_idx` (`user_id` ASC) VISIBLE,
  INDEX `shared_article_to_comment_fk_idx` (`shared_article_id` ASC) VISIBLE,
  CONSTRAINT `shared_article_to_comment_fk`
    FOREIGN KEY (`shared_article_id`)
    REFERENCES `statrip`.`share_article` (`share_article_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `user_to_shared_comment_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `statrip`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `statrip`.`question_comment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `statrip`.`question_comment` (
  `question_comment_id` INT NOT NULL,
  `question_article_id` INT NOT NULL,
  `user_id` VARCHAR(20) NOT NULL,
  `content` TEXT NOT NULL,
  `created_time` TIMESTAMP NULL,
  PRIMARY KEY (`question_comment_id`, `question_article_id`),
  INDEX `user_to_shared_comment_fk_idx` (`user_id` ASC) VISIBLE,
  INDEX `question_article_to_comment_fk0_idx` (`question_article_id` ASC) VISIBLE,
  CONSTRAINT `question_article_to_comment_fk`
    FOREIGN KEY (`question_article_id`)
    REFERENCES `statrip`.`question_article` (`question_article_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `user_to_question_comment_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `statrip`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `statrip`.`place_article`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `statrip`.`place_article` (
  `place_article_id` INT NOT NULL,
  `user_id` VARCHAR(20) NOT NULL,
  `attraction_id` INT NOT NULL,
  `title` VARCHAR(50) NOT NULL,
  `content` TEXT NOT NULL,
  `created_time` TIMESTAMP NOT NULL DEFAULT current_timestamp,
  `like` INT NOT NULL DEFAULT 0,
  `hit` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`place_article_id`),
  INDEX `attraction_to_place_article_route_id_fk_idx` (`attraction_id` ASC) VISIBLE,
  INDEX `user_to_place_article_user_id_fk_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `user_to_place_article_user_id_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `statrip`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `attraction_to_place_article_route_id_fk`
    FOREIGN KEY (`attraction_id`)
    REFERENCES `statrip`.`attraction_info` (`content_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `statrip`.`place_comment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `statrip`.`place_comment` (
  `place_article_id` INT NOT NULL,
  `place_comment_id` INT NOT NULL,
  `user_id` VARCHAR(20) NOT NULL,
  `content` TEXT NOT NULL,
  `created_time` TIMESTAMP NULL,
  PRIMARY KEY (`place_article_id`, `place_comment_id`),
  INDEX `user_to_shared_comment_fk_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `place_article_to_comment_fk`
    FOREIGN KEY (`place_article_id`)
    REFERENCES `statrip`.`place_article` (`place_article_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `user_to_place_comment_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `statrip`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
