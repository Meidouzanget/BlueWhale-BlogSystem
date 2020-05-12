package com.melcoc.bluewhale.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.melcoc.bluewhale.domain.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ArticleDao extends BaseMapper<Article> {
    @Insert("INSERT INTO article(a_id,user_id,create_time,content,deleted) " +"VALUES(#{aId},#{userId},#{createTime},#{content},#{deleted})")
    @Options(useGeneratedKeys = true, keyProperty = "aId", keyColumn = "aId")
    int insertArticle(Article article);


    @Select("select * from article as a left join img  as i on a.a_id=i.a_id ")
    List selectAll();

}
