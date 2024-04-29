package com.example.myapplication.dsAlgo.ds.Arrays;

import com.example.myapplication.dsAlgo.Utility;

import java.util.Arrays;

public class ArraySums {
    public static void main(String[] args) {
        int[] sort012Array = {0, 2, 2, 1, 1, 0, 1, 0, 2};
//        sort012(sort012Array, 9);

        int[] binaryEven = {10, 11, 12, 14, 16, 17, 18, 22, 25, 26}; //even
        int[] binaryOdd = {10, 11, 12, 14, 16, 17, 18, 22, 25, 26, 28}; //odd

//        binarySearch(binaryEven, 14);
//        binarySearch(binaryOdd, 17);

//        int[] maxSubArray = {1, 2, 3, -2, 5};
//        maxSubArraySum(maxSubArray);

        long[] mergeSortedArr1 = {13, 17, 18, 19, 20, 22, 22, 27, 36, 39, 46, 48, 50};
        long[] mergeSortedArr2 = {4, 12 ,45};
        mergeWithoutExtraSpace(mergeSortedArr1, mergeSortedArr2);
    }


    /**
     * for binary search, array should be sorted
     *
     * @param arr
     * @param target
     */
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

    private static void sort012(int a[], int n) {
        int low = 0;
        int mid = 0;
        int high = n - 1;
        while (mid <= high) {
            if (a[mid] == 0) {
                int temp = a[low];
                a[low] = a[mid];
                a[mid] = temp;
                low++;
                mid++;
            } else if (a[mid] == 1) {
                mid++;
            } else {
                int temp2 = a[high];
                a[high] = a[mid];
                a[mid] = temp2;
                high--;
            }
        }
        Utility.printArray(a);
    }

    private static void maxSubArraySum(int arr[]) {
        int currMax = arr[0];
        int globalMax = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currMax = Math.max((currMax + arr[i]), arr[i]);    // accounting either if current is max or (currMax + arr[i]) is max (if there is negative in prev summation)
            globalMax = Math.max(globalMax, currMax);
        }
        System.out.println(globalMax);
    }

    private static void mergeWithoutExtraSpace(long arr1[], long arr2[]) {
        // arr1 and arr2 are sorted; sort overall in place arr1 and arr2. arr1 contains all small integers
        //n = 4, arr1[] = [1 3 5 7]
        //m = 5, arr2[] = [0 2 6 8 9]

        int pr2 = arr2.length - 1;
        int pl2 = 0;
        int pr1 = arr1.length - 1;

        while (pr2 >= 0 && pr1 >= 0) {
            if (arr2[pr2] > arr1[pr1]) {
                pr2--;
            } else if (arr2[pr2] <= arr1[pr1] && pl2 <= pr2) {
                long temp = arr1[pr1];
                arr1[pr1] = arr2[pl2];
                arr2[pl2] = temp;
                pl2++;
                pr1--;
            }
        }
        Utility.printLongArray(arr1);
        Utility.printLongArray(arr2);

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        Utility.printLongArray(arr1);
        Utility.printLongArray(arr2);
    }
}
