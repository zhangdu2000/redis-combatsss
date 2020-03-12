package com.example.rediscombat.vo.resp;/**
 * Created with IntelliJ IDEA.
 * User: 张渡
 * Date: 2020/3/12
 * Time: 18:43
 * Description: No Description
 */

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @version 1.0
 * @author： 张渡
 * @date 2020/3/12 18:43
 * Modified By： 修改人姓名(如果有其他人修改时增加这三项)
 * Modified Date: 修改日期
 * Why & What is modified  修改原因描述
 */
@Data
public class LoginRespVo {
    @ApiModelProperty(value = "用户认证凭证")
    private  String token;
    @ApiModelProperty(value = "用户id")
    private  String userId;
}
