package com.example.myapplication;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.example.myapplication.dsAlgo.Utility;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


class Pair {
    char c;
    int a;

    public Pair(char c, int a) {
        this.c = c;
        this.a = a;
    }
}


public class Rough {
    public static void main(String[] args) {

//        String s1 = new String("kar");
//        String s2 = new String("kar");
//        String s3 = "kar";
//        String s4 = "kar";
//        System.out.println(s1 == s2);
//        System.out.println(s1.equals(s2));
//        System.out.println(s3 == s4);
//        s4 = "kart";
//        System.out.println(s3);
//        System.out.println(s4);

//        Solution solution = new Solution();
//        List<Integer> ans = solution.survivedRobotsHealths(new int[]{3, 5, 2, 6}, new int[]{10, 10, 15, 12}, "RLRL");
//        List<Integer> ans2 = solution.survivedRobotsHealths(new int[]{1,2,5,6}, new int[]{10,10,11,11}, "RLRL");
//        Utility.printArrayList((ArrayList<Integer>) ans, "");
//        Utility.printArrayList((ArrayList<Integer>) ans2, "");

//        System.out.println(backspaceCompare("xywrrmp", "xywrrmu#p"));
//        System.out.println(consecutiveNumbersSum(9548114));

        boolean has = haveConflict(new String[]{"01:00", "02:00"}, new String[]{"01:20", "03:00"});
        System.out.println(has);
    }


    public static boolean haveConflict(String[] event1, String[] event2) {
        List<Event> events = new ArrayList<>();
        events.add(new Event(Integer.parseInt(event1[0].replace(":", "")), 0));
        events.add(new Event((Integer.parseInt(event1[1].replace(":", "")) + 1), 1));
        events.add(new Event(Integer.parseInt(event2[0].replace(":", "")), 0));
        events.add(new Event((Integer.parseInt(event2[1].replace(":", "")) + 1), 1));

        Collections.sort(events, (Event a, Event b) -> a.time == b.time ? a.type - b.type : a.time - b.time);
        int overLap = 0;
        int maxOverLap = Integer.MIN_VALUE;
        for (Event event : events) {
            System.out.println(event.toString());
            if (event.type == 0) {
                overLap++;
                maxOverLap = Math.max(maxOverLap, overLap);
            } else {
                overLap--;
            }
        }

        return maxOverLap > 1;
    }

    public void printAllViews(View view) {
        Queue<View> queue = new LinkedList<>();

        System.out.println(view.getClass().getSimpleName());

        if (view instanceof ViewGroup) {
            queue.add(view);
            while (queue.size() != 0) {
                View v = queue.poll();
                int count = ((ViewGroup) v).getChildCount();
                for(int i=0; i<count; i++){
                    View child = ((ViewGroup) v).getChildAt(i);
                    System.out.println(child.getClass().getSimpleName());
                    if(child instanceof ViewGroup){
                        queue.add(child);
                    }
                }
            }
        }
    }

    public static boolean backspaceCompare(String s, String t) {
        int b1 = 0;
        int b2 = 0;
        int index1 = s.length() - 1;
        int index2 = t.length() - 1;

        while (index1 >= 0 && index2 >= 0) {
            char c1 = s.charAt(index1);
            char c2 = t.charAt(index2);
            if (c1 == '#' && c1 == c2) {
                b1++;
                b2++;
                index1--;
                index2--;
                continue;
            }
            if (c1 == c2) {
                index1--;
                index2--;
                continue;
            }
            if (c1 == '#') {
                b1++;
                index1--;
                if (b2 > 0) {
                    b2--;
                    index2--;
                } else {
                    return false;
                }
            }
            if (c2 == '#') {
                b2++;
                index2--;
                if (b1 > 0) {
                    b1--;
                    index1--;
                } else {
                    return false;
                }
            }
            if (c1 != c2) {
                if (b1 > 0 && b2 > 0) {
                    b1--;
                    b2--;
                    index1--;
                    index2--;
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static int consecutiveNumbersSum(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }

        int head = (n / 2) + 1;
        int ans = 1;

        while (head >= 1) {
            int curr = head;
            int sum = 0;
            while (sum < n) {
                sum = sum + curr;
                curr--;
            }
            if (sum == n) {
                ans++;
            }
            head--;
        }
        return ans;
    }
}

class Event {
    int time;
    int type;

    public Event(int time, int type) {
        this.time = time;
        this.type = type;
    }

    @NonNull
    @Override
    public String toString() {
        return "time" + time + " type = " + type;
    }
}


class Solution {

    public int consecutiveNumbersSum(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }

        int half = (n / 2) + 1;
        int head = half;
        int ans = 1;

        while (head >= 1) {
            int curr = head;
            int sum = 0;
            while (sum < n) {
                sum = sum + curr;
                curr--;
            }
            if (sum == n) {
                ans++;
            }
            head--;
        }
        return ans;
    }

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {

        boolean move = true;
        // HashSet<Pair> hs = new HashSet<>();

        boolean same = true;
        for (int i = 1; i < directions.length(); i++) {
            if (directions.charAt(i - 1) != directions.charAt(i)) {
                same = false;
                break;
            }
        }
        if (same) {
            return new ArrayList<Integer>();
        }


        HashMap<Integer, Integer> hm = new HashMap<>();

        while (move) {
            for (int i = 0; i < positions.length; i++) {
                if (directions.charAt(i) == 'R' && positions[i] != -1) {
//                    checkHashMapAndRemove(hm, positions, i, healths);
                    positions[i] = positions[i] + 1;
                    checkHashMapAndRemove(hm, positions, i, healths);
                } else if (directions.charAt(i) == 'L' && positions[i] != -1) {
                    //                   checkHashMapAndRemove(hm, positions, i, healths);
                    positions[i] = positions[i] - 1;
                    checkHashMapAndRemove(hm, positions, i, healths);
                }
            }
            move = checkForSameDirection(healths, directions);
        }

        ArrayList<Integer> ans = new ArrayList<Integer>();

        for (int i = 0; i < healths.length; i++) {
            if (healths[i] != 0) {
                ans.add(healths[i]);
            }
        }
        return ans;
    }

    private boolean checkForSameDirection(int[] healths, String directions) {
        char c = ' ';

        for (int i = 0; i < healths.length; i++) {
            if (healths[i] != 0 && c == ' ') {
                c = directions.charAt(i);
                break;
            }
        }

        for (int i = 0; i < healths.length; i++) {
            if (healths[i] != 0 && c != directions.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    private void checkHashMapAndRemove(HashMap<Integer, Integer> hm, int[] positions, int index, int[] healths) {
        if (hm.containsKey(positions[index])) {
            int existingIndex = hm.get(positions[index]);
            if (healths[existingIndex] == healths[index]) {
                healths[existingIndex] = 0;
                healths[index] = 0;
                hm.remove(positions[index]);
                positions[existingIndex] = -1;
                positions[index] = -1;
            } else if (healths[existingIndex] < healths[index]) {
                hm.put(positions[index], index);
                healths[existingIndex] = 0;
                healths[index] = healths[index] - 1;
                positions[existingIndex] = -1;
            } else {
                hm.put(positions[existingIndex], existingIndex);
                healths[index] = 0;
                healths[existingIndex] = healths[existingIndex] - 1;
                positions[index] = -1;
            }
        } else {
            hm.put(positions[index], index);
        }
    }
}