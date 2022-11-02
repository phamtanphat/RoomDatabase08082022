package com.example.roomdatabase08082022.presentation.viewmodel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.roomdatabase08082022.data.local.entity.TodoEntity;
import com.example.roomdatabase08082022.data.repository.TodoRepository;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

/**
 * Created by pphat on 11/2/2022.
 */
public class MainViewModel extends ViewModel {
    private MutableLiveData<List<TodoEntity>> listTodoLiveData = new MutableLiveData<>();
    private Context context;
    private TodoRepository todoRepository;

    public MainViewModel(Context context) {
        this.context = context;
        todoRepository = new TodoRepository(context);
    }

    public LiveData<List<TodoEntity>> getListTodoLiveData() { return listTodoLiveData; }

    public void selectAllTodoEntity() {
        todoRepository.getTodos()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<TodoEntity>>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull List<TodoEntity> todoEntities) {
                        listTodoLiveData.setValue(todoEntities);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
