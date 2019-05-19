package com.pets.api.services.store.implementation;

import com.google.gson.reflect.TypeToken;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.Method;
import io.restassured.response.Response;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

@SuppressWarnings("JavadocType")
public class StoreApi {

    private RequestSpecBuilder reqSpec;

    private StoreApi(RequestSpecBuilder reqSpec) {
        this.reqSpec = reqSpec;
    }

    public static StoreApi store(RequestSpecBuilder reqSpec) {
        return new StoreApi(reqSpec);
    }

    public GetInventoryOper getInventory() {
        return new GetInventoryOper(this.reqSpec);
    }

    public StoreApi reqSpec(Consumer<RequestSpecBuilder> consumer) {
        consumer.accept(this.reqSpec);
        return this;
    }

    public class GetInventoryOper {
        public static final String REQ_URI = "/store/inventory";
        private RequestSpecBuilder reqSpec;
        private ResponseSpecBuilder respSpec;

        public GetInventoryOper() {
            this.reqSpec = new RequestSpecBuilder();
            this.reqSpec.setAccept("application/json");
            this.respSpec = new ResponseSpecBuilder();
        }

        public GetInventoryOper(RequestSpecBuilder reqSpec) {
            this.reqSpec = reqSpec;
            reqSpec.setAccept("application/json");
            this.respSpec = new ResponseSpecBuilder();
        }

        public <T> T execute(Function<Response, T> handler) {
            return handler.apply(RestAssured
                    .given()
                    .spec(this.reqSpec.build())
                    .expect()
                    .spec(this.respSpec.build())
                    .when()
                    .request(Method.GET, "/store/inventory", new Object[0]));
        }

        public Map<String, Integer> executeAs(Function<Response, Response> handler) {
            Type type = (new TypeToken<Map<String, Integer>>() {
            }).getType();
            return (Map)((Response)this.execute(handler)).as(type);
        }

        public GetInventoryOper reqSpec(Consumer<RequestSpecBuilder> consumer) {
            consumer.accept(this.reqSpec);
            return this;
        }

        public GetInventoryOper respSpec(Consumer<ResponseSpecBuilder> consumer) {
            consumer.accept(this.respSpec);
            return this;
        }
    }
    
}
