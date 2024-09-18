package cn.edu.xmu.mapper;

import cn.edu.xmu.domain.po.Keyword;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface KeywordsMapper {

//    @Select("SELECT * FROM keywords ORDER BY heat DESC")
    List<Keyword> getKeywordsList(@Param("searchTerm") String searchTerm);
}
