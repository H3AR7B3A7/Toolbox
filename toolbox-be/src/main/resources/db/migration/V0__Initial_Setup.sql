DROP TABLE IF EXISTS toolbox.toolbox_user;

CREATE TABLE toolbox.toolbox_user (
                                id BIGINT(44) PRIMARY KEY AUTO_INCREMENT,
                                user_name VARCHAR(255),
                                first_name VARCHAR(255),
                                last_name VARCHAR(255),
                                email VARCHAR(255)
);