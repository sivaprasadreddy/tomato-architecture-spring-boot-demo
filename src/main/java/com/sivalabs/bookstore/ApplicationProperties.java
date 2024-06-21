package com.sivalabs.bookstore;

import jakarta.validation.constraints.Min;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;

@ConfigurationProperties(prefix = "app")
public record ApplicationProperties(
        @DefaultValue("10") @Min(1) int pageSize,
        String productPriceUpdatesTopic,
        String newOrdersTopic,
        OpenAPIProperties openapi,
        CorsProperties cors) {

    public record OpenAPIProperties(
            @DefaultValue("MRS APIs") String title,
            @DefaultValue("MRS REST API Swagger Documentation") String description,
            @DefaultValue("v1.0.0") String version,
            Contact contact) {

        public record Contact(
                @DefaultValue("SivaLabs") String name, @DefaultValue("support@sivalabs.in") String email) {}
    }

    public record CorsProperties(
            @DefaultValue("/api/**") String pathPattern,
            @DefaultValue("*") String allowedOrigins,
            @DefaultValue("*") String allowedMethods,
            @DefaultValue("*") String allowedHeaders) {}
}
