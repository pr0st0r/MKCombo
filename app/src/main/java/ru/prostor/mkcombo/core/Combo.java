package ru.prostor.mkcombo.core;

import java.util.HashMap;
import java.util.Map;

public interface Combo {
    default Map<String, Integer> getCombo(int base, int spec, int combo, int fatality){
        Map<String, Integer> listCombo = new HashMap<>();

        listCombo.put("base", base);
        listCombo.put("spec", spec);
        listCombo.put("combo", combo);
        listCombo.put("fatality", fatality);

        return listCombo;
    }
}
