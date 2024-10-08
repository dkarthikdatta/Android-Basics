package com.example.myapplication.machinecoding.pollingSystem.dao.impl;

import com.example.myapplication.machinecoding.pollingSystem.dao.PollDao;
import com.example.myapplication.machinecoding.pollingSystem.models.Poll;

import java.util.ArrayList;
import java.util.HashMap;

public class PollDaoInMemoryImpl implements PollDao {
    //    private final HashMap<String, Poll> pollStore = new HashMap<>();
    private final HashMap<String, Poll> pollStore;

    public PollDaoInMemoryImpl() {
        this.pollStore = new HashMap<>();
    }

    @Override
    public synchronized String createPoll(Poll poll) {
        String pollId = poll.getPollId();
        pollStore.put(pollId, poll);
        return pollId;
    }

    @Override
    public synchronized Poll getPoll(String pollId) {
        return pollStore.get(pollId);
    }

    @Override
    public synchronized String updatePoll(Poll poll) {
        String pollId = poll.getPollId();
        if (pollStore.containsKey(pollId)) {
            pollStore.put(pollId, poll);
            return "Poll updated successfully.";
        }
        return "Poll not found.";
    }

    @Override
    public synchronized String deletePoll(String pollId) {
        return pollStore.remove(pollId) != null ? "Poll deleted successfully." : "Poll not found.";
    }

    @Override
    public ArrayList<Poll> getAllPolls() {
        //todo
        return null;
    }
}
