DROP TABLE IF EXISTS bakery CASCADE;

CREATE TABLE bakery (
	id INTEGER AUTO_INCREMENT, 
	name VARCHAR(255),
	dietary VARCHAR(255), 
	product VARCHAR(255), 
	primary key (id)
	);