package cn.edu.xmu.domain.vo;

import cn.edu.xmu.domain.po.Event;
import lombok.Data;

import java.io.Serializable;

@Data
public class KeywordVO implements Serializable {
    private Long id;                    // 关键词唯一ID
    private String keyword;             // 关键词
    private Event representativeEvent;  // 关键词对应的代表事件
    private Integer heat;               // 热度
    private Integer sentiment;          // 情感
}
