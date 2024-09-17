CREATE DATABASE IF NOT EXISTS `public_eye`;
USE `public_eye`;

DROP TABLE IF EXISTS `keywords`;
CREATE TABLE `keywords`
(
    `id`          BIGINT AUTO_INCREMENT PRIMARY KEY, -- 关键词唯一ID
    `keyword`     VARCHAR(255)             NOT NULL, -- 关键词
    `heat`        INT      DEFAULT 0,                -- 热度
    `crawl_time`  DATETIME DEFAULT NULL COMMENT '爬取时间',
    `create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
    `update_time` DATETIME DEFAULT NULL COMMENT '更新时间'
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8mb3
  COLLATE = utf8_bin;

DROP TABLE IF EXISTS `events`;
CREATE TABLE `events`
(
    `id`          BIGINT AUTO_INCREMENT PRIMARY KEY,                    -- 事件唯一ID
    `keyword_id`  BIGINT NOT NULL,                                      -- 关联关键词的外键ID
    `description` TEXT   NOT NULL,                                      -- 事件描述
    `comment_cnt` INT      DEFAULT 0,                                   -- 评论数
    `like_cnt`    INT      DEFAULT 0,                                   -- 点赞数
    `share_cnt`   INT      DEFAULT 0,                                   -- 转发次数
    `sentiment`   DECIMAL(18,16) NOT NULL,                               -- 情感值
    `event_date`  DATE   NOT NULL,                                      -- 事件发生日期
    `crawl_time`  DATETIME DEFAULT NULL COMMENT '爬取时间',
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime DEFAULT NULL COMMENT '更新时间',
    FOREIGN KEY (keyword_id) REFERENCES keywords (id) ON DELETE CASCADE -- 关联关键词表
) ENGINE = InnoDB
  AUTO_INCREMENT = 23
  DEFAULT CHARSET = utf8mb3
  COLLATE = utf8_bin;
