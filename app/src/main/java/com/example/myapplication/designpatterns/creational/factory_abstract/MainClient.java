package com.example.myapplication.designpatterns.creational.factory_abstract;

public class MainClient {

    public static void main(String[] args) {

        String requiredComputer = "pc";
        ComputerFactory computerFactory = null;

        if(requiredComputer == "pc"){
            computerFactory = new PCFactory();
        } else {
            computerFactory = new ServerFactory();
        }

        Computer computerReceived = computerFactory.getComputer("16 GB","1 TB","2.9 GHz");
        System.out.println("Config::"+ computerReceived.toString());
    }
}