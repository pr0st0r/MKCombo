package ru.prostor.mkcombo.core;

import android.support.annotation.ArrayRes;

import java.util.HashMap;
import java.util.Map;

public interface Combo {
    default Map<String, Integer> getCombo(@ArrayRes int base,@ArrayRes int spec,@ArrayRes int combo,@ArrayRes int fatality){
        Map<String, Integer> listCombo = new HashMap<>();

        listCombo.put("base", base);
        listCombo.put("spec", spec);
        listCombo.put("combo", combo);
        listCombo.put("fatality", fatality);

        return listCombo;
    }
}
