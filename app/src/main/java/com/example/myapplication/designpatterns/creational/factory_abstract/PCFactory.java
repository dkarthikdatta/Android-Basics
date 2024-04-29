package com.example.myapplication.designpatterns.creational.factory_abstract;

public class PCFactory extends ComputerFactory {
    @Override
    protected Computer getAComputer(String ram, String hdd, String cpu) {
        return new PC(ram, hdd, cpu);
    }
}
