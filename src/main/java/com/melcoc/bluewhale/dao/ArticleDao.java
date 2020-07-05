package com.melcoc.bluewhale.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.melcoc.bluewhale.domain.Article;
import org.apache.ibatis.annotations.*;
import org.springframework.data.jpa.repository.Lock;

import javax.persistence.LockModeType;
import java.util.List;

@Mapper
public interface ArticleDao extends BaseMapper<Article> {
    @Insert("INSERT INTO article(a_id,user_id,create_time,content,deleted,url) " +"VALUES(#{aId},#{userId},#{createTime},#{content},#{deleted},#{url})")
    @Options(useGeneratedKeys = true, keyProperty = "aId", keyColumn = "aId")
    int insertArticle(Article article);

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
    @Update("UPDATE article SET deleted=1 where a_id=#{aId} and user_id=#{userId};")
    int deletedArticle(Integer aId,Integer userId);

    /**
     * 单用户文章的全查询
     * @return
     */
    @Select("select t1.*,t2.name,t2.nick_name,t2.avatar from article t1 LEFT JOIN  user t2  ON t1.user_id =t2.user_id WHERE t1.deleted=0 and t2.name=#{name} order by t1.a_id desc")
    List<Article> selectArticleByUserName(String name);
//    List<Map<String,Object>> selectUserAll(Integer userId);

    //多表联合查询
    @Select("select t1.*,t2.name,t2.nick_name,t2.avatar from article t1 LEFT JOIN  user t2  ON t1.user_id =t2.user_id WHERE t1.deleted=0 order by t1.a_id desc ")
    List<Article> articleUserList();
    //查询最新一条文章
    @Select("select t1.*,t2.name,t2.nick_name,t2.avatar from article t1 LEFT JOIN  user t2  ON t1.user_id =t2.user_id WHERE t1.deleted=0 order by t1.a_id desc limit 1")
    List<Article> articleUser();
}
