--  h2
CREATE TABLE IF NOT EXISTS posts (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    type INT NOT NULL,
    reg_date TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    mod_date TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

-- mysql
--  CREATE TABLE IF NOT EXISTS posts (
--       id BIGINT NOT NULL AUTO_INCREMENT,
--       title VARCHAR(255) NOT NULL,
--       content TEXT NOT NULL,
--       type INT NOT NULL,
--       reg_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
--       mod_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
--       PRIMARY KEY (id)
--  ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;