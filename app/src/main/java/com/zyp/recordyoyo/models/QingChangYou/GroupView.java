package com.zyp.recordyoyo.models.QingChangYou;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by zyp on 2017/1/22.
 *
 * http://q.chanyouji.com/api/v1/timelines.json?page=1
 *
 * http://q.chanyouji.com/api/v1/user_activities.json?district_id=53&page=1
 */
public class GroupView {

    @SerializedName("data")
    public ArrayList<QingChangYouViewContent> data;

    @SerializedName("message")
    public String message;

    @SerializedName("status")
    public int status;

    class QingChangYouViewContent{

        @SerializedName("activity")
        public ActivityContent activity;

        @SerializedName("event_type")
        public String eventType;

        @SerializedName("user")
        public User user;

    }

    class ActivityContent{
        @SerializedName("categories")
        public ArrayList<Category> categoryArrayList;

        @SerializedName("comments_count")
        public int commentsCount;

        @SerializedName("contents")
        public ArrayList<Content> contents;

        @SerializedName("contents_count")
        public int contentsCount;

        @SerializedName("created_at")
        public String created_at;

        @SerializedName("description")
        public String description;

        @SerializedName("district_id")
        public int district_id;

        @SerializedName("districts")
        public ArrayList<District> districts;

        @SerializedName("favorites_count")
        public int favoritesCount;

        @SerializedName("id")
        public int id;

        @SerializedName("level")
        public int level;

        @SerializedName("likes_count")
        public int likesCount;

        @SerializedName("made_at")
        public String madeAt;

        @SerializedName("topic")
        public String topic;

        @SerializedName("user")
        public User user;
    }


}
