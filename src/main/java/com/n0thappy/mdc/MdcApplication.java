package com.n0thappy.mdc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author shuqinghua
 * @date 2022/11/14 2:02 下午
 */
@ComponentScan("com.n0thappy")
@SpringBootApplication
@EnableAspectJAutoProxy
public class MdcApplication {

    public static void main(String[] args) {
        SpringApplication.run(MdcApplication.class, args);
    }
}
