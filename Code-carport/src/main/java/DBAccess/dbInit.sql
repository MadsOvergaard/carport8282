-- noinspection SqlDialectInspectionForFile

-- noinspection SqlNoDataSourceInspectionForFile

Create database Carports;

use Carports;

create table Carport (
`carportOrdreID` int not null auto_increment,
`length` int not null,
`width` int not null,
`height` int not null,
`slope` boolean not null,
`roof` varchar(50) not null default "plasttrapezplader",
`slopeAngle` int not null default 0,
`shack` boolean not null,
`shackLength` int not null,
`shackWidth` int not null,
`cladding` varchar(50) not null,
primary key(`carportOrdreID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

  create table Materials (
 `materialID` int not null auto_increment,
 `materialType` varchar(30) not null,
 `materialLength` int not null,
 `materialWidth` int not null,
 `materialHeight` int not null,
 `materialDetail` varchar(100) not null,
 `price` double not null,
 primary key (`materialID`)
 )ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

 insert into Materials value
(1, "Trykimpregneret stolpe", 300, 97, 97, "Det er en stolpe som bestemmer højden, trykimpregneret", 39.0),
(2, "Spærtræ", 600, 45, 195, "Vandret planke som forbinder stolper, spærtræ", 36.38),
(3, "Spærtræ", 480, 45, 195, "Vandret planke som forbinder stolper, spærtræ", 36.38),
(4, "Spærtræ", 600, 45, 195, "Holder de to sider sammen, reglar.", 36.38),
(5, "Trykimpregneret brædt", 360, 25, 200, "Understernbræder", 39.0),
(6, "Trykimpregneret brædt", 540, 25, 200, "Understernbræder", 39.0),
(7, "Trykimpregneret brædt", 360, 25, 125, "Oversternbræder", 33.22),
(8, "Trykimpregneret brædt", 540, 25, 125, "Oversternbræder", 33.22),
(9, "Trykimpregneret brædt", 210, 19, 100, "Beklædning og vandbrædt", 27.45),
(10, "Trykimpregneret brædt", 360, 19, 100, "Beklædning og vandbrædt", 27.45),
(11, "Trykimpregneret brædt", 540, 19, 100, "Beklædning og vandbrædt", 27.45),
(12, "Reglar ub.", 270, 45, 95, "Remme i sider", 28.95),
(13, "Reglar ub.", 240, 45, 95, "Remme i sider", 28.95),
(14, "Lægte", 420, 38, 73, "Til z på bagsiden af døren", 31.0),
(15, "Søm", 0, 0, 0, "Holder sammen på lortet", 230.0),
(16, "Skruer", 0, 0, 0, "Holder sammen på lortet", 130.0),
(17, "Hulbånd", 0, 0, 0, "Holder to ting sammen", 559.0),
(18, "Bøgetræ - sort", 0, 0, 0, "Cladding", 600),
(19, "Bøgetræ - Hvid", 0, 0, 0, "Cladding", 600),
(20, "Bøgetræ - Træ", 0, 0, 0, "Cladding", 600),
(21, "Plastik - sort", 0, 0, 0, "Cladding", 600),
(22, "Plastik - Hvid", 0, 0, 0, "Cladding", 600),
(23, "Plastik - Træ", 0, 0, 0, "Cladding", 600),
(24, "Betontagsten Rød", 0, 0, 0, "Roof", 2000),
(25, "Betontagsten Teglrød", 0, 0, 0, "Roof", 2000),
(26, "Betontagsten Brun", 0, 0, 0, "Roof", 2000),
(27, "Betontagsten Sort", 0, 0, 0, "Roof", 2000),
(28, "Eternittag B6 Grå", 0, 0, 0, "Roof", 2000),
(29, "Eternittag B6 Sort", 0, 0, 0, "Roof", 2000),
(30, "Eternittag B6 Mokka", 0, 0, 0, "Roof", 2000),
(31, "Eternittag B6 Rødbrun", 0, 0, 0, "Roof", 2000),
(32, "Eternittag B6 Teglrød", 0, 0, 0, "Roof", 2000),
(33, "Eternittag B7 Grå", 0, 0, 0, "Roof", 2000),
(34, "Eternittag B7 Sort", 0, 0, 0, "Roof", 2000),
(35, "Eternittag B7 Mokka", 0, 0, 0, "Roof", 2000),
(36, "Eternittag B7 Rødbrun", 0, 0, 0, "Roof", 2000),
(37, "Eternittag B7 Teglrød", 0, 0, 0, "Roof", 2000),
(38, "Eternittag B7 Rødflammet", 0, 0, 0, "Roof", 2000),
(39, "plasttrapezplader", 0, 0, 0, "DefaultRoof", 1500),
(40, "Trykimpregneret brædt", 480, 25, 150, "vindskeder på rejsening", 44.33),
(41, "Trykimpregneret brædt", 540, 25, 150, "vindskeder på rejsening", 48.22),
(42, "Trykimpregneret brædt", 600, 25, 150, "vindskeder på rejsening", 52.22),
(43, "Trykimpregneret stolpe", 150, 97, 97, "Det er en stolpe som bestemmer højden, trykimpregneret", 39.0);