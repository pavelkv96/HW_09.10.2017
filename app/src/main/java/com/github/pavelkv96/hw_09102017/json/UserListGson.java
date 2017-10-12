package com.github.pavelkv96.hw_09102017.json;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavel on 12.10.2017.
 */

public class UserListGson implements IAllList{

    private final List<UserGson> mUserList;

    public UserListGson(final List<UserGson> pUserList){
        mUserList = pUserList;
    }


    @Override
    public List<IAll> getAllList() {
        List<IAll> iAlls = new ArrayList<>();
        iAlls.addAll(mUserList);
        return iAlls;
    }
}
