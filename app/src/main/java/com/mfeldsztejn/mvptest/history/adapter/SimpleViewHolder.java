package com.mfeldsztejn.mvptest.history.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.mfeldsztejn.mvptest.R;

/**
 * Created by mfeldsztejn on 8/28/16.
 */

public class SimpleViewHolder extends RecyclerView.ViewHolder {
    TextView textView;

    public SimpleViewHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.simple_item_text_view);
    }

    public void bind(String item) {
        textView.setText(item);
    }
}
