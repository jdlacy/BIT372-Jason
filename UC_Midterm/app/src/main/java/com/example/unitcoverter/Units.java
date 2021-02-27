package com.example.unitcoverter;

import androidx.lifecycle.MutableLiveData;

public class Units {
    private MutableLiveData<String> unit;

    public Units (String num) {
        this.unit = new MutableLiveData<>();
        this.unit.setValue(num);
    }

    public String getValue() {
        return unit.getValue();
    }
}
