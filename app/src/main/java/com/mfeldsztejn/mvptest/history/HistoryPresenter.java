package com.mfeldsztejn.mvptest.history;

import com.mfeldsztejn.mvptest.base.BasePresenter;
import com.mfeldsztejn.mvptest.repositories.HistoryRepository;

import java.util.List;

/**
 * Created by mfeldsztejn on 8/27/16.
 */
public class HistoryPresenter extends BasePresenter<HistoryView> {
    private HistoryRepository historyRepository;

    public HistoryPresenter(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    @Override
    public void onViewAttach(HistoryView view) {
        super.onViewAttach(view);
        List<String> values = historyRepository.getAll();
        view.setHistoryResults(values);
    }
}
