package com.zjw.cloudnacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * ����
 * Zuul�����ṩͳһ�ķ�����ڣ���Ҫ��������ַ�ض���
 * ������ͨ��Filterʵ�ֹ�������
 * ���Hystrixʵ���۶�����������崻�ʱ�������쳣����
 *
 * @author Zhaojingwei
 * @date 2021/3/19
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
@RefreshScope
public class CloudZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudZuulApplication.class, args);
    }

}
