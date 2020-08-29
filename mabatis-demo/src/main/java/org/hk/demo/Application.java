package org.hk.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan(basePackages = "org.hk.demo.mapper")
@ComponentScan(basePackages = "org.hk.demo")
public class Application {
    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class).properties("spring.config.name:application,db").build().run(args);
    }
}
