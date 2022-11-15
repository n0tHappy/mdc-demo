package com.n0thappy.mdc.util;

import org.springframework.scheduling.concurrent.CustomizableThreadFactory;

import java.util.concurrent.*;

/**
 * @author shuqinghua
 * @date 2022/11/15 2:51 下午
 */
public class ThreadPoolUtil {

    public static Executor getThreadPool(String name, int corePoolSize, int maxPoolSize, int keepActiveS, int queueCapacity) {
        ThreadFactory namedThreadFactory = new CustomizableThreadFactory(name + "-pool-");
        return new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepActiveS, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(queueCapacity), namedThreadFactory,
                new ThreadPoolExecutor.DiscardOldestPolicy());
    }


}
