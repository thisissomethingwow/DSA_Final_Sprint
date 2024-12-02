package com.keyin.domain.binarysearchtree;

import com.keyin.domain.left.Left;
import com.keyin.domain.right.Right;
import jakarta.persistence.*;

@Entity
public class BinarySearchTree {
    @Id
    @SequenceGenerator(name = "BinarySearchTree_sequence", sequenceName = "BinarySearchTree_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "BinarySearchTree_sequence")
    private long id;

    private int root;

    @OneToOne(cascade = CascadeType.ALL)
    private Left left;

    @OneToOne(cascade = CascadeType.ALL)
    private Right right;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRoot() {
        return root;
    }

    public void setRoot(int root) {
        this.root = root;
    }

    public Left getLeft() {
        return left;
    }

    public void setLeft(Left left) {
        this.left = left;
    }

    public Right getRight() {
        return right;
    }

    public void setRight(Right right) {
        this.right = right;
    }

    public BinarySearchTree() {
    }

    public BinarySearchTree(int root, Left left, Right right) {
        this.root = root;
        this.left = left;
        this.right = right;
    }

    public BinarySearchTree(long id, int root, Left left, Right right) {
        this.id = id;
        this.root = root;
        this.left = left;
        this.right = right;
    }
}
