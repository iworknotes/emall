package com.cc.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author YL.huang
 * @date 04/16/2020
 */
@Service
public class IndexService {

    private Logger logger = LoggerFactory.getLogger(Thread.currentThread().getClass());

    public void query() {
        logger.info(" -----> IndexService doing query.");
        System.out.println(1/0);
        String name = null;
        System.out.println(name.toUpperCase());
    }

}
