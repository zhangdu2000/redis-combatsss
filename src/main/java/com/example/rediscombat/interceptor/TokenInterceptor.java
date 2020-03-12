package com.example.rediscombat.interceptor;/**
 * Created with IntelliJ IDEA.
 * User: 张渡
 * Date: 2020/3/12
 * Time: 19:30
 * 自定义拦截器
 */


import com.example.rediscombat.exception.BusinessException;
import com.example.rediscombat.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @version 1.0
 * @author： 张渡
 * @date 2020/3/12 19:30
 * Modified By： 修改人姓名(如果有其他人修改时增加这三项)
 * Modified Date: 修改日期
 * Why & What is modified  修改原因描述
 */
public class TokenInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisService redisService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //1、从Header拿到token
        String token=request.getHeader("token");
        if(StringUtils.isEmpty(token)){
            throw new BusinessException(4001002,"用户凭证不能为空,请重新登录");
        }else {
            if(!redisService.hasKey(token)){
                throw new BusinessException(4001002,"用户凭证无效,请重新登录");
            }
        }

        return true;
    }
}
