package com.example.jaruwatsukkhamjohn.liveat500px.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.jaruwatsukkhamjohn.liveat500px.dao.PhotoitemDao;
import com.example.jaruwatsukkhamjohn.liveat500px.manager.PhotoListManager;
import com.example.jaruwatsukkhamjohn.liveat500px.view.PhotoListitem;

/**
 * Created by Jaruwat Sukkhamjohn on 29/8/2560.
 */

public class PhotoListAdapter extends BaseAdapter {
    @Override
    public int getCount() {
        if (PhotoListManager.getInstance().getDao() == null)
            return 0;
        if (PhotoListManager.getInstance().getDao().getData() == null)
            return 0;
        return PhotoListManager.getInstance().getDao().getData().size();
    }

    @Override
    public Object getItem(int position) {
        return PhotoListManager.getInstance().getDao().getData().get(position);
    }

    @Override
    public long getItemId(int position) {

        return 0;
    }
/*
    Divine View on 2 Method

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2 == 0 ? 0 : 1;
    }
*/

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Mutiple View on list View
     /*   if (getItemViewType(position) == 0) {
            PhotoListitem item;
            if (convertView != null)
                item = (PhotoListitem) convertView;
            else
                item = new PhotoListitem(parent.getContext());
            return item;
        } else {
            TextView item;
            if (convertView != null)
                item = (TextView) convertView;
            else
                item = new TextView(parent.getContext());
            item.setText("Position: " + position);
            return item;
        }
    }*/
        PhotoListitem item;
        if (convertView != null)
            item = (PhotoListitem) convertView;
        else
            item = new PhotoListitem(parent.getContext());

        PhotoitemDao dao = (PhotoitemDao) getItem(position);

        item.setNameText(dao.getCaption());
        item.setDescriptionText(dao.getUsername() + "\n" + dao.getCamera());
        item.setImageUrl(dao.getImageUrl());
        return item;
    }
}
