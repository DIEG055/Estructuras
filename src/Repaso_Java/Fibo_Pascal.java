/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repaso_Java;

/**
 *
 * @author Juan Diego Medina
 */
public class Fibo_Pascal {

    public static void main(String[] args) {
        System.out.println("Factorial Normal: " + factorial(5));
        System.out.println("Factorial Recursivo: " + factorialRec(5));
        System.out.println("----------------------------------------");
        System.out.println("Fibonacci Normal: " + fibonacci(5));
        System.out.println("Fibonacci Recursivo: " + fibonacciRec(5));
        System.out.println("----------------------------------------");
        System.out.println("MCD Normal: " + mcd(3, 5));
        System.out.println("MCD Recursivo: " + mcdRec(3, 5));
        System.out.println("----------------------------------------");
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(pascalRec(i, j) + " ");
            }
            System.out.println();
        }
    }

    static int factorialRec(int num) {
        if (num == 0) {
            return 1;
        }
        return num * (factorialRec(num - 1));
    }

    static int factorial(int num) {
        int res = 1;
        for (int i = 2; i <= num; i++) {
            res *= i;
        }
        return res;
    }

    static int fibonacci(int num) {
        int lastValue = 1;
        int actualValue = 1;
        int res;
        for (int i = 2; i <= num; i++) {
            res = lastValue + actualValue;
            lastValue = actualValue;
            actualValue = res;
        }
        return actualValue;
    }

    static int fibonacciRec(int num) {
        if (num == 0 || num == 1) {
            return 1;
        }

        return fibonacciRec(num - 1) + fibonacciRec(num - 2);
    }

    static int mcd(int a, int b) {
        int res = 1;
        int limit;
        if (a > b) {
            limit = b;
        } else {
            limit = a;
        }

        for (int i = 2; i <= limit; i++) {
            if (a % i == 0 && b % i == 0) {
                res *= i;
                a /= i;
                b /= i;
                i = 2;
            }
        }
        return res;
    }

    static int mcdRec(int a, int b) {
        if (b == 0) {
            return a;
        }

        return mcdRec(b, a % b);
    }

    static long pascalRec(int n, int k) {
        if (k == 0 || k == n) {
            return 1;
        }

        return pascalRec(n - 1, k - 1) + pascalRec(n - 1, k);

    }
}
