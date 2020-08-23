CREATE DATABASE `jet_db`;

USE `jet_db`;

CREATE TABLE `JETS` (
  `manufacture_model_no` varchar(4) NOT NULL,
  `model_name` varchar(255) NOT NULL,
  `unit_price` varchar(255) NOT NULL,
  `passenger_seats` varchar(255) NOT NULL,
  `length` varchar(255)  NOT NULL,
  `height` varchar(255) NOT NULL,
  `wingspan` varchar(255) NOT NULL,
  `travel_range` varchar(255) NOT NULL,
  `speed` varchar(255) NOT NULL,
  `max_fuel_capacity` varchar(255) NOT NULL,
  PRIMARY KEY (`manufacture_model_no`)
);

INSERT INTO `JETS` VALUES
('JT01','Eclipse550','238.5million','12','63.66m','16.79m','60.30m','11750m','880km/hr','139090l');

INSERT INTO `JETS` VALUES
('JT02','PILATUS PC-12','250.5million','15','53.66m','16.79m','42.30m','1500m','750km/hr','129546l');

INSERT INTO `JETS` VALUES
('JT03','PHANTOM 350','560.5million','13','73.66m','15.79m','56.30m','1320m','960km/hr','149546l');

INSERT INTO `JETS` VALUES
('JT04','KING AIR 350i','320.5million','14','56.66m','14.79m','72.30m','1420m','960km/hr','135546l');




create table Orderdetails(
`order_id` int(5) NOT NULL,
`quotation_model_no` varchar(255) NOT NULL,
`customer_id` varchar(255) NOT NULL,
`customer_name` varchar(255) NOT NULL,
 `quantity` varchar(255) NOT NULL,
`price` varchar(255) NOT NULL,
`email` varchar(255) NOT NULL,
PRIMARY KEY(`order_id`)
);

