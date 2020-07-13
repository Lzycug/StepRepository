
package com.lzycug.mail.pojo;

import org.apache.commons.lang3.StringUtils;

/**
 * 返回结果枚举对象
 *
 * @author lzycug
 * @since 2020-07-11
 */
enum ResultCode {
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
        String msg = StringUtils.EMPTY;
        ResultCode[] resultCodes = values();
        for (ResultCode resultCode : resultCodes) {
            if (StringUtils.equals(code, resultCode.code)) {
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
