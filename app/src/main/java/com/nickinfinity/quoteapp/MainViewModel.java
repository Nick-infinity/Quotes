package com.nickinfinity.quoteapp;

import android.content.Context;

import androidx.lifecycle.ViewModel;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainViewModel extends ViewModel {
    private Context context;
    ArrayList<QuotesData> quoteList;
    private int index = 0;
    private int quoteListSize;

    public MainViewModel(Context context) throws IOException {
        this.context = context;
        quoteList = loadQuotesFromAssets();
        quoteListSize = quoteList.size();

    }

    private ArrayList<QuotesData> loadQuotesFromAssets() throws IOException {

        // Read fle via inputstream and store in a byte array
        InputStream inputStream = context.getAssets().open("quotes.json");
        int size = inputStream.available();
        byte buffer[] = new byte[size];
        inputStream.read(buffer);
        inputStream.close();

        // Make a string from the byte array
        String json = new String(buffer, "UTF_8");

        // Make a gson object to parse the json
        Gson gson = new Gson();
        return gson.fromJson(json, new TypeToken<ArrayList<QuotesData>>() {
        }.getType());

    }

    public QuotesData getQuote() {
        return quoteList.get(index);
    }

    public void nextQuote() {
        index = (index + 1) % quoteListSize;

    }

    public void previousQuote() {
        index = index - 1;
        if (index == -1) {
            index = quoteListSize - 1;

        }

    }
}
