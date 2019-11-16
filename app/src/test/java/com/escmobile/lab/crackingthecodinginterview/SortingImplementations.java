package com.escmobile.lab.crackingthecodinginterview;

import com.escmobile.lab.crackingthecodinginterview.sorting.InsertionSort;
import com.escmobile.lab.crackingthecodinginterview.sorting.MergeSortImpl;
import com.escmobile.lab.crackingthecodinginterview.sorting.QuickSortImpl;

import org.junit.Test;

public class SortingImplementations {

    private int[] arr = {2, 5, 7, 45, 90, 12, 15, 0, 19, 28, 1};

    @Test
    public void selectionSort() {

        for (int i = 0; i < arr.length; i++) {

            for (int j = i; j < arr.length; j++) {

                if (arr[i] < arr[j]) {    // swap
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }

        assert (arr[0] == 0);
        assert (arr[arr.length - 1] == 90);
    }

    @Test
    public void bubbleSort() {

        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr.length - 1; j++) {

                if (arr[j] < arr[j + 1]) {    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        assert (arr[0] == 0);
        assert (arr[arr.length - 1] == 90);
    }

    @Test
    public void insertionSort() {
        int[] insertionArr = {10, 4, 1, 19, 0};

        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(insertionArr);
    }

    @Test
    public void quickSortImpl() {
        int[] mergeArr = {10, 4, 1, 19, 0};

        QuickSortImpl qs = new QuickSortImpl();
        qs.quickSort(mergeArr);
    }

    @Test
    public void mergeSortImpl() {
        int[] mergeArr = {10, 4, 1, 19, 0};

        MergeSortImpl mergeSort = new MergeSortImpl();
        mergeSort.mergeSort(mergeArr);
    }

    private void mergeSort(int[] arr, int l, int r) {

        if (l >= r) return;

        int m = (l + r) / 2;

        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);

        merge(arr, l, r);
    }

    private void merge(int[] arr, int l, int r) {

        int m = (l + r) / 2;

        // create the sub arrays
        int[] sub1 = new int[m - l + 1];
        int[] sub2 = new int[r - m];

        // indexes
        int sub1Index = 0, sub2Index = 0, arrIndex = l;

        // populate the sub arrays
        for (int i = 0; i < sub1.length; i++)
            sub1[i] = arr[l + i];

        for (int i = 0; i < sub2.length; i++)
            sub2[i] = arr[m + 1 + i];

        // copy into array arr[]
        while (sub1Index < sub1.length && sub2Index < sub2.length) {

            if (sub1[sub1Index] < sub2[sub2Index]) {
                arr[arrIndex] = sub1[sub1Index];
                sub1Index++;
            } else {
                arr[arrIndex] = sub2[sub2Index];
                sub2Index++;
            }

            arrIndex++;
        }

        // copy the rest of the sub
        while (sub1Index < sub1.length) {
            arr[arrIndex] = sub1[sub1Index];
            sub1Index++;
            arrIndex++;
        }

        while (sub2Index < sub2.length) {
            arr[arrIndex] = sub2[sub2Index];
            sub2Index++;
            arrIndex++;
        }
    }
}