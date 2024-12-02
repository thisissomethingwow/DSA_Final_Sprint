package com.keyin.domain.right;

import com.keyin.domain.left.Left;
import jakarta.persistence.*;

@Entity
@Table(name = "right_table")
public class Right {
    @Id
    @SequenceGenerator(name = "Right_sequence", sequenceName = "Right_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "Right_sequence")
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

    public Right() {
    }

    public Right(int value, Left left, Right right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public Right(long id, int value, Left left, Right right) {
        this.id = id;
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
