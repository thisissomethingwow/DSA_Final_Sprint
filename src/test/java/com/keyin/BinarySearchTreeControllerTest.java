package com.keyin;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.keyin.domain.binarysearchtree.BinarySearchTree;
import com.keyin.domain.binarysearchtree.BinarySearchTreeController;
import com.keyin.domain.binarysearchtree.BinarySearchTreeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BinarySearchTreeController.class)
public class BinarySearchTreeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BinarySearchTreeService binarySearchTreeService;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testGetAllTree() throws Exception {
        BinarySearchTree tree1 = new BinarySearchTree();
        tree1.setRoot(10);

        BinarySearchTree tree2 = new BinarySearchTree();
        tree2.setRoot(20);

        List<BinarySearchTree> trees = Arrays.asList(tree1, tree2);

        Mockito.when(binarySearchTreeService.getAllTree()).thenReturn(trees);

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].root").value(10))
                .andExpect(jsonPath("$[1].root").value(20));
    }

    @Test
    public void testAddTree() throws Exception {
        BinarySearchTree tree = new BinarySearchTree();
        tree.setRoot(15);

        Mockito.when(binarySearchTreeService.addTree(any(BinarySearchTree.class))).thenReturn(tree);

        mockMvc.perform(post("/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(tree)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.root").value(15));
    }

    @Test
    public void testProcessNumber() throws Exception {
        BinarySearchTree tree = new BinarySearchTree();
        tree.setRoot(10);

        Mockito.when(binarySearchTreeService.insertValue(any(), any(Integer.class))).thenReturn(tree);
        Mockito.when(binarySearchTreeService.addTree(any(BinarySearchTree.class))).thenReturn(tree);

        String numbers = "10,20,30";

        mockMvc.perform(post("/process-numbers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(numbers)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.root").value(10));
    }

    @Test
    public void testGetPreviousTrees() throws Exception {
        BinarySearchTree tree1 = new BinarySearchTree();
        tree1.setRoot(5);

        BinarySearchTree tree2 = new BinarySearchTree();
        tree2.setRoot(15);

        List<BinarySearchTree> trees = Arrays.asList(tree1, tree2);

        Mockito.when(binarySearchTreeService.getAllTree()).thenReturn(trees);

        mockMvc.perform(get("/previous-trees"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].root").value(5))
                .andExpect(jsonPath("$[1].root").value(15));
    }
}
