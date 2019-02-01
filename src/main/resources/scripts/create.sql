create table IF NOT EXISTS OWNER(
	codOwner INT IDENTITY,
	name varchar(25),
	surname varchar(25),
	PRIMARY KEY (codOwner)
);

create table IF NOT EXISTS HOUSE(
	codHouse INT IDENTITY,
	direction varchar(50),
	PRIMARY KEY (codHouse)
);

create table IF NOT EXISTS OWNERHOUSE(
	codOwner INT,
	codHouse INT,
	typeHouse varchar(25),
	PRIMARY KEY (codOwner, codHouse),
	FOREIGN KEY (codOwner) REFERENCES OWNER(codOwner),
	FOREIGN KEY (codHouse) REFERENCES HOUSE(codHouse)
);

create table IF NOT EXISTS PET(
	petName varchar(25),
	codOwner INT,
	PRIMARY KEY (petName),
	FOREIGN KEY (codOwner) REFERENCES OWNER(codOwner)
);