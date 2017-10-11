package com.github.pavelkv96.hw_09102017.json;

import com.github.pavelkv96.hw_09102017.utils.IOUtils;

import org.json.JSONObject;

import java.io.InputStream;

/**
 * Created by Pavel on 10.10.2017.
 */

class UserJSONObjectParser implements IAllParser {

    private final InputStream mSource;

    UserJSONObjectParser(final InputStream pSource) {
        this.mSource = pSource;
    }

    @Override
    public IAll parse() throws Exception {
        final String Source = IOUtils.toString(mSource);
        final JSONObject jsonObject = new JSONObject(Source);
        return new UserJSONWrapper(jsonObject);
    }
}
