package com.keyin.domain.binarysearchtree;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
    //@RequestMapping("/tree") // this is here for the sake of testing can remove when working
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


    @PostMapping("/process-numbers")
    public BinarySearchTree processNumber(@RequestBody String stringNumbers){
        List<Integer> numbersInt = Arrays.stream(stringNumbers.replace("\"","").split(",")).map(String::trim).map(Integer::parseInt).toList();
        BinarySearchTree root =null;
        for (int number:numbersInt) {
            root= binarySearchTreeService.insertValue(root,number);
        }
        return binarySearchTreeService.addTree(root);
    }


    @GetMapping("/previous-trees")
    public List<BinarySearchTree> getPreviousTrees(){
        return binarySearchTreeService.getAllTree();
    }

}
