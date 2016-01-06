package com.zyp.recordyoyo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zyp.recordyoyo.R;

import java.util.List;

import com.zyp.recordyoyo.models.ViewContent;

/**
 * Created by Administrator on 2015/12/22.
 */
public class ListViewAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater mLayoutInflater;
    private String[] texts;
    private String tagString;
    private List<ViewContent> mViewContentsList;

    private ContentView mContentView = null;

    public ListViewAdapter(Context context, String[] texts, String tagString) {
        super();
        this.context = context;
        this.texts = texts;
        this.tagString = tagString;
        mLayoutInflater = LayoutInflater.from(this.context);
    }

    /**
     * constructor for ViewContent
     *
     * @param context
     * @param mViewContentsList
     * @param tagString
     */
    public ListViewAdapter(Context context, List<ViewContent> mViewContentsList, String tagString) {
        super();
        this.context = context;
        this.mViewContentsList = mViewContentsList;
        this.tagString = tagString;
        mLayoutInflater = LayoutInflater.from(this.context);
    }

    // 获得长度，一般返回数据的长度即可
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return tagString.toString().equals("ViewContentsList") ? mViewContentsList.size() : texts.length;

    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return tagString.toString().equals("ViewContentsList") ? (ViewContent) mViewContentsList.get(position) : texts[position];
        // return tagString.toString().equals("ViewContentsList") ? texts[position] : (String) mList.get(position).get("tittle");
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        // convertView对象就是item的界面对象，只有为空的时候我们才需要重新赋值一次，这样可以提高效率，如果有这个对象的话，系统会自动复用
        if (convertView == null) {
            if (tagString.toString().equals("ViewContentsList")) {
                convertView = mLayoutInflater.inflate(R.layout.view_content_list, null);
                mContentView = new ContentView();
                mContentView.mImageImageView = (ImageView) convertView.findViewById(R.id.view_image);
                mContentView.mTittleTxtView = (TextView) convertView.findViewById(R.id.view_tittle);
                mContentView.mCommentTxtView = (TextView) convertView.findViewById(R.id.view_comment);
                convertView.setTag(mContentView);
            }
        }
        if (mContentView != null) {
            mContentView = (ContentView) convertView.getTag();
            // 设置文本和图片，然后返回这个View，用于ListView的Item的展示
            if (tagString.toString().equals("ViewContentsList")) {
                mContentView.mImageImageView.setImageResource(mViewContentsList.get(position).getImageViewId());
                mContentView.mTittleTxtView.setText(mViewContentsList.get(position).getTittleTxtView().toString());
                mContentView.mCommentTxtView.setText(mViewContentsList.get(position).getCommentTxtView().toString());
                // mThingReleaseList.mImgView.setImageResource(R.drawable.ic_action_next_item);
            } else if (tagString.toString().equals("ListViewName")) {
                //mListCourse.mCourseTextView.setText((String) mList.get(position).get("tittle").toString());
                // mThingReleaseList.mImgView.setImageResource(R.drawable.ic_action_next_item);
            }
        }
        return convertView;
    }

    // view_content_list.xml布局里的对象
    private static class ContentView {
        private ImageView mImageImageView;
        private TextView mTittleTxtView;
        private TextView mCommentTxtView;
    }

}
