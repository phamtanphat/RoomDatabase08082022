package com.example.roomdatabase08082022.data.local;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.example.roomdatabase08082022.data.local.entity.TodoEntity;

/**
 * Created by pphat on 10/31/2022.
 */

@Database(entities = TodoEntity.class, version = 1)
public abstract class TodoDatabase extends RoomDatabase {
    private static TodoDatabase instance = null;
    public abstract TodoDao getTodoDao();

    public synchronized static TodoDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                    context,
                    TodoDatabase.class,
                    "todo-database"
            ).build();
        }
        return instance;
    }
}
