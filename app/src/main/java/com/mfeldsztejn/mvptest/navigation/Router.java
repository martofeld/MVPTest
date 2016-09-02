package com.mfeldsztejn.mvptest.navigation;

import android.content.Context;
import android.content.Intent;

import com.mfeldsztejn.mvptest.history.HistoryActivity;

/**
 * Created by mfeldsztejn on 9/1/16.
 */

public class Router {
    private Context context;

    public Router(Context context) {
        this.context = context;
    }

    public void goToHistory() {
        context.startActivity(new Intent(context, HistoryActivity.class));
    }
}
