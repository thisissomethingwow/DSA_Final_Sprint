package com.keyin.domain.binarysearchtree;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tree")
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

}
