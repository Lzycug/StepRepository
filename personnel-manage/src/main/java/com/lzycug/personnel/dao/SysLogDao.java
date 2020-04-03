
package com.lzycug.personnel.dao;

import com.lzycug.personnel.pojo.SysLog;

import org.apache.ibatis.annotations.Param;

/**
 * 功能描述
 *
 * @author lWX716128
 * @since 2020-04-03
 */
public interface SysLogDao {
    Integer insert(@Param("log") SysLog sysLog);
}
