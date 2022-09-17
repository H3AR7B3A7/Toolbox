DROP
    TABLE
        IF EXISTS toolbox.todo_board;

DROP
    TABLE
        IF EXISTS toolbox.todo;

CREATE
    TABLE
        toolbox.todo_board(
            id BIGINT PRIMARY KEY AUTO_INCREMENT,
            todo_board_id VARCHAR(36) NOT NULL,
            title VARCHAR(255) NOT NULL,
            toolbox_user_id BIGINT,
            FOREIGN KEY(toolbox_user_id) REFERENCES toolbox_user(id)
        );

CREATE
    TABLE
        toolbox.todo(
            id BIGINT PRIMARY KEY AUTO_INCREMENT,
            todo_id VARCHAR(36),
            title VARCHAR(255),
            body VARCHAR(255),
            todo_board_id BIGINT,
            FOREIGN KEY(todo_board_id) REFERENCES todo_board(id)
        );