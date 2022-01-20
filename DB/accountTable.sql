CREATE TABLE `employe` (
	`id` BIGINT(20) NOT NULL,
	`firstname` VARCHAR(255) NULL DEFAULT NULL,
	`lastname` VARCHAR(255) NULL DEFAULT NULL,
	`salary` INT(11) NULL DEFAULT NULL,
	`CreatedDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`ModifiedDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`Deleted` BIT(1) NOT NULL DEFAULT b'0',
	PRIMARY KEY (`id`)
)
COLLATE='latin1_swedish_ci'
ENGINE=MyISAM
;



-- add delete column institute`--
ALTER TABLE `institute`
	ADD COLUMN `Deleted` BIT(1) NOT NULL DEFAULT b'0' AFTER `ModifiedDate`;
	
-- add delete column profile`--	
ALTER TABLE `profile`
	ADD COLUMN `Deleted` INT(1) NOT NULL DEFAULT '0' AFTER `ModifiedDate`;

