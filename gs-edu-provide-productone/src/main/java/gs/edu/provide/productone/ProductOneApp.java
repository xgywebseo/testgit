package gs.edu.provide.productone;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("gs.edu.provide.productone.mapper")
@EnableEurekaClient
@EnableCircuitBreaker
public class ProductOneApp {

    public static void main(String[] args) {
        SpringApplication.run(ProductOneApp.class,args);
    }

}
