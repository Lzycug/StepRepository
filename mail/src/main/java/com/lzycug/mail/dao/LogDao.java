
package com.lzycug.mail.dao;

import com.lzycug.mail.pojo.Log;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

/**
 * 功能描述
 *
 * @author lWX716128
 * @since 2020-03-27
 */
public interface LogDao {
    @Insert("insert into log (operation, logTime, userId) values (#{log.operation}, #{log.logTime}, #{log.userId})")
    void insert(@Param("log") Log log);
}
