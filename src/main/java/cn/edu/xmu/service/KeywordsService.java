package cn.edu.xmu.service;

import cn.edu.xmu.domain.po.Event;
import cn.edu.xmu.result.PageResult;

import java.util.List;

public interface KeywordsService {
    PageResult getKeywordsList(int page, int size, String searchTerm);

    List<Event> getEventsByKeywordId(Long id);
}
