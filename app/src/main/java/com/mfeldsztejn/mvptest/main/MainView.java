package com.mfeldsztejn.mvptest.main;

import com.mfeldsztejn.mvptest.base.BaseView;

/**
 * Created by mfeldsztejn on 8/27/16.
 */

public interface MainView extends BaseView {
    void setResult(float result);

    void setSnackBarError(String error);

    void goToHistory();
}
