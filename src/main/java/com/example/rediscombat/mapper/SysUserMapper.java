package com.example.rediscombat.mapper;

import com.example.rediscombat.entity.SysUser;
import org.springframework.stereotype.Repository;

/**
* @author         张渡
* @version        1.0
* @date           2020/3/12 18:31
* Modified By    修改人姓名(如果有其他人修改时增加这三项)
* Modified Date: 修改日期
* Why & What is modified  修改原因描述
*/
@Repository
public interface SysUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(SysUser record);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SysUser record);

    int updateByPrimaryKey(SysUser record);

    SysUser selectByUsername(String username);
}
