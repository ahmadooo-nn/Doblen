package com.mydoblen1.doblen.classes;

import androidx.annotation.NonNull;

public class ListMasterSpiner {

    private  String name;

    public ListMasterSpiner(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NonNull
    @Override
    public String toString() {
        return name;
    }
}
