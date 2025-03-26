package com.github.qy.autotest.utils;

import com.github.qy.autotest.entity.CaseData;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class TestDataProvider {

    @Setter
    @Getter
    private static List<CaseData> caseDataList = new ArrayList<>();

}
