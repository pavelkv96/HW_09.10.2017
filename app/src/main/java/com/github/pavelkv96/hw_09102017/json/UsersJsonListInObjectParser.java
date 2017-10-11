package com.github.pavelkv96.hw_09102017.json;

import com.github.pavelkv96.hw_09102017.utils.IOUtils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;

/**
 * Created by Pavel on 11.10.2017.
 */

class UsersJsonListInObjectParser implements IAllListParser {
    private static final String RESPONSE_OBJECT = "response";
    private static final String USER_ARRAY = "items";
    private final InputStream mInputStream;

    UsersJsonListInObjectParser(InputStream pSource) {
        mInputStream = pSource;
    }

    @Override
    public IAllList parse() throws Exception {
        final String source = IOUtils.toString(mInputStream);
        final JSONObject rootObject = new JSONObject(source);

        JSONObject response = null;

        try {
            response = rootObject.getJSONObject(RESPONSE_OBJECT);

        } catch (final JSONException e) {
            e.getMessage();
        }
        assert response != null;
        final JSONArray jsonArray = response.optJSONArray(USER_ARRAY);

        return new UserListWrapper(jsonArray);
    }
}
