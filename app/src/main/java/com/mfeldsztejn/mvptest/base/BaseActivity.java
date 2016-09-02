package com.mfeldsztejn.mvptest.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by mfeldsztejn on 9/2/16.
 */

public abstract class BaseActivity<V extends BaseView<P>, P extends BasePresenter<V>>
        extends AppCompatActivity {

    private P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.presenter = createPresenter();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onViewAttach(getView());
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.onViewDetach();
    }

    protected P getPresenter() {
        return presenter;
    }

    protected abstract P createPresenter();

    protected abstract V getView();
}
