/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Recursion;

/**
 *
 * @author jchen
 */
public class CalculateE {
    public static double calculateE(int threshold) {
        if (threshold == 0) {
            return 1;
        }
        
        return (1.0 / factorial(threshold)) + calculateE(threshold - 1);
    } 
    
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        
        return n * factorial(n-1);
    }
    public static void main(String[] args) {
        System.out.println(calculateE(30));
    }
}
