package com.keyin.domain.left;

import com.keyin.domain.right.Right;
import jakarta.persistence.*;

@Entity
@Table(name = "left_table")
public class Left {

    @Id
    @SequenceGenerator(name = "Left_sequence", sequenceName = "Left_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "Left_sequence")
    private long id;

    private int value;

    @OneToOne(cascade = CascadeType.ALL)
    private Left left;

    @OneToOne(cascade = CascadeType.ALL)
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Left() {
    }

    public Left(int value, Left left, Right right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public Left(long id, int value, Left left, Right right) {
        this.id = id;
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
