package ru.prostor.mkcombo.core.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import ru.prostor.mkcombo.R;
import ru.prostor.mkcombo.core.pager.ComboAdapter;

public class ComboPage extends Fragment implements BottomNavigationView.OnNavigationItemSelectedListener{

    private Map<String, Integer> mCombo;
    private Unbinder mUnbinder;
    private ComboAdapter mComboAdapter;

    @BindView(R.id.list_combo)
    ListView mListCombo;
    @BindView(R.id.navigation)
    BottomNavigationView mNavigation;

    static public ComboPage newInstance(Map combo) {
        ComboPage comboPage = new ComboPage();
        comboPage.setCombo(combo);
        return comboPage;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.combo_page, null);

        mUnbinder = ButterKnife.bind(this, view);

       mNavigation.setOnNavigationItemSelectedListener(this);

        mComboAdapter = new ComboAdapter(getContext(), R.layout.item_combo);
        mComboAdapter.setCombo(mCombo.get("base"));
        mListCombo.setAdapter(mComboAdapter);
        return view;

    }

    public void setCombo(Map<String, Integer> combo) {
        mCombo = combo;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.base:
                mComboAdapter.setCombo(mCombo.get("base"));
                break;
            case R.id.spec:
                mComboAdapter.setCombo(mCombo.get("spec"));
                break;
            case R.id.combo:
                mComboAdapter.setCombo(mCombo.get("combo"));
                break;
            case R.id.fatality:
                mComboAdapter.setCombo(mCombo.get("fatality"));
                break;
        }

        mComboAdapter.notifyDataSetChanged();
        return true;
    }
}
