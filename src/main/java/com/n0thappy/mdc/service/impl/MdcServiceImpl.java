package com.n0thappy.mdc.service.impl;

import com.n0thappy.mdc.service.MdcService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.Executor;

/**
 * @author shuqinghua
 * @date 2022/11/14 3:34 下午
 */
@Slf4j
@Service
public class MdcServiceImpl implements MdcService {

    @Resource(name = "public")
    private Executor executor;

    @Override
    public String doSomething(String arg) {
        log.info("MdcServiceImpl.doSomething(), param: arg={}", arg);
        executor.execute(() -> log.info("异步线程执行..."));
        return "success";
    }
}
