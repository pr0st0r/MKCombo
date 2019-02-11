package ru.prostor.mkcombo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.ArrayRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.prostor.mkcombo.core.Hero;
import ru.prostor.mkcombo.core.pager.ComboPageAdapter;
import ru.prostor.mkcombo.core.presenter.ComboPresenter;
import ru.prostor.mkcombo.core.presenter.contracts.ContractComboActivity;

/**
 * Экран с комбинациями героев
 */
public class ComboActivity extends AppCompatActivity implements ContractComboActivity {

    @BindView(R.id.pager)
    ViewPager mPager;
    @BindView(R.id.pagerTabStrip)
    PagerTabStrip mPagerTabStrip;

    private ComboPageAdapter mComboPageAdapter;
    private ComboPresenter mPresenter;

    private static final String HERO = "hero";
    private static final String NUMBER_HERO_STYLE = "number_hero_style";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_combo);

        ButterKnife.bind(this);

        //Получаем элементы
        Intent intent = getIntent();
        Hero hero = (Hero) intent.getSerializableExtra(HERO);
        int number = intent.getIntExtra(NUMBER_HERO_STYLE, 0);

        mPagerTabStrip.setTextColor(getResources().getColor(R.color.white));
        mPagerTabStrip.setTabIndicatorColorResource(R.color.brown);
        /*Устанавливаем адаптер для viewPager
          и определяем на какую страницу был сделан переход*/
        mComboPageAdapter = new ComboPageAdapter(getSupportFragmentManager(), getResources());

        mPresenter = new ComboPresenter(hero);
        mPresenter.attachView(this);
        mPresenter.viewIsReady();

        mPager.setAdapter(mComboPageAdapter);
        mPager.setCurrentItem(number);
    }


    @Override
    public void setAdapterData(@ArrayRes int style,@NonNull Map... combo) {
        mComboPageAdapter.setStyle(style);
        mComboPageAdapter.setCombo(combo);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }
}
