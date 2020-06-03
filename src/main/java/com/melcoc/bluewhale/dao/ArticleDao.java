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
    @Insert("INSERT INTO article(a_id,user_id,create_time,content,deleted) " +"VALUES(#{aId},#{userId},#{createTime},#{content},#{deleted})")
    @Options(useGeneratedKeys = true, keyProperty = "aId", keyColumn = "aId")
    int insertArticle(Article article);


    @Select("select * FROM article  as a   left JOIN img as i  on a.deleted=1 and a.a_id=i.a_id")
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
}
