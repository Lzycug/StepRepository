
package com.lzycug.mail.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 功能描述
 *
 * @author lWX716128
 * @since 2020-03-27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String userName;

    private String hireTime;

    private Integer salary;
}
