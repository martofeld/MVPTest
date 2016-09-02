package com.mfeldsztejn.mvptest.history;

import com.mfeldsztejn.mvptest.base.BaseView;

import java.util.List;

/**
 * Created by mfeldsztejn on 8/27/16.
 */

public interface HistoryView extends BaseView {
    void setHistoryResults(List<String> results);
}
