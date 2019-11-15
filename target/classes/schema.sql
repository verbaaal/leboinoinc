CREATE TABLE utilisateur

(
  id serial NOT NULL ,
  login varchar(45) DEFAULT NULL,
  password varchar(45) DEFAULT NULL,
  name varchar(45) DEFAULT NULL,
  adress varchar(45) DEFAULT NULL, 

 PRIMARY KEY (id)
);

CREATE TABLE annonce

(

 id serial NOT NULL ,

 title varchar(45) NOT NULL,

 description varchar(300) NOT NULL,

 date date NOT NULL,


 PRIMARY KEY (id)
);


