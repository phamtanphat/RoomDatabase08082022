package com.example.roomdatabase08082022.data.local.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 * Created by pphat on 10/31/2022.
 */

@Entity(tableName = "todo")
public class TodoEntity {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;
    private String description;

    public TodoEntity(String title, String description) {
        this.title = title;
        this.description = description;
    }

    @Ignore
    public TodoEntity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "TodoEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
