package com.example.rediscombat.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
* @author         张渡
* @version        1.0
* @date           2020/3/12 18:00
* Modified By    修改人姓名(如果有其他人修改时增加这三项)
* Modified Date: 修改日期
* Why & What is modified  修改原因描述
*/

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createDocket(){
        List<Parameter> parameterList=new ArrayList<>();
        ParameterBuilder parameterBuilder=new ParameterBuilder();
        parameterBuilder.name("token").description("swagger调试用(模拟传入用户认证凭证)").modelRef(new ModelRef("String"))
                .parameterType("header").required(false);
        parameterList.add(parameterBuilder.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.rediscombat.controller"))//接口的包名
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(parameterList)
                ;
    }
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().
                title("Spring Boot 2.x视频教程")
                .description("spring boot 2.x 零基础到高级一个实战视频教程")
                .version("1.0")
                .build();
    }
}
