package com.koszkamoszka;

public class Node {
    int value;
    Node left;
    Node right;

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public Node(int value) {
        this(value, null, null);
    }

    public boolean equals(Node other) {
        if (other == null) {
            return false;
        }
        boolean valuesEqual = value == other.value;
        boolean leftEqual = left == null ? other.left == null : left.equals(other.left);
        boolean rightEqual = right == null ? other.right == null : right.equals(other.right);
        return valuesEqual && leftEqual && rightEqual;
    }
}
