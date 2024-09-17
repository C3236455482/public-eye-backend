package cn.edu.xmu.mapper;

import cn.edu.xmu.domain.po.Event;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EventsMapper {
    @Select("SELECT * FROM events WHERE keyword_id = #{keywordId} ORDER BY event_date ASC")
    List<Event> getEventsByKeywordId(Long keywordId);

    @Select("SELECT * FROM events WHERE keyword_id = #{keywordId} ORDER BY event_date ASC LIMIT 1")
    Event getEarliestEventByKeywordId(Long keywordId);
}
