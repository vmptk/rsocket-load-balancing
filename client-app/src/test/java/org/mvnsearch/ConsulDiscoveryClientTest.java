package org.mvnsearch;

import com.ecwid.consul.v1.ConsulClient;
import org.junit.jupiter.api.Test;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.commons.util.InetUtils;
import org.springframework.cloud.commons.util.InetUtilsProperties;
import org.springframework.cloud.consul.discovery.ConsulDiscoveryClient;
import org.springframework.cloud.consul.discovery.ConsulDiscoveryProperties;

import java.util.List;

public class ConsulDiscoveryClientTest {
    @Test
    public void testFindServiceServers() {
        ConsulClient consulClient = new ConsulClient("127.0.0.1", 8500);
        ConsulDiscoveryProperties properties = new ConsulDiscoveryProperties(new InetUtils(new InetUtilsProperties()));
        ConsulDiscoveryClient discoveryClient = new ConsulDiscoveryClient(consulClient, properties);
        List<ServiceInstance> instances = discoveryClient.getInstances("com-example-CalculatorService");
        for (ServiceInstance instance : instances) {
            System.out.println("Host: " + instance.getHost());
            System.out.println("RSocket Port:" + instance.getMetadata().get("rsocketPort"));
        }
    }
}
