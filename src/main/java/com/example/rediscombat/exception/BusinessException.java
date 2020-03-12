package com.example.rediscombat.exception;/**
 * Created with IntelliJ IDEA.
 * User: 张渡
 * Date: 2020/3/12
 * Time: 15:57
 * Description: No Description
 */

/**
 * @version 1.0
 * @author： 张渡
 * @date 2020/3/12 15:57
 * Modified By： 修改人姓名(如果有其他人修改时增加这三项)
 * Modified Date: 修改日期
 * 不是系统异常，是业务异常(自定义运行时异常)
 */
public class BusinessException extends RuntimeException{

        private final int messageCode;

        private final  String messageDefault;

    public BusinessException(int messageCode, String message) {
        super(message);
        this.messageCode = messageCode;
        this.messageDefault = message;
    }

    public int getMessageCode() {
        return messageCode;
    }

    public String getMessageDefault() {
        return messageDefault;
    }
}
