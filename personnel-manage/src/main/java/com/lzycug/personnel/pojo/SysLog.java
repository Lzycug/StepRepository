
package com.lzycug.personnel.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 功能描述
 *
 * @author lWX716128
 * @since 2020-04-03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysLog {
    private Integer id;

    private Integer userId;

    private String userAction;

    private Date createTime;
}
