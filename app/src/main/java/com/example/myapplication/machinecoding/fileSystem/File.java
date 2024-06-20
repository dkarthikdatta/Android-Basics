package com.example.myapplication.machinecoding.fileSystem;

public class File {

    String name;
    String data;

    public File(String name, String data) {
        this.name = name;
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
