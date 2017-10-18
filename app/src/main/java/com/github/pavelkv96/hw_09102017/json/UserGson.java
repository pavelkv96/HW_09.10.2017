package com.github.pavelkv96.hw_09102017.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import org.json.JSONException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.IllegalFormatCodePointException;
import java.util.List;
import java.util.Locale;

/**
 * Created by Pavel on 12.10.2017.
 */

public class UserGson implements IAll {

    @SerializedName("_id")
    private String _ID;

    @SerializedName("index")
    private long INDEX;

    @SerializedName("guid")
    private String GUID;

    @SerializedName("isActive")
    private boolean ISACTIVE;

    @SerializedName("balance")
    private String BALANCE;

    @SerializedName("picture")
    private String PICTURE;

    @SerializedName("age")
    private long AGE;

    @SerializedName("eyeColor")
    private String EYECOLOR;

    @SerializedName("name")
    private String NAME;

    @SerializedName("gender")
    private String GENDER;

    @SerializedName("company")
    private String COMPANY;

    @SerializedName("email")
    private String EMAIL;

    @SerializedName("phone")
    private String PHONE;

    @SerializedName("address")
    private String ADDRESS;

    @SerializedName("about")
    private String ABOUT;

    @SerializedName("registered")
    private String REGISTERED;

    @SerializedName("latitude")
    private double LATITUDE;

    @SerializedName("longitude")
    private double LONGITUDE;

    @SerializedName("id")
    private long ID;

    @SerializedName("greeting")
    private String GREETING;

    @SerializedName("favoriteFruit")
    private String FAVORITE_FRUIT;


    @Override
    public String getId() {
        return _ID;
    }

    @Override
    public long getIndex() {
        return INDEX;
    }

    @Override
    public String getGuid() {
        return GUID;
    }

    @Override
    public boolean getIsActive() {
        return ISACTIVE;
    }

    @Override
    public String getBalance() {
        return BALANCE;
    }

    @Override
    public String getPicture() {
        return PICTURE;
    }

    @Override
    public long getAge() {
        return AGE;
    }

    @Override
    public String getEyeColor() {
        return EYECOLOR;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String getGender() {
        return GENDER;
    }

    @Override
    public String getCompany() {
        return COMPANY;
    }

    @Override
    public String getEmail() {
        return EMAIL;
    }

    @Override
    public String getPhone() {
        return PHONE;
    }

    @Override
    public String getAddress() {
        return ADDRESS;
    }

    @Override
    public String getAbout() {
        return ABOUT;
    }

    @Override
    public String getRegistered() throws ParseException{
        final DateFormat dateFormat = new SimpleDateFormat("dd MMM yyyy, hh:mm:ss", Locale.ENGLISH);
        Date date = new Date(Long.parseLong(REGISTERED));
        return dateFormat.format(date);
    }

    @Override
    public double getLatitude() {
        return LATITUDE;
    }

    @Override
    public double getLongitude() {
        return LONGITUDE;
    }

    @Override
    public String getGreeting() {
        return GREETING;
    }

    @Override
    public String getFavoriteFruit() {
        return FAVORITE_FRUIT;
    }
}
