package com.dyt.doyourthing.controller;

import java.util.Objects;
import java.util.UUID;

/**
 * Author: Shubham Srivastava
 **/
public class Test {

    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            Node n = new Node(Integer.toString(i)).put();
            System.out.println(new Node().get(n.hash));
        }
    }
}


class Node {
    private String data;
    String hash;
    private Node node;
    private Node next;

    Node(String data){
        this.data = data;
        hash = UUID.randomUUID().toString();
    }

    Node() {

    }

    public Node put() {
        next = node;
        node = new Node(data);
        return node;
    }

    public Node get(String hash) {
        while(Objects.equals(this.node.hash,hash)){
            break;
        }
        return node;
    }
}