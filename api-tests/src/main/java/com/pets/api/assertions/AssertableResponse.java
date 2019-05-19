package com.pets.api.assertions;

import com.pets.api.condition.Condition;
import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@SuppressWarnings("JavadocType")
public class AssertableResponse {

    private final ValidatableResponse response;

    @Step("API Response should have {condition}")
    public AssertableResponse shouldHave(Condition condition) {
        condition.check(response);
        return this;
    }

    @Step("Extracting object by jPath: {jsonPath}")
    public String extractObject(String jsonPath) {
        return response.extract().jsonPath().getJsonObject(jsonPath);
    }

}
