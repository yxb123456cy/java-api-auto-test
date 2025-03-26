package com.github.qy.autotest.testcases;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class MyBaseCase {
    public static Logger logger = Logger.getLogger(MyBaseCase.class);

    @Test
    public void test() {
        System.out.println("hello, autotest");
        logger.info("finish");
    }
}
