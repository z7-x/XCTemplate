/**修改主键id为String id格式采取MongoDB主键生成策略**/
CREATE TABLE XC_USER
(
	ID VARCHAR(50) NOT NULL,
	SEX CHAR(1) not null,
	NAME VARCHAR(50) not null,
	EMAIL VARCHAR(50),
	PHONE VARCHAR(25),
	DESCRIBE VARCHAR(500),
	CLUSTER PRIMARY KEY("ID") ENABLE
);

CREATE TABLE "XC_ROLE"
(
 "ID" INT IDENTITY(1,1) NOT NULL,
 "NAME" VARCHAR(50) NOT NULL,
  CLUSTER PRIMARY KEY("ID") ENABLE
);

CREATE TABLE "XC_PERMISSION"
(
 "ID" INT IDENTITY(1,1) NOT NULL,
 "NAME" VARCHAR(50) NOT NULL,
  CLUSTER PRIMARY KEY("ID") ENABLE
);

SET IDENTITY_INSERT "XC_PERMISSION" ON;
INSERT INTO "XC_PERMISSION"("ID","NAME") VALUES(1,'具有读写权限');
INSERT INTO "XC_PERMISSION"("ID","NAME") VALUES(2,'具有读权限 ');

SET IDENTITY_INSERT "XC_PERMISSION" OFF;
SET IDENTITY_INSERT "XC_ROLE" ON;
INSERT INTO "XC_ROLE"("ID","NAME") VALUES(1,'管理员');
INSERT INTO "XC_ROLE"("ID","NAME") VALUES(2,'用户');

SET IDENTITY_INSERT "XC_ROLE" OFF;

SET IDENTITY_INSERT "XC_USER" ON;
INSERT INTO "XC_USER"("ID","SEX","NAME","EMAIL","PHONE","DESCRIBE") VALUES('6087b87125aca094d39db80f','F','李丽','lily@sina.com','02788548562','宪法是国家的根本法，在国家法律体系中居于最高的地位，是依法治国的基础，是一切国家机关、社会团体和公民的最高行为准则。');
INSERT INTO "XC_USER"("ID","SEX","NAME","EMAIL","PHONE","DESCRIBE") VALUES('6087b87125aca094d39db810','M','王刚','','02787584562','《宪法》第1条规定：“中华人民共和国是工人阶级领导的、以工农联盟为基础的人民民主专政的社会主义国家。”这就确认了我国的国家性质是人民民主专政。');
INSERT INTO "XC_USER"("ID","SEX","NAME","EMAIL","PHONE","DESCRIBE") VALUES('6087b87125aca094d39db811','M','李勇','','02782585462','政体，亦即政权组织形式，是指国家政权的构成形式，即特定社会的统治阶级按照一定的原则具体组成，并代表国家系统地行使权力的国家政权机关体系。');
INSERT INTO "XC_USER"("ID","SEX","NAME","EMAIL","PHONE","DESCRIBE") VALUES('6087b87125aca094d39db812','F','郭艳','','02787785462','《宪法》第2条规定：“中华人民共和国的一切权力属于人民。”“人民行使国家权力的机关是全国人民代表大会和地方各级人民代表大会。”');
INSERT INTO "XC_USER"("ID","SEX","NAME","EMAIL","PHONE","DESCRIBE") VALUES('6087b87125aca094d39db813','F','孙丽','','13055173012','第3条第1款规定：“中华人民共和国的国家机构实行民主集中制的原则。”这些规定表明，人民代表大会制度是我国人民民主专政的政权组织形式。');
INSERT INTO "XC_USER"("ID","SEX","NAME","EMAIL","PHONE","DESCRIBE") VALUES('6087b87125aca094d39db814','M','黄非','','13355173012','公民是一个法律概念，它通常是指具有某个国家国籍的个人。《宪法》第33条第1款规定：“凡具有中华人民共和国国籍的人都是中华人民共和国公民。');
INSERT INTO "XC_USER"("ID","SEX","NAME","EMAIL","PHONE","DESCRIBE") VALUES('6087b87125aca094d39db815','F','王菲','','13255173012','”具有我国国籍是成为我国公民的唯一资格条件。公民的基本权利包括：(1)平等权;(2)政治权利和自由;(3)宗教信仰自由;(4)人身自由;(5)监督权;(6)社会经济文化权利;(7)特定主体的权利保护。');
INSERT INTO "XC_USER"("ID","SEX","NAME","EMAIL","PHONE","DESCRIBE") VALUES('6087b87125aca094d39db816','M','张平','','13455173012','全国人民代表大会是我国的最高国家权力机关，又是行使国家立法权的机关。全国人民代表大会由省、自治区、直辖市和军队选出的代表组成。每届任期五年。');
INSERT INTO "XC_USER"("ID","SEX","NAME","EMAIL","PHONE","DESCRIBE") VALUES('6087b87125aca094d39db817','M','张红','','13555173012','全国人民代表大会会议每年举行一次，由全国人大常委会召集。如果全国人大常委会认为必要，或者有1/5以上的全国人大代表提议，可以临时召集全国人大会议。');
INSERT INTO "XC_USER"("ID","SEX","NAME","EMAIL","PHONE","DESCRIBE") VALUES('6087b87125aca094d39db818','F','刘佳','','13955173012','全国人民代表大会的职权可以概括为以下六类：①修改宪法、监督宪法的实施;②制定和修改基本法律;③最高国家机关领导人的任免权;④国家重大事项的决定权;⑤最高监督权;⑥应当由最高国家权力机关行使的其他职权。');
INSERT INTO "XC_USER"("ID","SEX","NAME","EMAIL","PHONE","DESCRIBE") VALUES('6087b87125aca094d39db819','F','王南','','15955173012','全国人大常委会是全国人民代表大会的常设机关，是在全国人大闭会期间行使最高国家权力的机关，也是国家的立法机关。它在地位上从属于全国人民代表大会。');
INSERT INTO "XC_USER"("ID","SEX","NAME","EMAIL","PHONE","DESCRIBE") VALUES('6087b87125aca094d39db820','F','李飞','','15954173012','全国人大常委会的职权是：①解释宪法和法律、监督宪法的实施;②国家立法权;③国家重要事项决定权;④人事任免权;⑤监督权;⑥全国人大授予的其他职权。');
INSERT INTO "XC_USER"("ID","SEX","NAME","EMAIL","PHONE","DESCRIBE") VALUES('6087b87125aca094d39db821','F','张大海','','15955673012','国务院即中央人民政府，是最高国家权力机关的执行机关，是最高国家行政机关。它对全国人大及其常委会负责并报告工作。国务院由总理、副总理若干人、国务委员若干人、各部部长、各委员会主任、审计长、秘书长组成。它的每届任期同全国人大每届任期相同。');
INSERT INTO "XC_USER"("ID","SEX","NAME","EMAIL","PHONE","DESCRIBE") VALUES('6087b87125aca094d39db822','F','王宇轩','','15955175012','总理、副总理、国务委员连续任职不得超过两届。国务院实行总理负责制。国务院的机构设置包括各部、各委员会、办公机构、直属机构和办事机构。');
INSERT INTO "XC_USER"("ID","SEX","NAME","EMAIL","PHONE","DESCRIBE") VALUES('6087b87125aca094d39db823','F','桑泽恩','','15955173024','中国人民政治协商会议(简称人民政协)是中国人民爱国统一战线的组织，是中国共产党领导的多党合作和政治协商的重要机构，是中国政治生活中发扬社会主义民主的一种重要形式。');
INSERT INTO "XC_USER"("ID","SEX","NAME","EMAIL","PHONE","DESCRIBE") VALUES('6087b87125aca094d39db824','F','刘青','','15955173055','中国人民政治协商会议，是中国各族人民经过长期的革命斗争，在新中国成立前夕，由中国共产党和各民主党派、无党派民主人士、各人民团体、各界爱国人士共同创立的。');
INSERT INTO "XC_USER"("ID","SEX","NAME","EMAIL","PHONE","DESCRIBE") VALUES('6087b87125aca094d39db825','F','杨兰','yanglan@sina.com','02785584662','国家大政方针和群众生活的重要问题进行政治协商，并通过建议和批评发挥参政议政、民主监督的作用。这有利于坚持和改善共产党的领导，又有利于更广泛地联系和团结各阶层群众。');
SET IDENTITY_INSERT "XC_USER" OFF;


