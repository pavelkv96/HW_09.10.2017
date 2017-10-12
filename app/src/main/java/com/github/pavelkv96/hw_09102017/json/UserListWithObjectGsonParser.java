package com.github.pavelkv96.hw_09102017.json;

import com.github.pavelkv96.hw_09102017.utils.IOUtils;
import com.google.gson.Gson;

import java.io.InputStream;

/**
 * Created by Pavel on 12.10.2017.
 */

public class UserListWithObjectGsonParser implements IAllListParser{
    private InputStream mInputStream;

    public UserListWithObjectGsonParser(InputStream pInputStream){
        mInputStream = pInputStream;
    }

    @Override
    public IAllList parse() throws Exception {
        String Source = IOUtils.toString(mInputStream);
        return new Gson().fromJson(Source, RootObjectForGsonList.class).getResponse();
    }
}
