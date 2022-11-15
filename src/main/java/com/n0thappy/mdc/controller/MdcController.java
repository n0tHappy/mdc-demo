package com.n0thappy.mdc.controller;

import com.n0thappy.mdc.service.MdcService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shuqinghua
 * @date 2022/11/14 2:04 下午
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class MdcController {

    @Autowired
    private MdcService mdcService;

    @GetMapping("/test")
    public String test(String arg) {
        mdcService.doSomething(arg);
        return "success";
    }

}
