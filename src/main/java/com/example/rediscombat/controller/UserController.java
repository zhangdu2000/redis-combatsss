package com.example.rediscombat.controller;/**
 * Created with IntelliJ IDEA.
 * User: 张渡
 * Date: 2020/3/12
 * Time: 19:24
 * Description: No Description
 */

import com.example.rediscombat.entity.SysUser;
import com.example.rediscombat.service.UserService;
import com.example.rediscombat.vo.req.LoginReqVo;
import com.example.rediscombat.vo.resp.LoginRespVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @version 1.0
 * @author： 张渡
 * @date 2020/3/12 19:24
 * Modified By： 修改人姓名(如果有其他人修改时增加这三项)
 * Modified Date: 修改日期
 * Why & What is modified  修改原因描述
 */
@RestController
@RequestMapping("/api")
@Api(tags = "用户模块",description = "用户模块相关接口")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/login")
    @ApiModelProperty(value ="登录接口")
    public LoginRespVo login(@RequestBody LoginReqVo vo){
        return userService.login(vo);
    }

    @GetMapping("/user/{id}")
    @ApiOperation(value = "获取用户信息接口")
    public SysUser getUserInfo(@PathVariable("id") String id){
        return userService.getUserInfo(id);
    }
}
