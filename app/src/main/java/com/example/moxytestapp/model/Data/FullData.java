package com.example.moxytestapp.model.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FullData {

    @SerializedName("data")
    @Expose
    private List<Datum> data = null;
    @SerializedName("view")
    @Expose
    private List<String> view = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public FullData() {
    }

    /**
     *
     * @param data
     * @param view
     */
    public FullData(List<Datum> data, List<String> view) {
        super();
        this.data = data;
        this.view = view;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public List<String> getView() {
        return view;
    }

    public void setView(List<String> view) {
        this.view = view;
    }
}