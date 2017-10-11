package com.github.pavelkv96.hw_09102017.json;

import org.json.JSONException;

import java.util.List;
import java.util.Map;

/**
 * Created by Pavel on 10.10.2017.
 */

public interface IAll {
    String getId();
    long getIndex();
    String getGuid();
    boolean getIsActive();
    String getBalance();
    String getPicture();
    long getAge();
    String getEyeColor();
    String getName();
    String getGender();
    String getCompany();
    String getEmail();
    String getPhone();
    String getAddress();
    String getAbout();
    long getRegistered();//Format
    double getLatitude();
    double getLongitude();
    //Tags
    List<IFriends> getFriends() throws JSONException;//Friends
    String getGreeting();
    String getFavoriteFruit();
}