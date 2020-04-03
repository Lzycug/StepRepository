
package com.lzycug.personnel;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lzycug.personnel.dao")
public class PersonnelManageApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonnelManageApplication.class, args);
    }

}
