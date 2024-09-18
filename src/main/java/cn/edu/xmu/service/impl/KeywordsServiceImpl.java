package cn.edu.xmu.service.impl;

import cn.edu.xmu.domain.po.Event;
import cn.edu.xmu.domain.po.Keyword;
import cn.edu.xmu.domain.vo.KeywordVO;
import cn.edu.xmu.mapper.EventsMapper;
import cn.edu.xmu.mapper.KeywordsMapper;
import cn.edu.xmu.result.PageResult;
import cn.edu.xmu.service.KeywordsService;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class KeywordsServiceImpl implements KeywordsService {

    @Autowired
    private KeywordsMapper keywordsMapper;

    @Autowired
    private EventsMapper eventsMapper;

    @Override
    public PageResult getKeywordsList(int page, int size, String searchTerm) {
        // 开启分页，PageHelper 会自动生成分页的 SQL 语句
        PageHelper.startPage(page, size);
        List<Keyword> keywordsList = keywordsMapper.getKeywordsList(searchTerm);

        // 使用 PageInfo 获取分页信息
        PageInfo<Keyword> pageInfo = new PageInfo<>(keywordsList);

        // 转换为 KeywordVO 列表，并获取最早的事件作为代表事件
        ArrayList<KeywordVO> keywordVOS = CollUtil.newArrayList(keywordsList.stream()
                .map(keyword -> {
                    // 创建并填充 KeywordVO
                    KeywordVO keywordVO = new KeywordVO();
                    BeanUtil.copyProperties(keyword, keywordVO);

                    // 获取该关键词对应的最早事件
                    Event earliestEvent = eventsMapper.getEarliestEventByKeywordId(keyword.getId());

                    if (earliestEvent != null) {
                        // 设置代表事件到 KeywordVO
                        keywordVO.setRepresentativeEvent(earliestEvent);
                    }

                    return keywordVO;
                })
                .collect(Collectors.toList()));

        // 构造 PageResult 对象，返回总记录数和当前页数据
        return new PageResult(pageInfo.getTotal(), keywordVOS);
    }

    @Override
    public List<Event> getEventsByKeywordId(Long keywordId) {
        // 使用 EventsMapper 获取事件列表
        return eventsMapper.getEventsByKeywordId(keywordId);
    }
}
