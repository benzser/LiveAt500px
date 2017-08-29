package com.example.jaruwatsukkhamjohn.liveat500px.manager;

import android.content.Context;

import com.example.jaruwatsukkhamjohn.liveat500px.dao.PhotoitemCollectionDao;
import com.inthecheesefactory.thecheeselibrary.manager.Contextor;

/**
 * Created by nuuneoi on 11/16/2014.
 */
public class PhotoListManager {

    private static PhotoListManager instance;

    public static PhotoListManager getInstance() {
        if (instance == null)
            instance = new PhotoListManager();
        return instance;
    }

    private Context mContext;
    private PhotoitemCollectionDao dao;

    private PhotoListManager() {
        mContext = Contextor.getInstance().getContext();
    }

    public PhotoitemCollectionDao getDao() {
        return dao;
    }

    public void setDao(PhotoitemCollectionDao dao) {
        this.dao = dao;
    }
}
