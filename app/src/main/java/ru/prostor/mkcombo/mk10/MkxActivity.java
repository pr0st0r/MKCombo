package ru.prostor.mkcombo.mk10;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.prostor.mkcombo.R;
import ru.prostor.mkcombo.core.Hero;
import ru.prostor.mkcombo.core.Lab;
import ru.prostor.mkcombo.core.presenter.contracts.ContractActivity;
import ru.prostor.mkcombo.core.presenter.HeroesPresenter;
import ru.prostor.mkcombo.core.rv.adapters.ListHeroesAdapter;

public class MkxActivity extends AppCompatActivity implements ContractActivity {

    @BindView(R.id.list_heroes)
    RecyclerView listHeroes;

    private HeroesPresenter mHeroesPresenter;
    private ListHeroesAdapter mListHeroesAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mkx_activity);
        ButterKnife.bind(this);

        listHeroes.setLayoutManager(new LinearLayoutManager(this));
        mListHeroesAdapter = new ListHeroesAdapter(this);
        listHeroes.setAdapter(mListHeroesAdapter);

        mHeroesPresenter = new HeroesPresenter(Lab.MKX);
        mHeroesPresenter.attachView(this);
        mHeroesPresenter.viewIsReady();
    }

    @Override
    public void setAdapterData(@NonNull List<Hero> list) {
        mListHeroesAdapter.setHeroList(list);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHeroesPresenter.detachView();
    }
}
