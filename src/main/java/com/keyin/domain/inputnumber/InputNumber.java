package com.keyin.domain.inputnumber;

import jakarta.persistence.*;

@Entity
public class InputNumber {
    @Id
    @SequenceGenerator(name = "member_sequence", sequenceName = "member_sequence", allocationSize = 1, initialValue=1)
    @GeneratedValue(generator = "member_sequence")
    private long id;

//    @Column(nullable = false) change this after everything works
    private String numbers;


}
