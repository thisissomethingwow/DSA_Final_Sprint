package com.keyin.domain.left;

import com.keyin.domain.right.Right;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Left {

    private int value;

    private Left left;

    private Right right;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
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

    public Left() {
    }

    public Left(int value, Left left, Right right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
