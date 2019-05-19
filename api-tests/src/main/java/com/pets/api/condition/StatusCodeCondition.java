package com.pets.api.condition;

import io.restassured.response.ValidatableResponse;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@SuppressWarnings("JavadocType")
public class StatusCodeCondition implements Condition {

    private int statusCode;

    @Override
    public void check(ValidatableResponse response) {
        response.assertThat().statusCode(statusCode);
    }

    @Override
    public String toString() {
        return "StatusCodeCondition: " +
                "statusCode is " + statusCode ;
    }
}
