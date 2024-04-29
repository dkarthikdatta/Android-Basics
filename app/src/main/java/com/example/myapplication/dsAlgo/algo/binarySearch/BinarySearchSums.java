package com.example.myapplication.dsAlgo.algo.binarySearch;

public class BinarySearchSums {

    public static void main(String[] args) {
//        int[] binarySearchArray = {4, 5, 6, 7, 8};
//        binarySearch(binarySearchArray, 7);
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        shipWithinDays(weights, 5);
    }

    private static void binarySearch(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == target) {
                System.out.println(mid);
                return;
            } else if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        System.out.println("not found");
    }


    /**
     * A conveyor belt has packages that must be shipped from one port to another within days days.
     * <p>
     * The ith package on the conveyor belt has a weight of weights[i].
     * Each day, we load the ship with packages on the conveyor belt (in the order given by weights).
     * We may not load more weight than the maximum weight capacity of the ship.
     * <p>
     * Return the least weight capacity of the ship that will result in all the packages on the conveyor
     * belt being shipped within days days.
     *
     * @param weights
     * @param days
     */
    private static void shipWithinDays(int[] weights, int days) {
        // each day only one trip, one trip may contains any weight items, within the capacity
        // ship in consecutive order only

        // min capacity is min weight and max capacity could be sum of all weights (all weights could go in 1 day)
        // need to find minimum capacity to be sent in d days

        // ans is in bw min weight and sum of all weights

        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int weight : weights) {
            min = Math.min(min, weight);
            max = max + weight;
        }

        // search for that least weight, which can carry all weights in D days

        while (min <= max) {
            int mid = (min + max) / 2;
            int daysTakenToShip = daysTakenToShip(mid, weights);
            if (daysTakenToShip <= days) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        System.out.println("Min ship capacity: " + min);
    }

    private static int daysTakenToShip(int permissibleWeight, int[] weights) {
        int days = 1;
        int currWeight = 0;
        for (int wt : weights) {
            if (wt + currWeight > permissibleWeight) {
                days++;
                currWeight = wt;
            } else {
                currWeight = currWeight + wt;
            }
        }
        return days;
    }


}
