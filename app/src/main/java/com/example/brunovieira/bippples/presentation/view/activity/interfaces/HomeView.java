package com.example.brunovieira.bippples.presentation.view.activity.interfaces;

import com.example.brunovieira.bippples.model.entities.ShotsVO;
import com.example.brunovieira.bippples.presentation.view.adapter.ShotsAdapter;

import java.util.List;

/**
 * Created by bruno.vieira on 28/03/2016.
 */
public interface HomeView {
    ShotsAdapter createInitialShotsAdapter();

    void hideSwipeRefresh();

    void setupSwipeRefreshListener();

    void showRecyclerView(ShotsAdapter shotsAdapter);

    ShotsAdapter createShotAdapter(List<ShotsVO> listShots);

    void showJokeDialog(String jokeDescription);

    void showSnackBarError(String errorDescription);
}
