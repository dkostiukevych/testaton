package com.pets.api;

import com.pets.api.services.store.implementation.StoreApi;
import io.restassured.builder.RequestSpecBuilder;

import java.util.function.Supplier;

@SuppressWarnings("JavadocType")
public class ApiClient {

    private final Config config;

    private ApiClient(Config config) {
        this.config = config;
    }

    public static ApiClient api(Config config) {
        return new ApiClient(config);
    }
    
    public StoreApi store() {
        return StoreApi.store(config.baseReqSpec.get());
    }

    public static class Config {
        private Supplier<RequestSpecBuilder> baseReqSpec;

        /**
         * Use common specification for all operations
         */
        public Config reqSpecSupplier(Supplier<RequestSpecBuilder> supplier) {
            this.baseReqSpec = supplier;
            return this;
        }

        public static Config apiConfig() {
            return new Config();
        }
    }
}
