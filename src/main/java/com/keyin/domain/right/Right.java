package com.keyin.domain.right;

import com.keyin.domain.left.Left;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Right {
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

    public Right() {
    }

    public Right(int value, Left left, Right right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
