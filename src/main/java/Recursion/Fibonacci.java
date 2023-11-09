/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Recursion;

/**
 *
 * @author jchen
 */
public class Fibonacci {
    public static int fib(int n) {
        if (n ==  1|| n == 0) {
            return 1;
        }
        
        return fib(n-1) + fib(n-2);
    }
    public static void main(String[] args) {
        System.out.println(fib(5));
        System.out.println(fib(8));
        System.out.println(fib(13));
    }
}
