package com.example.myapplication.machinecoding.wallet.java;

import com.example.myapplication.machinecoding.wallet.java.dao.IWalletDao;
import com.example.myapplication.machinecoding.wallet.java.dao.WalletDao;
import com.example.myapplication.machinecoding.wallet.java.services.WalletService;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static WalletService walletService;

    public static void main(String[] args) {
        IWalletDao walletDao = new WalletDao();
        walletService = new WalletService(walletDao);
        int input = 0;
        while (input != 5) {
            showOptions();
            input = scanner.nextInt();
            validateAndRun(input);
        }

        System.out.println("Exited from System");
    }

    private static void validateAndRun(int input) {
        switch (input) {
            case 1:
                createWalletInput();
                break;
            case 2:
                transferAmountInput();
                break;
            case 3:
                statementInput();
                break;
            case 4:
                walletService.overviewInput();
                break;
        }
    }


    private static void statementInput() {
        System.out.println("YOU SELECTED ACCOUNT STATEMENT");
        System.out.println("Enter account num");
        int accountNumber = scanner.nextInt();
        walletService.getStatement(accountNumber);
    }


    private static void transferAmountInput() {
        System.out.println("YOU SELECTED TRANSFER");
        System.out.println("Enter SENDER account number");
        int senderId = scanner.nextInt();
        System.out.println("Enter RECEIVER account number");
        int receiverId = scanner.nextInt();
        System.out.println("Enter amount");
        double amount = scanner.nextDouble();
        walletService.transact(senderId, receiverId, amount);
    }


    private static void createWalletInput() {
        System.out.println("YOU SELECTED CREATE WALLET");
        System.out.println("Enter name");
        String name = scanner.next();
        System.out.println("Enter amount");
        double amount = scanner.nextDouble();
        walletService.createWallet(name, amount);
    }


    private static void showOptions() {
        System.out.println("Select anyone");
        System.out.println("1. Create wallet\n" +
                "2. Transfer Amount\n" +
                "3. Account Statement\n" +
                "4. Overview\n" +
                "5. Exit");
    }
}
