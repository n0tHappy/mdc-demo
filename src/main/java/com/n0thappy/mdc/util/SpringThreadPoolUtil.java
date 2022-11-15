package com.n0thappy.mdc.util;

import com.n0thappy.mdc.config.MdcTaskDecorator;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author shuqinghua
 * @date 2022/11/15 4:58 下午
 */
public class SpringThreadPoolUtil {

    public static Executor getThreadPool(String name, int corePoolSize, int maxPoolSize, int keepActiveSeconds, int queueCapacity) {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setKeepAliveSeconds(keepActiveSeconds);
        executor.setQueueCapacity(queueCapacity);
        executor.setThreadNamePrefix(name + "-pool-");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardOldestPolicy());
        // 复制父线程traceId
        executor.setTaskDecorator(new MdcTaskDecorator());
        return executor;
    }
}
