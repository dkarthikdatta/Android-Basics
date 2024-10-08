package com.example.myapplication.machinecoding.pollingSystem.controller;

import com.example.myapplication.machinecoding.pollingSystem.dao.PollDao;
import com.example.myapplication.machinecoding.pollingSystem.dao.UserDao;
import com.example.myapplication.machinecoding.pollingSystem.dao.VoteDao;
import com.example.myapplication.machinecoding.pollingSystem.models.Poll;
import com.example.myapplication.machinecoding.pollingSystem.models.Vote;

import java.util.HashSet;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class VoteManager {
    private final VoteDao voteDao;
    private final PollDao pollDao;
    private final UserDao userDao;


    public VoteManager(VoteDao voteDao, PollDao pollDao, UserDao userDao) {
        this.voteDao = voteDao;
        this.pollDao = pollDao;
        this.userDao = userDao;
    }

    public String voteInPoll(String pollId, String userId, String option) {
        if (pollId == null || userId == null || option == null) {
            return "Enter valid input";
        }

        // if poll is not present
        if (pollDao.getPoll(pollId) == null) {
            return "Poll not found.";
        }

        // if option is not present
        if (!pollDao.getPoll(pollId).getOptions().contains(option)) {
            return "Invalid option.";
        }

        // userPresentInSystem - user voted already once. May be for this poll or other polls
        boolean userPresentInSystem = userDao.getUserVoteData().containsKey(userId);

        // check if user has voted for this poll already
        if (userPresentInSystem && userDao.getUserVoteData().get(userId).contains(pollId)) {
            return "User already casted vote for this poll";
        }

        // add the pollId wrt userId
        // get already polled ids by the user. if not new user, create new set for poll addition
        HashSet<String> polledIdsByUser = userDao.getUserVoteData().get(userId);
        if (polledIdsByUser == null) {
            polledIdsByUser = new HashSet<>();
        }
        polledIdsByUser.add(pollId);
        userDao.getUserVoteData().put(userId, polledIdsByUser); // adds/modify userId to store and adds pollId

        Vote vote = new Vote(pollId, userId, option);
        voteDao.saveVote(vote);
        return "Vote casted successfully.";
    }

    public String viewPollResults(String pollId) {
        Poll poll = pollDao.getPoll(pollId);
        if (poll == null) {
            return "Poll doesn't exits";
        }
        List<Vote> pollVotes = voteDao.getVotesByPollId(pollId);
        StringBuilder output = new StringBuilder();

        HashMap<String, Integer> results = new HashMap<>();

        for (String option : poll.getOptions()) {
            results.put(option, 0);
        }

        for (Vote vote : pollVotes) {
            results.put(vote.getOption(), results.getOrDefault(vote.getOption(), 0) + 1);
        }

        output.append("Poll id: ").append(pollId).append(" question: ").append(poll.getQuestion()).append(" results:");

        for (Map.Entry<String, Integer> entry : results.entrySet()) {
            output.append(" ").append(entry.getKey()).append(" : ").append(entry.getValue());
        }

        return output.toString();
    }

}
