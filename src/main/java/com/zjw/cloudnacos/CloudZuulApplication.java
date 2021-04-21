package com.zjw.cloudnacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 网关
 * Zuul对外提供统一的服务入口，主要是用作网址重定向。
 * 还可以通过Filter实现过滤器。
 * 配合Hystrix实现熔断器，当服务宕机时可以做异常处理。
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
