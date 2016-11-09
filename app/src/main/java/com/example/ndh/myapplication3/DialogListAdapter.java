package com.example.ndh.myapplication3;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ndh on 16/11/8.
 */

public class DialogListAdapter extends BaseAdapter {
    private Context mContext;

    public DialogListAdapter(Context conetxt) {
        mContext = conetxt;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = View.inflate(mContext, R.layout.item, null);
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.time = (TextView) convertView.findViewById(R.id.time);
            holder.content = (TextView) convertView.findViewById(R.id.content);
            holder.dot = convertView.findViewById(R.id.dot);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.name.setText("小明");
        holder.time.setText("15:15");
        holder.content.setText("你好,我的朋友");
        return convertView;
    }

    private class ViewHolder {
        TextView name;
        TextView time;
        TextView content;
        View dot;
    }

}
