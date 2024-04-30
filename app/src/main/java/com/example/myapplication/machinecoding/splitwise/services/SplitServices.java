package com.example.myapplication.machinecoding.splitwise.services;

import com.example.myapplication.machinecoding.splitwise.SplitType;
import com.example.myapplication.machinecoding.splitwise.dao.Dao;
import com.example.myapplication.machinecoding.splitwise.dao.IDao;
import com.example.myapplication.machinecoding.splitwise.models.Account;
import com.example.myapplication.machinecoding.splitwise.models.User;

import java.util.ArrayList;
import java.util.Map;

public class SplitServices {

    IDao dao;

    public SplitServices(IDao dao) {
        this.dao = dao;
    }

    public String split(double amount, int payeeUserId, ArrayList<Integer> listOfUserIdInExpense, SplitType type, ArrayList<Double> percentList, ArrayList<Double> exactSplitValues) {
//        checkAndCreateAccounts(listOfUserIdInExpense);
        String feedBack = "";
        switch (type) {
            case EQUAL:
                feedBack = splitEqually(amount, payeeUserId, listOfUserIdInExpense);
                break;
            case PERCENT:
                feedBack = splitPercentageWise(amount, payeeUserId, listOfUserIdInExpense, percentList);
                break;
            case EXACT:
                feedBack = splitExactly(amount, payeeUserId, listOfUserIdInExpense, exactSplitValues);
                break;
        }
        return feedBack;
    }

    public void createAccount(User user) {
        Account account = new Account(user);
        dao.createAccount(account.getAccountId(), account);
    }

//    private void checkAndCreateAccounts(ArrayList<Integer> listOfUserIdInExpense) {
//
//        for (int accountId : listOfUserIdInExpense) {
//            if(!dao.getAccounts().containsKey(accountId)){
//                dao.createAccount(accountId, new Account());
//            }
//        }
//    }

    private String splitExactly(double amount, int payeeUserId, ArrayList<Integer> listOfUserIdInExpense, ArrayList<Double> exactSplitValues) {
        String feedBack = "";
        Account payeeAccount = dao.getPayeeAccountDetails(payeeUserId);
        double eachAmount = amount / listOfUserIdInExpense.size();
        return feedBack;
    }

    private String splitPercentageWise(double amount, int payeeUserId, ArrayList<Integer> listOfUserIdInExpense, ArrayList<Double> percentList) {
        return "";
    }

    private String splitEqually(double amount, int payeeUserId, ArrayList<Integer> listOfUserIdInExpense) {
        String feedBack = "";
        Account payeeAccount = dao.getPayeeAccountDetails(payeeUserId);
        double eachAmount = amount / listOfUserIdInExpense.size();

        for (int accountId : listOfUserIdInExpense) {
            boolean isAnotherAccountPresent = payeeAccount.getBalances().get(accountId) != null;
            if (!isAnotherAccountPresent) {
                payeeAccount.updateBalance(accountId, 0);
            }
            double anotherPersonBalance = payeeAccount.getBalances().get(accountId);
            double net = anotherPersonBalance + eachAmount;
            payeeAccount.updateBalance(accountId, net);
        }
        feedBack = "Transaction updated successfully";
        return feedBack;
    }

    public void showOverView() {
        for (Map.Entry<Integer, Account> entry : dao.getAccounts().entrySet()) {
            Account account = entry.getValue();
            int accountId = entry.getKey();
            System.out.println("For user: " + account.getUser().getName());
            for (Map.Entry<Integer, Double> friends : account.getBalances().entrySet()) {
                Account friendAccount = dao.getAccount(friends.getKey());
                String friendName = friendAccount.getUser().getName();
                System.out.println("Balance with: " + friendName + " is: " + friends.getValue());
            }
        }
    }
}
