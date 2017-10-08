package com.lkp.controller.TypeAdapter;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.lkp.entity.OrderState;

import java.io.IOException;

/**
 * Created by cccxt on 2016/10/28.
 */
public class OrderSatetTypeAdapter extends TypeAdapter<OrderState> {
    @Override
    public void write(JsonWriter jsonWriter, OrderState orderState) throws IOException {
//        jsonWriter.jsonValue(orderState.getDes());
    }

    @Override
    public OrderState read(JsonReader jsonReader) throws IOException {
        return null;
    }
}
