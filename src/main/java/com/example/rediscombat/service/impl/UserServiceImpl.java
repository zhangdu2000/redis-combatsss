package com.example.rediscombat.service.impl;
/**
 * Created with IntelliJ IDEA.
 * User: 张渡
 * Date: 2020/3/12
 * Time: 18:52
 * Description: No Description
 */
import com.example.rediscombat.service.RedisService;
import com.example.rediscombat.utils.PasswordEncoder;
import com.example.rediscombat.utils.PasswordUtils;
import com.example.rediscombat.entity.SysUser;
import com.example.rediscombat.exception.BusinessException;
import com.example.rediscombat.mapper.SysUserMapper;
import com.example.rediscombat.service.UserService;
import com.example.rediscombat.vo.req.LoginReqVo;
import com.example.rediscombat.vo.resp.LoginRespVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @version 1.0
 * @author： 张渡
 * @date 2020/3/12 18:52
 * Modified By： 修改人姓名(如果有其他人修改时增加这三项)
 * Modified Date: 修改日期
 * Why & What is modified  修改原因描述
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private SysUserMapper sysUserMapper;
    @Autowired
    private RedisService redisService;
    @Override
    public LoginRespVo login(LoginReqVo vo) {
        SysUser sysUser = sysUserMapper.selectByUsername(vo.getUsername());
        if(sysUser==null){
            throw new BusinessException(4001005,"不存在该用户,请先注册");
        }
        if(sysUser.getStatus()==2){
            throw new BusinessException(4001006,"该账号已被禁用请联系系统管理员");
        }
        /*加密盐值、明文密码、数据库密文密文*/
        if(!PasswordUtils.matches(sysUser.getSalt(),vo.getPassword(),sysUser.getPassword())){
            throw new BusinessException(4001007,"账号用户名密码不匹配");
        }

        /*登录成功，就生成token*/
        String token= UUID.randomUUID().toString();
        LoginRespVo respVo=new LoginRespVo();
        respVo.setUserId(sysUser.getId());//把用户id保存到token中
        respVo.setToken(token);//保存到token中
        //TimeUnit.MINUTESG  时间格式
        redisService.set(token,sysUser.getId(),60, TimeUnit.MINUTES);//保存到redis中,并设置时间60分钟
        return respVo;
    }

    @Override
    public SysUser getUserInfo(String id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }
}
