package com.github.pavelkv96.hw_09102017.json;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavel on 11.10.2017.
 */

public class UserListWrapper implements IAllList {

    private final JSONArray mJsonArray;

    UserListWrapper(final JSONArray pJsonArray) {
        mJsonArray = pJsonArray;
    }

    @Override
    public List<IAll> getAllList() {
        final List<UserJSONWrapper> userJSONWrappers = new ArrayList<>();
        for (int i=0;i<mJsonArray.length();i++){
            try {
                final JSONObject jsonObject = mJsonArray.getJSONObject(i);
                final UserJSONWrapper userJSONWrapper = new UserJSONWrapper(jsonObject);
                userJSONWrappers.add(userJSONWrapper);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        List<IAll> iAlls = new ArrayList<>();
        iAlls.addAll(userJSONWrappers);
        return iAlls;
    }
}
