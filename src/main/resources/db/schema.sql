

CREATE TABLE ADMIN (
                       ID INT NOT NULL AUTO_INCREMENT
    , USERNAME VARCHAR(60) NOT NULL
    , PASSWORD VARCHAR(64) NOT NULL
    , PHONE_NUMBER VARCHAR(60) NOT NULL
    , ROLE VARCHAR(45) NOT NULL
    , ENABLED tinyint(4) DEFAULT NULL
    ,PRIMARY KEY (ID)
);

CREATE TABLE CONSUMER (
      PERSONAL_ACCOUNT INT NOT NULL AUTO_INCREMENT
    , FIRST_NAME VARCHAR(15) NOT NULL
    , LAST_NAME VARCHAR(15) NOT NULL
    , ADDRESS VARCHAR(30) NOT NULL
    , LAST_METER_READING FLOAT NOT NULL
    , REGION VARCHAR(50) NOT NULL
    ,PRIMARY KEY (PERSONAL_ACCOUNT)
);

CREATE TABLE BANK_ACCOUNT (
                          ID INT NOT NULL AUTO_INCREMENT
    , OWNER_FULL_NAME VARCHAR(60) NOT NULL
    , OWNER_PERSONAL_ACCOUNT INT NOT NULL
    , MONEY FLOAT NOT NULL
    , PAYMENT_FOR_THIS_MONTH BOOLEAN DEFAULT FALSE
    ,PRIMARY KEY (ID)
);

CREATE TABLE INSPECTOR (
            ID INT NOT NULL AUTO_INCREMENT
    , FIRST_NAME VARCHAR(15) NOT NULL
    , LAST_NAME VARCHAR(15) NOT NULL
    , REGION VARCHAR(50) NOT NULL
    , COST_OF_SERVICE INT NOT NULL
    , FREE BOOLEAN NOT NULL
    , PRIMARY KEY (ID)
);

CREATE TABLE REGION (
      ID INT NOT NULL AUTO_INCREMENT
    , NAME VARCHAR(50) NOT NULL
    , FIRST_LVL_PAYMENT FLOAT NOT NULL
    , SECOND_LVL_PAYMENT FLOAT NOT NULL
    , THIRD_LVL_PAYMENT FLOAT NOT NULL
    ,PRIMARY KEY (ID)
);

CREATE TABLE DOC (
      ID INT NOT NULL AUTO_INCREMENT
    , DOC_NAME VARCHAR(60) NOT NULL
    , DOC_TYPE VARCHAR(60) NOT NULL
    , DATA binary NOT NULL
    ,PRIMARY KEY (ID)
);
