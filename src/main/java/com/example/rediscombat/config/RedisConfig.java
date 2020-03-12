package com.example.rediscombat.config;/**
 * Created with IntelliJ IDEA.
 * User: 张渡
 * Date: 2020/3/12
 * Time: 15:47
 * Description: No Description
 */


import com.example.rediscombat.serializer.MyStringRedisSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @version 1.0
 * @author： 张渡
 * @date 2020/3/12 15:47
 * Modified By： 修改人姓名(如果有其他人修改时增加这三项)
 * Modified Date: 修改日期
 * redis 工具类
 */
@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory redisConnectionFactory){
         RedisTemplate<String,Object> redisTemplate=new RedisTemplate<>();
         redisTemplate.setConnectionFactory(redisConnectionFactory);

         /*序列化策略*/
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new MyStringRedisSerializer());//value使用自己的
        redisTemplate.setHashValueSerializer(new MyStringRedisSerializer());
        return redisTemplate;
    }
}
