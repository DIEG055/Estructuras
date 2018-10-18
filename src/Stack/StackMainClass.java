/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stack;

/**
 *
 * @author jccas
 */
public class StackMainClass {

    public static boolean iguales(MyLinkedStack<Integer> s1, MyLinkedStack<Integer> s2) {
        if (s1.size() == s2.size) {
            return true;
        } else {
            return false;
        }
    }

    public static int firstSpace(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                return i;
            }
        }
        return -1;
    }

    public static MyLinkedStack<Integer> toStack(String s) {
        MyLinkedStack<Integer> stack = new MyLinkedStack<>();
        MyLinkedStack<Integer> stack2 = new MyLinkedStack<>();
        while (firstSpace(s) != -1) {
            stack.push(Integer.valueOf(s.substring(0, firstSpace(s))));
            s = s.substring(firstSpace(s) + 1, s.length());
        }
        while (!stack.isEmpty()) {
            stack2.push(stack.pop());
        }
        return stack2;
    }

    public static int delete(MyLinkedStack<Integer> s) {
        MyLinkedStack<Integer> temp = s;
        MyLinkedStack<Integer> aux = new MyLinkedStack<>();
        int n, nn;
        int i = 0;
//        nn = s.pop();
//        aux.push(nn);
//        s.push(nn);
        boolean cambios = true;
        do {
            while (s.size() != 1) {
                n = s.pop();
                nn = s.pop();
                if(s.size==temp.size){
                    aux.push(n);
                }
                if (n > nn) {
                    aux.push(nn);
                }
                s.push(nn);

            }

            System.out.println("");
            System.out.println("aux");
            aux.print();
            System.out.println("");
            if (!iguales(temp, aux)) {
                i++;
            } else {
                cambios = false;
            }
            s.clear();
            temp=aux;
            while (!aux.isEmpty()) {

                s.push(aux.pop());
            };

        } while (cambios);
        return i;
    }

    public static void main(String[] args) {

        MyLinkedStack<Integer> stack = new MyLinkedStack<>();

        String s = "3 6 2 7 5 ";
        stack = toStack(s);
        stack.print();
        System.out.println("");
        int i = delete(stack);
        System.out.println("dias: " + i);

    }

}
