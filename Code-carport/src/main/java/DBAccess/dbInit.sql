-- noinspection SqlDialectInspectionForFile

-- noinspection SqlNoDataSourceInspectionForFile

Create database Carports;

use Carports;

create table Carport (
`length` int not null,
`width` int not null,
`height` int not null,
`slope` boolean not null,
`roof` varchar(50) not null default "plasttrapezplader",
`slopeAngle` int not null default 0,
`shack` boolean not null,
`shackLength` int not null,
`shackWidth` int not null,
`carportCladding` varchar(50) not null,
`shackCladding` varchar(50) not null
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

create table RoofType (
`roofID` int not null auto_increment,
`type` varchar(50) not null,
primary key (`roofID`)
)ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

insert into RoofType value
(1, "Betontagsten Rød"),
(2, "Betontagsten Teglrød"),
 (3, "Betontagsten Brun"),
 (4, "Betontagsten Sort"),
 (5, "Eternittag B6 Grå"),
 (6, "Eternittag B6 Sort"),
 (7, "Eternittag B6 Mokka"),
 (8, "Eternittag B6 Rødbrun"),
 (9, "Eternittag B6 Teglrød"),
 (10, "Eternittag B7 Grå"),
 (11, "Eternittag B7 Sort"),
 (12, "Eternittag B7 Mokka"),
 (13, "Eternittag B7 Rødbrun"),
 (14, "Eternittag B7 Teglrød"),
 (15, "Eternittag B7 Rødflammet");

 create table Mats (
 `MatsID` int not null auto_increment,
 `type` varchar(50) not null,
 primary key (`MatsID`)
 )ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

 insert into Mats value
 (1, "Bøgetræ - sort"),
 (2, "Bøgetræ - Hvid"),
 (3, "Bøgetræ - Træ"),
 (4, "Plastik - sort"),
 (5, "Plastik - Hvid"),
 (6, "Plastik - Træ");