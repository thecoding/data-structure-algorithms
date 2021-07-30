package com.graph;

import java.util.ArrayList;

/**
 * @author Mirko
 */
public class Node {

    private int value;
    private ArrayList<Node> nexts;

    public Node(int value) {
        this.value = value;
        this.nexts = new ArrayList<>();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ArrayList<Node> getNexts() {
        return nexts;
    }

    public void setNexts(ArrayList<Node> nexts) {
        this.nexts = nexts;
    }
}
