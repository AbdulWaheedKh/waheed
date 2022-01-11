-- create Table account -- 

CREATE TABLE `account` (
	`Id` BIGINT(10) NOT NULL AUTO_INCREMENT,
	`Username` VARCHAR(100) NOT NULL,
	`Password` VARCHAR(100) NOT NULL,
	`CreatedDate` DATETIME NOT NULL,
	`ModifiedDate` DATETIME NOT NULL,
	`Deleted` BIT(1) NOT NULL DEFAULT b'0',
	PRIMARY KEY (`Id`)
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
;
