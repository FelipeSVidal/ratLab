package com.iscb.RatLab;

import com.iscb.RatLab.Security.PasswordEncoderConfig;
import nz.net.ultraq.thymeleaf.LayoutDialect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.thymeleaf.spring5.SpringTemplateEngine;

import javax.xml.bind.SchemaOutputResolver;


@SpringBootApplication
public class RatLabApplication {

	@Bean
    public LayoutDialect layoutDialect() {
        return new LayoutDialect();
    }



	public static void main(String[] args) {
		SpringApplication.run(RatLabApplication.class, args);
	}
}
