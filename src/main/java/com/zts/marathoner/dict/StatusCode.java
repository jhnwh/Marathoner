package com.zts.marathoner.dict;

public enum StatusCode {
    SUCCESS(0, "成功"),
    CHECK_FAILED(1, "检查失败"),
    EXECUTE_FAILED(2, "执行失败"),

    CHECK_NOT_PASSED(11, "检查未通过"),
    ANCESTORS_IS_RUNNING(12, "上游任务正在运行");

    private final int code;
    private final String msg;

    StatusCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode(){
        return this.code;
    }

    public String getMsg(){
        return this.msg;
    }

    public static StatusCode getObjectByCode(int code){
        for (StatusCode value : StatusCode.values()) {
            if(value.getCode() == code){
                return value;
            }
        }
        return null;
    }
}
