package com.github.pavelkv96.hw_09102017.json;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavel on 12.10.2017.
 */

public class UserListWithObjectGson implements IAllList{
    @SerializedName("items")
    private List<UserGson> mUserList;


    @Override
    public List<IAll> getAllList() {
        final List<IAll> iAlls = new ArrayList<>();
        iAlls.addAll(mUserList);
        return iAlls;
    }
}
