package com.example.myapplication.machinecoding.inMemoryKeyValue;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Dao dao = new Dao();
    static Services services = new Services(dao);

    //put sde_bootcamp title SDE-Bootcamp price 30000.00 enrolled false estimated_time 30
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useDelimiter("\\n");;
        while (true) {
            String input = scanner.next();
//            System.out.println("input = " + input );
            String[] inputArray = input.split("\\s+");
            String type = inputArray[0];

//            System.out.println("inputArray = " + inputArray[3]);
            String outputString = "";
            switch (type) {
                case "put":
                    outputString = services.put(inputArray);
                    break;
                case "get":
                    outputString = services.get(inputArray);
                    break;
            }
            System.out.println(outputString);
        }
    }
}
