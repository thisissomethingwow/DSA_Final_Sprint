package com.keyin.domain.binarysearchtree;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/tree") // this is here for the sake of testing can remove when working
@CrossOrigin

public class BinarySearchTreeController {
    @Autowired
    private BinarySearchTreeService binarySearchTreeService;



    @GetMapping
    public List<BinarySearchTree> getAllTree(){
        return binarySearchTreeService.getAllTree();
    }

    @PostMapping
    public BinarySearchTree addTree(@RequestBody BinarySearchTree binarySearchTree){
        return binarySearchTreeService.addTree(binarySearchTree);
    }

    @GetMapping("/enter_numbers")
    public String showInput() {
        return "index";
    }

//    @PostMapping("/process-numbers")
//    public String processNumber(){
////        ArrayList<Integer> numberArray = binaryTreeSetUp.sortNumber();
////       String jsonNumber = binaryTreeSetUp.json(numberArray);
//
//    }

}
