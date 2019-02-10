package ru.prostor.mkcombo.mk10;

import java.util.ArrayList;
import java.util.List;

import ru.prostor.mkcombo.R;
import ru.prostor.mkcombo.core.Combo;
import ru.prostor.mkcombo.core.Hero;
import ru.prostor.mkcombo.core.presenter.contracts.BindLab;

/**
 * Класс для создания и хранения героев
 * mHeroes - список героев
 */
public class LabHeroesMKX implements BindLab, Combo {
    private static final LabHeroesMKX ourInstance = new LabHeroesMKX();
    private List<Hero> mHeroes = new ArrayList<>();

    static public LabHeroesMKX getInstance() {
        return ourInstance;
    }

    private LabHeroesMKX() {
        mHeroes.add(new Hero("Kenshi", R.drawable.kenshi, R.array.kenshi_style,
                getCombo(R.array.kenshi_base_style_first, R.array.kenshi_spec_style_first, R.array.kenshi_combo_style_first, R.array.kenshi_fatality_style_first),
                getCombo(R.array.kenshi_base_style_second, R.array.kenshi_spec_style_second, R.array.kenshi_combo_style_second, R.array.kenshi_fatality_style_second),
                getCombo(R.array.kenshi_base_style_third, R.array.kenshi_spec_style_third, R.array.kenshi_combo_style_third, R.array.kenshi_fatality_style_third)));
    }

    @Override
    public List<Hero> getHeroes() {
        return mHeroes;
    }
}
