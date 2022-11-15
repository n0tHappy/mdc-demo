package com.n0thappy.mdc.config;

import com.n0thappy.mdc.util.SpringThreadPoolUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executor;

/**
 * @author shuqinghua
 * @date 2022/11/15 2:50 下午
 */
@Configuration
public class ThreadPoolConfig {

    @Bean("public")
    public Executor getPublicPool() {
        return SpringThreadPoolUtil.getThreadPool("public", 50, 100, 60, 200000);
    }

}
