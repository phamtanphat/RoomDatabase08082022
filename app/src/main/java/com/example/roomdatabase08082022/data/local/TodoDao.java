package com.example.roomdatabase08082022.data.local;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.roomdatabase08082022.data.local.entity.TodoEntity;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;

/**
 * Created by pphat on 10/31/2022.
 */

@Dao
public interface TodoDao {

    @Query("SELECT * FROM todo")
    Observable<List<TodoEntity>> getTodoEntity();

    @Insert
    Completable insertTodoEntity(TodoEntity todoEntity);

    @Query("DELETE FROM todo WHERE id = :id")
    Completable deleteTodoEntity(int id);

    @Query("UPDATE todo SET title=:title WHERE id = :id")
    Completable updateTodoEntity(String title, int id);
}
