package com.pets.api.tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class BaseExtension implements BeforeAllCallback {
    
    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
    }
}
