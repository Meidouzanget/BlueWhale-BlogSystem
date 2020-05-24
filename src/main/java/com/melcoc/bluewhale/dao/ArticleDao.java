package com.melcoc.bluewhale.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.melcoc.bluewhale.domain.Article;
import com.melcoc.bluewhale.domain.Img;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ArticleDao extends BaseMapper<Article> {
    @Insert("INSERT INTO article(a_id,user_id,create_time,content,deleted) " +"VALUES(#{aId},#{userId},#{createTime},#{content},#{deleted})")
    @Options(useGeneratedKeys = true, keyProperty = "aId", keyColumn = "aId")
    int insertArticle(Article article);


    @Select("select * FROM article  as a   left JOIN img as i  on a.deleted=1 and a.a_id=i.a_id")
    List<Article> selectAll();

    @Update("UPDATE article SET greatnum=#{greatnum} where aid=#{aId}")
    Article updateById(int aid);
}
