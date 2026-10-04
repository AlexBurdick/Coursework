CREATE TABLE `orders` (
	`orderNumber`		int NOT NULL,
	`orderDate`			date NOT NULL,
	`requiredDate`		date NOT NULL,
	`shippedDate`		date DEFAULT NULL,
	`status`			varchar(15) NOT NULL,
	`comments`			text,
	`customerNumber`	int NOT NULL,

	PRIMARY KEY (`orderNumber`),
	FOREIGN KEY (`customerNumber`) REFERENCES `customers` (`customerNumber`)
) ENGINE=InnoDB;

CREATE TABLE `products` (
	`productCode`			varchar(15) NOT NULL,
	`productName`			varchar(70) NOT NULL,
	`productLine`			varchar(50) NOT NULL,
	`productScale`			varchar(10) NOT NULL,
	`productVendor`			varchar(50) NOT NULL,
	`productDescription`	text NOT NULL,
	`quantityInStock`		smallint NOT NULL,
	`buyPrice`				decimal(10,2) NOT NULL,
	`MSRP`					decimal(10,2) NOT NULL,

	PRIMARY KEY (`productCode`),
	FOREIGN KEY (`productLine`) REFERENCES `productlines` (`productLine`)
) ENGINE=InnoDB;


CREATE TABLE IF NOT EXISTS `orderdetails` (
	`orderNumber` 		INT NOT NULL,
	`productCode` 		VARCHAR(15) NOT NULL,
	`quantityOrdered` 	INT NOT NULL,
	`priceEach` 		DECIMAL(10,2) NOT NULL,
	`orderLineNumber` 	SMALLINT NOT NULL,

	PRIMARY KEY (`orderNumber`, `productCode`),

	FOREIGN KEY (`orderNumber`) REFERENCES `classicmodels`.`orders` (`orderNumber`),
	FOREIGN KEY (`productCode`) REFERENCES `classicmodels`.`products` (`productCode`)
)ENGINE = InnoDB;






