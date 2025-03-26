package com.github.qy.autotest.entity;

import cn.idev.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 注意 不能添加Accessors注解 @Builder注解也不行
 */
@Data

public class CaseData {
    @ExcelProperty("CaseId")
    private String caseId;
    @ExcelProperty("ApiName")
    private String apiName;
    @ExcelProperty("Describe")
    private String describe;
    @ExcelProperty("Url")
    private String url;
    @ExcelProperty("RequestType")
    private String requestType;
    @ExcelProperty("Headers")
    private String headers;
    @ExcelProperty("Cookies")
    private String cookies;
    @ExcelProperty("Parameters")
    private String parameters;
    @ExcelProperty("UploadFile")
    private String uploadFile;
    @ExcelProperty("GlobalVariables")
    private String globalVariables;
    @ExcelProperty("AssertFields")
    private String assertFields;
}
