-- MySQL Workbench Forward Engineering

-- -----------------------------------------------------
-- Schema PCH_test
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `PCH_test` ;

-- -----------------------------------------------------
-- Schema PCH_test
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `PCH_test` DEFAULT CHARACTER SET utf8 ;
USE `PCH_test` ;

-- -----------------------------------------------------
-- Table `PCH_test`.`PetType`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PCH_test`.`PetType` ;

CREATE TABLE IF NOT EXISTS `PCH_test`.`PetType` (
  `petTypeId` INT NOT NULL AUTO_INCREMENT,
  `petSpec` VARCHAR(45) NOT NULL,
  `dropDownInd` TINYINT NULL,
  PRIMARY KEY (`petTypeId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PCH_test`.`PetStatus`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PCH_test`.`PetStatus` ;

CREATE TABLE IF NOT EXISTS `PCH_test`.`PetStatus` (
  `petStatusId` INT NOT NULL AUTO_INCREMENT,
  `petStatus` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`petStatusId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PCH_test`.`Pet`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PCH_test`.`Pet` ;

CREATE TABLE IF NOT EXISTS `PCH_test`.`Pet` (
  `petId` INT NOT NULL AUTO_INCREMENT,
  `petName` VARCHAR(45) NULL,
  `petChipTag` VARCHAR(45) NULL,
  `petRabiesTag` VARCHAR(45) NULL,
  `petDesc` VARCHAR(280) NOT NULL,
  `petBreed` VARCHAR(45) NULL,
  `petSize` VARCHAR(45) NOT NULL,
  `petColor` VARCHAR(45) NOT NULL,
  `petImgUrl` VARCHAR(100) NULL,
  `PetType_petTypeId` INT NOT NULL,
  `petCreateDate` DATE NULL,
  `petModifiedDate` DATE NULL,
  `petLostDate` DATE NULL,
  `petFoundDate` DATE NULL,
  `petSightedDate` DATE NULL,
  `PetStatus_petStatusId` INT NOT NULL,
  PRIMARY KEY (`petId`),
  UNIQUE INDEX `petChipTag_UNIQUE` (`petChipTag` ASC),
  UNIQUE INDEX `petRabiesTag_UNIQUE` (`petRabiesTag` ASC),
  INDEX `fk_Pet_PetType1_idx` (`PetType_petTypeId` ASC),
  INDEX `fk_Pet_PetStatus1_idx` (`PetStatus_petStatusId` ASC),
  CONSTRAINT `fk_Pet_PetType1`
    FOREIGN KEY (`PetType_petTypeId`)
    REFERENCES `PCH_test`.`PetType` (`petTypeId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pet_PetStatus1`
    FOREIGN KEY (`PetStatus_petStatusId`)
    REFERENCES `PCH_test`.`PetStatus` (`petStatusId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PCH_test`.`Location`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PCH_test`.`Location` ;

CREATE TABLE IF NOT EXISTS `PCH_test`.`Location` (
  `locId` INT NOT NULL AUTO_INCREMENT,
  `locLat` DECIMAL(9,6) NULL,
  `locLong` DECIMAL(9,6) NULL,
  `locName` VARCHAR(45) NULL,
  `locDesc` VARCHAR(280) NOT NULL,
  `locState` CHAR(2) NOT NULL,
  `locCity` VARCHAR(45) NULL,
  `locZip` VARCHAR(5) NULL,
  `locInd` CHAR(1) NOT NULL,
  PRIMARY KEY (`locId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PCH_test`.`User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PCH_test`.`User` ;

CREATE TABLE IF NOT EXISTS `PCH_test`.`User` (
  `userId` INT NOT NULL AUTO_INCREMENT,
  `userFirstName` VARCHAR(45) NOT NULL,
  `userLastName` VARCHAR(45) NOT NULL,
  `userLogin` VARCHAR(15) NOT NULL,
  `userState` CHAR(2) NOT NULL,
  `userCity` VARCHAR(45) NOT NULL,
  `userMobile` CHAR(10) NOT NULL,
  `userEmail` VARCHAR(60) NOT NULL,
  `userAltPhone` CHAR(10) NULL,
  `userAltEmail` VARCHAR(60) NULL,
  `userPassword` VARCHAR(15) NULL,
  `userZip` VARCHAR(5) NOT NULL,
  PRIMARY KEY (`userId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PCH_test`.`User_has_Pet`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PCH_test`.`User_has_Pet` ;

CREATE TABLE IF NOT EXISTS `PCH_test`.`User_has_Pet` (
  `User_userId` INT NOT NULL,
  `Pet_petId` INT NOT NULL,
  PRIMARY KEY (`User_userId`, `Pet_petId`),
  INDEX `fk_User_has_Pet_Pet1_idx` (`Pet_petId` ASC),
  INDEX `fk_User_has_Pet_User1_idx` (`User_userId` ASC),
  CONSTRAINT `fk_User_has_Pet_User1`
    FOREIGN KEY (`User_userId`)
    REFERENCES `PCH_test`.`User` (`userId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_has_Pet_Pet1`
    FOREIGN KEY (`Pet_petId`)
    REFERENCES `PCH_test`.`Pet` (`petId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PCH_test`.`Pet_has_User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PCH_test`.`Pet_has_User` ;

CREATE TABLE IF NOT EXISTS `PCH_test`.`Pet_has_User` (
  `Pet_petId` INT NOT NULL,
  `Pet_PetStatus_petStatusId` INT NOT NULL,
  `User_userId` INT NOT NULL,
  PRIMARY KEY (`Pet_petId`, `Pet_PetStatus_petStatusId`, `User_userId`),
  INDEX `fk_Pet_has_User_User1_idx` (`User_userId` ASC),
  INDEX `fk_Pet_has_User_Pet1_idx` (`Pet_petId` ASC, `Pet_PetStatus_petStatusId` ASC),
  CONSTRAINT `fk_Pet_has_User_Pet1`
    FOREIGN KEY (`Pet_petId`)
    REFERENCES `PCH_test`.`Pet` (`petId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pet_has_User_User1`
    FOREIGN KEY (`User_userId`)
    REFERENCES `PCH_test`.`User` (`userId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PCH_test`.`Pet_has_User1`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PCH_test`.`Pet_has_User` ;

CREATE TABLE IF NOT EXISTS `PCH_test`.`Pet_has_User` (
  `Pet_petId` INT NOT NULL,
  `User_userId` INT NOT NULL,
  PRIMARY KEY (`Pet_petId`, `User_userId`),
  INDEX `fk_Pet_has_User_User1_idx` (`User_userId` ASC),
  INDEX `fk_Pet_has_User_Pet1_idx` (`Pet_petId` ASC),
  CONSTRAINT `fk_Pet_has_User_Pet1`
    FOREIGN KEY (`Pet_petId`)
    REFERENCES `PCH_test`.`Pet` (`petId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pet_has_User_User1`
    FOREIGN KEY (`User_userId`)
    REFERENCES `PCH_test`.`User` (`userId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `PCH_test`.`Pet_has_Location`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `PCH_test`.`Pet_has_Location` ;

CREATE TABLE IF NOT EXISTS `PCH_test`.`Pet_has_Location` (
  `Pet_petId` INT NOT NULL,
  `Location_locId` INT NOT NULL,
  PRIMARY KEY (`Pet_petId`, `Location_locId`),
  INDEX `fk_Pet_has_Location_Location1_idx` (`Location_locId` ASC),
  INDEX `fk_Pet_has_Location_Pet1_idx` (`Pet_petId` ASC),
  CONSTRAINT `fk_Pet_has_Location_Pet1`
    FOREIGN KEY (`Pet_petId`)
    REFERENCES `PCH_test`.`Pet` (`petId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pet_has_Location_Location1`
    FOREIGN KEY (`Location_locId`)
    REFERENCES `PCH_test`.`Location` (`locId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

    
insert into PCH_test.pettype (petSpec, dropDownInd)
	values ('Dog', true),
		   ('Cat', true),
           ('Reptile', true),
           ('Farm Animals',  true),
           ('Bird', false),
           ('Other', false);
           
insert into PCH_test.PetStatus (petStatus) values ('LOST'), ('FOUND'), ('SIGHTED'), ('RETURNED');
