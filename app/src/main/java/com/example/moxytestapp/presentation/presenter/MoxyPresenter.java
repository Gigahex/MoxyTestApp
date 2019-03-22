package com.example.moxytestapp.presentation.presenter;


import com.example.moxytestapp.model.DataModel;
import com.example.moxytestapp.model.Data.Variant;
import com.example.moxytestapp.interfaces.presenter.FetchReceiver;
import com.example.moxytestapp.presentation.view.MoxyView;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

@InjectViewState
public class MoxyPresenter extends MvpPresenter<MoxyView> implements FetchReceiver {
    private  final DataModel dataModel;


    public MoxyPresenter() {
        dataModel = new DataModel();
        fetchData();
    }
    void fetchData(){
        getViewState().showProgress();
        dataModel.loadDataFromServer(this);

    }



    public void clickItemList(int index) {
        Variant variant = dataModel.getVariants().get(index);
        String text = String.valueOf(variant.getId()) + " " + variant.getText();
        getViewState().showToast(text);
        }

    @Override
    public void resultFetch(int result) {
        getViewState().hideProgress();
        if(result == DataModel.OK){
            getViewState().setImageView(dataModel.getPictureUrl());
            getViewState().setText(dataModel.getHzText());
            getViewState().setRecyclerView(dataModel.getVariants());
            getViewState().RenderActivity(dataModel.getView());
        } else if (result == DataModel.ERROR){
            getViewState().showToast("ERROR!");
        }
    }
}
