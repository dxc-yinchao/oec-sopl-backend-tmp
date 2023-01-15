package oec.lis.sopl.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Swagger 組態設定
 * 
 * @author Frank Yeh
 * @Date 2023-1-6
 */
@Configuration
@EnableOpenApi
public class SwaggerConfig {

	@Bean
	public Docket init() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				//.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
				.apis(RequestHandlerSelectors.basePackage("oec.lis"))
				//.paths(PathSelectors.any())
				.build();
	}

}
