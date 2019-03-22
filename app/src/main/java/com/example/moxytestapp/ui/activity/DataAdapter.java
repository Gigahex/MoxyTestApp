package com.example.moxytestapp.ui.activity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.moxytestapp.model.Data.Variant;
import com.example.moxytestapp.R;
import com.example.moxytestapp.interfaces.ui.OnItemClickListener;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<Variant> variants;
    private OnItemClickListener listener;
    public DataAdapter(Context context, List<Variant> variants, OnItemClickListener listener) {
        this.variants = variants;
        this.inflater = LayoutInflater.from(context);
        this.listener = listener;
    }
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Variant variant = variants.get(position);
        holder.textViewId.setText(String.valueOf(variant.getId()));
        holder.textViewText.setText(variant.getText());
    }
    public void notifyData(List<Variant> phones) {
        this.variants = phones;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return variants.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final TextView textViewId, textViewText;
        ViewHolder(View view){
            super(view);
            textViewId = (TextView) view.findViewById(R.id.textId);
            textViewText = (TextView) view.findViewById(R.id.textVariant);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    Log.d("Android", String.valueOf(pos));
                    listener.onItemClick(pos);

                }
            });
        }
    }
}
