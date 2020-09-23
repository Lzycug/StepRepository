package com.lzycug.learn.jpa.entity;

/**
 * description：
 * author：lzyCug
 * date: 2020/9/23 21:26
 */
public enum ResultCode {
    // 根据业务需要补充相应的状态码及对应的提示信息，此处作简单罗列
    OK("0", "操作成功"),
    NOPARAMETER("1001", "参数为空"),
    NOAUTH("1002", "暂无接口调用权限"),
    ERROR("-1", "系统内部异常");

    private String code;

    private String msg;

    ResultCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 根据code值获取对应的消息
     *
     * @param code 状态码
     * @return 消息
     */
    public static String getMsgByCode(String code) {
        String msg = "";
        ResultCode[] resultCodes = values();
        for (ResultCode resultCode : resultCodes) {
            if (code.equals(resultCode.code)) {
                msg = resultCode.msg;
            }
        }
        return msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
