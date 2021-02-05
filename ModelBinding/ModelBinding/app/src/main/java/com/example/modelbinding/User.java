package com.example.modelbinding;
import androidx.lifecycle.MutableLiveData;

public class User {
    public MutableLiveData<String> name;
    public String email;

    public User(String name, String email) {
        this.name = new MutableLiveData<>();
        this.name.setValue(name);
        this.email = email;
    }
}
