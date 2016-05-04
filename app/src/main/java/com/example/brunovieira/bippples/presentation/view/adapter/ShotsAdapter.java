package com.example.brunovieira.bippples.presentation.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.brunovieira.bippples.R;
import com.example.brunovieira.bippples.common.custom.RecyclerViewAdapter;
import com.example.brunovieira.bippples.model.entities.ShotsVO;
import com.example.brunovieira.bippples.presentation.view.viewholder.ShotItemViewHolder;

import org.androidannotations.annotations.EBean;

/**
 * Created by bruno.vieira on 03/05/2016.
 */
@EBean
public class ShotsAdapter extends RecyclerViewAdapter<ShotItemViewHolder, ShotsVO, RecyclerView.RecyclerListener> {

    @Override
    public ShotItemViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
        return new ShotItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item_shot, parent, false));
    }

    @Override
    public void onBindItemViewHolder(ShotItemViewHolder holder, int position) {
        holder.bind(getItems().get(position));
    }

}
