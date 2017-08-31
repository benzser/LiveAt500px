package com.example.jaruwatsukkhamjohn.liveat500px.datatype;

import android.os.Bundle;

/**
 * Created by Jaruwat Sukkhamjohn on 31/8/2560.
 */

public class Mutableinteger {

    private int value;

    public Mutableinteger(int value) {
        this.value = value;
    }

    public Bundle onSavedInstanceState(){
        Bundle bundle = new Bundle();
        bundle.putInt("value",value);
        return bundle;
    }

    public void onRestoreInstanceState(Bundle savedInstanceState){
        value = savedInstanceState.getInt("value");
    }
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
