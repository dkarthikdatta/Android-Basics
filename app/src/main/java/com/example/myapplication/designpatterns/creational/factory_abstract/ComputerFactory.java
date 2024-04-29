package com.example.myapplication.designpatterns.creational.factory_abstract;

public abstract class ComputerFactory {

    public Computer getComputer(String ram, String hdd, String cpu) {

        Computer computer = getAComputer(ram, hdd, cpu);

        return computer;
    }

    protected abstract Computer getAComputer(String ram, String hdd, String cpu);
}
