package com.nickinfinity.quoteapp;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import java.io.IOException;

public class MainViewModelFactory implements ViewModelProvider.Factory {

    private Context context;

    public MainViewModelFactory(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        try {
            return (T) new MainViewModel(context);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
