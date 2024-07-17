CREATE TABLE UserTable (
	id INT AUTO_INCREMENT PRIMARY KEY,
	emp_id VARCHAR(10) default 'abc',
	name VARCHAR(50),
	email VARCHAR(100) NOT NULL UNIQUE,
	phone_number VARCHAR(10) NOT NULL UNIQUE,
	password VARCHAR(50) NOT NULL,
	createdatetime TIMESTAMP,
	role_fid INT
);

create table Roles(
 id INT AUTO_INCREMENT PRIMARY KEY,
 role_name Varchar(20),
 role_description Varchar(20)
)