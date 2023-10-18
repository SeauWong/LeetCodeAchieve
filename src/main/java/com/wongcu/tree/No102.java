package com.wongcu.tree;

import com.wongcu.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class No102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return null;
        }
        List<List<Integer>> list = new LinkedList();
        while(true){
            int cnt = 0;
            List<Integer> layer = new LinkedList<>();
            layer.add(root.val);
        }
    }
}
