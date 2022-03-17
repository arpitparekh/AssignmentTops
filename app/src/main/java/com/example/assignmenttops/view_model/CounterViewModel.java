package com.example.assignmenttops.view_model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CounterViewModel extends ViewModel {

    public LiveData<Integer> getCounter() {
        if(counter==null){
            counter=new MutableLiveData<>();
            counter.setValue(1);
        }
        return counter;
    }

    public void setCounter() {
        counter.setValue(counter.getValue()+1);
    }

    private MutableLiveData<Integer> counter;



    
}
