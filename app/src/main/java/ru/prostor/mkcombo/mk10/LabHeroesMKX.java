package ru.prostor.mkcombo.mk10;

import java.util.ArrayList;
import java.util.List;

import ru.prostor.mkcombo.R;
import ru.prostor.mkcombo.core.Hero;
import ru.prostor.mkcombo.core.presenter.contracts.BindLab;

/**
 * Класс для создания и хранения героев
 * mHeroes - список героев
 */
public class LabHeroesMKX implements BindLab {
    private static final LabHeroesMKX ourInstance = new LabHeroesMKX();
    private List<Hero> mHeroes = new ArrayList<>();

    static public LabHeroesMKX getInstance() {
        return ourInstance;
    }

    private LabHeroesMKX() {
        mHeroes.add(new Hero("Kenshi", R.drawable.kenshi, R.array.kenshi_style));
    }

    @Override
    public List<Hero> getHeroes() {
        return mHeroes;
    }
}
