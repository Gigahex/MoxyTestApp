package com.example.moxytestapp.model.Data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {

    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("selectedId")
    @Expose
    private Integer selectedId;
    @SerializedName("variants")
    @Expose
    private List<Variant> variants = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public Data() {
    }

    /**
     *
     * @param text
     * @param variants
     * @param selectedId
     * @param url
     */
    public Data(String text, String url, Integer selectedId, List<Variant> variants) {
        super();
        this.text = text;
        this.url = url;
        this.selectedId = selectedId;
        this.variants = variants;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getSelectedId() {
        return selectedId;
    }

    public void setSelectedId(Integer selectedId) {
        this.selectedId = selectedId;
    }

    public List<Variant> getVariants() {
        return variants;
    }

    public void setVariants(List<Variant> variants) {
        this.variants = variants;
    }

}



