package com.keyin.domain.left;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeftService {
    @Autowired
    private LeftRepository leftRepository;

    public Left addLeft(Left left){
        return leftRepository.save(left);
    }

}
