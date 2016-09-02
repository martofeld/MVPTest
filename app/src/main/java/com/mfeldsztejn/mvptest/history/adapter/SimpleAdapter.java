package com.mfeldsztejn.mvptest.history.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.mfeldsztejn.mvptest.R;

import java.util.List;

/**
 * Created by mfeldsztejn on 8/28/16.
 */

public class SimpleAdapter extends RecyclerView.Adapter<SimpleViewHolder> {

    private List<String> items;

    public SimpleAdapter(List<String> info) {
        this.items = info;
    }

    @Override
    public SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new SimpleViewHolder(inflater.inflate(R.layout.simple_text_item, parent, false));
    }

    @Override
    public void onBindViewHolder(SimpleViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
