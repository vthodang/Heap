package ex4_heap;

import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 * input an array of integers then 1. build the heap; 2. sort the array from heap
 * @author VNHS
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("Input an integer sequence by comma(,): ");
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        Heap h = Heap.heapify(toArray(s));
        System.out.println("Heap: " + h.toString());
        displayArray(h.heapSort());
    }
    
    private static Integer[] toArray(String s) {
        String[] st = s.split(",");
        Integer[] a = new Integer[st.length];
        for (int i = 0; i < st.length; i++) {
            a[i] = Integer.parseInt(st[i].trim());
        }
        return a;
    }
    
    private static void displayArray(Integer[] a) {
        String s = "";
        for (int i: a) {
            s += i + " ";
        }
        System.out.println(s);
    }
    
}
