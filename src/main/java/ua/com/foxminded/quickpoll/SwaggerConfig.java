package ua.com.foxminded.quickpoll;

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
public class SwaggerConfig {
    @Bean
    public Docket v1Api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("quickpoll-api-v1")
                .select()
                .apis(RequestHandlerSelectors.basePackage("ua.com.foxminded.quickpoll.v1.controller"))
                .paths(PathSelectors.regex("(?!/error).+"))
                .build()
                .apiInfo(getApiInfoV1())
                .useDefaultResponseMessages(false);
    }

    @Bean
    public Docket v2Api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("quickpoll-api-v2")
                .select()
                .apis(RequestHandlerSelectors.basePackage("ua.com.foxminded.quickpoll.v2.controller"))
                .paths(PathSelectors.regex("(?!/error).+"))
                .build()
                .apiInfo(getApiInfoV2())
                .useDefaultResponseMessages(false);
    }

    @Bean
    public Docket v3Api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("quickpoll-api-v3")
                .select()
                .apis(RequestHandlerSelectors.basePackage("ua.com.foxminded.quickpoll.v3.controller"))
                .paths(PathSelectors.regex("(?!/error).+"))
                .build()
                .apiInfo(getApiInfoV3())
                .useDefaultResponseMessages(false);
    }

    private ApiInfo getApiInfoV1() {
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("QuickPoll REST API")
                .description("QuickPoll Api for creating and managing polls")
                .version("1.0")
                .termsOfServiceUrl("http://example.com/terms-of-service")
                .contact(new Contact("Developer", "https://www.facebook.com/artem333", "shpykuliak@gmail.com"))
                .license("MIT License").licenseUrl("http://opensource.org/licenses/MIT").build();
        return apiInfo;
    }

    private ApiInfo getApiInfoV2() {
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("QuickPoll REST API")
                .description("QuickPoll Api for creating and managing polls")
                .version("2.0")
                .termsOfServiceUrl("http://example.com/terms-of-service")
                .contact(new Contact("Developer", "https://www.facebook.com/artem333", "shpykuliak@gmail.com"))
                .license("MIT License").licenseUrl("http://opensource.org/licenses/MIT").build();
        return apiInfo;
    }

    private ApiInfo getApiInfoV3() {
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("QuickPoll REST API")
                .description("QuickPoll Api for creating and managing polls")
                .version("3.0")
                .termsOfServiceUrl("http://example.com/terms-of-service")
                .contact(new Contact("Developer", "https://www.facebook.com/artem333", "shpykuliak@gmail.com"))
                .license("MIT License").licenseUrl("http://opensource.org/licenses/MIT").build();
        return apiInfo;
    }
}
