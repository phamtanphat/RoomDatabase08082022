package com.example.roomdatabase08082022.data.local;

import androidx.room.Dao;
import androidx.room.Query;

import com.example.roomdatabase08082022.data.local.entity.TodoEntity;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

/**
 * Created by pphat on 10/31/2022.
 */

@Dao
public interface TodoDao {

    @Query("SELECT * FROM todo")
    Observable<List<TodoEntity>> getTodoEntity();
}
