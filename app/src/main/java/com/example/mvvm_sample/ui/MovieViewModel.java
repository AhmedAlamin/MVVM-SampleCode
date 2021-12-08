package com.example.mvvm_sample.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvm_sample.pojo.MovieModel;

import java.util.ArrayList;

public class MovieViewModel extends ViewModel {

    MutableLiveData<ArrayList<String>> dataMutable = new MutableLiveData<>();

    public MovieModel getMovieDataFromDatabase(){
        return new MovieModel("cast a way","very sad movie");
    }

    public void getMovieData(){
        ArrayList<String> data = new ArrayList<>();
        data.add(getMovieDataFromDatabase().getName());
        data.add(getMovieDataFromDatabase().getDescription());
        dataMutable.setValue(data);

    }

}
