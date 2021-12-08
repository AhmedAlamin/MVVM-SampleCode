package com.example.mvvm_sample.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.mvvm_sample.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    TextView textView;
    Button button;
    MovieViewModel movieViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);

        movieViewModel = new MovieViewModel();

        movieViewModel = new ViewModelProvider(this).get(MovieViewModel.class);


      movieViewModel.dataMutable.observe(this, new Observer<ArrayList<String>>() {
            @Override
            public void onChanged(ArrayList<String> strings) {
                String s = "";
                for (String data : strings){
                    s += data;
                }
                textView.setText(s);
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                movieViewModel.getMovieData();
            }
        });
    }
}