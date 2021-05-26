package com.example.assignment2.viewmodels;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.assignment2.AppDatabase;
import com.example.assignment2.AppDatabaseSingleton;
import com.example.assignment2.entity.Settings;

import java.util.List;


public class SettingsViewModel extends ViewModel {

    public LiveData<List<Settings>> loadSettings(Context context) {
        AppDatabase db = AppDatabaseSingleton.getDatabase(context);
        return db.settingsDao().getSettings();
    }

    public void saveSettings(Context context, Settings... settings) {
        AppDatabase db = AppDatabaseSingleton.getDatabase(context);
        db.getTransactionExecutor().execute(() -> {
            db.settingsDao().saveSettings(settings);
        });
    }

    public void nukeAll(Context context) {
        AppDatabase db = AppDatabaseSingleton.getDatabase(context);
        db.getTransactionExecutor().execute(() -> {
            db.clearAllTables();
        });
    }

}
