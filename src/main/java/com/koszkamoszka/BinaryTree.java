package com.koszkamoszka;

public class BinaryTree {
    Node root;

    public BinaryTree() {}

    public BinaryTree(Node root) {
        this.root = root;
    }

    public int childFreeAmount() {
        return childFreeDescendants(root);
    }

    private int childFreeDescendants(Node node) {
        int amountLeft = 0;
        int amountRight = 0;
        if (node.left == null && node.right == null) {
            return 1;
        }
        if (node.left != null) {
            amountLeft = childFreeDescendants(node.left);
        }
        if (node.right != null) {
            amountRight = childFreeDescendants(node.right);
        }
        return amountRight + amountLeft;
    }

    public int calculateHeight() {
        return subTreeHeight(root);
    }

    private int subTreeHeight(Node node) {
        if (node.left == null && node.right == null) {
            return 0;
        }
        int heightLeft = 0;
        int heightRight = 0;
        if (node.left != null) {
            heightLeft = subTreeHeight(node.left);
        }
        if (node.right != null) {
            heightRight = subTreeHeight(node.right);
        }
        return Math.max(heightLeft, heightRight) + 1;
    }

}
