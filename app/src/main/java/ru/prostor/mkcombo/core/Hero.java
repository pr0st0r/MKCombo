package ru.prostor.mkcombo.core;

import java.io.Serializable;
import java.util.Map;

public class Hero implements Serializable {
    private String mName;
    private int mImage;
    private int mStyle;

    private Map<String, Integer> mComboStyleFirst;
    private Map<String, Integer> mComboStyleSecond;
    private Map<String, Integer> mComboStyleThird;

    public Hero(String name, int image, int style, Map comboStyleFirst, Map comboStyleSecond, Map comboStyleThird){
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
