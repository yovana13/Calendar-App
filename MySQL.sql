
CREATE TABLE users_cale(
	id INT AUTO_INCREMENT PRIMARY KEY ,
	username VARCHAR(255) NOT NULL UNIQUE ,
    password VARCHAR(255) NOT NULL ,
    firstName VARCHAR(255) NOT NULL ,
    LastName VARCHAR(255) NOT NULL ,
    city VARCHAR(255) NOT NULL ,
    dateOfBirthday DATE NOT NULL 
);

CREATE TABLE events(
	id INT AUTO_INCREMENT PRIMARY KEY ,
	dateOfEvent DATE NOT NULL ,
    timeOfEvent TIME NULL ,
    title VARCHAR(255) NOT NULL ,
    location VARCHAR(255) NULL ,
    users_id INT NOT NULL , 
    CONSTRAINT FOREIGN KEY (users_id) 
		REFERENCES users_cale(id) 
);

INSERT INTO users_cale  
VALUES 	(NULL, 'ivan99', '123456', 'Ivan', 'Ivanov', 'Sofia', '1999-01-01') ,
		(NULL, 'martin_dimitrov', '987654', 'Martin', 'Dimitrov', 'Plovdiv', '1995-12-25') ,
		(NULL, 'dimitar2000', '000000', 'Dimitar', 'Dimitrov', 'Sofia', '2000-06-18') ,
		(NULL, 'ralica33', '123456789', 'Ralica', 'Vasileva', 'Varna', '1988-09-11') ,
		(NULL, 'iva_dimitrova', '123457', 'Iva', 'Dimitrova', 'Burgas', '2002-03-22') , 
		(NULL, 'preslava66', '654321', 'Preslava', 'Nikolova', 'Sofia', '1991-10-29');
        
INSERT INTO events  
VALUES 	(NULL, '2021-07-26', '11:00:00', 'To wash the car', NULL,2) ,
		(NULL, '2021-08-01', '12:00:00', 'Lunch with my wife', 'Happy Bar & Grill',1) ,
		(NULL, '2021-07-29', '19:00:00', 'Dinner with my colleagues', 'Paradise center',5) ,
		(NULL, '2021-07-31', '06:00:00', 'To walk my dog', 'Borisova gradina',4) ,
		(NULL, '2021-08-08', '16:00:00', 'To clean my room ', NULL,2) , 
		(NULL, '2022-07-24', '10:00:00', 'Coffee with my girlfriend Mimi', NULL,1);
        
INSERT INTO events  VALUES (NULL,'2021-07-26', '11:00:00', 'To wash the car','Garden',5);

UPDATE events SET title='Workout',location='Gymmmm' WHERE  users_id=1 and dateOfEvent='2021-08-01' and timeOfEvent='12:00:00';

