package com.zyp.recordyoyo.interfaces;

import android.graphics.Bitmap;

/**
 * Created by YipengZhang on 2016/2/18.
 */
public interface GetContentData {

    String getContentTittleStr(Integer id);

    String getContentCommentStr(Integer id);

    Bitmap getContentViewImage(Integer id);
}
