package com.example.unitcoverter;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class Units {
    public MutableLiveData<String> value;

    public Units (String num) {
        this.value = new MutableLiveData<>();
        this.value.setValue(num);
    }

    public LiveData<String> getUserInput() {
        return this.value;
    }

    public LiveData<String> setValueText() {

    }
}
