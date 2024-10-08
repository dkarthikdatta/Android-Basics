package com.example.myapplication.machinecoding.pollingSystem.controller;

import com.example.myapplication.machinecoding.pollingSystem.dao.PollDao;
import com.example.myapplication.machinecoding.pollingSystem.models.Poll;
import com.example.myapplication.machinecoding.pollingSystem.util.Utility;

import java.util.ArrayList;

public class PollManager {

    private final PollDao pollDAO;

    public PollManager(PollDao pollDAO) {
        this.pollDAO = pollDAO;
    }

    public String createPoll(String question, ArrayList<String> options) {
        if(question == null || options == null){
            return "Enter valid question and valid options";
        }
        Poll poll = new Poll(Utility.generateUniqueId(), question, options);
        String pollId = pollDAO.createPoll(poll);
        return "Poll created Successfully with poll id: " + pollId;
    }

    public String updatePoll(String pollId, String question, ArrayList<String> options) {
        Poll poll = pollDAO.getPoll(pollId);
        if (poll == null) {
            return "Poll not found.";
        }
        poll.setQuestion(question);
        poll.setOptions(options);
        return pollDAO.updatePoll(poll);
    }

    public String deletePoll(String pollId) {
        return pollDAO.deletePoll(pollId);
    }
}
