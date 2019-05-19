package com.pets.api.services.store;

import com.pets.api.ApiClient;
import com.pets.api.assertions.AssertableResponse;
import io.qameta.allure.Step;

import static com.pets.api.ApiClient.Config.apiConfig;
import static com.pets.api.ApiClient.api;
import static com.pets.api.ApiClientsUtils.RESPONSE_HANDLER;
import static com.pets.api.ApiClientsUtils.supplier;

@SuppressWarnings("JavadocType")
public class StoreApiService {

    private final ApiClient apiClient;

    public StoreApiService() {
        this.apiClient = api(
                apiConfig()
                        .reqSpecSupplier(supplier()));
    }
    
    @Step("Getting inventory operation.")
    public AssertableResponse getInventory() {
        return new AssertableResponse(
                apiClient
                        .store()
                        .getInventory()
                        .execute(RESPONSE_HANDLER)
                        .then());
    }
}
