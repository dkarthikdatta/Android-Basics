package com.example.myapplication.machinecoding.pollingSystem.models;

import java.util.ArrayList;
import java.util.Date;

public class Poll {
    private String pollId;
    private String question;
    private ArrayList<String> options;
    private final long timeStamp;

    public Poll(String pollId, String question, ArrayList<String> options) {
        this.pollId = pollId;
        this.question = question;
        this.options = options;
        this.timeStamp = System.currentTimeMillis();
    }


    public String getPollId() {
        return pollId;
    }

    public void setPollId(String pollId) {
        this.pollId = pollId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<String> options) {
        this.options = options;
    }

    public long getTimeStamp() {
        return timeStamp;
    }
}
