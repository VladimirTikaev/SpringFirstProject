CREATE TABLE `springftwr`.`users` (
  `id` BIGINT(20) NOT NULL, AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE);

INSERT INTO `springftwr`.`users` (`email`, `password`) VALUES ('test@mail.ru', '123');
INSERT INTO `springftwr`.`users` (`email`, `password`) VALUES ('new@mail.com', '555');
INSERT INTO `springftwr`.`users` (`email`, `password`) VALUES ('mm@mail.ru', '88');

CREATE TABLE `springftwr`.`roles` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE);



CREATE TABLE `springftwr`.`users_roles` (
  `user_id` BIGINT(20) NOT NULL,
  `role_id` BIGINT(20) NOT NULL,
  INDEX `fk_user_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_roles_idx` (`role_id` ASC) VISIBLE,
  CONSTRAINT `fk_users`
    FOREIGN KEY (`user_id`)
    REFERENCES `springftwr`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_roles`
    FOREIGN KEY (`role_id`)
    REFERENCES `springftwr`.`roles` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


INSERT INTO `springftwr`.`roles` (`name`) VALUES ('USER');
INSERT INTO `springftwr`.`roles` (`name`) VALUES ('MANAGER');
INSERT INTO `springftwr`.`roles` (`name`) VALUES ('ADMIN');

INSERT INTO `springftwr`.`users_roles` (`user_id`, `role_id`) VALUES ('1','1');
INSERT INTO `springftwr`.`users_roles` (`user_id`, `role_id`) VALUES ('1','2');

CREATE TABLE `springftwr`.`en_words` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `meaning` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `meaning_UNIQUE` (`meaning` ASC) VISIBLE);



CREATE TABLE `springftwr`.`ru_words` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `meaning` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `meaning_UNIQUE` (`meaning` ASC) VISIBLE);


CREATE TABLE `springftwr`.`cards` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `id_en_word` BIGINT(20) NOT NULL,
  `id_ru_word` BIGINT(20) NOT NULL,
  `rating` BIGINT(20) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_idx` (`id_en_word` ASC) VISIBLE,
  INDEX `fk_ru_word_idx` (`id_ru_word` ASC) VISIBLE,
  CONSTRAINT `fk_en_word`
    FOREIGN KEY (`id_en_word`)
    REFERENCES `springftwr`.`en_words` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ru_word`
    FOREIGN KEY (`id_ru_word`)
    REFERENCES `springftwr`.`ru_words` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



INSERT INTO `springftwr`.`en_words` (`meaning`) VALUES ('Hello');
INSERT INTO `springftwr`.`ru_words` (`meaning`) VALUES ('Привет');
INSERT INTO `springftwr`.`cards` (`id_en_word`,`id_ru_word`,`rating`) VALUES ('1', '1','1');
