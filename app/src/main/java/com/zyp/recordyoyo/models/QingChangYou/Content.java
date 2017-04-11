package com.zyp.recordyoyo.models.QingChangYou;

import com.google.gson.annotations.SerializedName;

/**
 * Created by zyp on 2017/1/22.
 */
public class Content {
    @SerializedName("caption")
    public String caption;

    @SerializedName("height")
    public int height;

    @SerializedName("id")
    public int id;

    @SerializedName("photo_url")
    public String photoUrl;

    @SerializedName("position")
    public int position;

    @SerializedName("width")
    public int width;
}
