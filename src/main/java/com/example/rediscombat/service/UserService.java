package com.example.rediscombat.service;

import com.example.rediscombat.entity.SysUser;
import com.example.rediscombat.vo.req.LoginReqVo;
import com.example.rediscombat.vo.resp.LoginRespVo;

/**
 * Created with IntelliJ IDEA.
 * User: 张渡
 * Date: 2020/3/12
 * Time: 18:50
 * Description: No Description
 */
public interface UserService {

    LoginRespVo login(LoginReqVo vo);

    SysUser getUserInfo(String id);
}
