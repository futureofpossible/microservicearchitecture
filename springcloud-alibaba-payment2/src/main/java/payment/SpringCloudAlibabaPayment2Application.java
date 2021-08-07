package payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudAlibabaPayment2Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudAlibabaPayment2Application.class, args);
    }
}