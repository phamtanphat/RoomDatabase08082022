package com.example.roomdatabase08082022.presentation.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.example.roomdatabase08082022.R;
import com.example.roomdatabase08082022.data.local.entity.TodoEntity;
import com.example.roomdatabase08082022.presentation.viewmodel.MainViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    MainViewModel mainViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainViewModel = new ViewModelProvider(this, new ViewModelProvider.Factory() {
            @NonNull
            @Override
            public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
                return (T) new MainViewModel(MainActivity.this);
            }
        }).get(MainViewModel.class);

        observerData();
        event();
    }

    private void event() {
        mainViewModel.selectAllTodoEntity();
        for (int i = 0; i < 10; i++) {
            mainViewModel.insertTodoEntity(new TodoEntity("Title " + i, "Description " + i));
        }
    }

    private void observerData() {
        mainViewModel.getListTodoLiveData().observe(MainActivity.this, new Observer<List<TodoEntity>>() {
            @Override
            public void onChanged(List<TodoEntity> todoEntities) {
                if (todoEntities != null){
                    for (int i = 0; i < todoEntities.size(); i++) {
                        Log.d("BBB", todoEntities.get(i).toString());
                    }

                }
            }
        });
    }
}
