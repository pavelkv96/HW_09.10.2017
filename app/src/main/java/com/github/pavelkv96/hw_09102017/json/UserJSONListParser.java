package com.github.pavelkv96.hw_09102017.json;

import com.github.pavelkv96.hw_09102017.utils.IOUtils;

import org.json.JSONArray;

import java.io.InputStream;

/**
 * Created by Pavel on 11.10.2017.
 */

class UserJSONListParser implements IAllListParser{

    private final InputStream mSource;
    UserJSONListParser(final InputStream pSource){
        mSource = pSource;
    }

    @Override
    public IAllList parse() throws Exception {
        final String Source = IOUtils.toString(mSource);
        final JSONArray rootArray = new JSONArray(Source);
        return new UserListWrapper(rootArray);
    }
}
