
package com.lzycug.mail.service;

import com.lzycug.mail.dao.LogDao;
import com.lzycug.mail.pojo.Log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 功能描述
 *
 * @author lWX716128
 * @since 2020-03-27
 */
@Service
public class LogService {
    @Autowired
    LogDao logDao;

    public void insert(Log log) {
        logDao.insert(log);
    }
}
