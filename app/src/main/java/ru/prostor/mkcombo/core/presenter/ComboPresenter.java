package ru.prostor.mkcombo.core.presenter;

import ru.prostor.mkcombo.core.Hero;
import ru.prostor.mkcombo.core.presenter.contracts.ContractComboActivity;

public class ComboPresenter {

    private ContractComboActivity mActivity;
    private Hero mModel;

    public ComboPresenter(Hero hero) {
       mModel = hero;
    }

    public void attachView(ContractComboActivity activity) {
        mActivity = activity;
    }

    public void viewIsReady(){
        mActivity.setAdapterData(
                mModel.getStyle(),
                mModel.getComboStyleFirst(),
                mModel.getComboStyleSecond(),
                mModel.getComboStyleThird()
        );
    }

    public void detachView() {
        mActivity = null;
        mModel = null;
    }
}
