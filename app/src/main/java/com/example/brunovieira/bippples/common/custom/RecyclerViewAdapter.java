package com.example.brunovieira.bippples.common.custom;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by bruno.vieira on 28/03/2016.
 */
public abstract class RecyclerViewAdapter<VH extends RecyclerView.ViewHolder, I, L> extends RecyclerView.Adapter<VH> {

    private List<I> items;
    private L listener;

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        return onCreateItemViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        onBindItemViewHolder(holder, position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public abstract VH onCreateItemViewHolder(ViewGroup parent, int viewType);

    public abstract void onBindItemViewHolder(VH holder, int position);

    public boolean hasItems() {
        return items.size() > 0;
    }

    public boolean hasListener() {
        return listener != null;
    }

    public void setItems(List<I> items) {
        this.items = items;
    }

    public List<I> getItems() {
        return items;
    }

    public L getListener() {
        return listener;
    }

    public void setListener(L listener) {
        this.listener = listener;
    }
}
