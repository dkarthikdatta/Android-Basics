package com.example.myapplication.machinecoding.pollingSystem.dao;

import com.example.myapplication.machinecoding.pollingSystem.models.Poll;

import java.util.ArrayList;

public interface PollDao {
    String createPoll(Poll poll);

    Poll getPoll(String pollId);

    String updatePoll(Poll poll);

    String deletePoll(String pollId);

    ArrayList<Poll> getAllPolls();
}
