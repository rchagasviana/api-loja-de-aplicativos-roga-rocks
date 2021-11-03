package api.loja.rrocks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;


@SpringBootApplication
@EnableCaching
public class ApiLojaDeAplicativosRogaRocksApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiLojaDeAplicativosRogaRocksApplication.class, args);
	}

}
