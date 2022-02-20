package ex4_heap;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * integer heap as an array
 * @author VNHS
 */
public class Heap {
    private Integer[] data;
    private int p = -1; // p as the last data position in the array, -1 = no data
    
    // constructor
    public Heap(int size) {
        this.data = new Integer[size];
    }
    
    private boolean isFull() {
        return this.p == this.data.length - 1;
    }
    
    //bubble index with its parent
    private void bubble(int index) {
        int tmp = data[index];
        data[index] = data[(index - 1) / 2];
        data[(index - 1) / 2] = tmp;
    }
    
    // fixUp - bubble the heap from the index to the root
    private void fixUp(int index) {
        int parent = (index - 1) / 2;
        while (parent >= 0 && data[parent] < data[index]) {
            bubble(index);
            index = parent;
            parent = (index - 1) / 2;
        }
    }
    
    private void fixDown(int upto) {
        int i = 0; // start from root
        while (i < upto) {
            int leftChild = 2*i + 1, rightChild = 2*i + 2;
            int toBubble = leftChild;
            // if rightChild bigger then to bubble the right
            if (rightChild <= upto && data[rightChild] > data[leftChild]) {
                toBubble = rightChild;
            }
            // if toBubble in the range and the child is bigger the bubble
            if (toBubble <= upto && data[i] < data[toBubble]) {
                bubble(toBubble);
                i = toBubble;
            } else {
                break;
            }
        }
    }
    
    // insert new data
    public void add(int a) {
        if (isFull()) {
            throw new RuntimeException("Heap is full.");
        }
        this.data[++p] = a;
        fixUp(p);
    }
    
    // heapSort - sort the data - no heap any more
    public Integer[] heapSort() {
        for (int i = data.length - 1; i > 0; i--) {
            // swap the current position with the root - max
            int tmp = data[i];
            data[i] = data[0];  // place root to position i as max
            data[0] = tmp;
            // rearrange the heap upto i-1, since i max now
            fixDown(i - 1);
        }
        return data;
    }
    
    // heaptify, static method, just call by class name
    public static Heap heapify(Integer[] a) {
        Heap h = new Heap(a.length); // construct the heap
        for (int i: a) {
            h.add(i);
        }
        return h;
    }
    
    @Override
    public String toString() {
        String s = "";
        for (int i: data) {
            s += i + " ";
        }
        return s;
    }
}
