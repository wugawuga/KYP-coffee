package team.kyp.kypcoffee;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "team.kyp.kypcoffee.mapper")
public class KypcoffeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(KypcoffeeApplication.class, args);
	}

}
