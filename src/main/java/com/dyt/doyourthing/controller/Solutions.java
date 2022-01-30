package com.dyt.doyourthing.controller;

/**
 * Author: shubhamsrivastava
 **/
public class Solutions {

    public static void main(String[] args) {
        int[] a = {2,0,2,1,1,0};
        int k = a.length;

        for(int i=0;i<k;i++){
            if(a[i]==2){
                int temp = a[i];
                a[i] = a[k-1];

            }

        }

    }
}
