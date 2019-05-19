package com.pets.api.condition;

import io.restassured.http.ContentType;
import org.hamcrest.Matcher;

@SuppressWarnings("JavadocType")
public class Conditions {

    public static StatusCodeCondition statusCode(int code) {
        return new StatusCodeCondition(code);
    }
    
    public static ContentTypeCondition contentType(ContentType contentType) {
        return new ContentTypeCondition(contentType);
    }

    public static ResponseBodyCondition jsonObject(String jsonPath, Matcher matcher) {
        return new ResponseBodyCondition(matcher, jsonPath);
    }
}
