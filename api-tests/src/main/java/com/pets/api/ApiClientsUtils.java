package com.pets.api;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;

import java.util.function.Function;
import java.util.function.Supplier;

import static com.pets.api.GsonObjectMapper.gson;
import static io.restassured.config.ObjectMapperConfig.objectMapperConfig;
import static io.restassured.config.RestAssuredConfig.config;
import static io.restassured.http.ContentType.JSON;

@SuppressWarnings("JavadocType")
public class ApiClientsUtils {

    public static Supplier<RequestSpecBuilder> supplier() {
        return () -> new RequestSpecBuilder()
                .setContentType(JSON)
                .setConfig(config().objectMapperConfig(
                        objectMapperConfig()
                                .defaultObjectMapper(gson())))
                .addFilter(new ErrorLoggingFilter())
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .addFilter(new AllureRestAssured());
    }

    public static final Function<Response, Response> RESPONSE_HANDLER = r -> r;

    @Override
    public String toString() {
        return super.toString();
    }
}
