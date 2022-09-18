DROP
    TABLE
        IF EXISTS toolbox.toolbox_user;

CREATE
    TABLE
        toolbox.toolbox_user(
            id BIGINT PRIMARY KEY AUTO_INCREMENT,
            toolbox_user_id VARCHAR(36),
            first_name VARCHAR(255),
            last_name VARCHAR(255),
            email VARCHAR(255)
        );