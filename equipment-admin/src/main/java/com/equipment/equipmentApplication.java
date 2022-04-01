package com.equipment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * 启动程序
 * 
 * @author equipment
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class equipmentApplication
{
    public static void main(String[] args)
    {
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(equipmentApplication.class, args);
        System.out.println("多媒体教室设备管理系统启动成功！");
    }
}
