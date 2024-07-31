package com.splitwise.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@OpenAPIDefinition(
        info = @Info(
                title = "ExpenseMate",
                contact = @Contact(
                        name = "Avinash Kumar Singh",
                        email = "avi.singh.iit01@gmail.com",
                        url = "https://www.linkedin.com/in/avinash-19/"
                ),
                version = "1.0"
        ),
        security = @SecurityRequirement(
                name = "Bearer JWT Token"
        )
)

@SecurityScheme(
        name = "Bearer JWT Token",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER,
        description = "Connect JWT token"

)
public class OpenApiConfig {
}
