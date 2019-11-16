package com.escmobile.lab.crackingthecodinginterview.sorting;

public class QuickSortImpl {

    public void quickSort(int[] arr) {

        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int l, int r) {

        if (l >= r) return;

        int partition = getPartition(arr, l, r);

        sort(arr, l, partition - 1);
        sort(arr, partition + 1, r);
    }

    private int getPartition(int[] arr, int l, int r) {

        // {10, 4, 1, 19, 0, 5}
        // l: 0, r: 4

        int pivot = arr[r];
        int runnerIndex = l;

        for (int i = l; i < r; i++) {

            if (arr[i] < pivot) {

                int temp = arr[i];
                arr[i] = arr[runnerIndex];
                arr[runnerIndex] = temp;
                runnerIndex++;
            }
        }

        // also move the pivot
        arr[r] = arr[runnerIndex];
        arr[runnerIndex] = pivot;

        return runnerIndex;
    }
}
