package cn.edu.xmu.domain.po;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Keyword implements Serializable {
    private Long id;                    // 关键词唯一ID
    private String keyword;             // 关键词
    private Integer heat;               // 热度
    private LocalDateTime crawlTime;    // 记录爬取时间
    private LocalDateTime createdTime;  // 记录创建时间
    private LocalDateTime updatedTime;  // 记录更新时间
}
