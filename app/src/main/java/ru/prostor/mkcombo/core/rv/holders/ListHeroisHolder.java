package ru.prostor.mkcombo.core.rv.holders;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.prostor.mkcombo.ComboActivity;
import ru.prostor.mkcombo.R;
import ru.prostor.mkcombo.core.Hero;

public class ListHeroisHolder extends RecyclerView.ViewHolder {

    private Hero mHero;
    private Resources mResources;
    private Context mContext;

    @BindView(R.id.hero_image)
    ImageView imageHero;
    @BindView(R.id.hero_name)
    TextView heroName;
    @BindViews({R.id.hero_style_1, R.id.hero_style_2, R.id.hero_style_3})
    Button[] styleButton;

    private static final String HERO = "hero";
    private static final String NUMBER_HERO_STYLE = "number_hero_style";

    public ListHeroisHolder(final LayoutInflater inflater, ViewGroup parent) {
        super(inflater.inflate(R.layout.item_hero, parent, false));
        ButterKnife.bind(this, itemView);
        mResources = itemView.getResources();
        mContext = inflater.getContext();
    }

    public void bind(@NonNull Hero hero){
        mHero = hero;
        setParams();
    }

    private void setParams(){
        imageHero.setImageResource(mHero.getImage());
        heroName.setText(mHero.getName());
        String[] style = mResources.getStringArray(mHero.getStyle());

        int i = 0;
        for (String elem : style){
            styleButton[i].setText(elem);
            i++;
        }
    }

    @OnClick({R.id.hero_style_1, R.id.hero_style_2, R.id.hero_style_3})
    public void openActivityCombo(View view){
        Intent intent = new Intent(mContext, ComboActivity.class);
        intent.putExtra(HERO, mHero);
        switch(view.getId()){
            case R.id.hero_style_1:
                intent.putExtra(NUMBER_HERO_STYLE, 0);
                break;
            case R.id.hero_style_2:
                intent.putExtra(NUMBER_HERO_STYLE, 1);
                break;
            case R.id.hero_style_3:
                intent.putExtra(NUMBER_HERO_STYLE, 2);
                break;
        }
        mContext.startActivity(intent);
    }
}
