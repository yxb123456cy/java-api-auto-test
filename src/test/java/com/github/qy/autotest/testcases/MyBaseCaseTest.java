package com.github.qy.autotest.testcases;

import cn.hutool.http.HttpUtil;
import com.github.qy.autotest.entity.CaseData;

import com.github.qy.autotest.utils.ExcelUtil;
import com.github.qy.autotest.utils.TestDataProvider;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class MyBaseCaseTest {
    public static Logger logger = Logger.getLogger(MyBaseCaseTest.class);
    public static List<CaseData> caseDataList = new ArrayList<>();
    private static final String API_BASEURL = "localhost:8080";
    private static final String COMMON_PREFIX = "http://";

    @Test
    public void test() {
        System.out.println("hello, autotest");
        logger.info("finish");
        System.out.println(caseDataList);
        String resp = HttpUtil.get(COMMON_PREFIX + API_BASEURL + caseDataList.get(0).getUrl());
        System.out.println(resp);
    }

    @BeforeTest
    public void raedTestDataFromExcel() {
        ExcelUtil.readData();
        caseDataList = TestDataProvider.getCaseDataList();
    }
}
