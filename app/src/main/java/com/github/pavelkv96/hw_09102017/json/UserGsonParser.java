package com.github.pavelkv96.hw_09102017.json;

import com.github.pavelkv96.hw_09102017.utils.IOUtils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.Date;

/**
 * Created by Pavel on 12.10.2017.
 */

public class UserGsonParser implements IAllParser {
    private final InputStream mInputStream;

    UserGsonParser(final InputStream pInputStream) {
        mInputStream = pInputStream;
    }


    @Override
    public IAll parse() throws Exception {
        final JsonDeserializer<Date> date = new JsonDeserializer<Date>() {
            @Override
            public Date deserialize(JsonElement jsonElement,
                                    Type type, JsonDeserializationContext context)
                    throws JsonParseException {
                return jsonElement == null ? null : new Date(jsonElement.getAsLong());
            }
        };

        String Source = IOUtils.toString(mInputStream);
        final Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, date).create();
        return gson.fromJson(Source, UserGson.class);
        /*String Source = IOUtils.toString(mInputStream);
        return new Gson().fromJson(Source, UserGson.class);*/
    }
}
