create database assetManagementDb;

use assetManagementDb;

CREATE TABLE Users (
    userId INT PRIMARY KEY AUTO_INCREMENT,
    firstName varchar(50) not null,
    lastName varchar(50) not null,
    email VARCHAR(100) UNIQUE not null,
    userRole varchar(10) NOT NULL,
    gender VARCHAR(6) not null,
    contactNumber VARCHAR(10) unique not null,
    address TEXT not null,
    check(userRole in('EMPLOYEE', 'ADMIN'))
);

CREATE TABLE Credential(
	userId int,
    userName varchar(20) not null unique,
    password varchar(20) not null,
    FOREIGN KEY (userId) REFERENCES Users(userId)
);

CREATE TABLE Asset (
    assetNo INT PRIMARY KEY AUTO_INCREMENT,
    assetName VARCHAR(100) not null,
    assetCategory varchar(20) not null,
    assetModel VARCHAR(100) not null,
    manufacturingDate DATE not null,
    expiryDate DATE,
    assetValue DECIMAL(10,2) not null,
    check (assetCategory in("Laptop","Furniture","Car","Gadget"))
);

CREATE TABLE AssetAllocation (
    allocationId INT PRIMARY KEY AUTO_INCREMENT,
    assetNo INT,
    userId INT,
    allocationDate DATE DEFAULT (CURRENT_DATE),
    returnDate DATE not null,
    FOREIGN KEY (assetNo) REFERENCES Asset(assetNo),
    FOREIGN KEY (userId) REFERENCES Users(userId)
);

CREATE TABLE ServiceRequests (
    requestId INT PRIMARY KEY AUTO_INCREMENT,
    assetNo INT,
    userId INT,
    assetDscription TEXT,
    issueType varchar(15) not null,
    requestStatus varchar(10) DEFAULT 'PENDING',
    requestedAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (assetNo) REFERENCES Asset(assetNo),
    FOREIGN KEY (userId) REFERENCES Users(userId),
    check(issueType in('MALFUNCTION', 'REPAIR')),
    check(requestStatus in('PENDING', 'VERIFIED', 'REJECTED')) 
);

CREATE TABLE AuditRequest (
    auditId INT PRIMARY KEY AUTO_INCREMENT,
    assetNo INT,
    userId INT,
    requestAt TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    requestStatus varchar(10) DEFAULT 'PENDING',
    FOREIGN KEY (assetNo) REFERENCES Asset(assetNo),
    FOREIGN KEY (userId) REFERENCES Users(userId),
    check(requestStatus in('PENDING', 'VERIFIED', 'REJECTED')) 
);
