package com.easy.myapplication1236.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.easy.myapplication1236.R;
import com.easy.myapplication1236.databinding.AdapterViewBinding;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<TestModel> notes;
    private ItemClickListener itemClickListener;

    public RecyclerViewAdapter(List<TestModel> notes, ItemClickListener itemClickListener) {
        this.notes = notes;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public WithTitle onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =
                LayoutInflater.from(parent.getContext());

        /*View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_view, parent, false);*/

        AdapterViewBinding itemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.adapter_view, parent, false);

        return new WithTitle( itemClickListener, itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        TestModel currentNote = notes.get(position);

        WithTitle noteHolder = (WithTitle) holder;
        noteHolder.bind(currentNote);


    }


    @Override
    public int getItemCount() {
        return notes.size();
    }

    public interface ItemClickListener {
        void onItemClick(int id);
    }

}

