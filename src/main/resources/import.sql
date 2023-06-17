INSERT INTO `uces_videos`.`user` (`enabled`, `id`, `username`, `password`) VALUES (1, 1, 'admin', '$2a$10$MtJ.LCpMv.O4hmlQvTngo.qSqoV4QIAViY6hzTVwv8UMre4TJ47ti');
INSERT INTO `uces_videos`.`user_role` (`id`,`user_id`,`role`) VALUES (1, 1, "ROLE_ADMIN");

INSERT INTO `uces_videos`.`user` (`enabled`, `id`, `username`, `password`) VALUES (1, 2, 'auditor', '$2a$10$SukpGU3.i8gSo/VW.IFJ8.p5L1qLiByT1AHVeyOMcaaWjDygB/Wta');
INSERT INTO `uces_videos`.`user_role` (`id`,`user_id`,`role`) VALUES (2, 2, "ROLE_AUDITOR");


INSERT INTO `uces_videos`.`avatar` (`id`, `email`, `web_personal`) VALUES ('1', 'csantander1993@gmail.com', 'www.cristian.com.ar');
INSERT INTO `uces_videos`.`persona` (`avatar_id`, `id`, `dni`, `apellido`, `nombres`) VALUES (1, 1, '11111111', 'Santander', 'Cristian');
INSERT INTO `uces_videos`.`avatar` (`id`, `email`, `web_personal`) VALUES ('2', 'kevin@gmail.com', 'www.kevin.com.ar');
INSERT INTO `uces_videos`.`persona` (`avatar_id`, `id`, `dni`, `apellido`, `nombres`) VALUES (2, 2, '22222222', 'Oviedo', 'Kevin');
INSERT INTO `uces_videos`.`avatar` (`id`, `email`, `web_personal`) VALUES ('3', 'juan@gmail.com', 'www.juan.com.ar');
INSERT INTO `uces_videos`.`persona` (`avatar_id`, `id`, `dni`, `apellido`, `nombres`) VALUES (3, 3, '33333333', 'Pico', 'Juan');
INSERT INTO `uces_videos`.`avatar` (`id`, `email`, `web_personal`) VALUES ('4', 'ezequiel@gmail.com', 'www.eze.com.ar');
INSERT INTO `uces_videos`.`persona` (`avatar_id`, `id`, `dni`, `apellido`, `nombres`) VALUES (4, 4, '44444444', 'Salgueiro', 'Ezequiel');
INSERT INTO `uces_videos`.`avatar` (`id`, `email`, `web_personal`) VALUES ('5', 'Belen@gmail.com', 'www.belen.com.ar');
INSERT INTO `uces_videos`.`persona` (`avatar_id`, `id`, `dni`, `apellido`, `nombres`) VALUES (5, 5, '55555555', 'Renda', 'Belen');
INSERT INTO `uces_videos`.`avatar` (`id`, `email`, `web_personal`) VALUES ('6', 'Facu@gmail.com', 'www.facundo.com.ar');
INSERT INTO `uces_videos`.`persona` (`avatar_id`, `id`, `dni`, `apellido`, `nombres`) VALUES (6, 6, '66666666', 'Lopez', 'Facundo');