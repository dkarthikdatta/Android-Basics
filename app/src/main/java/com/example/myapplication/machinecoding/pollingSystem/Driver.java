package com.example.myapplication.machinecoding.pollingSystem;

import com.example.myapplication.machinecoding.pollingSystem.controller.PollManager;
import com.example.myapplication.machinecoding.pollingSystem.controller.VoteManager;
import com.example.myapplication.machinecoding.pollingSystem.dao.PollDao;
import com.example.myapplication.machinecoding.pollingSystem.dao.impl.PollDaoInMemoryImpl;
import com.example.myapplication.machinecoding.pollingSystem.dao.UserDao;
import com.example.myapplication.machinecoding.pollingSystem.dao.impl.UserDaoImMemoryImpl;
import com.example.myapplication.machinecoding.pollingSystem.dao.VoteDao;
import com.example.myapplication.machinecoding.pollingSystem.dao.impl.VoteDaoInMemoryImpl;

import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        scanner.useDelimiter("\\n");
        PollDao pollDao = new PollDaoInMemoryImpl();
        VoteDao voteDao = new VoteDaoInMemoryImpl();
        UserDao userDao = new UserDaoImMemoryImpl();

        PollManager pollManager = new PollManager(pollDao);
        VoteManager voteManager = new VoteManager(voteDao, pollDao, userDao);

        int input = 0;
        while (input != 6) {
            showOptions();
            input = scanner.nextInt();
            validateAndRun(input, pollManager, voteManager);
        }
        scanner.close();
    }

    private static void validateAndRun(int input, PollManager pollManager, VoteManager voteManager) {
        switch (input) {
            case 1:
                createPoll(pollManager);
                break;
            case 2:
                updatePoll(pollManager);
                break;
            case 3:
                deletePoll(pollManager);
                break;
            case 4:
                voteInPoll(voteManager);
                break;
            case 5:
                viewResults(voteManager);
                break;
        }
    }

    private static void viewResults(VoteManager voteManager) {
        System.out.println("Enter poll id");
        String pollId = scanner.next();

        String output = voteManager.viewPollResults(pollId);
        System.out.println(output);
    }

    private static void voteInPoll(VoteManager voteManager) {
        System.out.println("Enter poll id");
        String pollId = scanner.next();

        System.out.println("Enter user id");
        String userId = scanner.next();

        System.out.println("Enter option");
        String option = scanner.next();

        String output = voteManager.voteInPoll(pollId, userId, option);
        System.out.println(output);
    }

    private static void deletePoll(PollManager pollManager) {
        System.out.println("Enter poll id");
        String pollId = scanner.next();
        String output = pollManager.deletePoll(pollId);
        System.out.println(output);
    }

    private static void updatePoll(PollManager pollManager) {
        System.out.println("Enter poll id");
        String pollId = scanner.next();

        System.out.println("Enter question");
        String question = scanner.next();
        System.out.println("Enter no of options");
        int noOfOptions = scanner.nextInt();
        System.out.println("Enter options");
        ArrayList<String> options = new ArrayList<>();
        for (int i = 0; i < noOfOptions; i++) {
            String option = scanner.next();
            options.add(option);
        }

        String output = pollManager.updatePoll(pollId, question, options);
        System.out.println(output);
    }

    private static void createPoll(PollManager pollManager) {
        System.out.println("Enter question");
        String question = scanner.next();
        System.out.println("Enter no of options");
        int noOfOptions = scanner.nextInt();
        System.out.println("Enter options");
        ArrayList<String> options = new ArrayList<>();
        for (int i = 0; i < noOfOptions; i++) {
            String option = scanner.next();
            options.add(option);
        }
        String output = pollManager.createPoll(question, options);
        System.out.println(output);
    }

    private static void showOptions() {
        System.out.println("1. Create Poll");
        System.out.println("2. Update Poll");
        System.out.println("3. Delete Poll");
        System.out.println("4. Vote In Poll");
        System.out.println("5. View Poll Results");
        System.out.print("Choose an option: ");
    }
}


/**
 * Online Polling System
 * Problem Statement
 * You are required to design and implement an online polling system. The system should allow users to create, manage, and participate in polls. Each poll consists of a question and multiple options for answers. Users can vote on polls and view the results.
 * Requirements
 * 1. Create Polls:
 * - Users should be able to create a new poll with a question and multiple answer options.
 * - Each poll must have a unique identifier, a question, a list of options, and a timestamp of creation.
 * <p>
 * <p>
 * 2. Manage Polls:
 * - Users should be able to update the questions or options of an existing poll.
 * - Users should be able to delete a poll.
 * <p>
 * <p>
 * 3. Vote in Polls:
 * - Users should be able to cast a vote for one of the options in a poll.
 * - Each user can only vote once per poll.
 * <p>
 * <p>
 * 4. View Poll Results:
 * <p>
 * - Users should be able to view the current results of a poll, including the number of votes for each option.
 * <p>
 * <p>
 * 5. Poll Data:
 * - Store polls, options, and votes in a way that allows efficient retrieval and updates.
 * - Ensure data integrity and consistency, especially when multiple users are voting simultaneously.
 * <p>
 * <p>
 * Implementation Details
 * - Functions/Methods:
 * 1. createPoll:
 * - Input: question (string), options (array of strings)
 * - Output: pollId (string), message (string)
 * - Example: createPoll("What is your favorite color?", ["Red", "Blue", "Green", "Yellow"]) returns {"pollId": "123", "message": "Poll created successfully."}
 * <p>
 * 2. updatePoll:
 * - Input: pollId (string), question (string), options (array of strings)
 * - Output: message (string)
 * - Example: updatePoll("123", "Updated question?", ["Option1", "Option2"]) returns {"message": "Poll updated successfully."}
 * 3. deletePoll:
 * - Input: pollId (string)
 * - Output: message (string)
 * - Example: deletePoll("123") returns {"message": "Poll deleted successfully."}
 * 4. voteInPoll:
 * - Input: pollId (string), userId (string), option (string)
 * - Output: message (string)
 * - Example: voteInPoll("123", "user1", "Option1") returns {"message": "Vote cast successfully."}
 * 5. viewPollResults:
 * - Input: pollId (string)
 * - Output: pollId (string), question (string), results (object with option keys and vote count values)
 * - Example: viewPollResults("123") returns {"pollId": "123", "question": "What is your favorite color?", "results": {"Red": 10, "Blue": 5, "Green": 3, "Yellow": 2}}
 * <p>
 * <p>
 * Data Models
 * Poll: { "pollId": "123", "question": "What is your favorite color?", "options": ["Red", "Blue", "Green", "Yellow"], "createdAt": "2024-07-11T00:00:00Z" }
 * Vote: { "pollId": "123", "userId": "user1", "option": "Red", "timestamp": "2024-07-11T01:00:00Z" }
 * <p>
 * <p>
 * Expectations
 * Make sure that you have a working and demonstrable code
 * Make sure that the code is functionally correct
 * Code should be modular and readable
 * Separation of concern should be addressed
 * Please do not write everything in a single file
 * Code should easily accommodate new requirements and minimal changes
 * There should be a main method from where the code could be easily testable
 * [Optional] Write unit tests, if possible
 * No need to create a GUI
 * Handling concurrency and consistency [BONUS]
 * <p>
 * <p>
 * <p>
 * Evaluation Criteria
 * - Correctness and completeness of the implemented functionalities.
 * - Code quality, readability, and maintainability.
 * - Efficient handling of data and concurrency(optional)
 * - Proper error handling and validation.
 * - Use of appropriate data structures and algorithms.
 */