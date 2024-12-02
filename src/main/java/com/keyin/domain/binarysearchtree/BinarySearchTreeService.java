package com.keyin.domain.binarysearchtree;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BinarySearchTreeService {
    @Autowired
    private BinarySearchTreeRepository binarySearchTreeRepository;

    public List<BinarySearchTree> getAllTree(){return (List<BinarySearchTree>) binarySearchTreeRepository.findAll();}

    @Transactional
    public BinarySearchTree addTree(BinarySearchTree binarySearchTree){
        return binarySearchTreeRepository.save(binarySearchTree);
    }
}
