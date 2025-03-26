package com.github.qy.autotest.utils;

import cn.idev.excel.context.AnalysisContext;
import cn.idev.excel.read.listener.ReadListener;
import com.alibaba.fastjson2.JSON;
import com.github.qy.autotest.entity.CaseData;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class CaseDataListener implements ReadListener<CaseData> {
    private List<CaseData> list = new ArrayList<>();

    @Override
    public void invoke(CaseData caseData, AnalysisContext analysisContext) {
        log.info("解析到一条数据:{}", JSON.toJSONString(caseData));
        list.add(caseData);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        log.info("所有数据解析完成！");
        log.info("开始打印");
        list.forEach(System.out::println);
    }
}
