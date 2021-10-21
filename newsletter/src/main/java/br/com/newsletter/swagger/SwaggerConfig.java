package br.com.newsletter.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
		          .apis(RequestHandlerSelectors.basePackage("br.com.newslleter.forum."))
		         .paths(PathSelectors.regex("/assinantes.*"))
				.build()
				.apiInfo(apiInfo());			
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("Assinatura  API REST") 
				.description("API para criação de assinaturas")
				.version("1.0.0")
	            .termsOfServiceUrl("Terms Of Service")
	            .license("Apache License Version 1.0")
	            .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
	            .build();

	}
}
