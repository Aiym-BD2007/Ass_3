package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args)
    {
        //HashTable
        MyHashTable t1=new MyHashTable<>();
        t1.put(1,"one");
        t1.put(2,"two");
        t1.put(3,"three");
        t1.put(4,"four");
        t1.put(5,"five");
        for(int i=6;i<11;i++ )
        {
            t1.put(i,"number");
        }
        t1.put(12312,"smt");
        System.out.println(t1);
        t1.remove(5);
        System.out.println(t1.get(55));

        //BinarySearchTree
        BinarySearchTree bst = new BinarySearchTree();
        bst.put(1,"one");
        bst.put(2,"two");
        bst.put(3,"three");
        bst.put(4,"three");
        bst.put(5,"three");
        bst.put(6,"three");
        System.out.println(bst);
        System.out.println(bst.get(6));
        bst.remove(4);
        System.out.println(bst);

        /*sorts*/
        ArrayList<Character> arr = new ArrayList<>(Arrays.asList('3','2','3','4','8','1','h','t','a','v'));//если хочется определенный массив
        System.out.println("arr - "+arr);
        quick_sort(arr, 0, arr.size() - 1);
        System.out.println("quick sort: "+arr);
        arr= new ArrayList<>(Arrays.asList('3','2','3','4','8','1','h','t','a','v'));
        System.out.println("arr - "+arr);
        merge_sort(arr, 0, arr.size() - 1);
        System.out.println("merge sort: "+ arr);
    }
    public static <T extends Comparable<? super T>> void quick_sort(ArrayList<T> arr, int low, int high)
    {
        if (low < high)
        {

            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high);

            // Separately sort elements before
            // partition and after partition
            quick_sort(arr, low, pi - 1);
            quick_sort(arr, pi + 1, high);
        }
    }
    public static <T extends Comparable<? super T>> int partition(ArrayList<T> arr, int low, int high)
    {
        // pivot
        T pivot = arr.get(high);

        // Index of smaller element and
        // indicates the right position
        // of pivot found so far
        int i = (low - 1);

        for(int j = low; j <= high - 1; j++)
        {

            // If current element is smaller
            // than the pivot
            if (arr.get(j).compareTo(pivot) < 0)
            {

                // Increment index of
                // smaller element
                i++;
                Collections.swap(arr, i, j);
            }
        }
        Collections.swap(arr, i + 1, high);
        return (i + 1);
    }
    public static <T extends Comparable<? super T>> void merge_sort(ArrayList<T> arr, int l, int r)
    {
        // Main function that sorts arr[l..r] using
        // merge()
        if (l < r)
        {
            // Find the middle point
            int m =l+ (r-l)/2;

            // Sort first and second halves
            merge_sort(arr, l, m);
            merge_sort(arr, m + 1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
    public static <T extends Comparable<? super T>> void merge(ArrayList<T> arr, int l, int m, int r)
    {
        // Merges two subarrays of arr[].
        // First subarray is arr[l..m]
        // Second subarray is arr[m+1..r]
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        ArrayList<T> L=new ArrayList<>(n1);
        ArrayList<T> R=new ArrayList<>(n2);
        //int[] L = new int[n1];
        //int[] R = new int[n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)

            L.add(i, arr.get(l + i));
        for (int j = 0; j < n2; ++j)
            R.add(j, arr.get(m + 1 + j));

        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L.get(i).compareTo(R.get(j)) <= 0) {
                arr.set(k, L.get(i));
                i++;
            }
            else {
                arr.set(k, R.get(j));
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr.set(k, L.get(i));
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr.set(k, R.get(j));
            j++;
            k++;
        }
    }

}
