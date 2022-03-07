DROP TABLE IF EXISTS bakery CASCADE;

CREATE TABLE bakery (
	id INTEGER AUTO_INCREMENT, 
	name VARCHAR(255),
	isvegan BOOL, 
	product VARCHAR(255), 
	primary key (id)
	);