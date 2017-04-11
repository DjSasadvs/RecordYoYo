package com.zyp.recordyoyo.models.QingChangYou;

import com.google.gson.annotations.SerializedName;

/**
 * Created by zyp on 2017/1/22.
 */
public class User {

    @SerializedName("gender")
    public byte gender;

    @SerializedName("id")
    public int id;

    @SerializedName("name")
    public String name;

    @SerializedName("level")
    public int level;

    @SerializedName("photo_url")
    public String photo_url;
}
