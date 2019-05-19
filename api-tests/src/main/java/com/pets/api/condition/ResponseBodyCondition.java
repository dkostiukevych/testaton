package com.pets.api.condition;

import io.restassured.response.ValidatableResponse;
import lombok.AllArgsConstructor;
import org.hamcrest.Matcher;

@AllArgsConstructor
@SuppressWarnings("JavadocType")
public class ResponseBodyCondition implements Condition {

    private Matcher matcher;
    private String jsonPath;

    @Override
    public void check(ValidatableResponse response) {
        response.assertThat().body(jsonPath, matcher);
    }

}
