CREATE TABLE `user` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(100) NOT NULL,
    `password` VARCHAR(200) NOT NULL,
    PRIMARY KEY(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `contact` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `phone_number` VARCHAR(12) NOT NULL,
    `address` TEXT,
    `user_id` INT NOT NULL,
    PRIMARY KEY(`id`),
    FOREIGN KEY (`user_id`) REFERENCES `user`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
