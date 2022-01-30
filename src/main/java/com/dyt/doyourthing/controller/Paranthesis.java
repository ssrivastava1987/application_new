package com.dyt.doyourthing.controller;

import java.util.Stack;

/**
 * Author: shubhamsrivastava
 **/
public class Paranthesis {

    public static void main(String[] args) {
        String a = "()(())))((((()))())";
        int k = 0;
        int y = 0;
        Stack<Character> st = new Stack<>();

        for(int i = 0;i<a.length();i++){
            if(a.charAt(i) == '(') {
                st.push(a.charAt(i));
                if(k > y) {
                    y = k;
                }
                k = 0;
            }
            if (a.charAt(i) == ')') {
                if (!st.empty() && st.peek() == '(') {
                    st.pop();
                    k = k + 2;
                }
            }
        }
//        int v = 0;
        if (k > y) {
            System.out.println(k);
//            v = k;
        } else {
            System.out.println(y);
//            v = y;
        }
//        System.out.println(v);
    }
}
