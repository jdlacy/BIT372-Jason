package com.example.unitcoverter;

import androidx.lifecycle.MutableLiveData;

public class Units {
    private MutableLiveData<String> value;

    public Units (String num) {
        this.value = new MutableLiveData<>();
        this.value.setValue(num);
    }

    public String getValue() {
        return value.getValue();
    }
}
