package com.pets.api;

import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;

@SuppressWarnings("JavadocType")
public class GsonObjectMapper implements ObjectMapper {

    private JSON json;

    private GsonObjectMapper() {
        this.json = new JSON();
    }

    public static GsonObjectMapper gson() {
        return new GsonObjectMapper();
    }

    @Override
    public Object deserialize(ObjectMapperDeserializationContext context) {
        return json.deserialize(context.getDataToDeserialize().asString(), context.getType());
    }

    @Override
    public Object serialize(ObjectMapperSerializationContext context) {
        return json.serialize(context.getObjectToSerialize());
    }
}
