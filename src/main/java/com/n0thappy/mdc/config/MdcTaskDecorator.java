package com.n0thappy.mdc.config;

import com.n0thappy.mdc.util.LogTraceGenerator;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.core.task.TaskDecorator;

import java.util.Map;

/**
 * @author shuqinghua
 * @date 2022/11/15 3:25 下午
 */
@Slf4j
public class MdcTaskDecorator implements TaskDecorator {

    @Override
    public Runnable decorate(Runnable runnable) {
        try{
            Map<String, String> contextMap = MDC.getCopyOfContextMap();
            return () -> {
                MDC.clear();
                if (contextMap != null && !contextMap.isEmpty()) {
                    MDC.put("traceId", LogTraceGenerator.generateShortUuid(contextMap.getOrDefault("traceId", null)));
                }
                runnable.run();
            };
        } finally {
        }
    }
}
