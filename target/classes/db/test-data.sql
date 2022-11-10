

insert into admin (username, password, phone_number, role, enabled) values ('User1', '$2a$10$zxvEq8XzYEYtNjbkRsJEbukHeRx3XS6MDXHMu8cNuNsRfZJWwswDy', '87026232102', 'ROLE_ADMIN', 1);

insert into consumer(first_name, last_name, address, last_meter_reading, region) values ( 'Beksultan1', 'Komekbay1', 'Aksai 3b', 0.00, 'AUEZOVSCKI' );
insert into consumer(first_name, last_name, address, last_meter_reading, region) values ( 'Beksultan2', 'Komekbay2', 'Aksai 3b', 0.00, 'AUEZOVSCKI' );
insert into consumer(first_name, last_name, address, last_meter_reading, region) values ( 'Beksultan3', 'Komekbay3', 'Aksai 3b', 0.00, 'BOSTANDIKSI' );
insert into consumer(first_name, last_name, address, last_meter_reading, region) values ( 'Beksultan4', 'Komekbay4', 'Aksai 3b', 0.00, 'BOSTANDIKSI' );
insert into consumer(first_name, last_name, address, last_meter_reading, region) values ( 'Beksultan5', 'Komekbay5', 'Aksai 3b', 0.00, 'MEDEUSKYI' );
insert into consumer(first_name, last_name, address, last_meter_reading, region) values ( 'Beksultan6', 'Komekbay6', 'Aksai 3b', 0.00, 'MEDEUSKYI' );

insert into region(name, first_lvl_payment, second_lvl_payment, third_lvl_payment) values ( 'AUEZOVSCKI', 17.53, 22.66, 28.32);
insert into region(name, first_lvl_payment, second_lvl_payment, third_lvl_payment) values ( 'ALMALINSKI', 17.53, 22.66, 28.32);
insert into region(name, first_lvl_payment, second_lvl_payment, third_lvl_payment) values ( 'TURKISIBSKI', 17.53, 22.66, 28.32);
insert into region(name, first_lvl_payment, second_lvl_payment, third_lvl_payment) values ( 'BOSTANDIKSI', 16.56, 24.62, 21.37);
insert into region(name, first_lvl_payment, second_lvl_payment, third_lvl_payment) values ( 'MEDEUSKYI', 14.54, 20.67, 24.30);
insert into region(name, first_lvl_payment, second_lvl_payment, third_lvl_payment) values ( 'NAURYZBAISKI', 14.54, 20.67, 24.30);


insert into bank_account(OWNER_FULL_NAME, OWNER_PERSONAL_ACCOUNT, MONEY, PAYMENT_FOR_THIS_MONTH) values ( 'Beksultan1 Komekbay1', 1, 0.00, false );
insert into bank_account(OWNER_FULL_NAME, OWNER_PERSONAL_ACCOUNT, MONEY, PAYMENT_FOR_THIS_MONTH) values ( 'Beksultan2 Komekbay2', 2, 0.00, false );
insert into bank_account(OWNER_FULL_NAME, OWNER_PERSONAL_ACCOUNT, MONEY, PAYMENT_FOR_THIS_MONTH) values ( 'Beksultan3 Komekbay3', 3, 0.00, false );
insert into bank_account(OWNER_FULL_NAME, OWNER_PERSONAL_ACCOUNT, MONEY, PAYMENT_FOR_THIS_MONTH) values ( 'Beksultan4 Komekbay4', 4, 0.00, false );
insert into bank_account(OWNER_FULL_NAME, OWNER_PERSONAL_ACCOUNT, MONEY, PAYMENT_FOR_THIS_MONTH) values ( 'Beksultan5 Komekbay5', 5, 0.00, false );
insert into bank_account(OWNER_FULL_NAME, OWNER_PERSONAL_ACCOUNT, MONEY, PAYMENT_FOR_THIS_MONTH) values ( 'Beksultan6 Komekbay6', 6, 0.00, false );


insert into inspector(FIRST_NAME, LAST_NAME, REGION, COST_OF_SERVICE,FREE) values ( 'Damir1','Agadil1', 'AUEZOVSCKI',2000, true );
insert into inspector(FIRST_NAME, LAST_NAME, REGION, COST_OF_SERVICE,FREE) values ( 'Damir2','Agadil2', 'ALMALINSKI',2500, true );
insert into inspector(FIRST_NAME, LAST_NAME, REGION, COST_OF_SERVICE,FREE) values ( 'Damir3','Agadil3', 'MEDEUSKYI',3000, false );

insert into doc (DOC_NAME, DOC_TYPE, DATA) values ('Johnss', 'text/plain', 01410101);

