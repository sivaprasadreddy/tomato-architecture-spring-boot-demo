package com.sivalabs.bookstore.config;

import com.sivalabs.bookstore.ApplicationProperties;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class OpenAPIConfig {

    @Bean
    OpenAPI openApi(ApplicationProperties properties) {
        var openapi = properties.openapi();
        Contact contact = new Contact()
                .name(openapi.contact().name())
                .email(openapi.contact().email());
        Info info = new Info()
                .title(openapi.title())
                .description(openapi.description())
                .version(openapi.version())
                .contact(contact);
        return new OpenAPI().info(info);
    }
}
