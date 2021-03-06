package order.demo.orderservice;

import order.demo.orderservice.entity.OrderItemData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients
public class OrderServiceApplication {

	@Bean
	public RestTemplate getRestTmeplate(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

}
