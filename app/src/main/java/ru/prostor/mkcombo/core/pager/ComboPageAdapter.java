package ru.prostor.mkcombo.core.pager;

import android.content.res.Resources;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import ru.prostor.mkcombo.core.fragment.ComboPage;

public class ComboPageAdapter extends FragmentPagerAdapter {

    private Resources mResources;
    private String[] mStyle;
    private List<Map> mCombo = new ArrayList<>();

    /**
     *
     * @param fm
     * @param resources - объект для доступа к ресурсам
     */
    public ComboPageAdapter(FragmentManager fm, Resources resources) {
        super(fm);
        mResources = resources;
    }

    @Override
    public Fragment getItem(int i) {
        return ComboPage.newInstance(mCombo.get(i));
    }

    @Override
    public int getCount() {
        return mStyle.length;
    }

    @Override
    public CharSequence getPageTitle(int i) {
        return mStyle[i];
    }

    public void setStyle(int style){
        mStyle = mResources.getStringArray(style);
    }

    public void setCombo(Map... combo){
        for(Map item : combo){
            mCombo.add(item);
        }
    }
}
