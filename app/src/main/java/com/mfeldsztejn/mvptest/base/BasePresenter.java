package com.mfeldsztejn.mvptest.base;

import android.support.annotation.Nullable;

import java.lang.ref.WeakReference;

/**
 * Created by mfeldsztejn on 8/27/16.
 */

public abstract class BasePresenter<V extends BaseView> {
    protected WeakReference<V> view;

    public void onViewAttach(V view) {
        this.view = new WeakReference<>(view);
    }

    public void onViewDetach() {
        this.view = null;
    }

    public boolean isViewAttached() {
        return view != null && view.get() != null;
    }

    @Nullable
    public V getView() {
        return view != null ? view.get() : null;
    }
}
