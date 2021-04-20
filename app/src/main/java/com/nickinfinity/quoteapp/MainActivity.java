package com.nickinfinity.quoteapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    // Declaration
    TextView tv;
    Button btn_next;
    Button btn_prev;
    MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Init
        mainViewModel = new ViewModelProvider(this, new MainViewModelFactory(getApplicationContext())).get(MainViewModel.class);
        tv = findViewById(R.id.tv_quote);
        btn_next = findViewById(R.id.btn_next);
        btn_prev = findViewById(R.id.btn_prev);
        setText();

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainViewModel.nextQuote();
                setText();
            }
        });

        btn_prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainViewModel.previousQuote();
                setText();
            }
        });

    }

    public void setText() {
        tv.setText(mainViewModel.getQuote().getQ());
    }
}