package com.z7.legal.config;

import com.rds.client.javaclient.Client;
import com.rds.client.javaclient.Connection;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetSocketAddress;

/**
 * @Classname RdsConfig
 * @Description TODO RDS连接
 * @Date 2021/5/8 10:33 上午
 * @Author z7-x
 */
@Slf4j
@Configuration
public class RDSConfig {
    @Value("${spring.rds.host}")
    private String host;

    @Value("${spring.rds.password}")
    private String password;

    @Value("${spring.rds.port}")
    private String port;

    @Bean
    public Connection rdsConnection() {
        Client client =
                new Client(false,
                        true,
                        password,
                        new InetSocketAddress(host, Integer.parseInt(port)));
        Connection connection = client.getConnection();

        log.info("RDS 连接成功！");
        log.info("RDS 地址：" + host + ":" + port);

        return connection;
    }
}
