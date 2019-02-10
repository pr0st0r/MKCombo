package ru.prostor.mkcombo.core.rv.holders;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import ru.prostor.mkcombo.R;
import ru.prostor.mkcombo.core.Hero;

public class ListHeroisHolder extends RecyclerView.ViewHolder {

    private Hero mHero;
    private Resources mResources;

    @BindView(R.id.hero_image)
    ImageView imageHero;
    @BindView(R.id.hero_name)
    TextView heroName;
    @BindViews({R.id.hero_style_1, R.id.hero_style_2, R.id.hero_style_3})
    Button[] styleButton;


    public ListHeroisHolder(final LayoutInflater inflater, ViewGroup parent) {
        super(inflater.inflate(R.layout.item_hero, parent, false));
        ButterKnife.bind(this, itemView);
        mResources = itemView.getResources();
    }

    public void bind(Hero hero){
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
}
