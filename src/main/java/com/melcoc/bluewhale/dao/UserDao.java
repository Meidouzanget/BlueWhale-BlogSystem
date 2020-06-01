package com.melcoc.bluewhale.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.melcoc.bluewhale.domain.LUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao extends BaseMapper<LUser>
{
    @Select("select * from l_user u inner join `l_userrole` ur on (ur.uid=u.uid) inner join `l_role` r on (r.rid=ur.rid) inner join `l_rolepermission` rp on (rp.`rid`=r.rid) inner join `l_permission` p on (rp.pid=p.pid) where account=#{account} limit 1")
    LUser getUserWithPermission(@Param("account") String account);
}
