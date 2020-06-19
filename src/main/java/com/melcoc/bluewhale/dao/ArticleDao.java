package com.melcoc.bluewhale.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.melcoc.bluewhale.domain.Article;
import com.melcoc.bluewhale.domain.Img;
import org.apache.ibatis.annotations.*;
import org.springframework.data.jpa.repository.Lock;

import javax.persistence.LockModeType;
import java.util.List;

@Mapper
public interface ArticleDao extends BaseMapper<Article> {
    @Insert("INSERT INTO article(a_id,user_id,create_time,content,deleted,url) " +"VALUES(#{aId},#{userId},#{createTime},#{content},#{deleted},#{url})")
    @Options(useGeneratedKeys = true, keyProperty = "aId", keyColumn = "aId")
    int insertArticle(Article article);


    @Select("select article.a_id,article.user_id,article.create_time,article.content,article.deleted,article.great_num,img.url from article,img where article.a_id=img.a_id")
    List<Article> selectAll();

    /**
     * 点赞模块
     * @param aid
     * @return
     */
    @Lock(value = LockModeType.PESSIMISTIC_WRITE)
    @Select("select * from article where a_id=#{aId}")
    Article findByIdForUpdate(int aid);
    @Update("UPDATE article SET great_num=#{greatNum} where a_id=#{aId};")
    int saveAndFlush(Article article);

    /**
     * 逻辑删除
     */
    @Update("UPDATE article SET deleted=0 where a_id=#{aId};")
    int deletedArticle(Integer aId);

    /**
     * 单用户文章的全查询
     * @return
     */
    List<Article> selectUserAll(Integer userId);
}
