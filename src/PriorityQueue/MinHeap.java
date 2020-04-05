package PriorityQueue;

import java.lang.reflect.Array;
import java.util.Arrays;

// index i
// i-leftChild: 2*i + 1
// i-rightChild: 2*i + 2
// i-parent: (i - 1)/ 2
public class MinHeap {
    // fields
    int[] arr;
    int size;
    static final int DEFAULT_CAPACITY = 16;

    // method
    public MinHeap(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("");
        }
        arr = new int[capacity];
        size = 0;
    }
    public MinHeap() {
        this(DEFAULT_CAPACITY);
    }
    public MinHeap(int[] inputArr) { // clone(without index) or copyOf(with index)
        if (inputArr == null || inputArr.length == 0) {
            throw new IllegalArgumentException("");
        }
        arr = Arrays.copyOf(inputArr, inputArr.length * 2); // stateless + 余地
        size = inputArr.length;
        heapify(); // arr is global, no need to serve as input
    }


    private void heapify(){ //自右向左，自下向上，从第一个非leafnode开始percolateDown
        for(int i = (size - 2) / 2; i >= 0; i--) { //i = (size - 1 - 1) / 2
            percolateDown(i);
        }
    }

    private void percolateUp(int index) {
        while (index > 0) {
            int parentIdx = (index - 1) / 2;
            if (arr[index] < arr[parentIdx]) {
                swap(arr, index, parentIdx);
            } else {
                break;
            }
            index = parentIdx;
        }


    }
    private void percolateDown(int index) {
        while (index <= (size - 2) / 2) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int swapIdx = left;
            if (right < size && arr[right] < arr[left]) {
                swapIdx = right;
            }
            if (arr[swapIdx] < arr[index]) {
                swap(arr, index, swapIdx);
            } else {
                break;
            }
            index = left;
        }

/*        while (index < arr.length) {
            int left = 2 * index + 1;
            if (left < arr.length && arr[left] < arr[index]) {
                swap(arr, index, left);
            } else {
                int right = 2 * index + 2;
                if (left < arr.length && arr[left] < arr[index]) {
                    swap(arr, index, right);
                }
            }
        }*/
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public void offer(int val) { // public boolean offer(int val) {
        // resize
        if (arr.length == size) {
            int[] newArr = new int[2 * size];
            newArr = Arrays.copyOf(arr, size);
            arr = newArr;
        }
        arr[size] = val;
        percolateUp(size);
        size++;
    }

    public Integer poll() { // public int poll() {
        // if NULL
        if (size == 0) {
            return null;
        }
        int smallestVal = arr[0];
        arr[arr.length - 1] = arr[0];
        percolateDown(0);
        size--;

        return smallestVal;
    }

    public int peek() {
        return arr[0];
    }

    public void update(int val, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("");
        }
        int temp = arr[index];
        arr[index] = val;
        if (temp > val) {
            percolateUp(index);
        } else if (temp < val){
            percolateDown(index);
        }
    }
    

}
