package com.pets.api.condition;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@SuppressWarnings("JavadocType")
public class ContentTypeCondition implements Condition {
    
    private ContentType contentType;
    
    @Override
    public void check(ValidatableResponse response) {
        response.assertThat().contentType(contentType);
    }

    @Override
    public String toString() {
        return "ContentTypeCondition:" 
                + "contentType is: " 
                + contentType;
    }
}
