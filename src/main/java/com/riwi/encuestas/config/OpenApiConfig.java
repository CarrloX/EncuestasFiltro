package com.riwi.encuestas.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(info = @Info(
title = "API para administrar encuestas y preguntas con usuarios",
version ="1.0",
description = "Docuemntacion Api de administracion de encuestas y preguntas con usuarios"))
public class OpenApiConfig {

}