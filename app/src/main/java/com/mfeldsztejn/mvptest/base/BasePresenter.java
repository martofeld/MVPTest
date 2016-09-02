package com.mfeldsztejn.mvptest.base;

import android.support.annotation.Nullable;

/**
 * Created by mfeldsztejn on 8/27/16.
 */

public abstract class BasePresenter<V extends BaseView> {
    protected V view;

    public void onViewAttach(V view) {
        this.view = view;
    }

    public void onViewDetach() {
        this.view = null;
    }

    public boolean isViewAttached() {
        return view != null;
    }

    @Nullable
    public V getView() {
        return view;
    }
}
