CREATE SCHEMA IF NOT EXISTS DBO;
SET SCHEMA DBO;

DROP TABLE IF EXISTS MYSCOFILE;

CREATE TABLE MYSCOFILE (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  user_id VARCHAR(250) NOT NULL,
  user_name VARCHAR(250) NOT NULL,
  user_email VARCHAR(250) NOT NULL,
  customer_name  VARCHAR(250) NOT NULL,
  input_file_name VARCHAR(250) NOT NULL,
  file_row_count VARCHAR(250) DEFAULT NULL,
  file_match_count VARCHAR(250) DEFAULT NULL,
  file_status VARCHAR(250) DEFAULT NULL,
  file_sha3 VARCHAR(128) DEFAULT NULL,
  dateCreated DATETIME  DEFAULT NULL,
  dateModified DATETIME  DEFAULT NULL,
  uuid VARCHAR(128) DEFAULT NULL
);

INSERT INTO MYSCOFILE (user_id, user_name, user_email, customer_name, input_file_name, file_row_count,file_status, file_sha3, dateCreated, dateModified, uuid) VALUES
('24548d05-5274-4ea0-82aa-f1693cb82045', 'Hu, YuCheng', 'YuCheng.Hu@insight.com', 'My First', 'Hu, YuCheng-01.csv', '65', 'NEW', '47ec963787f3acf88747ca7a37ccac9e2cc9b05c87eda1852cb4bc3b0273a431', '2020-10-22 12:47:52.690', CURRENT_TIMESTAMP(), '2796fc55-b50e-423e-ad8c-bf2c9239a02c'),
('24548d05-5274-4ea0-82aa-f1693cb82045', 'Hu, YuCheng', 'YuCheng.Hu@insight.com', 'HoneyMoose', 'Hu, YuCheng-02.csv', '85', 'NEW', 'f1290186a5d0b1ceab27f4e77c0c5d68', '2020-10-22 11:47:52.690', CURRENT_TIMESTAMP(), '2796fc55-b50e-423e-ad8c-bf2c9239a02c'),
('24548d05-5274-4ea0-82aa-f1693cb82045', 'Hu, YuCheng', 'YuCheng.Hu@insight.com', 'Testing', 'Hu, YuCheng-03.csv', '78', 'NEW', 'ff1ccf57e98c817df1efcd9fe44a8aeb', '2020-10-22 13:47:52.690', CURRENT_TIMESTAMP(), 'd98209a4-e2c7-4257-9144-3c48ccb24f69'),
('d21c6925-365e-4170-87c6-7863df5afefc', 'Dasilva, Stacy', 'Stacy.Dasilva@insight.com', 'Dasilva, Stacy First',  'Dasilva, Stacy-01.csv', '78', 'NEW', '37693cfc748049e45d87b8c7d8b9aacd', '2020-10-22 13:47:52.690', CURRENT_TIMESTAMP(), '8ec09e3b-0b9f-4fd8-aec0-ad3d77d8d656'),
('d21c6925-365e-4170-87c6-7863df5afefc', 'Dasilva, Stacy', 'Stacy.Dasilva@insight.com', 'I Changed Name', 'Dasilva, Stacy-02.csv', '78', 'NEW', 'd785c99d298a4e9e6e13fe99e602ef42', '2020-10-22 13:47:52.690', CURRENT_TIMESTAMP(), '07ceed76-5638-47ff-bb4e-acc1db0f1a37'),
('d443b93f-869c-4e46-a5e5-7f19fe2b1640', 'Yeung, Eric', 'Eric.Yeung@insight.com', 'Find it-A', 'Yeung, Eric-01.csv', '78', 'NEW', '85e17c3d948ae38811ff453ff1182ad9', '2020-10-22 13:47:52.690', CURRENT_TIMESTAMP(), 'f518a09c-85e8-45f1-b759-4050dd45e6b9'),
('d443b93f-869c-4e46-a5e5-7f19fe2b1640', 'Yeung, Eric', 'Eric.Yeung@insight.com', 'Find it-B', 'Yeung, Eric-02.csv', '78', 'NEW', '85e17c3d948ae38811ff453ff1182ad9', '2020-10-22 13:47:52.690', CURRENT_TIMESTAMP(), 'f518a09c-85e8-45f1-b759-4050dd45e6b9'),
('d443b93f-869c-4e46-a5e5-7f19fe2b1640', 'Yeung, Eric', 'Eric.Yeung@insight.com', 'Find it-C', 'Yeung, Eric-03.csv', '78', 'NEW', '85e17c3d948ae38811ff453ff1182ad9', '2020-10-22 13:47:52.690', CURRENT_TIMESTAMP(), 'f518a09c-85e8-45f1-b759-4050dd45e6b9');