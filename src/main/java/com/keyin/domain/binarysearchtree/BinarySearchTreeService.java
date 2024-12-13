package com.keyin.domain.binarysearchtree;

import com.keyin.domain.left.Left;
import com.keyin.domain.right.Right;
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


    public BinarySearchTree insertValue(BinarySearchTree root,int value){
        if (root ==null){
            root = new BinarySearchTree();
            root.setRoot(value);
            return root;
        }
        if (value<root.getRoot()) {
            if (root.getLeft()==null){
                Left newLeft = new Left();
                newLeft.setValue(value);
                root.setLeft(newLeft);
            }else {
                root.setLeft(incertLeft(root.getLeft(),value));
            }
        }else {
            if (root.getRight()==null){
                Right newRight = new Right();
                newRight.setValue(value);
                root.setRight(newRight);
            }else {
                root.setRight(incertRight(root.getRight(),value));
            }
        }
        return root;
    }

    public Left incertLeft(Left node, int value){
        if (node==null){
            Left newLeft = new Left();
            newLeft.setValue(value);
            return newLeft;
        }
        if (value<node.getValue()){
            node.setLeft(incertLeft(node.getLeft(),value));
        }else {
            node.setRight(incertRight(node.getRight(),value));
        }
        return node;
    }

    public Right incertRight(Right node, int value){
        if (node==null){
            Right newRight = new Right();
            newRight.setValue(value);
            return newRight;
        }
        if (value<node.getValue()){
            node.setLeft((incertLeft(node.getLeft(),value)));
        }else{
            node.setRight(incertRight(node.getRight(),value));
        }
        return node;
    }



}
