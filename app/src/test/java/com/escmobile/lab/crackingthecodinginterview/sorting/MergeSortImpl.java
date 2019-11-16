package com.escmobile.lab.crackingthecodinginterview.sorting;

public class MergeSortImpl {

    public void mergeSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int l, int r) {

        if (l >= r) return;
        int m = (l + r) / 2;

        sort(arr, l, m);
        sort(arr, m + 1, r);

        merge(arr, l, r);
    }

    private void merge(int[] arr, int l, int r) {
        // l: 0, r: 2, m: 1
        int m = (l + r) / 2;

        // create 2 sub arrays
        int[] sub1 = new int[m - l + 1];
        int[] sub2 = new int[r - m];

        int sub1Index = 0, sub2Index = 0, arrayIndex = l;

        // populate the sub arrays
        for (int i = 0; i < sub1.length; i++)
            sub1[i] = arr[l + i];

        for (int i = 0; i < sub2.length; i++)
            sub2[i] = arr[m + 1 + i];

        // merge sub arrays into the array
        while (sub1Index < sub1.length && sub2Index < sub2.length) {

            if (sub1[sub1Index] < sub2[sub2Index]) {
                arr[arrayIndex] = sub1[sub1Index];
                sub1Index++;
            } else {
                arr[arrayIndex] = sub2[sub2Index];
                sub2Index++;
            }

            arrayIndex++;
        }

        // copy the rest of the sub arrays into arr
        while (sub1Index < sub1.length) {
            arr[arrayIndex] = sub1[sub1Index];
            arrayIndex++;
            sub1Index++;
        }

        while (sub2Index < sub2.length) {
            arr[arrayIndex] = sub2[sub2Index];
            arrayIndex++;
            sub2Index++;
        }

    }
}
