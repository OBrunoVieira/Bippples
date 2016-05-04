package com.example.brunovieira.bippples.common.custom;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by bruno.vieira on 04/05/2016.
 */
public class CustomSwipeRefresh extends SwipeRefreshLayout {

    public CustomSwipeRefresh(Context context) {
        super(context);
    }

    public CustomSwipeRefresh(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes) {
        return !isRefreshing() && super.onStartNestedScroll(child, target, nestedScrollAxes);
    }
}