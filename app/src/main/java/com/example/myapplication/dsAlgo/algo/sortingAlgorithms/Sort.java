package com.example.myapplication.dsAlgo.algo.sortingAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;

public class Sort {


    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 5, 1, 2, 7, 8};

        // divide into two halves recursively until each array size is 1. merge consecutive arrays using 2 pointers
        //tc - nlogn, sc - o(n)
        mergeSort(arr, 0, arr.length - 1);
//        System.out.println(Arrays.toString(arr));
//
        // select min element from 0 to n-1, and swap with zero index
        // select min element from 1` to n-1, nd swap with first index .. continue
        // tc - n^2
        // sc - o(1)
        selectionSort(arr);
//        System.out.println(Arrays.toString(arr));

        // swap adjacent pairs.
        // if left is > right, swap -> 1st max element is right most - sorted
        // do swap for entire array again -> 2nd max element correct place - last 2 indexes sorted
        // tc - n^2 - worst and avg case. o(n) at best case when the array is already sorted by keeping check in any swap happened in first iteration for o(n), else breaks at further point when no further sorting is req
        // sc - 0(1)
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int target) {
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < arr.length - 3; i++) {
            for (int j = i + 1; j < arr.length - 2; j++) {
                int k = j + 1;
                int l = arr.length-1;
                while (k < l) {
                    int sum = arr[i] + arr[j] + arr[k] + arr[l];
                    if (sum == target) {
                        ans.add(new ArrayList<>(Arrays.asList(arr[i],arr[j], arr[k],arr[l])));
                        break;
                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }
                }
            }
        }
        return ans;

    }

    // dividing require log(n) time complexity
    static void mergeSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    // time complexity is near to n
    private static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int left = low;
        int right = mid + 1;
        int i = 0;
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[i] = arr[left];
                left++;
            } else {
                temp[i] = arr[right];
                right++;
            }
            i++;
        }
        while (left <= mid) {
            temp[i] = arr[left];
            left++;
            i++;
        }
        while (right <= high) {
            temp[i] = arr[right];
            right++;
            i++;
        }
        for (int index = low; index <= high; index++) {
            arr[index] = temp[index - low];
        }
    }


    static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] <= min) {
                    min = arr[j];
                    index = j;
                }
            }
            int temp = arr[i];
            arr[i] = min;
            arr[index] = temp;
        }
    }


    private static void bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            boolean swapHappened = false;
            for (int j = 0; j <= i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    swapHappened = true;
                }
            }
            if (!swapHappened) {
                break;
            }
        }
    }

}
