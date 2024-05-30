/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 100424
 Source Host           : localhost:3306
 Source Schema         : proyecto_clinica

 Target Server Type    : MySQL
 Target Server Version : 100424
 File Encoding         : 65001

 Date: 04/12/2023 23:14:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ambulancia
-- ----------------------------
DROP TABLE IF EXISTS `ambulancia`;
CREATE TABLE `ambulancia`  (
  `ambulancia` int NOT NULL AUTO_INCREMENT,
  `marca` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `modelo` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `anio_fabricacion` int NOT NULL,
  `placa` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `id_tipo_ambulancia` int NOT NULL,
  PRIMARY KEY (`ambulancia`) USING BTREE,
  INDEX `fk_id_tipo_ambulancia`(`id_tipo_ambulancia` ASC) USING BTREE,
  CONSTRAINT `fk_id_tipo_ambulancia` FOREIGN KEY (`id_tipo_ambulancia`) REFERENCES `tipo_ambulancia` (`id_tipo_ambulancia`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ambulancia
-- ----------------------------
INSERT INTO `ambulancia` VALUES (1, 'Nissan', 'N432', 2014, 'P217-67', 2);
INSERT INTO `ambulancia` VALUES (2, 'Toyota', 'N345', 2012, 'P342-43', 1);
INSERT INTO `ambulancia` VALUES (3, 'Nissan', 'N432', 2014, 'P654-54', 3);
INSERT INTO `ambulancia` VALUES (4, 'Nissan', 'N436', 2011, 'P543-23', 2);
INSERT INTO `ambulancia` VALUES (5, 'Toyota', 'Y432', 2013, 'P343-65', 1);
INSERT INTO `ambulancia` VALUES (6, 'Nissan', 'Urvan', 2013, 'P422-23', 2);
INSERT INTO `ambulancia` VALUES (7, 'Ford', 'MedTec', 2015, 'P234-53', 3);
INSERT INTO `ambulancia` VALUES (8, 'Toyota', 'Hiace', 2010, 'P543-65', 2);
INSERT INTO `ambulancia` VALUES (9, 'Ford', 'E4434', 2016, 'P243-45', 1);
INSERT INTO `ambulancia` VALUES (10, 'Toyota', 'K3434', 2017, 'P334-54', 3);

-- ----------------------------
-- Table structure for antecedente
-- ----------------------------
DROP TABLE IF EXISTS `antecedente`;
CREATE TABLE `antecedente`  (
  `antecedente` int NOT NULL AUTO_INCREMENT,
  `medico` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `quirurgico` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `alergico` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `ginecoobstetrico` int NULL DEFAULT NULL,
  PRIMARY KEY (`antecedente`) USING BTREE,
  INDEX `ginecoobstetrico`(`ginecoobstetrico` ASC) USING BTREE,
  CONSTRAINT `antecedente_ibfk_1` FOREIGN KEY (`ginecoobstetrico`) REFERENCES `ginecoobstetrico` (`ginecoobstetrico`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of antecedente
-- ----------------------------
INSERT INTO `antecedente` VALUES (1, 'Azucar en la sangre', 'Apendisectomia', 'Mani', NULL);
INSERT INTO `antecedente` VALUES (2, 'Migraña', 'Cirugía de Brazo', 'Mariscos', NULL);
INSERT INTO `antecedente` VALUES (3, NULL, NULL, NULL, NULL);
INSERT INTO `antecedente` VALUES (4, 'Hipertension', 'Cirugía de Cataratas', NULL, NULL);
INSERT INTO `antecedente` VALUES (5, 'Azucar en la sangre', 'Apendisectomia', 'Mani', NULL);
INSERT INTO `antecedente` VALUES (6, NULL, NULL, NULL, NULL);
INSERT INTO `antecedente` VALUES (7, NULL, NULL, NULL, NULL);
INSERT INTO `antecedente` VALUES (8, 'hipertensión arterial', 'Litiasis Vesicular', 'Lacteos', NULL);
INSERT INTO `antecedente` VALUES (9, '', '', NULL, 1);
INSERT INTO `antecedente` VALUES (10, 'Dorsalgia crónica', NULL, NULL, NULL);
INSERT INTO `antecedente` VALUES (11, '', 'Apendisectomia', 'Mariscos', NULL);
INSERT INTO `antecedente` VALUES (12, NULL, 'Litiasis Vesicula', 'Mariscos', NULL);
INSERT INTO `antecedente` VALUES (13, 'Hipertensión', NULL, NULL, NULL);
INSERT INTO `antecedente` VALUES (14, 'Hipertension', 'Lisitasis Vesicula', 'Frutos secos', NULL);
INSERT INTO `antecedente` VALUES (15, 'no', 'no', 'no', 2);
INSERT INTO `antecedente` VALUES (16, 'nose', 'nose', 'nose', 3);
INSERT INTO `antecedente` VALUES (17, 'no hay', 'no hay', 'no hay', 4);
INSERT INTO `antecedente` VALUES (18, 'Apendisectomia lateral', 'nose', 'al mani', 5);
INSERT INTO `antecedente` VALUES (19, 'ninguno', 'ninguno', 'ningun', 6);
INSERT INTO `antecedente` VALUES (20, 'no', 'no', 'no', NULL);
INSERT INTO `antecedente` VALUES (21, 'no', 'no', 'talvez', NULL);
INSERT INTO `antecedente` VALUES (22, 'Diabetes', 'Apendisectomia lateral', 'Mani', NULL);
INSERT INTO `antecedente` VALUES (23, 'no tiene', 'no tiene ', 'no tiene', NULL);
INSERT INTO `antecedente` VALUES (24, 'no tiene', 'no tiene', 'no tiene', NULL);
INSERT INTO `antecedente` VALUES (25, 'no tiene', 'no tiene', 'no tiene', NULL);
INSERT INTO `antecedente` VALUES (26, 'no tiene ', 'no tiene', 'no tiene', NULL);
INSERT INTO `antecedente` VALUES (27, 'no hay', 'no hay', ' no hay', NULL);
INSERT INTO `antecedente` VALUES (28, 'no tiene', 'no tiene', 'no tiene', NULL);
INSERT INTO `antecedente` VALUES (29, 'ni idea', 'ni idea', 'ni idea', NULL);
INSERT INTO `antecedente` VALUES (30, 'no se ', 'no se ', 'no se ', NULL);
INSERT INTO `antecedente` VALUES (31, 'no', 'no', 'no', NULL);
INSERT INTO `antecedente` VALUES (32, 'no', 'no', 'no', NULL);
INSERT INTO `antecedente` VALUES (33, 'no', 'no', 'no', NULL);
INSERT INTO `antecedente` VALUES (34, 'noo', 'no', 'no', NULL);

-- ----------------------------
-- Table structure for conductor
-- ----------------------------
DROP TABLE IF EXISTS `conductor`;
CREATE TABLE `conductor`  (
  `conductor` int NOT NULL AUTO_INCREMENT,
  `dui` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `nombre` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `genero` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `numero_licencia` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `licencia` int NOT NULL,
  PRIMARY KEY (`conductor`) USING BTREE,
  INDEX `licencia`(`licencia` ASC) USING BTREE,
  CONSTRAINT `conductor_ibfk_1` FOREIGN KEY (`licencia`) REFERENCES `licencia` (`licencia`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of conductor
-- ----------------------------
INSERT INTO `conductor` VALUES (1, '44324145-3', 'Juan Martinez', 'm', '54376543-5', 3);
INSERT INTO `conductor` VALUES (2, '91352745-3', 'Pedro Flores', 'm', '45678342-3', 1);
INSERT INTO `conductor` VALUES (3, '44352175-2', 'Guillermo Ochoa', 'm', '56428654-8', 1);
INSERT INTO `conductor` VALUES (4, '59352745-6', 'Federico Aguilar', 'm', '87545436-4', 2);
INSERT INTO `conductor` VALUES (5, '00352745-2', 'Rafael Mora', 'm', '76444532-6', 2);
INSERT INTO `conductor` VALUES (6, '40352745-0', 'Camila Lugo', 'f', '65443453-3', 3);
INSERT INTO `conductor` VALUES (7, '81092892-1', 'Victoria Contreras', 'f', '54323453-2', 1);
INSERT INTO `conductor` VALUES (8, '89247512-1', 'Valentina Silva', 'f', '76554454-1', 3);
INSERT INTO `conductor` VALUES (9, '44112745-1', 'Renata Castillo', 'f', '65334643-3', 2);
INSERT INTO `conductor` VALUES (10, '61352745-5', 'Esteban Velasco', 'm', '87753431-9', 1);
INSERT INTO `conductor` VALUES (12, '        - ', 'xwdw', 'Femenino', '        - ', 1);
INSERT INTO `conductor` VALUES (13, '        - ', 'ererf', 'Femenino', '        - ', 1);

-- ----------------------------
-- Table structure for conductor_ambulancia
-- ----------------------------
DROP TABLE IF EXISTS `conductor_ambulancia`;
CREATE TABLE `conductor_ambulancia`  (
  `conductor_ambulancia` int NOT NULL AUTO_INCREMENT,
  `ambulancia` int NOT NULL,
  `conductor` int NOT NULL,
  PRIMARY KEY (`conductor_ambulancia`) USING BTREE,
  INDEX `ambulancia`(`ambulancia` ASC) USING BTREE,
  INDEX `conductor`(`conductor` ASC) USING BTREE,
  CONSTRAINT `conductor_ambulancia_ibfk_1` FOREIGN KEY (`ambulancia`) REFERENCES `ambulancia` (`ambulancia`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `conductor_ambulancia_ibfk_2` FOREIGN KEY (`conductor`) REFERENCES `conductor` (`conductor`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of conductor_ambulancia
-- ----------------------------
INSERT INTO `conductor_ambulancia` VALUES (1, 3, 5);
INSERT INTO `conductor_ambulancia` VALUES (2, 5, 1);
INSERT INTO `conductor_ambulancia` VALUES (3, 2, 8);
INSERT INTO `conductor_ambulancia` VALUES (4, 1, 4);
INSERT INTO `conductor_ambulancia` VALUES (5, 8, 2);
INSERT INTO `conductor_ambulancia` VALUES (6, 1, 6);

-- ----------------------------
-- Table structure for consulta
-- ----------------------------
DROP TABLE IF EXISTS `consulta`;
CREATE TABLE `consulta`  (
  `consulta` int NOT NULL AUTO_INCREMENT,
  `doc_especialidad` int NOT NULL,
  `fecha_consulta` date NOT NULL,
  `consulta_por` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `presenta_enfermedad` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `diagnostico` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `cita_control` date NULL DEFAULT NULL,
  `cita_seguimiento` date NULL DEFAULT NULL,
  `antecedente` int NOT NULL,
  `hoja_inscripcion` int NOT NULL,
  `hoja_enfermeria` int NOT NULL,
  PRIMARY KEY (`consulta`) USING BTREE,
  INDEX `doc_especialidad`(`doc_especialidad` ASC) USING BTREE,
  INDEX `antecedente`(`antecedente` ASC) USING BTREE,
  INDEX `hoja_inscripcion`(`hoja_inscripcion` ASC) USING BTREE,
  INDEX `hoja_enfermeria`(`hoja_enfermeria` ASC) USING BTREE,
  CONSTRAINT `consulta_ibfk_1` FOREIGN KEY (`doc_especialidad`) REFERENCES `doc_especialidad` (`doc_especialidad`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `consulta_ibfk_2` FOREIGN KEY (`antecedente`) REFERENCES `antecedente` (`antecedente`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `consulta_ibfk_3` FOREIGN KEY (`hoja_inscripcion`) REFERENCES `hoja_inscripcion` (`codigo_inscripcion`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `consulta_ibfk_4` FOREIGN KEY (`hoja_enfermeria`) REFERENCES `hoja_enfermeria` (`hoja_enfermeria`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 58 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of consulta
-- ----------------------------
INSERT INTO `consulta` VALUES (1, 1, '2023-11-25', 'Me duele el oido', 'Me fui a bañar y se me metio agua en los oidos', 'otitis externa', NULL, '2023-12-02', 1, 1, 1);
INSERT INTO `consulta` VALUES (2, 1, '2023-11-25', 'Me cai de un palo', 'Estaba cortando unas ramas y me cai del palo y me golpie la espalda', 'Lesión Traumática en la Columna Vertebral', NULL, '2023-12-02', 2, 2, 2);
INSERT INTO `consulta` VALUES (3, 4, '2023-11-25', 'Me mordio un perro la pierna', 'Iba caminando para mi casa cuando el perro del vecino me salio siguiendo y me mordio en el pie', 'Herida Cortante por Mordedura de Perro', '2023-12-02', NULL, 3, 3, 3);
INSERT INTO `consulta` VALUES (4, 2, '2023-11-25', 'Me duele el estomago', 'Comi unas pupusas que me cayeron mal y me llamo al baño todo el dia', 'gastroenteritis', NULL, '2023-12-02', 4, 4, 4);
INSERT INTO `consulta` VALUES (5, 4, '2023-11-25', 'Me queme la mano', 'Estaba cocinando y agarre la tapa que estaba caliente', 'Quemadura de Primer Grado', NULL, '2023-11-29', 5, 5, 5);
INSERT INTO `consulta` VALUES (6, 3, '2023-11-25', 'Me quebre la mano', 'Iba bajando las escaleras y me tropeze y cai sobre mi cuerpo', 'Fractura de la Mano', '2023-11-28', NULL, 6, 6, 6);
INSERT INTO `consulta` VALUES (8, 6, '2023-11-25', 'Me duele el estomago', 'Me duele el estomago como si tuviera un colico', 'Apendicitis', NULL, NULL, 7, 7, 7);
INSERT INTO `consulta` VALUES (10, 2, '2023-11-25', 'No aguanto la cabeza', 'Me duele todo el tiempo es como que tuviera agujas en la parte detras de la cabeza', 'cefalea occipital\"', '2023-12-02', NULL, 8, 8, 8);
INSERT INTO `consulta` VALUES (12, 4, '2023-11-25', 'Tengo nauseas', 'Siempre que intento comer algo lo vomito, aveces solo oler cosas me dan ganas de vomitar, y ultimamento tengo demasiado sueño todo el tiempo', 'Embarazo', '2023-11-27', NULL, 9, 9, 9);
INSERT INTO `consulta` VALUES (13, 2, '2023-11-25', 'Me duele la espalda', 'Me duele desde que me cai desde una escalera y me golpee la espalda', 'Dorsalgia asociada a hernia discal', NULL, '2023-12-09', 10, 10, 10);
INSERT INTO `consulta` VALUES (14, 5, '2023-11-25', 'Me siento debil', 'Ultimamente me siento muy debil, aveces hago un minimo esfuerzo y me siento cansado', 'Anemia', NULL, '2023-12-02', 11, 1, 11);
INSERT INTO `consulta` VALUES (15, 2, '2023-12-01', 'Tengo gripe', 'Andaba en la calle cuando se vino una tormenta y me cayo toda encima', 'Influenza', NULL, '2023-12-08', 12, 10, 12);
INSERT INTO `consulta` VALUES (16, 1, '2023-12-02', 'prueba	', 'es una prueba	', 'ninguno', '2023-12-09', NULL, 12, 2, 14);
INSERT INTO `consulta` VALUES (17, 1, '2023-12-02', 'Me duele el estomago	', 'Me duele el estomago como un colico, y cada vez me duele mas, tanto que me duele caminar', 'Apendicitis', '2023-12-09', NULL, 12, 10, 15);
INSERT INTO `consulta` VALUES (18, 1, '2023-12-02', 'Me duele la cabeza ', 'Me duele la cabeza todo el tiempo, en especial la parte del cuello', 'Migraña', NULL, NULL, 12, 1, 13);
INSERT INTO `consulta` VALUES (19, 1, '2023-12-02', 'Me duele la espalda', 'Estaba usando las escaleras cuando esta se resbalo y me cai desde lo mas alto', 'trumatismo dorsal', NULL, '2023-12-09', 12, 4, 18);
INSERT INTO `consulta` VALUES (20, 1, '2023-12-02', 'Tengo dolor de estomago	', 'Me duele el estomago por que comi en un puesto que estaba en otro pueblo', 'intoxicación alimentaria', NULL, '2023-12-09', 12, 3, 17);
INSERT INTO `consulta` VALUES (21, 1, '2023-12-02', 'Me duele el estomago', 'Me llama al baño a cada rato y no puedo comer nada por que salgo corriendo para el baño', 'gastroenteritis', '2023-12-13', NULL, 12, 6, 16);
INSERT INTO `consulta` VALUES (22, 1, '2023-12-02', 'Me han salido uno granos en los brazos', 'Despues que fui a la playa me salieron esos granos y realmente no se que puede ser', 'Urticaria solar', '2023-12-09', NULL, 12, 10, 19);
INSERT INTO `consulta` VALUES (23, 1, '2023-12-02', 'Tengo unas manchas en la piel', 'Me salieron unas manchas despues de estar todo el dia en el sol', 'urticaria solar', '2023-12-09', NULL, 12, 3, 20);
INSERT INTO `consulta` VALUES (24, 1, '2023-12-02', 'Me duele el pie', 'Me cayo un ladrillo en el pie cuando estaba trabajando', 'Contusion podal', '2023-12-09', NULL, 12, 8, 21);
INSERT INTO `consulta` VALUES (25, 1, '2023-12-02', 'Me duele el pie', 'Me doble el pie en la piscina y desde entonces lo tengo hinchado', 'esguince de tobillo', NULL, '2023-12-06', 12, 7, 22);
INSERT INTO `consulta` VALUES (26, 1, '2023-12-02', 'Tengo diarrea	', 'No puedo comer nada por que rapido me llama al baño, me siento hasta debil', 'Gastroenteritis aguda', NULL, '2023-12-06', 12, 2, 23);
INSERT INTO `consulta` VALUES (27, 1, '2023-12-02', 'Tengo un uñero', 'Tengo un uñero por que los zapatos me molestan, y ya hasta me duele caminar', 'paroniquia aguda', '2023-12-06', NULL, 12, 1, 24);
INSERT INTO `consulta` VALUES (28, 1, '2023-12-02', 'Me duele los huesos', 'Me duelen las manos por que plancho y luego me mojo las manos por que tengo que lavar', 'Artritis', NULL, NULL, 12, 4, 25);
INSERT INTO `consulta` VALUES (29, 1, '2023-12-02', 'No puedo dormir nada', 'No he podido dormir las ultimas semanas, y me siento muy cansado, no tomo cafe antes de acostarme por pensar que es por eso', 'Insomnio', NULL, '2023-12-09', 12, 2, 26);
INSERT INTO `consulta` VALUES (30, 1, '2023-12-02', 'Tengo dolor en la espada', 'Estaba levantando unas cajas pesada, cuando al levantar una muy pesada  senti el punzon', 'traumatismo dorsal', NULL, '2023-12-09', 12, 4, 27);
INSERT INTO `consulta` VALUES (31, 1, '2023-12-02', 'Tengo gripe', 'Me cayo la tormenta encima y desde ahi me senti mal', 'influenza', '2023-12-09', NULL, 12, 1, 28);
INSERT INTO `consulta` VALUES (32, 1, '2023-12-02', 'Me duele la cabeza	', 'Me duele derrepente bien fuerte y me molesta el ruido, hasta la luz', 'Migraña', '2023-12-06', NULL, 12, 5, 29);
INSERT INTO `consulta` VALUES (33, 1, '2023-12-02', 'Tengo agruras', 'Tengo un rugir fuerte en el estomago y sabor feo en la boca', 'pirosis', NULL, '2023-12-09', 12, 2, 30);
INSERT INTO `consulta` VALUES (34, 1, '2023-12-02', 'Me duelen los oido', 'Me fui a bañar a las piscinas y desde ese dia me duelen', 'otitis externa', '2023-12-09', NULL, 12, 1, 32);
INSERT INTO `consulta` VALUES (35, 1, '2023-12-02', 'Me duele el cuerpo', 'Ultimamente me siento debil y un frio que me entra en los huesos', 'Anemia', '2023-12-09', NULL, 12, 7, 33);
INSERT INTO `consulta` VALUES (36, 1, '2023-12-02', 'Me duele la rodilla', 'Me duele la rodilla cuando camino, cuando me levanto y todo basicamente', 'Artritis', NULL, '2023-12-09', 12, 2, 34);
INSERT INTO `consulta` VALUES (37, 1, '2023-12-02', 'Me duele el estomago', 'Me duele por que comi en la calle y comi a la carrera', 'gastroenteritis aguda', NULL, '2023-12-09', 12, 5, 35);
INSERT INTO `consulta` VALUES (38, 1, '2023-12-02', 'Me duele el estomago', 'Me duele el estomago por que comi en la calle y comi a la carrera', 'Gastroenteritis aguda', NULL, '2023-12-09', 12, 2, 38);
INSERT INTO `consulta` VALUES (39, 1, '2023-12-03', 'Tengo una chibola en el cuello', 'Estos dias sentia que me dolia el cuello y cuando me toque senti una chibola, le dije a mis hermanos que la revisaran y me dijeron que tenia como esa pelota en el cuello', 'Quiste cervical', '2023-12-10', NULL, 12, 4, 39);
INSERT INTO `consulta` VALUES (40, 1, '2023-12-03', 'prueba', 'prueba	', 'ninguno', NULL, NULL, 12, 1, 37);
INSERT INTO `consulta` VALUES (41, 1, '2023-12-03', 'Me desmayo seguido', 'Derrepente veo lucesitas y cuando menos siento me estan levantando, y me levanto desorientada', 'Anemia', '2023-12-20', NULL, 12, 7, 36);
INSERT INTO `consulta` VALUES (42, 10, '2023-12-03', 'Me duele el estomago', 'Fui a comer al mercado y me cayo mal la comida', 'Gastroenteritis aguda', '2023-12-09', NULL, 12, 12023, 40);
INSERT INTO `consulta` VALUES (43, 8, '2023-12-04', 'Me duele el estomago	', 'Me comis unos chorys y estaban buenos', 'Gastroenteritis aguda', NULL, '2023-12-11', 19, 5, 41);
INSERT INTO `consulta` VALUES (44, 4, '2023-12-04', 'Me duele la cabeza	', 'me duele la cabeza hasta con la luz,', 'Migraña', NULL, NULL, 20, 5, 43);
INSERT INTO `consulta` VALUES (45, 8, '2023-12-04', 'nose	', 'prueba', 'es un prueba', NULL, NULL, 21, 3, 42);
INSERT INTO `consulta` VALUES (46, 4, '2023-12-04', 'Me duele el pie', 'me cayo un ladrillo', 'Contusion en el pie', NULL, '2023-12-11', 22, 8, 45);
INSERT INTO `consulta` VALUES (47, 8, '2023-12-04', 'me duele el estomago', 'he pasado con diarrea todo el dia', 'Gastroenteritis', NULL, '2023-12-11', 24, 3, 44);
INSERT INTO `consulta` VALUES (48, 8, '2023-12-04', 'Me siento debil	', 'Me siento cansada y tengo mucho sueño', 'Anemia', '2023-12-11', NULL, 25, 5, 46);
INSERT INTO `consulta` VALUES (49, 4, '2023-12-04', 'Me duele la cabeza', 'Me duele y me molesta hasta la luz', 'Migraña', '2023-12-19', NULL, 26, 1, 49);
INSERT INTO `consulta` VALUES (50, 4, '2023-12-04', 'prueba', 'prueba', 'prueba', '2023-12-12', NULL, 27, 3, 50);
INSERT INTO `consulta` VALUES (51, 4, '2023-12-04', 'prueba	', 'prueba', 'prueba', '2023-12-12', NULL, 28, 7, 48);
INSERT INTO `consulta` VALUES (52, 10, '2023-12-04', 'prueba', 'prueba	', 'prueba', '2023-12-11', NULL, 29, 6, 47);
INSERT INTO `consulta` VALUES (53, 10, '2023-12-04', 'no se	jolkj', 'joj', 'oijio', NULL, NULL, 30, 6, 51);
INSERT INTO `consulta` VALUES (54, 8, '2023-12-04', 'prueba	', 'prueba', 'prueba', NULL, NULL, 31, 6, 52);
INSERT INTO `consulta` VALUES (55, 8, '2023-12-04', 'prueba	', 'prueba', 'prueba', '2023-12-27', NULL, 32, 4, 53);
INSERT INTO `consulta` VALUES (56, 1, '2023-12-04', 'prueba	', 'prueba', 'prueba', NULL, NULL, 33, 1, 54);
INSERT INTO `consulta` VALUES (57, 4, '2023-12-04', 'kjfk	', 'oj', 'iouj', NULL, NULL, 34, 1, 55);

-- ----------------------------
-- Table structure for consulta_examen
-- ----------------------------
DROP TABLE IF EXISTS `consulta_examen`;
CREATE TABLE `consulta_examen`  (
  `consulta_examen` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `examen` int NOT NULL,
  `consulta` int NOT NULL,
  PRIMARY KEY (`consulta_examen`) USING BTREE,
  INDEX `examen`(`examen` ASC) USING BTREE,
  INDEX `consulta`(`consulta` ASC) USING BTREE,
  CONSTRAINT `consulta_examen_ibfk_1` FOREIGN KEY (`examen`) REFERENCES `examen` (`examen`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `consulta_examen_ibfk_2` FOREIGN KEY (`consulta`) REFERENCES `consulta` (`consulta`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of consulta_examen
-- ----------------------------
INSERT INTO `consulta_examen` VALUES (1, 'Parásitos Intestinales Detectados', 2, 4);
INSERT INTO `consulta_examen` VALUES (2, 'Análisis de sangre las posibles anormalidades en la regulación de glucosa', 3, 4);
INSERT INTO `consulta_examen` VALUES (3, 'Anemia por falta de vitaminas', 5, 14);
INSERT INTO `consulta_examen` VALUES (4, 'Falta de buena alimentacion', 9, 8);
INSERT INTO `consulta_examen` VALUES (5, 'Globulos rojos hay poco en el cuerpo', 1, 4);
INSERT INTO `consulta_examen` VALUES (6, 'Cefalea occipital', 9, 10);
INSERT INTO `consulta_examen` VALUES (7, 'Infeccion de oidos', 9, 1);
INSERT INTO `consulta_examen` VALUES (8, 'salio mal', 5, 43);
INSERT INTO `consulta_examen` VALUES (9, 'salio mal, tiene anemia', 9, 48);
INSERT INTO `consulta_examen` VALUES (10, 'Salio mal', 9, 49);
INSERT INTO `consulta_examen` VALUES (11, 'fadiosj', 9, 56);
INSERT INTO `consulta_examen` VALUES (12, 'lafdkjs', 9, 57);

-- ----------------------------
-- Table structure for contacto
-- ----------------------------
DROP TABLE IF EXISTS `contacto`;
CREATE TABLE `contacto`  (
  `contacto` int NOT NULL AUTO_INCREMENT,
  `dui` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `nombre` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `apellido` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `genero` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `telefono` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `domicilio` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`contacto`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of contacto
-- ----------------------------
INSERT INTO `contacto` VALUES (1, '12345678-9', 'Fernanda', 'Suarez', 'f', '1234-5678', 'Las margaritas');
INSERT INTO `contacto` VALUES (2, '45678934-5', 'Lucia', 'Gonzales', 'f', '4567-8945', 'Dolores');
INSERT INTO `contacto` VALUES (3, '35678934-7', 'Jose', 'Morales', 'm', '2345-5678', 'Las mercedes');
INSERT INTO `contacto` VALUES (4, '12345678-6', 'Carlos', '	García', 'm', '3256-6789', 'San Sebastian');
INSERT INTO `contacto` VALUES (5, '34657657-8', 'Laura', '	Rodríguez', 'f', '4536-4656', 'Candelaria');
INSERT INTO `contacto` VALUES (6, '57475676-4', 'Manuel', 'Martínez', 'm', '3423-5433', 'San Salvador');
INSERT INTO `contacto` VALUES (7, '34645756-6', 'Margarita', 'Flores', 'f', '5475-5465', 'San Rafael Cedros');
INSERT INTO `contacto` VALUES (8, '23534668-7', 'Martin', 'Torres', 'm', '6547-5775', 'Santo Domingo');
INSERT INTO `contacto` VALUES (9, '32576875-5', 'Yessenia', 'Lopez', 'f', '3436-4343', 'San Vicente');
INSERT INTO `contacto` VALUES (10, '23425465-8', 'Daniel', 'Ramirez', 'm', '5644-6864', 'Santa Elena');

-- ----------------------------
-- Table structure for doc_especialidad
-- ----------------------------
DROP TABLE IF EXISTS `doc_especialidad`;
CREATE TABLE `doc_especialidad`  (
  `doc_especialidad` int NOT NULL AUTO_INCREMENT,
  `empleado` int NOT NULL,
  `especialidad` int NOT NULL,
  PRIMARY KEY (`doc_especialidad`) USING BTREE,
  INDEX `empleado`(`empleado` ASC) USING BTREE,
  INDEX `especialidad`(`especialidad` ASC) USING BTREE,
  CONSTRAINT `doc_especialidad_ibfk_1` FOREIGN KEY (`empleado`) REFERENCES `empleado` (`empleado`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `doc_especialidad_ibfk_2` FOREIGN KEY (`especialidad`) REFERENCES `especialidad` (`especialidad`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of doc_especialidad
-- ----------------------------
INSERT INTO `doc_especialidad` VALUES (1, 2, 3);
INSERT INTO `doc_especialidad` VALUES (2, 3, 4);
INSERT INTO `doc_especialidad` VALUES (3, 7, 1);
INSERT INTO `doc_especialidad` VALUES (4, 2, 2);
INSERT INTO `doc_especialidad` VALUES (5, 6, 5);
INSERT INTO `doc_especialidad` VALUES (6, 3, 3);
INSERT INTO `doc_especialidad` VALUES (7, 4, 3);
INSERT INTO `doc_especialidad` VALUES (8, 2, 1);
INSERT INTO `doc_especialidad` VALUES (9, 6, 3);
INSERT INTO `doc_especialidad` VALUES (10, 2, 5);
INSERT INTO `doc_especialidad` VALUES (12, 1, 3);
INSERT INTO `doc_especialidad` VALUES (13, 1, 8);
INSERT INTO `doc_especialidad` VALUES (14, 1, 6);

-- ----------------------------
-- Table structure for empleado
-- ----------------------------
DROP TABLE IF EXISTS `empleado`;
CREATE TABLE `empleado`  (
  `empleado` int NOT NULL AUTO_INCREMENT,
  `dui` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `nombre` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `apellido` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `genero` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `correo_electronico` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `telefono` varchar(9) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `afp` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `JVMP` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `contraseña` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `rol` int NOT NULL,
  PRIMARY KEY (`empleado`) USING BTREE,
  INDEX `rol`(`rol` ASC) USING BTREE,
  CONSTRAINT `empleado_ibfk_1` FOREIGN KEY (`rol`) REFERENCES `rol` (`rol`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of empleado
-- ----------------------------
INSERT INTO `empleado` VALUES (1, '002453098-', 'Maycol Jose', 'Dominguez Cornejo', 'm', '2003-07-30', 'maycol@gmail.com', '7633-7866', '0123987-4', '123456', '12dacadabfa509dd84b85e13bc7b7022dc18e06a50a58ec5c0c882a790f535d8', 1, 3);
INSERT INTO `empleado` VALUES (2, '006384587-', 'Mauricio Jose', 'Crespin Landaverde', 'm', '1990-11-24', 'crespin@gmail.com', '7888-9809', '0948393-8', '789101', '2f20216dae4a1ba6915852d565eb5cdac5883d47327c888969fdccd2cb80cbb5', 1, 2);
INSERT INTO `empleado` VALUES (3, '64538267-0', 'Carlos Emanuel', 'Lovato Hernandez', 'm', '1995-01-10', 'carlos@gmail.com', '7453-6243', '5337282-1', '121314', '7b85175b455060e3237e925f023053ca9515e8682a83c8b09911c724a1f8b75f', 1, 2);
INSERT INTO `empleado` VALUES (4, '44352745-3', 'Jose Nelson', 'Dominguez Gil', 'm', '1980-10-01', 'nelson@gmail.com', '5741-1123', '4673937-2', '151617', '1ec4ed037766aa181d8840ad04b9fc6e195fd37dedc04c98a5767a67d3758ece', 1, 1);
INSERT INTO `empleado` VALUES (6, '546378935-', 'Elena Sofia', 'Gomar Ticas', 'f', '1984-08-14', 'elena@gmail.com', '7768-8953', '5900639-5', '181920', '0ce93c9606f0685bf60e051265891d256381f639d05c0aec67c84eec49d33cc1', 1, 1);
INSERT INTO `empleado` VALUES (7, '43997650-4', 'Carmen Yaneth', 'Baires Contreras', 'f', '1986-05-13', 'carmen@gmail.com', '6209-8867', '8845632-0', '212223', 'f3c2ce176290b0c384cb4881eb714f2db58f630c33863d91c9bedf58d36007db', 1, 2);
INSERT INTO `empleado` VALUES (8, '23176632-6', 'Claudia Marlene', 'Hernandez Hernandez', 'f', '1987-10-01', 'claudia@gmail.com', '6399-0414', '7453890-1', '242526', '35f85825b9016fcc7818aca22298dc88a92ba6e4f029366ff8acbb3f823152d4', 1, 3);
INSERT INTO `empleado` VALUES (9, '64836728-0', 'Emanuel Adrian', 'Guzman Gavidia', 'm', '2000-06-13', 'emanuel@gmail.com', '7722-8877', '7455290-1', '272829', 'fcd2b45b8eda145e115dbb448441653fd3575661b8cd5dcc623353444ff9d99d', 1, 3);
INSERT INTO `empleado` VALUES (10, '06383543-0', 'Marlon Steed', 'Dominguez Cornejo', 'm', '2002-08-28', 'marlon@gmail.com', '6305-7722', '7352900-0', '303132', '7ca840127ca5a1264a588d4da8c0aa751780f33d73db484fe9251d68c60f5427', 1, 3);
INSERT INTO `empleado` VALUES (11, '63528963-8', 'Genesis Sarai', 'Azucena Pineda', 'f', '1990-09-10', 'sarai@gmail.com', '7320-2312', '7575546-1', '333435', 'aeebad4a796fcc2e15dc4c6061b45ed9b373f26adfc798ca7d2d8cc58182718e', 1, 2);
INSERT INTO `empleado` VALUES (14, '06060097-1', 'Karina Elizabeth', 'Alvares Alfaro', 'F', '2003-10-16', 'karina@gmail.com', '2273-6000', '4512365-4', '451245', 'karina2003', 1, 3);
INSERT INTO `empleado` VALUES (15, '87346273-4', 'PABLO ANTHONY', 'RAMOS ZEPEDA', 'M', '2002-05-28', 'PABLO@GMAIL.COM', '5462-7829', '6327237-6', 'JSHD553', '63993a43c7e5c0699582dd34acc2906538557433f753b44179c21aed51e673ed', 1, 2);
INSERT INTO `empleado` VALUES (16, '73265882-7', 'sfjfhgjgf', 'hgcghcghc', 'M', '2023-12-04', 'jhfdshdhgahs', '8243-7688', '2638462-6', 'hfbeh23646', '5dbd229750da1e24cd36dd615f050b59426b54d3708336524bba2afa088f446f', 1, 2);

-- ----------------------------
-- Table structure for especialidad
-- ----------------------------
DROP TABLE IF EXISTS `especialidad`;
CREATE TABLE `especialidad`  (
  `especialidad` int NOT NULL AUTO_INCREMENT,
  `nombre_especialidad` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `descripcion` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`especialidad`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of especialidad
-- ----------------------------
INSERT INTO `especialidad` VALUES (1, 'Cardiología', 'Especialidad médica que se ocupa del estudio, diagnóstico y tratamiento de las enfermedades del corazón y del aparato circulatorio.');
INSERT INTO `especialidad` VALUES (2, 'Dermatología', 'Rama de la medicina que se dedica al estudio de la piel, sus estructuras, funciones y enfermedades.');
INSERT INTO `especialidad` VALUES (3, 'Neurología', 'Especialidad médica que se ocupa del estudio del sistema nervioso, sus estructuras, funciones y enfermedades.');
INSERT INTO `especialidad` VALUES (4, 'Gastroenterología', 'Rama de la medicina que se ocupa del estudio del sistema digestivo y sus trastornos.');
INSERT INTO `especialidad` VALUES (5, 'Oftalmología', 'Especialidad médica que se dedica al estudio de las enfermedades del ojo y estructuras relacionadas.');
INSERT INTO `especialidad` VALUES (6, 'Traumatología', 'Especialidad médica que se ocupa de las lesiones del aparato locomotor, como huesos, músculos, articulaciones y tendones.');
INSERT INTO `especialidad` VALUES (7, 'Psiquiatría', 'Rama de la medicina que se ocupa del estudio, diagnóstico, tratamiento y prevención de los trastornos mentales.');
INSERT INTO `especialidad` VALUES (8, 'Pediatría', 'Especialidad médica que se dedica al estudio y tratamiento de los niños y adolescentes.');
INSERT INTO `especialidad` VALUES (9, 'Endocrinología', 'Rama de la medicina que se ocupa del estudio de las glándulas endocrinas y sus trastornos.');
INSERT INTO `especialidad` VALUES (10, 'Otorrinolaringología', 'Especialidad médica que se dedica al estudio de las enfermedades del oído, nariz, garganta y estructuras relacionadas.');

-- ----------------------------
-- Table structure for examen
-- ----------------------------
DROP TABLE IF EXISTS `examen`;
CREATE TABLE `examen`  (
  `examen` int NOT NULL AUTO_INCREMENT,
  `nombre_examen` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`examen`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of examen
-- ----------------------------
INSERT INTO `examen` VALUES (1, 'Hemograma');
INSERT INTO `examen` VALUES (2, 'Heces por parásito');
INSERT INTO `examen` VALUES (3, 'Glucosa');
INSERT INTO `examen` VALUES (4, 'Urinálisis ');
INSERT INTO `examen` VALUES (5, ' Sangre');
INSERT INTO `examen` VALUES (6, 'Ácido úrico');
INSERT INTO `examen` VALUES (7, 'Perfil hepático');
INSERT INTO `examen` VALUES (8, 'Perfil lipídico');
INSERT INTO `examen` VALUES (9, ' Electrolitos');
INSERT INTO `examen` VALUES (10, 'Perfil hepático');

-- ----------------------------
-- Table structure for ginecoobstetrico
-- ----------------------------
DROP TABLE IF EXISTS `ginecoobstetrico`;
CREATE TABLE `ginecoobstetrico`  (
  `ginecoobstetrico` int NOT NULL AUTO_INCREMENT,
  `n_hijos` int NOT NULL,
  `fecha_ultima_periodo` date NOT NULL,
  `fecha_ultimo_parto` date NOT NULL,
  `planificacion` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`ginecoobstetrico`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ginecoobstetrico
-- ----------------------------
INSERT INTO `ginecoobstetrico` VALUES (1, 0, '2023-10-18', '2023-12-04', 0);
INSERT INTO `ginecoobstetrico` VALUES (2, 3, '2023-11-24', '2020-12-09', 1);
INSERT INTO `ginecoobstetrico` VALUES (3, 1, '2023-12-04', '2023-12-04', 1);
INSERT INTO `ginecoobstetrico` VALUES (4, 2, '2023-12-12', '2023-12-13', 1);
INSERT INTO `ginecoobstetrico` VALUES (5, 2, '2023-12-03', '2018-12-20', 1);
INSERT INTO `ginecoobstetrico` VALUES (6, 1, '2023-11-16', '2023-11-06', 1);

-- ----------------------------
-- Table structure for hoja_enfermeria
-- ----------------------------
DROP TABLE IF EXISTS `hoja_enfermeria`;
CREATE TABLE `hoja_enfermeria`  (
  `hoja_enfermeria` int NOT NULL AUTO_INCREMENT,
  `peso` double NOT NULL,
  `altura` double NOT NULL,
  `temperatura` double NOT NULL,
  `presion` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `oxigenacion` double NOT NULL,
  `codigo_inscripcion` int NOT NULL,
  PRIMARY KEY (`hoja_enfermeria`) USING BTREE,
  INDEX `codigo_inscripcion`(`codigo_inscripcion` ASC) USING BTREE,
  CONSTRAINT `hoja_enfermeria_ibfk_1` FOREIGN KEY (`codigo_inscripcion`) REFERENCES `hoja_inscripcion` (`codigo_inscripcion`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 56 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hoja_enfermeria
-- ----------------------------
INSERT INTO `hoja_enfermeria` VALUES (1, 70, 153, 37, '110/70', 98, 1);
INSERT INTO `hoja_enfermeria` VALUES (2, 67, 160, 36, '200/90', 97, 2);
INSERT INTO `hoja_enfermeria` VALUES (3, 76, 180, 36.7, '120/80', 98, 3);
INSERT INTO `hoja_enfermeria` VALUES (4, 77, 184, 38, '100/70', 96, 4);
INSERT INTO `hoja_enfermeria` VALUES (5, 100, 169, 39.7, '200/100', 99, 5);
INSERT INTO `hoja_enfermeria` VALUES (6, 89, 188, 36.7, '150/100', 96, 6);
INSERT INTO `hoja_enfermeria` VALUES (7, 60, 165, 39.7, '120/139', 97, 7);
INSERT INTO `hoja_enfermeria` VALUES (8, 87, 189, 36.2, '120/89', 99, 8);
INSERT INTO `hoja_enfermeria` VALUES (9, 66, 167, 36.9, '140/159', 95, 9);
INSERT INTO `hoja_enfermeria` VALUES (10, 79, 176, 37, '120/90', 99, 10);
INSERT INTO `hoja_enfermeria` VALUES (11, 65, 153, 39, '200/70', 99, 1);
INSERT INTO `hoja_enfermeria` VALUES (12, 67, 161, 36, '120/70', 98, 3);
INSERT INTO `hoja_enfermeria` VALUES (13, 65, 153, 36, '100/80', 99, 1);
INSERT INTO `hoja_enfermeria` VALUES (14, 78, 170, 37, '120/70', 96, 2);
INSERT INTO `hoja_enfermeria` VALUES (15, 100, 190, 36, '200/70', 95, 10);
INSERT INTO `hoja_enfermeria` VALUES (16, 89, 188, 36.7, '120/90', 99, 6);
INSERT INTO `hoja_enfermeria` VALUES (17, 76, 180, 36.7, '120/80', 98, 3);
INSERT INTO `hoja_enfermeria` VALUES (18, 77, 184, 38, '100/70', 96, 4);
INSERT INTO `hoja_enfermeria` VALUES (19, 77, 184, 38, '100/70', 98, 10);
INSERT INTO `hoja_enfermeria` VALUES (20, 87, 176, 36, '120/70', 99, 3);
INSERT INTO `hoja_enfermeria` VALUES (21, 100, 190, 37, '110/80', 98, 8);
INSERT INTO `hoja_enfermeria` VALUES (22, 110, 180, 36, '100/70', 97, 7);
INSERT INTO `hoja_enfermeria` VALUES (23, 120, 180, 37, '90/60', 98, 2);
INSERT INTO `hoja_enfermeria` VALUES (24, 160, 190, 36, '150/60', 95, 1);
INSERT INTO `hoja_enfermeria` VALUES (25, 120, 170, 36, '120/80', 98, 4);
INSERT INTO `hoja_enfermeria` VALUES (26, 100, 160, 36, '110/70', 98, 2);
INSERT INTO `hoja_enfermeria` VALUES (27, 88, 178, 36, '110/60', 96, 4);
INSERT INTO `hoja_enfermeria` VALUES (28, 50, 161, 35, '110/70', 99, 1);
INSERT INTO `hoja_enfermeria` VALUES (29, 67, 189, 36, '110/70', 96, 5);
INSERT INTO `hoja_enfermeria` VALUES (30, 66, 170, 36, '100/70', 98, 2);
INSERT INTO `hoja_enfermeria` VALUES (32, 61, 169, 37, '120/60', 97, 1);
INSERT INTO `hoja_enfermeria` VALUES (33, 67, 170, 36, '110/60', 98, 7);
INSERT INTO `hoja_enfermeria` VALUES (34, 55, 160, 37, '120/60', 97, 2);
INSERT INTO `hoja_enfermeria` VALUES (35, 64, 167, 36, '120/60', 99, 5);
INSERT INTO `hoja_enfermeria` VALUES (36, 76, 179, 36, '110/60', 98, 7);
INSERT INTO `hoja_enfermeria` VALUES (37, 66, 167, 35, '110/70', 99, 1);
INSERT INTO `hoja_enfermeria` VALUES (38, 65, 169, 36, '110/70', 98, 2);
INSERT INTO `hoja_enfermeria` VALUES (39, 66, 170, 36, '120/70', 98, 4);
INSERT INTO `hoja_enfermeria` VALUES (40, 56, 155, 37, '120/70', 98, 12023);
INSERT INTO `hoja_enfermeria` VALUES (41, 76, 190, 36, '110/70', 98, 5);
INSERT INTO `hoja_enfermeria` VALUES (42, 55, 166, 160, '100/10', 97, 3);
INSERT INTO `hoja_enfermeria` VALUES (43, 100, 100, 37, '100/75', 98, 5);
INSERT INTO `hoja_enfermeria` VALUES (44, 65, 180, 38, '110/70', 98, 3);
INSERT INTO `hoja_enfermeria` VALUES (45, 76, 180, 38, '130/60', 95, 8);
INSERT INTO `hoja_enfermeria` VALUES (46, 78, 189, 39, '120/70', 98, 5);
INSERT INTO `hoja_enfermeria` VALUES (47, 88, 189, 38, '145/60', 97, 6);
INSERT INTO `hoja_enfermeria` VALUES (48, 77, 179, 36, '100/70', 99, 7);
INSERT INTO `hoja_enfermeria` VALUES (49, 67, 167, 37, '110/70', 97, 1);
INSERT INTO `hoja_enfermeria` VALUES (50, 77, 187, 36, '120/60', 99, 3);
INSERT INTO `hoja_enfermeria` VALUES (51, 67, 160, 37, '100/60', 98, 6);
INSERT INTO `hoja_enfermeria` VALUES (52, 76, 189, 38, '120/70', 98, 6);
INSERT INTO `hoja_enfermeria` VALUES (53, 87, 167, 36, '110/60', 98, 4);
INSERT INTO `hoja_enfermeria` VALUES (54, 76, 170, 37, '110/60', 98, 1);
INSERT INTO `hoja_enfermeria` VALUES (55, 67, 178, 36, '100/70', 98, 1);

-- ----------------------------
-- Table structure for hoja_inscripcion
-- ----------------------------
DROP TABLE IF EXISTS `hoja_inscripcion`;
CREATE TABLE `hoja_inscripcion`  (
  `codigo_inscripcion` int NOT NULL,
  `dui` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `nombre` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `apellido` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `telefono` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `domicilio` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `contacto` int NULL DEFAULT NULL,
  `triaje` int NOT NULL,
  `Genero` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `fecha_inscripcion` date NOT NULL,
  `empleado` int NOT NULL,
  PRIMARY KEY (`codigo_inscripcion`) USING BTREE,
  INDEX `contacto`(`contacto` ASC) USING BTREE,
  INDEX `triaje`(`triaje` ASC) USING BTREE,
  INDEX `empleado`(`empleado` ASC) USING BTREE,
  CONSTRAINT `hoja_inscripcion_ibfk_1` FOREIGN KEY (`contacto`) REFERENCES `contacto` (`contacto`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `hoja_inscripcion_ibfk_2` FOREIGN KEY (`triaje`) REFERENCES `triaje` (`triaje`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `hoja_inscripcion_ibfk_3` FOREIGN KEY (`empleado`) REFERENCES `empleado` (`empleado`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hoja_inscripcion
-- ----------------------------
INSERT INTO `hoja_inscripcion` VALUES (1, '456789343-5', 'Karla Rosibel', 'Martinez Lopez', '4532-3478', 'San Sebastian', '2000-07-23', 3, 4, 'f', '2023-11-05', 1);
INSERT INTO `hoja_inscripcion` VALUES (2, '456789322-1', 'Jose David', 'Peña Lopez', '3455-6789', 'Los amigos', '1997-03-18', 2, 1, 'm', '2023-11-06', 9);
INSERT INTO `hoja_inscripcion` VALUES (3, '435677889-2', 'Pedro Luis', 'Gonzales Flores', '2367-9845', 'San Ramon', '1880-04-20', 9, 4, 'm', '2023-11-13', 8);
INSERT INTO `hoja_inscripcion` VALUES (4, '345475687-7', 'Josselyn Azucena', 'Torres Castro', '3457-9867', 'Barrio San Juan', '1999-02-09', 1, 2, 'f', '2023-11-14', 1);
INSERT INTO `hoja_inscripcion` VALUES (5, '455667789-8', 'Tatiana Maria', 'Martinez Argueta', '2345-4557', 'San Salvador', '2003-09-30', 6, 3, 'f', '2023-11-20', 9);
INSERT INTO `hoja_inscripcion` VALUES (6, '224537809-4', 'Mario Ernesto', 'Flores Ramirez', '2367-8798', 'Santa Tecla', '2001-01-23', 8, 5, 'm', '2023-11-05', 8);
INSERT INTO `hoja_inscripcion` VALUES (7, '652834346-3', 'Maria Yancy', 'Bolaños Suarez', '3455-4756', 'San Vicente', '2004-04-12', 10, 4, 'f', '2023-11-21', 1);
INSERT INTO `hoja_inscripcion` VALUES (8, '354645776-5', 'Pablo Jose', 'Abarca Dolores', '3244-5688', 'Apastepeque', '1994-09-25', 4, 1, 'm', '2023-11-09', 10);
INSERT INTO `hoja_inscripcion` VALUES (9, '543754875-7', 'Erika Elizabeth', 'Barquero Castillo', '2343-3546', 'Barrio San Miguel', '2000-08-04', 9, 5, 'f', '2023-11-19', 9);
INSERT INTO `hoja_inscripcion` VALUES (10, '343654748-6', 'Flavio Enrique', 'Romeo Valles', '3465-4767', 'Colonia Las Mercedes', '1990-05-03', 5, 2, 'm', '2023-11-16', 1);
INSERT INTO `hoja_inscripcion` VALUES (5452, 'prueba', 'jor', 'ljk', '987', 'lkjlkj', '2023-12-05', 3, 2, 'Femenino', '2023-12-12', 9);
INSERT INTO `hoja_inscripcion` VALUES (12023, '987349-2', 'Oscar', 'Romero', '7676-1212', 'San francisco gotera', '1998-12-31', 5, 3, 'Masculino', '2023-12-03', 8);

-- ----------------------------
-- Table structure for hospital
-- ----------------------------
DROP TABLE IF EXISTS `hospital`;
CREATE TABLE `hospital`  (
  `hospital` int NOT NULL AUTO_INCREMENT,
  `nombre_hospital` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `direccion_hospital` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`hospital`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hospital
-- ----------------------------
INSERT INTO `hospital` VALUES (1, 'Hospital Nacional \"San Pedro\"', 'Final calle Dr. Federico Penado salida a San Salvador, Usulután, El Salvador, C.A.');
INSERT INTO `hospital` VALUES (2, 'Hospital Nacional General \"Santa Gertrudis\"', '8ª Avenida Sur N° 1000, Barrio San Francisco, San Vicente, El Salvador, C.A.');
INSERT INTO `hospital` VALUES (3, 'Hospital Nacional \"Monseñor Óscar Arnulfo Romero\" ', '6ª Avenida Norte Barrio Roma, Ciudad Barrios, San Miguel, El Salvador, C.A.');
INSERT INTO `hospital` VALUES (4, 'Hospital Nacional de La Mujer \"Dra. María Isabel R', 'Entre 25 Avenida Sur y Calle Francisco Menéndez, Antigua Quinta María Luisa, Barrio Santa Anita, San Salvador, El Salvador, C.A.');
INSERT INTO `hospital` VALUES (5, 'Hospital Nacional de Ilobasco', 'Final 4ta. Calle Poniente, Barrio El Calvario, Ilobasco, Cabañas, El Salvador, C.A. ');
INSERT INTO `hospital` VALUES (6, 'Hospital Nacional de Nueva Guadalupe', 'Final Avenida Principal, Barrio San Luis, Nueva Guadalupe, San Miguel, El Salvador, C.A');
INSERT INTO `hospital` VALUES (7, 'Hospital Nacional General de Neumología y Medicina', 'Kilometro 8 1/2, Carretera a Planes de Renderos, San Salvador, El Salvador, C.A.');
INSERT INTO `hospital` VALUES (8, 'prueba', 'peureba');

-- ----------------------------
-- Table structure for licencia
-- ----------------------------
DROP TABLE IF EXISTS `licencia`;
CREATE TABLE `licencia`  (
  `licencia` int NOT NULL AUTO_INCREMENT,
  `tipo_licencia` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`licencia`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of licencia
-- ----------------------------
INSERT INTO `licencia` VALUES (1, 'Particular');
INSERT INTO `licencia` VALUES (2, 'Liviana');
INSERT INTO `licencia` VALUES (3, 'Pesada');

-- ----------------------------
-- Table structure for medicamento
-- ----------------------------
DROP TABLE IF EXISTS `medicamento`;
CREATE TABLE `medicamento`  (
  `numero_lote` int NOT NULL AUTO_INCREMENT,
  `nombre_medicamento` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `fecha_fabricacion` date NOT NULL,
  `fecha_caducidad` date NOT NULL,
  `presentacion` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `proveedor` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `cantidad_disponible` int NOT NULL,
  `via_de_administracion` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `descripcion_medicamento` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`numero_lote`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of medicamento
-- ----------------------------
INSERT INTO `medicamento` VALUES (1, 'Paracetamol', '2022-01-10', '2023-01-10', 'Tabletas', 'MIGUELEÑA', 1280, 'Oral', 'Analgésico y antipirético.');
INSERT INTO `medicamento` VALUES (2, 'Ibuprofeno', '2022-02-15', '2023-02-15', 'Cápsulas', 'DROGUERIA VITAL MEDICAL', 2400, 'Oral', 'Antiinflamatorio no esteroideo.');
INSERT INTO `medicamento` VALUES (3, 'Amoxicilina', '2022-03-20', '2023-03-20', 'Suspensión', 'DROGUERIA VELMED', 2370, 'Oral', 'Antibiótico de amplio espectro.');
INSERT INTO `medicamento` VALUES (4, 'Loratadina', '2022-04-25', '2023-04-25', 'Tabletas', 'MIGUELEÑA', 2400, 'Oral', 'Antihistamínico para alergias.');
INSERT INTO `medicamento` VALUES (5, 'Omeprazol', '2022-05-30', '2023-05-30', 'Cápsulas', 'DROGUERIA CAPITOL', 2400, 'Oral', 'Inhibidor de la bomba de protones.');
INSERT INTO `medicamento` VALUES (6, 'Aspirina', '2022-06-05', '2023-06-05', 'Tabletas', 'DROGUERIA LOGICOM ', 2400, 'Oral', 'Analgésico y antiinflamatorio.');
INSERT INTO `medicamento` VALUES (7, 'Insulina', '2022-07-10', '2023-07-10', 'Inyección', 'DROGUERIA POPULAR', 2400, 'Inyectable', 'Hormona para el control de la glucosa.');
INSERT INTO `medicamento` VALUES (8, 'Atorvastatina', '2022-08-15', '2023-08-15', 'Tabletas', 'DROGUERIA MEDICA CUSCATLECA ', 2400, 'Oral', 'Estatina para reducción del colesterol.');
INSERT INTO `medicamento` VALUES (9, 'Metformina', '2022-09-20', '2023-09-20', 'Tabletas', 'DROGUERIA PASMO', 2400, 'Oral', 'Antidiabético oral.');
INSERT INTO `medicamento` VALUES (10, 'Diazepam', '2022-10-25', '2023-10-25', 'Tabletas', 'DROGUERIA SAN JOSE ', 2400, 'Oral', 'Ansiolítico y relajante muscular.');
INSERT INTO `medicamento` VALUES (11, 'Ciprofloxacino', '2022-11-01', '2023-11-01', 'Tabletas', 'DIPROFAR', 2400, 'Oral', 'Antibiótico de amplio espectro.');
INSERT INTO `medicamento` VALUES (12, 'Sertralina', '2022-12-05', '2023-12-05', 'Tabletas', 'DROGUERIA FARNET', 2400, 'Oral', 'Antidepresivo y ansiolítico.');
INSERT INTO `medicamento` VALUES (13, 'Losartan', '2023-01-10', '2024-01-10', 'Tabletas', 'DROGUERIA FARNET', 2400, 'Oral', 'Bloqueador del receptor de angiotensina II.');
INSERT INTO `medicamento` VALUES (14, 'Ranitidina', '2023-02-15', '2024-02-15', 'Tabletas', 'DROGUERIA FARNET', 2400, 'Oral', 'Antagonista del receptor H2 para úlceras gástricas.');
INSERT INTO `medicamento` VALUES (15, 'Levotiroxina', '2023-03-20', '2024-03-20', 'Tabletas', 'DROGUERIA FARNET', 2400, 'Oral', 'Hormona tiroidea para trastornos de la tiroides.');
INSERT INTO `medicamento` VALUES (16, 'Clopidogrel', '2023-04-25', '2024-04-25', 'Tabletas', 'MIGUELEÑA', 2400, 'Oral', 'Antiagregante plaquetario para enfermedades cardiovasculares.');
INSERT INTO `medicamento` VALUES (17, 'Escitalopram', '2023-05-30', '2024-05-30', 'Tabletas', 'MIGUELEÑA', 2400, 'Oral', 'Antidepresivo y ansiolítico.');
INSERT INTO `medicamento` VALUES (18, 'Metoprolol', '2023-06-05', '2024-06-05', 'Tabletas', 'MIGUELEÑA', 2400, 'Oral', 'Bloqueador beta para problemas cardíacos y presión arterial.');
INSERT INTO `medicamento` VALUES (19, 'Candesartan', '2023-07-10', '2024-07-10', 'Tabletas', 'MIGUELEÑA', 2400, 'Oral', 'Bloqueador del receptor de angiotensina II.');
INSERT INTO `medicamento` VALUES (20, 'Pantoprazol', '2023-08-15', '2024-08-15', 'Tabletas', 'MIGUELEÑA', 2400, 'Oral', 'Inhibidor de la bomba de protones para problemas gastrointestinales.');
INSERT INTO `medicamento` VALUES (21, 'Acetaminofen', '2023-06-29', '2024-11-06', 'Tabletas', 'MIGUELEÑA', 2400, 'Oral', 'Antibiótico de amplio espectro.');
INSERT INTO `medicamento` VALUES (22, 'Paracetamol', '2023-11-01', '2024-11-01', 'Tabletas', 'MIGUELEÑA', 2400, 'Oral', 'Analgésico y antipirético.');
INSERT INTO `medicamento` VALUES (23, 'Aspirina', '2023-11-02', '2023-11-02', 'Tabletas', 'DROGUERIA LOGICOM', 0, 'Oral', 'Analgésico y antiinflamatorio.');
INSERT INTO `medicamento` VALUES (24, 'Insulina', '2023-11-29', '2023-11-29', 'Inyeccion', 'ESPECMEDIC', 1000, 'Inyectable', 'Hormona para el control de la glucosa.');
INSERT INTO `medicamento` VALUES (25, 'Pantoprazol', '2023-11-29', '2023-11-29', 'Tabletas', 'LA POPULAR', 2400, 'Oral', 'Inhibidor de la bomba de protones para problemas gastrointestinales.');
INSERT INTO `medicamento` VALUES (26, 'Criprofloxacino', '2023-11-30', '2024-11-30', 'Tabletas', 'LA SULTANA', 2400, 'Oral', 'Antibiótico de amplio espectro.');
INSERT INTO `medicamento` VALUES (27, 'Ranitidina', '2023-11-14', '2025-11-28', 'Tabletas', 'SAIMED', 2400, 'Oral', 'Antagonista del receptor H2 para úlceras gástricas.');
INSERT INTO `medicamento` VALUES (28, 'Acetaminofen', '2023-12-12', '2023-12-12', 'tabletas', 'LA POPULAR', 1980, 'jjfoa', 'ijfioo');

-- ----------------------------
-- Table structure for medicamento_entrega
-- ----------------------------
DROP TABLE IF EXISTS `medicamento_entrega`;
CREATE TABLE `medicamento_entrega`  (
  `medic_entrega` int NOT NULL AUTO_INCREMENT,
  `cantidad` int NOT NULL,
  `dosis` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `consulta` int NOT NULL,
  `numero_lote` int NOT NULL,
  PRIMARY KEY (`medic_entrega`) USING BTREE,
  INDEX `consulta`(`consulta` ASC) USING BTREE,
  INDEX `numero_lote`(`numero_lote` ASC) USING BTREE,
  CONSTRAINT `medicamento_entrega_ibfk_1` FOREIGN KEY (`consulta`) REFERENCES `consulta` (`consulta`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `medicamento_entrega_ibfk_2` FOREIGN KEY (`numero_lote`) REFERENCES `medicamento` (`numero_lote`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 24 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of medicamento_entrega
-- ----------------------------
INSERT INTO `medicamento_entrega` VALUES (1, 100, '1 cada 8 horas', 1, 1);
INSERT INTO `medicamento_entrega` VALUES (2, 20, '1 cada 8 horas', 26, 1);
INSERT INTO `medicamento_entrega` VALUES (3, 20, '1 cada 12 horas', 26, 28);
INSERT INTO `medicamento_entrega` VALUES (4, 30, '1 cada 8 horas', 27, 1);
INSERT INTO `medicamento_entrega` VALUES (5, 30, '1 cada 8 horas', 28, 1);
INSERT INTO `medicamento_entrega` VALUES (6, 20, '1 cada 12 horas', 29, 1);
INSERT INTO `medicamento_entrega` VALUES (7, 20, '1 cada 8 horas', 30, 1);
INSERT INTO `medicamento_entrega` VALUES (8, 30, '1 cada 12 horas', 31, 1);
INSERT INTO `medicamento_entrega` VALUES (9, 30, '1 cada 6 horas', 32, 1);
INSERT INTO `medicamento_entrega` VALUES (10, 20, '1 cada 12 horas', 33, 1);
INSERT INTO `medicamento_entrega` VALUES (11, 200, '1 cada 8 horas', 34, 1);
INSERT INTO `medicamento_entrega` VALUES (12, 20, '1 cada 8 horas', 35, 1);
INSERT INTO `medicamento_entrega` VALUES (13, 30, '1 cada 8 horas', 36, 1);
INSERT INTO `medicamento_entrega` VALUES (14, 30, '1 cada 8 horas', 37, 1);
INSERT INTO `medicamento_entrega` VALUES (15, 20, '1 cada 8 horas', 37, 1);
INSERT INTO `medicamento_entrega` VALUES (16, 30, '1 cada 12 horas', 37, 3);
INSERT INTO `medicamento_entrega` VALUES (17, 20, '1 cada 8 horas', 38, 1);
INSERT INTO `medicamento_entrega` VALUES (18, 200, '1 cada 8 horas', 39, 1);
INSERT INTO `medicamento_entrega` VALUES (19, 20, '1 cada 8 horas', 39, 1);
INSERT INTO `medicamento_entrega` VALUES (20, 50, '1 cada dia', 40, 1);
INSERT INTO `medicamento_entrega` VALUES (21, 10, '1 cada 8 horas', 41, 1);
INSERT INTO `medicamento_entrega` VALUES (22, 20, '1 cada hora', 49, 1);
INSERT INTO `medicamento_entrega` VALUES (23, 300, 'oiufd', 57, 1);

-- ----------------------------
-- Table structure for referencia
-- ----------------------------
DROP TABLE IF EXISTS `referencia`;
CREATE TABLE `referencia`  (
  `referencia` int NOT NULL AUTO_INCREMENT,
  `consulta` int NOT NULL,
  `ambulancia` int NOT NULL,
  `hospital` int NOT NULL,
  `enfermera` int NOT NULL,
  PRIMARY KEY (`referencia`) USING BTREE,
  INDEX `consulta`(`consulta` ASC) USING BTREE,
  INDEX `ambulancia`(`ambulancia` ASC) USING BTREE,
  INDEX `hospital`(`hospital` ASC) USING BTREE,
  CONSTRAINT `referencia_ibfk_1` FOREIGN KEY (`consulta`) REFERENCES `consulta` (`consulta`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `referencia_ibfk_2` FOREIGN KEY (`ambulancia`) REFERENCES `ambulancia` (`ambulancia`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `referencia_ibfk_3` FOREIGN KEY (`hospital`) REFERENCES `hospital` (`hospital`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of referencia
-- ----------------------------
INSERT INTO `referencia` VALUES (1, 4, 3, 2, 64836728);
INSERT INTO `referencia` VALUES (2, 10, 8, 5, 23176632);
INSERT INTO `referencia` VALUES (3, 5, 8, 4, 23176632);
INSERT INTO `referencia` VALUES (4, 6, 3, 3, 64836728);
INSERT INTO `referencia` VALUES (5, 3, 2, 6, 64836728);
INSERT INTO `referencia` VALUES (6, 43, 1, 3, 13);
INSERT INTO `referencia` VALUES (7, 47, 1, 3, 13);
INSERT INTO `referencia` VALUES (8, 48, 1, 3, 13);
INSERT INTO `referencia` VALUES (9, 51, 1, 3, 13);
INSERT INTO `referencia` VALUES (10, 52, 1, 3, 13);
INSERT INTO `referencia` VALUES (11, 53, 1, 3, 13);
INSERT INTO `referencia` VALUES (12, 54, 1, 5, 13);
INSERT INTO `referencia` VALUES (13, 57, 2, 5, 14);

-- ----------------------------
-- Table structure for rol
-- ----------------------------
DROP TABLE IF EXISTS `rol`;
CREATE TABLE `rol`  (
  `rol` int NOT NULL AUTO_INCREMENT,
  `nombre_rol` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`rol`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rol
-- ----------------------------
INSERT INTO `rol` VALUES (1, 'Director');
INSERT INTO `rol` VALUES (2, 'Medico');
INSERT INTO `rol` VALUES (3, 'Enfermeria');
INSERT INTO `rol` VALUES (16, 'prueba');

-- ----------------------------
-- Table structure for tipo_ambulancia
-- ----------------------------
DROP TABLE IF EXISTS `tipo_ambulancia`;
CREATE TABLE `tipo_ambulancia`  (
  `id_tipo_ambulancia` int NOT NULL AUTO_INCREMENT,
  `nombre_tipo` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id_tipo_ambulancia`) USING BTREE,
  UNIQUE INDEX `id_tipo_ambulancia`(`id_tipo_ambulancia` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tipo_ambulancia
-- ----------------------------
INSERT INTO `tipo_ambulancia` VALUES (1, 'Básica');
INSERT INTO `tipo_ambulancia` VALUES (2, 'Avanzada');
INSERT INTO `tipo_ambulancia` VALUES (3, 'Terapia intensiva');

-- ----------------------------
-- Table structure for triaje
-- ----------------------------
DROP TABLE IF EXISTS `triaje`;
CREATE TABLE `triaje`  (
  `triaje` int NOT NULL AUTO_INCREMENT,
  `tipo` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`triaje`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of triaje
-- ----------------------------
INSERT INTO `triaje` VALUES (1, 'Rojo');
INSERT INTO `triaje` VALUES (2, 'Naranja');
INSERT INTO `triaje` VALUES (3, 'Amarillo');
INSERT INTO `triaje` VALUES (4, 'Verde');
INSERT INTO `triaje` VALUES (5, 'Azul');

SET FOREIGN_KEY_CHECKS = 1;
