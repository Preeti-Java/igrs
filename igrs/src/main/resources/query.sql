INSERT INTO `igrsmain`.`roles` (`role_id`, `description`, `name`, `optcounter`) VALUES ('1', 'Root use, internally control by Neel for support', 'GHOST', '0');
INSERT INTO `igrsmain`.`roles` (`role_id`, `description`, `name`, `optcounter`) VALUES ('2', 'Control everything ', 'SUPERADMIN', '0');
INSERT INTO `igrsmain`.`roles` (`role_id`, `description`, `name`, `optcounter`) VALUES ('3', 'Control ', 'ADMIN', '0');
INSERT INTO `igrsmain`.`roles` (`role_id`, `description`, `name`, `optcounter`) VALUES ('4', 'Registered User', 'REGISTERED', '0');
INSERT INTO `igrsmain`.`roles` (`role_id`, `description`, `name`, `optcounter`) VALUES ('5', 'Visitor User', 'GUEST', '0');


INSERT INTO `igrsmain`.`member` (`member_id`, `state`, `type`) VALUES ('1', '1', 'O');
INSERT INTO `igrsmain`.`member` (`member_id`, `state`, `type`) VALUES ('2', '1', 'G');
INSERT INTO `igrsmain`.`member` (`member_id`, `state`, `type`) VALUES ('3', '1', 'U');


INSERT INTO `igrsmain`.`mbrrole` (`mbrrole_id`, `optcounter`, `member_id`, `role_id`, `user_id`) VALUES ('1', '0', '1', '1', '1');
INSERT INTO `igrsmain`.`mbrrole` (`mbrrole_id`, `optcounter`, `member_id`, `role_id`, `user_id`) VALUES ('2', '0', '1', '2', '2');
INSERT INTO `igrsmain`.`mbrrole` (`mbrrole_id`, `optcounter`, `member_id`, `role_id`, `user_id`) VALUES ('3', '0', '2', '3', '3');
INSERT INTO `igrsmain`.`mbrrole` (`mbrrole_id`, `optcounter`, `member_id`, `role_id`, `user_id`) VALUES ('4', '0', '3', '3', '4');
INSERT INTO `igrsmain`.`mbrrole` (`mbrrole_id`, `optcounter`, `member_id`, `role_id`, `user_id`) VALUES ('5', '0', '3', '4', '5');
INSERT INTO `igrsmain`.`mbrrole` (`mbrrole_id`, `optcounter`, `member_id`, `role_id`, `user_id`) VALUES ('6', '0', '3', '5', '6');

INSERT INTO `igrsmain`.`users` (`users_id`) VALUES ('1');
INSERT INTO `igrsmain`.`users` (`users_id`) VALUES ('2');
INSERT INTO `igrsmain`.`users` (`users_id`) VALUES ('3');
INSERT INTO `igrsmain`.`users` (`users_id`) VALUES ('4');
INSERT INTO `igrsmain`.`users` (`users_id`) VALUES ('5');
INSERT INTO `igrsmain`.`users` (`users_id`) VALUES ('6');


INSERT INTO `igrsmain`.`users` (`users_id`, `registertype`,  `user_id`) VALUES ('1', 'S',  '1');
INSERT INTO `igrsmain`.`users` (`users_id`, `registertype`,  `user_id`) VALUES ('2', 'S',  '2');
INSERT INTO `igrsmain`.`users` (`users_id`, `registertype`,  `user_id`) VALUES ('3', 'A',  '3');
INSERT INTO `igrsmain`.`users` (`users_id`, `registertype`,  `user_id`) VALUES ('4', 'A',  '4');
INSERT INTO `igrsmain`.`users` (`users_id`, `registertype`,  `user_id`) VALUES ('5', 'R',  '5');
INSERT INTO `igrsmain`.`users` (`users_id`, `registertype`,  `user_id`) VALUES ('6', 'G',  '6');

 update igrsmain.users set registration = "2023-06-01 01:15:00"  where users_id=5;
 
 ALTER TABLE igrsmain.userreg ALTER updated_at SET DEFAULT 0;
 ALTER TABLE igrsmain.userreg ALTER created_at SET DEFAULT 0;
 
 INSERT INTO `igrsmain`.`userreg` (`users_id`, `optcounter`, `logonid`, `logonpassword`, `status`) VALUES ('1', '0', 'root', '1234', '1');
INSERT INTO `igrsmain`.`userreg` (`users_id`, `optcounter`, `logonid`, `status`) VALUES ('2', '0', 'CHIPS', '1');
INSERT INTO `igrsmain`.`userreg` (`users_id`, `optcounter`, `logonid`, `status`) VALUES ('3', '0', 'KawardhaDistrictAdmin', '1');
INSERT INTO `igrsmain`.`userreg` (`users_id`, `optcounter`, `logonid`, `status`) VALUES ('4', '0', 'kawardhasruser', '1');
INSERT INTO `igrsmain`.`userreg` (`users_id`, `optcounter`, `logonid`, `status`) VALUES ('5', '0', 'Preeti', '1');
INSERT INTO `igrsmain`.`userreg` (`users_id`, `optcounter`, `logonid`, `status`) VALUES ('6', '0', 'Kamal', '1');
 
 
UPDATE `igrsmain`.`userreg` SET `logonpassword` = '1234' WHERE (`users_id` = '2');
UPDATE `igrsmain`.`userreg` SET `logonpassword` = '1234' WHERE (`users_id` = '3');
UPDATE `igrsmain`.`userreg` SET `logonpassword` = '1234' WHERE (`users_id` = '4');
UPDATE `igrsmain`.`userreg` SET `logonpassword` = '1234' WHERE (`users_id` = '5');
UPDATE `igrsmain`.`userreg` SET `logonpassword` = '1234' WHERE (`users_id` = '6');

INSERT INTO `igrsmain`.`userdemo` (`users_id`, `age`, `companyname`, `gender`, `optcounter`, `user_id`) VALUES ('1', '0', 'Neel Data', 'O', '0', '1');

INSERT INTO `igrsmain`.`userdemo` (`users_id`, `age`, `companyname`, `gender`, `optcounter`, `user_id`) VALUES ('2', '0', 'CG', 'O', '0', '2');
INSERT INTO `igrsmain`.`userdemo` (`users_id`, `age`, `companyname`, `gender`, `optcounter`, `user_id`) VALUES ('3', '0', 'CG', 'O', '0', '3');
INSERT INTO `igrsmain`.`userdemo` (`users_id`, `age`, `companyname`, `gender`, `optcounter`, `user_id`) VALUES ('4', '0', 'CG', 'O', '0', '4');
INSERT INTO `igrsmain`.`userdemo` (`users_id`, `age`, `companyname`, `gender`, `optcounter`, `user_id`) VALUES ('5', '0', 'NONE', 'F', '0', '5');
INSERT INTO `igrsmain`.`userdemo` (`users_id`, `age`, `companyname`, `gender`, `optcounter`, `user_id`) VALUES ('6', '0', 'NONE', 'M', '0', '6');

 # privilege_id, description, name, optcounter
'1', 'Only Read Authority', 'READ', '0'
'2', 'Read and Write Authority', 'WRITE', '0'
'3', 'Read, Write, Edit Authority', 'UPDATE', '0'
'4', 'Delete Authroity', 'DELETE', '0'
'5', 'Download Authroity', 'DOWNLOAD', '0'


INSERT INTO `igrsmain`.`roleprivilege` (`roleprivilege_id`, `privilege_id`, `role_id`) VALUES ('1', '1', '1');
INSERT INTO `igrsmain`.`roleprivilege` (`roleprivilege_id`, `privilege_id`, `role_id`) VALUES ('2', '2', '1');
INSERT INTO `igrsmain`.`roleprivilege` (`roleprivilege_id`, `privilege_id`, `role_id`) VALUES ('3', '3', '1');
INSERT INTO `igrsmain`.`roleprivilege` (`roleprivilege_id`, `privilege_id`, `role_id`) VALUES ('4', '4', '1');
INSERT INTO `igrsmain`.`roleprivilege` (`roleprivilege_id`, `privilege_id`, `role_id`) VALUES ('5', '5', '1');
INSERT INTO `igrsmain`.`roleprivilege` (`roleprivilege_id`, `privilege_id`, `role_id`) VALUES ('6', '1', '2');
INSERT INTO `igrsmain`.`roleprivilege` (`roleprivilege_id`, `privilege_id`, `role_id`) VALUES ('7', '2', '2');
INSERT INTO `igrsmain`.`roleprivilege` (`roleprivilege_id`, `privilege_id`, `role_id`) VALUES ('8', '3', '2');
INSERT INTO `igrsmain`.`roleprivilege` (`roleprivilege_id`, `privilege_id`, `role_id`) VALUES ('9', '5', '2');
INSERT INTO `igrsmain`.`roleprivilege` (`roleprivilege_id`, `privilege_id`, `role_id`) VALUES ('10', '1', '3');
INSERT INTO `igrsmain`.`roleprivilege` (`roleprivilege_id`, `privilege_id`, `role_id`) VALUES ('11', '2', '3');
INSERT INTO `igrsmain`.`roleprivilege` (`roleprivilege_id`, `privilege_id`, `role_id`) VALUES ('12', '3', '3');
INSERT INTO `igrsmain`.`roleprivilege` (`roleprivilege_id`, `privilege_id`, `role_id`) VALUES ('13', '5', '3');
INSERT INTO `igrsmain`.`roleprivilege` (`roleprivilege_id`, `privilege_id`, `role_id`) VALUES ('14', '1', '4');
INSERT INTO `igrsmain`.`roleprivilege` (`roleprivilege_id`, `privilege_id`, `role_id`) VALUES ('15', '2', '4');
INSERT INTO `igrsmain`.`roleprivilege` (`roleprivilege_id`, `privilege_id`, `role_id`) VALUES ('16', '3', '4');
INSERT INTO `igrsmain`.`roleprivilege` (`roleprivilege_id`, `privilege_id`, `role_id`) VALUES ('17', '5', '4');
INSERT INTO `igrsmain`.`roleprivilege` (`roleprivilege_id`, `privilege_id`, `role_id`) VALUES ('18', '1', '5');


INSERT INTO `igrsmain`.`menu` (`menu_id`, `description`, `en_label`, `hi_label`, `optcounter`) VALUES ('1', 'Deshboard', 'Home', '', '0');
INSERT INTO `igrsmain`.`menu` (`menu_id`, `description`, `en_label`, `hi_label`, `optcounter`) VALUES ('2', 'Service Provided By Software', 'E-Service', '', '0');
INSERT INTO `igrsmain`.`menu` (`menu_id`, `description`, `en_label`, `hi_label`, `optcounter`) VALUES ('3', 'Various Option For Searching Deed', 'Search Deed', '', '0');
INSERT INTO `igrsmain`.`menu` (`menu_id`, `description`, `en_label`, `hi_label`, `optcounter`) VALUES ('4', 'Contact', 'Contact', '', '0');


ALTER TABLE `igrsmain`.`menu` 
CHARACTER SET = utf8 , COLLATE = utf8_bin , ENGINE = InnoDB ;


ALTER TABLE `igrsmain`.`menu` 
COLLATE = utf8_general_ci ;

ALTER TABLE `igrsmain`.`menu` 
CHANGE COLUMN `hi_label` `hi_label` VARCHAR(255) NULL DEFAULT NULL ;

SET NAMES 'utf8mb4';
SET CHARACTER SET utf8mb4;

ALTER TABLE igrsmain.menu CHANGE hi_label hi_label VARCHAR(225) CHARSET utf8 COLLATE utf8_general_ci DEFAULT '' NOT NULL;

#System Restart


UPDATE `igrsmain`.`menu` SET `hi_label` = 'ई-सेवा' WHERE (`menu_id` = '2');
UPDATE `igrsmain`.`menu` SET `hi_label` = 'विलेख खोजे' WHERE (`menu_id` = '3');
UPDATE `igrsmain`.`menu` SET `hi_label` = 'संपर्क करे' WHERE (`menu_id` = '4');
INSERT INTO `igrsmain`.`menu` (`description`, `en_label`, `hi_label`, `optcounter`) VALUES ('Department Login', 'Department Login', 'विभाग लॉगिन', '0');


UPDATE `igrsmain`.`childmenu` SET `description` = 'View Registred Deed', `en_label` = 'View Registred Deed', `optcounter` = '0', `menu_id` = '2' WHERE (`childmenu_id` = '1');
UPDATE `igrsmain`.`childmenu` SET `hi_label` = 'पंजीकृत विलेख देखें' WHERE (`childmenu_id` = '1');
INSERT INTO `igrsmain`.`childmenu` (`childmenu_id`, `description`, `en_label`, `hi_label`, `optcounter`, `menu_id`) VALUES ('2', 'Download Registered Deed', 'Download Registered Deed', 'पंजीकृत विलेख डाउनलोड करें', '0', '2');
INSERT INTO `igrsmain`.`childmenu` (`childmenu_id`, `description`, `en_label`, `hi_label`, `optcounter`, `menu_id`) VALUES ('3', 'Dashboard', 'Dashboard', 'डैशबोर्ड', '0', '2');
INSERT INTO `igrsmain`.`childmenu` (`childmenu_id`, `description`, `en_label`, `hi_label`, `optcounter`, `menu_id`) VALUES ('4', 'By Owner Name', 'By Owner Name', 'मालिक के नाम से', '0', '3');
INSERT INTO `igrsmain`.`childmenu` (`childmenu_id`, `description`, `en_label`, `hi_label`, `optcounter`, `menu_id`) VALUES ('5', 'By Village Name', 'By Village Name', 'गांव के नाम से', '0', '3');
INSERT INTO `igrsmain`.`childmenu` (`childmenu_id`, `description`, `en_label`, `hi_label`, `optcounter`, `menu_id`) VALUES ('6', 'By Khasra No', 'By Khasra No', 'खसरा नं', '0', '3');
INSERT INTO `igrsmain`.`childmenu` (`childmenu_id`, `description`, `en_label`, `hi_label`, `optcounter`, `menu_id`) VALUES ('7', 'Headquarter', 'Headquarter', 'मुख्यालय ', '0', '4');
INSERT INTO `igrsmain`.`childmenu` (`childmenu_id`, `description`, `en_label`, `hi_label`, `optcounter`, `menu_id`) VALUES ('8', 'District Headquarter', 'District Headquarter', 'जिला मुख्यालय', '0', '4');
INSERT INTO `igrsmain`.`childmenu` (`childmenu_id`, `description`, `en_label`, `hi_label`, `optcounter`, `menu_id`) VALUES ('9', 'Sub-Registrar', 'Sub-Registrar', 'उप-पंजीयक', '0', '5');
INSERT INTO `igrsmain`.`childmenu` (`childmenu_id`, `description`, `en_label`, `hi_label`, `optcounter`, `menu_id`) VALUES ('10', 'District Manager', 'District Manager', 'जिला प्रबंधक', '0', '5');
INSERT INTO `igrsmain`.`childmenu` (`childmenu_id`, `description`, `en_label`, `hi_label`, `optcounter`, `menu_id`) VALUES ('11', 'Department', 'Department', 'विभाग', '0', '5');


UPDATE `igrsmain`.`userreg` SET `updated_at` = '2023-06-06 02:12:12';
UPDATE `igrsmain`.`userreg` SET `passwordcreation` = '2023-06-06 02:12:12';

UPDATE `igrsmain`.`member` SET `user_id` = '1' WHERE (`member_id` = '1');
UPDATE `igrsmain`.`member` SET `user_id` = '1' WHERE (`member_id` = '2');
UPDATE `igrsmain`.`member` SET `user_id` = '1' WHERE (`member_id` = '3');


Executing:
ALTER TABLE `igrsmain`.`userreg` 
CHANGE COLUMN `users_id` `users_id` BIGINT(20) NOT NULL AUTO_INCREMENT ;

SQL script was successfully applied to the database.

ALTER TABLE `igrsmain`.`userreg` 
CHANGE COLUMN `mobileno` `mobileno` VARCHAR(255) NULL DEFAULT 0 ;

 alter table userreg_roles add constraint FK2l8rxpeq4v291nuf4pl02vhyt foreign key (users_id) references USERREG (USERS_ID);
 create table userreg_roles (users_id bigint not null, role_Id bigint not null, primary key (users_id, role_Id)) ENGINE=MyISAM;


