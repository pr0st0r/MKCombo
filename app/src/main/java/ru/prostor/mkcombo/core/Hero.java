package ru.prostor.mkcombo.core;

import android.support.annotation.ArrayRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.Map;

public class Hero implements Serializable {
    private String mName;
    private int mImage;
    private int mStyle;

    private Map<String, Integer> mComboStyleFirst;
    private Map<String, Integer> mComboStyleSecond;
    private Map<String, Integer> mComboStyleThird;

    public Hero(String name, @DrawableRes int image,
                @ArrayRes int style, @NonNull Map comboStyleFirst,
                @NonNull Map comboStyleSecond, @NonNull Map comboStyleThird){
        mName = name;
        mImage = image;
        mStyle = style;
        mComboStyleFirst = comboStyleFirst;
        mComboStyleSecond = comboStyleSecond;
        mComboStyleThird = comboStyleThird;
    }

    public String getName() {
        return mName;
    }

    public int getImage() {
        return mImage;
    }

    public int getStyle() {
        return mStyle;
    }

    public Map<String, Integer> getComboStyleFirst() {
        return mComboStyleFirst;
    }

    public Map<String, Integer> getComboStyleSecond() {
        return mComboStyleSecond;
    }

    public Map<String, Integer> getComboStyleThird() {
        return mComboStyleThird;
    }
}
