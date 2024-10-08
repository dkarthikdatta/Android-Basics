package com.example.myapplication.machinecoding.pollingSystem.dao.impl;

import com.example.myapplication.machinecoding.pollingSystem.dao.VoteDao;
import com.example.myapplication.machinecoding.pollingSystem.models.Vote;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VoteDaoInMemoryImpl implements VoteDao {
    //<pollId, List<Vote>
//    private final HashMap<String, ArrayList<Vote>> voteStore = new HashMap<>();
    private final HashMap<String, ArrayList<Vote>> voteStore;

    public VoteDaoInMemoryImpl(){
        this.voteStore = new HashMap<>();
    }

    @Override
    public synchronized void saveVote(Vote vote) {
        ArrayList<Vote> voteList = voteStore.getOrDefault(vote.getPollId(), new ArrayList<>());
        voteList.add(vote);
        voteStore.put(vote.getPollId(), voteList);
    }

    @Override
    public synchronized List<Vote> getVotesByPollId(String pollId) {
        return voteStore.getOrDefault(pollId, new ArrayList<>());
    }
}
