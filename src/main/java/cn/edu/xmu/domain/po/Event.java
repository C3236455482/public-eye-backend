package cn.edu.xmu.domain.po;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Event implements Serializable {
    private Long id;               // 事件唯一ID
    private Long keywordId;         // 关联关键词的外键ID
    private String description;     // 事件描述
    private Integer commentCnt;     // 评论数
    private Integer likeCnt;        // 点赞数
    private Integer shareCnt;       // 转发次数
    private Double sentiment;       // 情感值
    private LocalDateTime eventDate;         // 事件发生日期
    private LocalDateTime crawlTime;        // 创建时间
    private LocalDateTime createTime;        // 创建时间
    private LocalDateTime updateTime;        // 更新时间
}