package com.keyin.domain.binarysearchtree;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    @GetMapping("/enter-numbers")
    public String getPage(){
        return "index.html";
    }
}
