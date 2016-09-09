package com.mfeldsztejn.mvptest.history;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.mfeldsztejn.mvptest.R;
import com.mfeldsztejn.mvptest.base.BaseActivity;
import com.mfeldsztejn.mvptest.history.adapter.SimpleAdapter;
import com.mfeldsztejn.mvptest.repositories.HistoryRepository;

import java.util.List;

public class HistoryActivity extends BaseActivity<HistoryView, HistoryPresenter> implements HistoryView {

    private RecyclerView recyclerView;

    public static void start(Context context) {
        context.startActivity(new Intent(context, HistoryActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        recyclerView = (RecyclerView) findViewById(R.id.history_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public HistoryPresenter createPresenter() {
        return new HistoryPresenter(new HistoryRepository(this));
    }

    @Override
    protected HistoryView getView() {
        return this;
    }

    @Override
    public void setHistoryResults(List<String> results) {
        recyclerView.setAdapter(new SimpleAdapter(results));
    }
}
