package com.example.moxytestapp.presentation.view;

import com.arellomobile.mvp.MvpView;
import com.example.moxytestapp.model.Data.Variant;

import java.util.List;

public interface MoxyView extends MvpView {
    public void showProgress();
    public void hideProgress();
    public void showToast(String text);
    public void setText(String string);
    public void setRecyclerView(List<Variant> variants);
    public void setImageView(String path);
    public void RenderActivity(List<String> strings);


}
