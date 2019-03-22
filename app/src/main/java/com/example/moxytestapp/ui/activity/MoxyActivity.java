package com.example.moxytestapp.ui.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.moxytestapp.model.Data.Variant;
import com.example.moxytestapp.R;
import com.example.moxytestapp.interfaces.ui.OnItemClickListener;
import com.example.moxytestapp.presentation.view.MoxyView;
import com.example.moxytestapp.presentation.presenter.MoxyPresenter;

import com.arellomobile.mvp.MvpActivity;


import com.arellomobile.mvp.presenter.InjectPresenter;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MoxyActivity extends MvpActivity implements MoxyView, OnItemClickListener {
    public static final String TAG = "MoxyActivity";
    private ProgressDialog progressDialog;
    LinearLayout linearLayout;
    LinearLayout.LayoutParams layoutParams;

    TextView textView;
    ImageView imageView;
    RecyclerView recyclerView;
    DataAdapter adapter;
    String stringForHz;

    @InjectPresenter
    MoxyPresenter mMoxyPresenter;

    public static Intent getIntent(final Context context) {
        Intent intent = new Intent(context, MoxyActivity.class);

        return intent;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        imageView = new ImageView(this);
        recyclerView = new RecyclerView(this);

        layoutParams= new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.gravity = Gravity.CENTER;
        layoutParams.setMargins(16,16,16,0);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setLayoutParams(layoutParams);

    }


    public void showProgress() {
        progressDialog = ProgressDialog.show(this, "", getString(R.string.please_wait));
    }

    public void hideProgress() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setText(String string) {
        stringForHz = string;
    }



    @Override
    public void setRecyclerView(List<Variant> variants) {
        adapter = new DataAdapter(this, variants, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void setImageView(String path) {
        Picasso.get().load(path).into(imageView);
    }


    @Override
    public void RenderActivity(List<String> strings) {

        for (int i = 0; i<strings.size(); i++) {
            switch (strings.get(i)) {
                case ("hz"):
                    textView = new TextView(this);
                    textView.setLayoutParams(layoutParams);
                    textView.setText(stringForHz);
                    linearLayout.addView(textView);
                    textView = null;
                    break;
                case ("selector"):
                    linearLayout.addView(recyclerView);
                    break;
                case ("picture"):
                    linearLayout.addView(imageView);
                    break;

            }
        }
        setContentView(linearLayout);
    }

    @Override
    public void onItemClick(int position) {
        mMoxyPresenter.clickItemList(position);
    }
}
