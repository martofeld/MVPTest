package com.mfeldsztejn.mvptest.repositories;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by mfeldsztejn on 9/1/16.
 */

public class HistoryRepository {

    private SharedPreferences sharedPreferences;

    public HistoryRepository(Context context) {
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public void save(String entry) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(new Date().toString(), entry);
        editor.apply();
    }

    public List<String> getAll() {
        TreeMap<String, ?> orderedMap = new TreeMap<>(sharedPreferences.getAll());
        Map<String, ?> reverseMap = orderedMap.descendingMap();
        List<String> values = new ArrayList<>();
        for (Object o : reverseMap.values()) {
            values.add((String) o);
        }
        return values;
    }
}
