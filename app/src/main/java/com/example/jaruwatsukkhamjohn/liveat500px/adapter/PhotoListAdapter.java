package com.example.jaruwatsukkhamjohn.liveat500px.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.jaruwatsukkhamjohn.liveat500px.R;
import com.example.jaruwatsukkhamjohn.liveat500px.dao.PhotoitemCollectionDao;
import com.example.jaruwatsukkhamjohn.liveat500px.dao.PhotoitemDao;
import com.example.jaruwatsukkhamjohn.liveat500px.datatype.Mutableinteger;
import com.example.jaruwatsukkhamjohn.liveat500px.manager.PhotoListManager;
import com.example.jaruwatsukkhamjohn.liveat500px.view.PhotoListitem;

/**
 * Created by Jaruwat Sukkhamjohn on 29/8/2560.
 */

public class PhotoListAdapter extends BaseAdapter {

    PhotoitemCollectionDao dao;
    Mutableinteger lastPositionInteger;

    public PhotoListAdapter(Mutableinteger lastPositionInteger) {
        this.lastPositionInteger = lastPositionInteger;
    }

    public void setDao(PhotoitemCollectionDao dao) {
        this.dao = dao;
    }

    @Override
    public int getCount() {
        if (dao == null)
            return 1;
        if (dao.getData() == null)
            return 1;
        return dao.getData().size() + 1;
    }

    @Override
    public Object getItem(int position) {
        return dao.getData().get(position);
    }

    @Override
    public long getItemId(int position) {

        return 0;
    }

    //Divine View on 2 Method

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        return position == getCount() - 1 ? 1 : 0;
    }


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
        if (position == getCount() - 1) {
            ProgressBar item;
            if (convertView != null)
                item = (ProgressBar) convertView;
            else
                item = new ProgressBar(parent.getContext());
            return item;
        }
        PhotoListitem item;
        if (convertView != null)
            item = (PhotoListitem) convertView;
        else
            item = new PhotoListitem(parent.getContext());

        PhotoitemDao dao = (PhotoitemDao) getItem(position);

        item.setNameText(dao.getCaption());
        item.setDescriptionText(dao.getUsername() + "\n" + dao.getCamera());
        item.setImageUrl(dao.getImageUrl());

        if (position > lastPositionInteger.getValue()) {
            Animation anim = AnimationUtils.loadAnimation(parent.getContext(), R.anim.up_from_bottom);
            item.startAnimation(anim);
            lastPositionInteger.setValue(position);
        }
        return item;
    }


    public void increaseLastPosition(int amount) {
        lastPositionInteger.setValue(lastPositionInteger.getValue() + amount);
    }
}
