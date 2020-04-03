
package com.lzycug.personnel.service.impl;

import com.alibaba.fastjson.JSON;
import com.lzycug.personnel.dao.SysLogDao;
import com.lzycug.personnel.pojo.SysLog;
import com.lzycug.personnel.service.SysLogService;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 功能描述
 *
 * @author lWX716128
 * @since 2020-04-03
 */
@Service
public class SysLogServiceImpl implements SysLogService {
    @Autowired
    SysLogDao sysLogDao;

    @Override
    public Integer insert(SysLog sysLog) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://127.0.0.1:44000/mq/sendLog");
        String jsonString = JSON.toJSONString(sysLog);
        byte[] stringBytes = jsonString.getBytes();
        ByteArrayEntity byteArrayEntity = new ByteArrayEntity(stringBytes);
        byteArrayEntity.setContentType("application/octet-stream");
        httpPost.setEntity(byteArrayEntity);
        // httpPost.setHeader("Content-Type", "application/json;charset=utf8");
        try {
            CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                InputStream inputStream = httpResponse.getEntity().getContent();
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                byte[] bytes = new byte[1024];
                int len;
                inputStream.read(bytes);
                while ((len = inputStream.read(bytes)) != -1) {
                    bos.write(bytes, 0, len);
                }
                String result = new String(bos.toByteArray());
                System.out.println(result);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
