package com.zyp.recordyoyo.models;

/**
 * Created by Administrator on 2015/12/22.
 */
public class ViewContent {

    private int mImageViewId;
    private String mContentTxtView;
    private String mTittleTxtView;
    private String mCommentTxtView;
    private String mContentDate;
    private int mContentType;
    private String mContentTag;

    public String getContentDate() {
        return mContentDate;
    }

    public void setContentDate(String contentDate) {
        mContentDate = contentDate;
    }

    public int getContentType() {
        return mContentType;
    }

    public void setContentType(int contentType) {
        mContentType = contentType;
    }

    public String getContentTag() {
        return mContentTag;
    }

    public void setContentTag(String contentTag) {
        mContentTag = contentTag;
    }

    public int getImageViewId() {
        return mImageViewId;
    }

    public void setImageViewId(int imageViewId) {
        mImageViewId = imageViewId;
    }

    public String getContentTxtView() {
        return mContentTxtView;
    }

    public void setContentTxtView(String contentTxtView) {
        mContentTxtView = contentTxtView;
    }

    public String getTittleTxtView() {
        return mTittleTxtView;
    }

    public void setTittleTxtView(String tittleTxtView) {
        mTittleTxtView = tittleTxtView;
    }

    public String getCommentTxtView() {
        return mCommentTxtView;
    }

    public void setCommentTxtView(String commentTxtView) {
        mCommentTxtView = commentTxtView;
    }
}
