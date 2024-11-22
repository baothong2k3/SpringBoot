/*
 * @ (#) OpenAPIConfiguration.java    1.0    22/11/2024
 * Copyright (c) 2024 IUH. All rights reserved.
 */
package org.example.dangbaothong_21014091_springapi.configs;/*
 * @description:
 * @author: Bao Thong
 * @date: 22/11/2024
 * @version: 1.0
 */

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfiguration {
    @Bean
    public OpenAPI defineOpenApi() {
        Server server = new Server();
        server.setUrl("http://localhost:9998");
        server.setDescription("Employee Management REST API Documentation");
        Info information = new Info()
                .title("Employee Management REST API Documentation")
                .version("1.0")
                .description("This API exposes endpoints to manage employees.");
        return new OpenAPI().info(information).servers(List.of(server));
    }
}
