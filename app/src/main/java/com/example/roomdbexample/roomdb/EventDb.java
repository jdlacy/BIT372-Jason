package com.example.roomdbexample.roomdb;

import androidx.lifecycle.Lifecycle;
import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.roomdbexample.roomdb.EventDao;

@Database(entities = {Event.class}, version = 1, exportSchema = false)
public abstract class EventDb extends RoomDatabase {
    public final static String DATABASE_NAME = "EventsRoomDb";
    public abstract EventDao eventDao();
}

