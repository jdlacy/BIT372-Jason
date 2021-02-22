package com.example.unitcoverter;

import android.os.Build;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

@RequiresApi(api = Build.VERSION_CODES.R)
public class UnitViewModel extends ViewModel {

    public MutableLiveData<String> user_input = new MutableLiveData<>();

    public void setUserInput() {
        user_input.setValue(user_input.getValue());
    }
}
