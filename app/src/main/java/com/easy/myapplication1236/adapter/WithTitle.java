package com.easy.myapplication1236.adapter;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.easy.myapplication1236.R;
import com.easy.myapplication1236.databinding.AdapterViewBinding;


public class WithTitle extends RecyclerView.ViewHolder implements View.OnClickListener {

    private TextView textView;

    private RecyclerViewAdapter.ItemClickListener itemClickListener;
    private TestModel testModel;
    private  AdapterViewBinding bindingAdapter;

    WithTitle(RecyclerViewAdapter.ItemClickListener itemClickListener, AdapterViewBinding adapterViewBinding) {
        super(adapterViewBinding.getRoot());
       // textView = itemView.findViewById(R.id.textView);
        this.itemClickListener = itemClickListener;
        this.bindingAdapter = adapterViewBinding;
        itemView.setOnClickListener(this);
    }


    void bind( TestModel model) {
        bindingAdapter.setNote(model);
        Log.v("APP", String.valueOf(bindingAdapter.getNote().getId()));
      /*  testModel = model;
        textView.setText(bindingAdapter.getNote().getId());*/
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onItemClick(bindingAdapter.getNote().getId());
    }
}
