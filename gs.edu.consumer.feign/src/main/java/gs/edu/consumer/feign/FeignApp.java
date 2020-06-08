package gs.edu.consumer.feign;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 引入的jar没有办法扫描到，需要手动引入
 */
@SpringBootApplication(scanBasePackages = {"gs.edu.feignservice.services","gs.edu.consumer.feign"})
@EnableEurekaClient
@RibbonClient(name = "GS-EDU-PROVIDER-PRODUCT")
@EnableFeignClients("gs.edu.feignservice.services")
public class FeignApp {
    public static void main(String[] args) {
        SpringApplication.run(FeignApp.class,args);
    }

}
