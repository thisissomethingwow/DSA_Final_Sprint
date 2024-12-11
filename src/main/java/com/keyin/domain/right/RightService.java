package com.keyin.domain.right;

import com.keyin.domain.left.Left;
import org.springframework.stereotype.Service;

@Service
public class RightService {

    private RightRepository rightRepository;

    public Right addRight(Right right){
        return rightRepository.save(right);
    }
}
