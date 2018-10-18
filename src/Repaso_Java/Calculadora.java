
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repaso_Java;

import java.util.Scanner;

/**
 *
 * @author jccas
 */
public class Calculadora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int option = 0;
        int n1 = 0, n2 = 0;
        do {
            System.out.println("Menu");
            System.out.println("1. Suma");
            System.out.println("2. Resta");
            System.out.println("3. Multiplicacion");
            System.out.println("4. Division");
            System.out.println("5. Factorial");
            System.out.println("6. Salir");
            try {
                option = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Digite una opción correcta");
                option = 0;
                sc.next();
            }
            if (option >= 1 && option < 5) {
                System.out.println("Digite el primer numero");
                n1 = sc.nextInt();
                System.out.println("Digite el segundo numero");
                n2 = sc.nextInt();
            }

            switch (option) {
                case 1:
                    System.out.println("Suma: " + (n1 + n2));
                    break;
                case 2:
                    System.out.println("Resta: " + (n1 - n2));
                    break;
                case 3:
                    System.out.println("Multiplicacion: " + (n1 * n2));
                    break;
                case 4:
                    System.out.println("Division: " + (n1 / n2));
                    break;
                case 5:
                    System.out.println("Digite el primer numero");
                    n1 = sc.nextInt();
                    System.out.println("Factorial " + factorial(n1));
                    break;
                case 6:
                    System.out.println("Fin del Programa");
                    break;
                default:
                    System.out.println("No existe esa opcion " + option);
                    break;
            }

        } while (option != 5);
    }

    static int factorial(int num) {
        int res = 1;
        for (int i = 2; i <= num; i++) {
            res *= i;
        }
        return res;
    }
}
