INSERT INTO `springit`.`link` (`id`, `created_by`, `creation_date`, `last_modified_date`,`last_modified_by`,`title`, `url`)
VALUES (1, null, NOW(), NOW(),null,'Getting started with spring boot 2', 'https://www.danvega.dev/docs/spring-boot-2-docs/#_mysql');

INSERT INTO `springit`.`comment` (`id`, `created_by`, `creation_date`, `last_modified_by`, `last_modified_date`, `body`, `link_id`)
VALUES ('1', null, NOW(), null, NOW(), 'This is a fucking course !!!!', 1);