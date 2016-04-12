/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.discussion3;

import java.beans.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Timothy
 */
public class Bean123 implements Serializable {
    
    public static final String PROP_SAMPLE_PROPERTY = "sampleProperty";
    
    private Stack<String> stackPosts;     //  = new Stack<String>();
    private ArrayList<String> listPosts;  //  = new ArrayList<String>();
    
    public ArrayList<String> getList() {
        return listPosts;
    }
    
    public void addPost(String post) {
        if (stackPosts == null) {               // Is this a valid way to check for null here?
            stackPosts = new Stack<String>();
        }
        stackPosts.push(post);
    }
    
    public void reverseOrder() {
        if (listPosts == null) {               // Is this a valid way to check for null here?
            listPosts = new ArrayList<String>();
        }
        listPosts.clear();  // double-check the list is empty - then reorder posts in stack
        while (!stackPosts.empty()) {
            listPosts.add(stackPosts.pop());  // Assumption - .pop() returns top element and then removes it
        }
    }
    
    public Boolean isListEmpty() {
        return listPosts.isEmpty();
    }
    
}
