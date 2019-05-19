package com.pets.api.tests;

import com.pets.api.services.store.StoreApiService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.pets.api.condition.Conditions.contentType;
import static com.pets.api.condition.Conditions.statusCode;
import static io.restassured.http.ContentType.JSON;
import static org.apache.http.HttpStatus.SC_OK;

@ExtendWith(BaseExtension.class)
class StoreManagementTests {
    
    private StoreApiService storeApiService = new StoreApiService();

    @Test
    void name() {
        storeApiService.getInventory()
                .shouldHave(statusCode(SC_OK))
                .shouldHave(contentType(JSON));
    }
}
