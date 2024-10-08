package com.example.myapplication.machinecoding.pollingSystem.dao;

import com.example.myapplication.machinecoding.pollingSystem.models.Vote;

import java.util.List;

public interface VoteDao {
    void saveVote(Vote vote);
    List<Vote> getVotesByPollId(String pollId);
}
