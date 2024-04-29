package com.example.myapplication.designpatterns.creational.factory_abstract;

public class ServerFactory extends ComputerFactory {
    @Override
    protected Computer getAComputer(String ram, String hdd, String cpu) {
        return new Server(ram, hdd, cpu);
    }
}
