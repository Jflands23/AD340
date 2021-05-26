package com.example.assignment2;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.assignment2.dao.SettingDao;
import com.example.assignment2.entity.Settings;

@Database(entities = {Settings.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract SettingDao settingsDao();
}
