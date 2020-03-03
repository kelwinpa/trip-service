package com.trip.api.config;

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

	private static final String DESCRIPTION = 
			"\n" + 
			"- Implement the specified REST Endpoint\n" + 
			"- Protect the API with BasicAuth\n" + 
			"- Use Docker to run your application\n" + 
			"- Use one of the following languages&#58; Go, Java, Python, C++\n" + 
			"- Automate the infrastructure rollout\n" + 
			"- Use an external service to determine the city name for departure and destination\n" + 
			"- Upload your solution to a private GitHub repository\n" + 
			"- Provide a link to the secured hosted instance of your solution\n" + 
			"- Provide the following files together with your code:\n" + ""+
			"      * Dockerfile\n" + 
			"      * Build-Script\n" + 
			"      * Deployment-Script\n" + 
			"      * Kubernetes deployment YAML (if Kubernetes is used)\n" + 
			"      * Infrastructure automation scripts\n" + 
			"      * README.md with documentation how to deploy the infrastructure and the application";  
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.any()).paths(PathSelectors.any())
				.build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Mercedes-Benz AG Programming Challenge").description(DESCRIPTION)
				.version("1.0.0").build();
	}

}