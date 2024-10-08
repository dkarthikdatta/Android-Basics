package com.example.myapplication.machinecoding.pollingSystem.models;

public class Vote {
    private String pollId;
    private String userId;
    private String option;
    private final long timeStamp;

    public Vote(String pollId, String userId, String option) {
        this.pollId = pollId;
        this.userId = userId;
        this.option = option;
        this.timeStamp = System.currentTimeMillis();
    }

    public String getPollId() {
        return pollId;
    }

    public void setPollId(String pollId) {
        this.pollId = pollId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

}
