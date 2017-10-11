package com.github.pavelkv96.hw_09102017.json;

import org.json.JSONException;

/**
 * Created by Pavel on 10.10.2017.
 */

public interface IFriends {
    long getIdFriends(int i) throws JSONException;
    String getNameFriends(int i) throws JSONException;
}
