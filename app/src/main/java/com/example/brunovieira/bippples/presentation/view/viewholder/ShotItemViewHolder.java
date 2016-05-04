package com.example.brunovieira.bippples.presentation.view.viewholder;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bumptech.glide.Glide;
import com.example.brunovieira.bippples.Bippples_;
import com.example.brunovieira.bippples.R;
import com.example.brunovieira.bippples.model.entities.ShotsVO;

/**
 * Created by bruno.vieira on 03/05/2016.
 */
public class ShotItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    AppCompatImageView backgroundImageView;

    AppCompatTextView viewersTextView;

    AppCompatTextView loversTextView;

    AppCompatTextView commentsTextView;

    public ShotItemViewHolder(View itemView) {
        super(itemView);

        backgroundImageView = (AppCompatImageView) itemView.findViewById(R.id.view_item_shot_background_imageview);
        viewersTextView = (AppCompatTextView) itemView.findViewById(R.id.view_item_shot_viewers_textview);
        loversTextView = (AppCompatTextView) itemView.findViewById(R.id.view_item_shot_lovers_textview);
        commentsTextView = (AppCompatTextView) itemView.findViewById(R.id.view_item_shot_comments_textview);
    }

    @Override
    public void onClick(View view) {
    }

    public void bind(ShotsVO shotsVO) {
        Drawable drawable = ContextCompat.getDrawable(Bippples_.getInstance(), R.drawable.placeholder_background);
        if (shotsVO.getImagesTypeVO() != null && shotsVO.getImagesTypeVO().getHidpi() != null && !shotsVO.getImagesTypeVO().getHidpi().isEmpty()) {
            Glide.with(Bippples_.getInstance())
                    .load(shotsVO.getImagesTypeVO().getHidpi())
                    .placeholder(drawable)
                    .override(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight())
                    .into(backgroundImageView);
        }

        viewersTextView.setText(String.valueOf(shotsVO.getViewCount()));
        loversTextView.setText(String.valueOf(shotsVO.getLikesCount()));
        commentsTextView.setText(String.valueOf(shotsVO.getCommentsCount()));
    }
}
