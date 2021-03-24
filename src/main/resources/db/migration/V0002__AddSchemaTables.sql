CREATE TABLE IF NOT EXISTS play_schemas (id INT PRIMARY KEY AUTO_INCREMENT,
                    scheme_ta INT,
                     scheme_tdm INT,
                      scheme_df INT) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

INSERT INTO play_schemas VALUES (1,3,3,4);
INSERT INTO play_schemas VALUES (2,2,5,3);
INSERT INTO play_schemas VALUES (3,1,5,4);
INSERT INTO play_schemas VALUES (4,2,4,4);
INSERT INTO play_schemas VALUES (5,4,2,4);
INSERT INTO play_schemas VALUES (6,3,4,3);

CREATE TABLE IF NOT EXISTS play_position (id INT PRIMARY KEY AUTO_INCREMENT,
                       position_id INT,
                       coef_ta DOUBLE,
                       coef_tdm DOUBLE,
                       coef_df DOUBLE,
                        coef_gl DOUBLE) ENGINE=InnoDB DEFAULT CHARSET=UTF8;

INSERT INTO play_position VALUES (1,4,1.0,0.7,0.3,0.0);
INSERT INTO play_position VALUES (2,3,1.0,0.7,0.3,0.0);
INSERT INTO play_position VALUES (3,2,1.0,0.8,0.2,0.0);
INSERT INTO play_position VALUES (4,1,0.5,1.0,0.3,0.0);
INSERT INTO play_position VALUES (5,0,0.4,1.0,0.4,0.0);
INSERT INTO play_position VALUES (6,-1,0.3,1.0,0.6,0.1);
INSERT INTO play_position VALUES (7,-2,0.3,0.8,1.0,0.2);
INSERT INTO play_position VALUES (8,-3,0.2,0.8,1.0,0.3);
INSERT INTO play_position VALUES (9,-4,0.1,0.6,0.9,1.0);
