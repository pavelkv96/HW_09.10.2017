package com.github.pavelkv96.hw_09102017.json;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Pavel on 12.10.2017.
 */

public class RootObjectForGsonList {
    @SerializedName("response")
    private UserListWithObjectGson mObjectGson;

    UserListWithObjectGson getResponse(){
        return mObjectGson;
    }
}
