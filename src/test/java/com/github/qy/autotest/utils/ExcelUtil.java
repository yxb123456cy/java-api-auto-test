package com.github.qy.autotest.utils;

import cn.idev.excel.FastExcel;
import com.github.qy.autotest.entity.CaseData;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Excel工具类 读取测试数据;
 */
@Slf4j
public class ExcelUtil {
    public static void readData() {
        String fileName = "D:\\001轻叶毕设项目\\pytest-api-provider\\api-auto-test\\java-api-auto-test\\testdata\\excel\\caseData.xlsx";
        CaseDataListener caseDataListener = new CaseDataListener();
        // 使用方式1：Lambda表达式直接处理数据
        FastExcel.read(fileName, CaseData.class, caseDataListener).sheet().doRead();
    }

    public static void main(String[] args) {

    }
}
