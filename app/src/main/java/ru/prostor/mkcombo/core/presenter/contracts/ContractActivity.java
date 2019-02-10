package ru.prostor.mkcombo.core.presenter.contracts;

import java.util.List;

import ru.prostor.mkcombo.core.Hero;

public interface ContractActivity {
    void setAdapterData(List<Hero> list);
}
