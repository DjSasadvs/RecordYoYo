package com.zyp.recordyoyo.utils;

/**
 * calculate the dynamic height of list_view conference on stack overflow
 * <p>
 * Created by zyp on 2015/12/22.
 */

import android.app.ActivityManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.zyp.recordyoyo.R;
import com.zyp.recordyoyo.activity.DetailsActivity;
import com.zyp.recordyoyo.recordYoYo.RecordYoYo;

public class Utility {
    // 依据specMode的值，（MeasureSpec有3种模式分别是UNSPECIFIED, EXACTLY和AT_MOST）
    // 如果是AT_MOST，specSize 代表的是最大可获得的空间；
    // 如果是EXACTLY，specSize 代表的是精确的尺寸；
    // 如果是UNSPECIFIED，对于控件尺寸来说，没有任何参考意义
    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null)
            return;

        int desiredWidth = MeasureSpec.makeMeasureSpec(listView.getWidth(), MeasureSpec.UNSPECIFIED);
        int totalHeight = 0;
        View view = null;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            view = listAdapter.getView(i, view, listView);
            if (i == 0)
                view.setLayoutParams(new LayoutParams(desiredWidth, LayoutParams.WRAP_CONTENT));
            view.measure(0, 0);
            view.measure(desiredWidth, MeasureSpec.UNSPECIFIED);
            totalHeight += view.getMeasuredHeight();
        }
        LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }

    public static void showRecommendNotification() {
        Context context = RecordYoYo.getContext();
        NotificationManager nm = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
        final NotificationCompat.Builder builder = new NotificationCompat.Builder(context);

        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra(DetailsActivity.TOOLBAR_TITLE, context.getString(R.string.notification_recommend_title));
        PendingIntent startIntent = PendingIntent.getActivity(context, R.id.notification_recommend, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(startIntent);
        builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher))
                .setContentTitle(context.getString(R.string.notification_recommend_title))
                .setContentText(context.getString(R.string.notification_recommend_content));
        builder.setOngoing(false);
        builder.setAutoCancel(true);
        builder.setSmallIcon(R.mipmap.ic_action_next_item);
        nm.notify(R.id.notification_recommend, builder.build());
    }
}

