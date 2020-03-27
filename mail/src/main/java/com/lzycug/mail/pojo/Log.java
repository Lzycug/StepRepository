
package com.lzycug.mail.pojo;

import lombok.Data;

import java.util.Date;

/**
 * 功能描述
 *
 * @author lWX716128
 * @since 2020-03-27
 */
@Data
public class Log {
    private Integer id;

    private String operation;

    private Date logTime;

    private Integer userId;
}
