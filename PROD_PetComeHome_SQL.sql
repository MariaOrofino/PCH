-- -----------------------------------------------------
-- Schema PCH
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS PCH ;

-- -----------------------------------------------------
-- Schema PCH
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS PCH DEFAULT CHARACTER SET utf8 ;
USE PCH ;

-- -----------------------------------------------------
-- Table PCH.PetType
-- -----------------------------------------------------
DROP TABLE IF EXISTS PCH.PetType ;

CREATE TABLE IF NOT EXISTS PCH.PetType (
  petTypeId INT NOT NULL AUTO_INCREMENT,
  petSpec VARCHAR(45) NULL,
  other VARCHAR(45) NULL,
  PRIMARY KEY (petTypeId))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table PCH.Pet
-- -----------------------------------------------------
DROP TABLE IF EXISTS PCH.Pet ;

CREATE TABLE IF NOT EXISTS PCH.Pet (
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
    REFERENCES PCH.PetType (petTypeId)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table PCH.Location
-- -----------------------------------------------------
DROP TABLE IF EXISTS PCH.Location ;

CREATE TABLE IF NOT EXISTS PCH.Location (
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
-- Table PCH.User
-- -----------------------------------------------------
DROP TABLE IF EXISTS PCH.User ;

CREATE TABLE IF NOT EXISTS PCH.User (
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
-- Table PCH.Pet_has_Location
-- -----------------------------------------------------
DROP TABLE IF EXISTS PCH.Pet_has_Location ;

CREATE TABLE IF NOT EXISTS PCH.Pet_has_Location (
  Pet_petId INT NOT NULL,
  Location_locationId INT NOT NULL,
  PRIMARY KEY (Pet_petId, Location_locationId),
  INDEX fk_Pet_has_Location_Location1_idx (Location_locationId ASC),
  INDEX fk_Pet_has_Location_Pet1_idx (Pet_petId ASC),
  CONSTRAINT fk_Pet_has_Location_Pet1
    FOREIGN KEY (Pet_petId)
    REFERENCES PCH.Pet (petId)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Pet_has_Location_Location1
    FOREIGN KEY (Location_locationId)
    REFERENCES PCH.Location (locationId)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table PCH.User_has_Pet
-- -----------------------------------------------------
DROP TABLE IF EXISTS PCH.User_has_Pet ;

CREATE TABLE IF NOT EXISTS PCH.User_has_Pet (
  User_userId INT NOT NULL,
  Pet_petId INT NOT NULL,
  PRIMARY KEY (User_userId, Pet_petId),
  INDEX fk_User_has_Pet_Pet1_idx (Pet_petId ASC),
  INDEX fk_User_has_Pet_User1_idx (User_userId ASC),
  CONSTRAINT fk_User_has_Pet_User1
    FOREIGN KEY (User_userId)
    REFERENCES PCH.User (userId)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_User_has_Pet_Pet1
    FOREIGN KEY (Pet_petId)
    REFERENCES PCH.Pet (petId)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

