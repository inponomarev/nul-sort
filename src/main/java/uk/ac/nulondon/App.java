package uk.ac.nulondon;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public final class App {
    private App() {
    }

    public static void shuffle(int[] arr) {
        //Fisher–Yates shuffle
        for (int i = arr.length - 1; i > 0; i--) {
            int index = ThreadLocalRandom.current().nextInt(i + 1);
            int a = arr[index];
            arr[index] = arr[i];
            arr[i] = a;
        }
    }

    public static void bubble(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void bubbleImproved(int[] arr) {
        int n = arr.length;
        boolean nextIter = true;
        for (int i = 0; i < n && nextIter; i++) {
            nextIter = false;
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                    nextIter = true;
                }
            }
        }
    }

    public static void insertion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int k;
            for (k = i - 1; k >= 0 && arr[k] > current; k--)
                arr[k + 1] = arr[k];
            arr[k + 1] = current;
        }
    }


    public static void mergeSort(int[] list) {
        if (list.length > 1) {
            int firstHalfSize = list.length / 2;
            int[] fstHalf = new int[firstHalfSize];
            System.arraycopy(list, 0, fstHalf, 0, firstHalfSize);
            mergeSort(fstHalf);

            int sndHalfSize = list.length - firstHalfSize;
            int[] sndHalf = new int[sndHalfSize];
            System.arraycopy(list, firstHalfSize, sndHalf, 0, sndHalfSize);
            mergeSort(sndHalf);

            merge(fstHalf, sndHalf, list);
        }
    }

    public static void merge(int[] list1, int[] list2, int[] result) {
        int current1 = 0;
        int current2 = 0;
        int current3 = 0;

        while (current1 < list1.length && current2 < list2.length) {
            if (list1[current1] < list2[current2])
                result[current3++] = list1[current1++];
            else
                result[current3++] = list2[current2++];
        }

        while (current1 < list1.length)
            result[current3++] = list1[current1++];

        while (current2 < list2.length)
            result[current3++] = list2[current2++];
    }


    public static void quickSort(int[] array) {  // the wrapper
        quickSort(array, 0, array.length - 1);
    }

    // the recursive method
    public static void quickSort(int[] array, int first, int last) {
        if (last > first) {
            int pivot = partition(array, first, last);
            quickSort(array, first, pivot - 1);
            quickSort(array, pivot + 1, last);
        }
    }

    public static int partition(int[] array, int first, int last) {
        int pivot = array[first];
        int low = first + 1;
        int high = last;

        while (high > low) {
            while (low <= high && array[low] <= pivot)
                low++;
            while (low <= high && array[high] > pivot)
                high--;
            // swapping the smaller and larger wrt pivot
            if (high > low) {
                int temp = array[high];
                array[high] = array[low];
                array[low] = temp;
            }
        }
        while (high > first && array[high] >= pivot)
            high--;

        if (pivot > array[high]) {
            array[first] = array[high];
            array[high] = pivot;
            return high;
        } else {
            return first;
        }
    }

    public static void main(String[] args) {

        int[] arr = IntStream.range(0, 10).toArray();
        System.out.println(Arrays.toString(arr));
        shuffle(arr);
        System.out.println(Arrays.toString(arr));
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
