package com.pets.api.condition;

import io.restassured.response.ValidatableResponse;

@SuppressWarnings("JavadocType")
public interface Condition {

    void check(ValidatableResponse response);
}
