
package com.lzycug.mail.pojo;

/**
 * 功能描述
 *
 * @author lWX716128
 * @since 2020-03-24
 */
public enum Result {
    SUCCESS("发送成功", 200),

    ERROR("发送失败", 300);

    private String message;

    private int code;

    Result(String message, int code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }
}
