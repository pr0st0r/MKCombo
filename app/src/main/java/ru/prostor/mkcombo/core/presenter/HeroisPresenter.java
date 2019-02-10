package ru.prostor.mkcombo.core.presenter;

import ru.prostor.mkcombo.core.Lab;
import ru.prostor.mkcombo.core.presenter.contracts.BindLab;
import ru.prostor.mkcombo.core.presenter.contracts.ContractActivity;
import ru.prostor.mkcombo.mk10.LabHeroesMKX;

public class HeroisPresenter {

    private ContractActivity mActivity;
    private BindLab mModel;

    public HeroisPresenter(Lab lab) {
        switch (lab){
            case MKX:
                mModel = LabHeroesMKX.getInstance();
                break;
        }
    }

    public void attachView(ContractActivity activity) {
        mActivity = activity;
    }

    public void viewIsReady(){
        mActivity.setAdapterData(mModel.getHeroes());
    }

    public void detachView() {
        mActivity = null;
        mModel = null;
    }
}
