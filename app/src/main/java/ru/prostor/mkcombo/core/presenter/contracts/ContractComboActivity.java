package ru.prostor.mkcombo.core.presenter.contracts;
import android.support.annotation.ArrayRes;
import android.support.annotation.NonNull;

import java.util.Map;

public interface ContractComboActivity {
    void setAdapterData(@ArrayRes int style, @NonNull Map... combo );
}
