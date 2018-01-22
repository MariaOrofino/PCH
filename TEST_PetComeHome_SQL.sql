-- -----------------------------------------------------
-- Schema pch_test
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS pch_test ;

-- -----------------------------------------------------
-- Schema pch_test
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS pch_test DEFAULT CHARACTER SET utf8 ;
USE pch_test ;

-- -----------------------------------------------------
-- Table pch_test.PetType
-- -----------------------------------------------------
DROP TABLE IF EXISTS pch_test.PetType ;

CREATE TABLE IF NOT EXISTS pch_test.PetType (
  petTypeId INT NOT NULL AUTO_INCREMENT,
  petSpec VARCHAR(45) NOT NULL,
  dropDownInd TINYINT NULL,
  PRIMARY KEY (petTypeId));


-- -----------------------------------------------------
-- Table pch_test.PetStatus
-- -----------------------------------------------------
DROP TABLE IF EXISTS pch_test.PetStatus ;

CREATE TABLE IF NOT EXISTS pch_test.PetStatus (
  petStatusId INT NOT NULL AUTO_INCREMENT,
  petStatus VARCHAR(45) NOT NULL,
  PRIMARY KEY (petStatusId));


-- -----------------------------------------------------
-- Table pch_test.Pet
-- -----------------------------------------------------
DROP TABLE IF EXISTS pch_test.Pet ;

CREATE TABLE IF NOT EXISTS pch_test.Pet (
  petId INT NOT NULL AUTO_INCREMENT,
  petName VARCHAR(45) NULL,
  petChipTag VARCHAR(45) NULL,
  petRabiesTag VARCHAR(45) NULL,
  petDescripton VARCHAR(280) NOT NULL,
  petBreed VARCHAR(45) NULL,
  petSize VARCHAR(45) NOT NULL,
  petColor VARCHAR(45) NOT NULL,
  petImgUrl VARCHAR(100) NULL,
  PetType_petTypeId INT NOT NULL,
  petCreateDate DATE NULL,
  petModifiedDate DATE NULL,
  petLostDate DATE NULL,
  petFoundDate DATE NULL,
  petSightedDate DATE NULL,
  PetStatus_petStatusId INT NOT NULL,
  PRIMARY KEY (petId, PetStatus_petStatusId),
  UNIQUE INDEX petChipTag_UNIQUE (petChipTag ASC),
  UNIQUE INDEX petRabiesTag_UNIQUE (petRabiesTag ASC),
  INDEX fk_Pet_PetType1_idx (PetType_petTypeId ASC),
  INDEX fk_Pet_PetStatus1_idx (PetStatus_petStatusId ASC),
  CONSTRAINT fk_Pet_PetType1
    FOREIGN KEY (PetType_petTypeId)
    REFERENCES pch_test.PetType (petTypeId)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Pet_PetStatus1
    FOREIGN KEY (PetStatus_petStatusId)
    REFERENCES pch_test.PetStatus (petStatusId)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

-- -----------------------------------------------------
-- Table pch_test.Location
-- -----------------------------------------------------
DROP TABLE IF EXISTS pch_test.Location ;

CREATE TABLE IF NOT EXISTS pch_test.Location (
  locationId INT NOT NULL AUTO_INCREMENT,
  locLat DECIMAL(9,6) NULL,
  locLong DECIMAL(9,6) NULL,
  locName VARCHAR(45) NULL,
  locDescription VARCHAR(280) NOT NULL,
  locState CHAR(2) NOT NULL,
  locCity VARCHAR(45) NULL,
  locZip VARCHAR(5) NULL,
  locInd CHAR(1) NOT NULL,
  PRIMARY KEY (locationId));

-- -----------------------------------------------------
-- Table pch_test.User
-- -----------------------------------------------------
DROP TABLE IF EXISTS pch_test.User ;

CREATE TABLE IF NOT EXISTS pch_test.User (
  userId INT NOT NULL AUTO_INCREMENT,
  userFirstName VARCHAR(45) NOT NULL,
  userLastName VARCHAR(45) NOT NULL,
  userLogin VARCHAR(15) NOT NULL,
  userState CHAR(2) NOT NULL,
  userCity VARCHAR(45) NOT NULL,
  userMobile CHAR(10) NOT NULL,
  userEmail VARCHAR(60) NOT NULL,
  userAltPhone CHAR(10) NULL,
  userAltEmail VARCHAR(60) NULL,
  userPassword VARCHAR(15) NULL,
  userZip VARCHAR(5) NOT NULL,
  PRIMARY KEY (userId));


-- -----------------------------------------------------
-- Table pch_test.Pet_has_Location
-- -----------------------------------------------------
DROP TABLE IF EXISTS pch_test.Pet_has_Location ;

CREATE TABLE IF NOT EXISTS pch_test.Pet_has_Location (
  Pet_petId INT NOT NULL,
  Location_locationId INT NOT NULL,
  PRIMARY KEY (Pet_petId, Location_locationId),
  INDEX fk_Pet_has_Location_Location1_idx (Location_locationId ASC),
  INDEX fk_Pet_has_Location_Pet1_idx (Pet_petId ASC),
  CONSTRAINT fk_Pet_has_Location_Pet1
    FOREIGN KEY (Pet_petId)
    REFERENCES pch_test.Pet (petId)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Pet_has_Location_Location1
    FOREIGN KEY (Location_locationId)
    REFERENCES pch_test.Location (locationId)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table pch_test.User_has_Pet
-- -----------------------------------------------------
DROP TABLE IF EXISTS pch_test.User_has_Pet ;

CREATE TABLE IF NOT EXISTS pch_test.User_has_Pet (
  User_userId INT NOT NULL,
  Pet_petId INT NOT NULL,
  PRIMARY KEY (User_userId, Pet_petId),
  INDEX fk_User_has_Pet_Pet1_idx (Pet_petId ASC),
  INDEX fk_User_has_Pet_User1_idx (User_userId ASC),
  CONSTRAINT fk_User_has_Pet_User1
    FOREIGN KEY (User_userId)
    REFERENCES pch_test.User (userId)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_User_has_Pet_Pet1
    FOREIGN KEY (Pet_petId)
    REFERENCES pch_test.Pet (petId)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

insert into pch_test.pettype (petSpec, dropDownInd)
	values ('Dog', true),
		   ('Cat', true),
           ('Reptile', true),
           ('Farm Animals',  true),
           ('Bird', false),
           ('Other', false);
           
insert into pch_test.PetStatus (petStatus) values ('LOST'), ('FOUND'), ('SIGHTED'), ('RETURNED');
           
           
           