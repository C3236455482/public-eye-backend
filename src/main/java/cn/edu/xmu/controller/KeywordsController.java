package cn.edu.xmu.controller;

import cn.edu.xmu.domain.po.Event;
import cn.edu.xmu.result.PageResult;
import cn.edu.xmu.result.Result;
import cn.edu.xmu.service.KeywordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/keywords")
public class KeywordsController {

    @Autowired
    private KeywordsService keywordsService;

    @GetMapping("/list")
    public Result<PageResult> getKeywordsList(
            @RequestParam(defaultValue = "1") int page,  // 页码，从1开始
            @RequestParam(defaultValue = "10") int size  // 每页条数
    ) {
        try {
            // 获取分页数据
            PageResult pageResult = keywordsService.getKeywordsList(page, size);
            return Result.success(pageResult);
        } catch (Exception e) {
            return Result.error("Failed to fetch keywords list: " + e.getMessage());
        }
    }

    @GetMapping("/{id}/events")
    public Result<List<Event>> getEventsByKeywordId(@PathVariable Long id) {
        try {
            List<Event> events = keywordsService.getEventsByKeywordId(id);
            return Result.success(events);
        } catch (Exception e) {
            return Result.error("Failed to fetch events for keyword ID: " + id);
        }
    }

}
