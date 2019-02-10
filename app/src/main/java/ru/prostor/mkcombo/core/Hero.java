package ru.prostor.mkcombo.core;

import java.util.Map;

public class Hero {
    private String mName;
    private int mImage;
    private int mStyle;

    private Map<String, Integer> mComboStyleFirst;
    private Map<String, Integer> mComboStyleSecond;
    private Map<String, Integer> mComboStyleThird;

    public Hero(String name, int image, int style){
        mName = name;
        mImage = image;
        mStyle = style;
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
