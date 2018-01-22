-- -----------------------------------------------------
-- Schema PCH_TEST
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS PCH_TEST ;

-- -----------------------------------------------------
-- Schema PCH_TEST
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS PCH_TEST DEFAULT CHARACTER SET utf8 ;
USE PCH_TEST ;

-- -----------------------------------------------------
-- Table PCH_TEST.PetType
-- -----------------------------------------------------
DROP TABLE IF EXISTS PCH_TEST.PetType ;

CREATE TABLE IF NOT EXISTS PCH_TEST.PetType (
  petTypeId INT NOT NULL AUTO_INCREMENT,
  petSpec VARCHAR(45) NULL,
  other VARCHAR(45) NULL,
  PRIMARY KEY (petTypeId))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table PCH_TEST.Pet
-- -----------------------------------------------------
DROP TABLE IF EXISTS PCH_TEST.Pet ;

CREATE TABLE IF NOT EXISTS PCH_TEST.Pet (
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
  PRIMARY KEY (petId),
  UNIQUE INDEX petChipTag_UNIQUE (petChipTag ASC),
  UNIQUE INDEX petRabiesTag_UNIQUE (petRabiesTag ASC),
  INDEX fk_Pet_PetType1_idx (PetType_petTypeId ASC),
  CONSTRAINT fk_Pet_PetType1
    FOREIGN KEY (PetType_petTypeId)
    REFERENCES PCH_TEST.PetType (petTypeId)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table PCH_TEST.Location
-- -----------------------------------------------------
DROP TABLE IF EXISTS PCH_TEST.Location ;

CREATE TABLE IF NOT EXISTS PCH_TEST.Location (
  locationId INT NOT NULL AUTO_INCREMENT,
  locLat DECIMAL(9,6) NULL,
  locLong DECIMAL(9,6) NULL,
  locName VARCHAR(45) NULL,
  locDescription VARCHAR(280) NOT NULL,
  locState CHAR(2) NOT NULL,
  locCity VARCHAR(45) NULL,
  locZip VARCHAR(5) NULL,
  locInd CHAR(1) NOT NULL,
  PRIMARY KEY (locationId))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table PCH_TEST.User
-- -----------------------------------------------------
DROP TABLE IF EXISTS PCH_TEST.User ;

CREATE TABLE IF NOT EXISTS PCH_TEST.User (
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
  PRIMARY KEY (userId))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table PCH_TEST.Pet_has_Location
-- -----------------------------------------------------
DROP TABLE IF EXISTS PCH_TEST.Pet_has_Location ;

CREATE TABLE IF NOT EXISTS PCH_TEST.Pet_has_Location (
  Pet_petId INT NOT NULL,
  Location_locationId INT NOT NULL,
  PRIMARY KEY (Pet_petId, Location_locationId),
  INDEX fk_Pet_has_Location_Location1_idx (Location_locationId ASC),
  INDEX fk_Pet_has_Location_Pet1_idx (Pet_petId ASC),
  CONSTRAINT fk_Pet_has_Location_Pet1
    FOREIGN KEY (Pet_petId)
    REFERENCES PCH_TEST.Pet (petId)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Pet_has_Location_Location1
    FOREIGN KEY (Location_locationId)
    REFERENCES PCH_TEST.Location (locationId)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table PCH_TEST.User_has_Pet
-- -----------------------------------------------------
DROP TABLE IF EXISTS PCH_TEST.User_has_Pet ;

CREATE TABLE IF NOT EXISTS PCH_TEST.User_has_Pet (
  User_userId INT NOT NULL,
  Pet_petId INT NOT NULL,
  PRIMARY KEY (User_userId, Pet_petId),
  INDEX fk_User_has_Pet_Pet1_idx (Pet_petId ASC),
  INDEX fk_User_has_Pet_User1_idx (User_userId ASC),
  CONSTRAINT fk_User_has_Pet_User1
    FOREIGN KEY (User_userId)
    REFERENCES PCH_TEST.User (userId)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_User_has_Pet_Pet1
    FOREIGN KEY (Pet_petId)
    REFERENCES PCH_TEST.Pet (petId)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

insert into pch_test.pettype (petSpec, other)
	values ('Dog', NULL),
		   ('Cat', NULL),
           ('Reptile', NULL),
           ('Farm Animals',  NULL),
           ('Other', 'Spider');
           
           
           