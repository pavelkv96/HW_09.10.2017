package com.github.pavelkv96.hw_09102017.json;

import com.github.pavelkv96.hw_09102017.utils.IOUtils;
import com.google.gson.Gson;

import java.io.InputStream;
import java.util.Arrays;

/**
 * Created by Pavel on 12.10.2017.
 */

public class UserListGsonParser implements IAllListParser{
    private final InputStream mInputStream;

    public UserListGsonParser(InputStream pInputStream){
        mInputStream = pInputStream;
    }

    @Override
    public IAllList parse() throws Exception {
        String Source = IOUtils.toString(mInputStream);
        UserGson[] result = new Gson().fromJson(Source,UserGson[].class);
        return new UserListGson(Arrays.asList(result));
    }
}
