package com.koszkamoszka;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class BinaryTreeTest {
    @ParameterizedTest
    @MethodSource("binaryTreesAndExpectedChildFreeAmounts")
    void testChildFreeAmountReturnsCorrectResult(BinaryTree tree, int expectedChildFreeAmount) {
        Assertions.assertEquals(expectedChildFreeAmount, tree.childFreeAmount());
    }

    private static List<Arguments> binaryTreesAndExpectedChildFreeAmounts() {
        return List.of(
                Arguments.of(singleNodeTree(), 1),
                Arguments.of(multiNodeTree(), 3)
        );
    }

    @ParameterizedTest
    @MethodSource("binaryTreesAndExpectedHeights")
    void testCalculateHeightReturnsCorrectResult(BinaryTree tree, int expectedHeight) {
        Assertions.assertEquals(expectedHeight, tree.calculateHeight());
    }

    private static List<Arguments> binaryTreesAndExpectedHeights() {
        return List.of(
                Arguments.of(singleNodeTree(), 0),
                Arguments.of(multiNodeTree(), 3)
        );
    }

    @ParameterizedTest
    @MethodSource("binaryTreesAndComparisonResults")
    void testEqualsReturnsCorrectResult(BinaryTree tree, BinaryTree otherTree, boolean expectedEqual) {
        boolean actualEqual = tree.equals(otherTree);
        Assertions.assertEquals(expectedEqual, actualEqual);
    }

    private static List<Arguments> binaryTreesAndComparisonResults() {
        return List.of(
                Arguments.of(singleNodeTree(), singleNodeTree(), true),
                Arguments.of(singleNodeTree(), null, false),
                Arguments.of(multiNodeTree(), multiNodeTree(), true),
                Arguments.of(multiNodeTree(), null, false),
                Arguments.of(singleNodeTree(), multiNodeTree(), false)
        );
    }

    private static BinaryTree singleNodeTree() {
        Node singleRootNode = new Node(5);
        return new BinaryTree(singleRootNode);
    }

    private static BinaryTree multiNodeTree() {
        Node root = new Node(5);
        Node rootLeft = new Node(3);
        Node rootRight = new Node(7);
        Node rootLeftLeft = new Node(2);
        Node rootLeftRight = new Node(5);
        Node rootRightRight = new Node(0);
        Node rootRightRightRight = new Node(8);
        root.left = rootLeft;
        root.right = rootRight;
        rootLeft.left = rootLeftLeft;
        rootLeft.right = rootLeftRight;
        rootRight.right = rootRightRight;
        rootRightRight.right = rootRightRightRight;
        return new BinaryTree(root);
    }

}
