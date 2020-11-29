package com.pisi.marketplace.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger {

	@Bean
	public Docket portalApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.pisi.marketplace.controller"))
				.paths(PathSelectors.ant("/**"))
				.build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
	    return new ApiInfoBuilder()
	            .title("Titulo")
	            .description("descricao")
	            .version("1.0.0")
	            .license("licenca")
	            .licenseUrl("url")
	            .contact( new Contact ("Laura", null,"laura.kohatsu@usp.br"))
	            .build();
	}
}