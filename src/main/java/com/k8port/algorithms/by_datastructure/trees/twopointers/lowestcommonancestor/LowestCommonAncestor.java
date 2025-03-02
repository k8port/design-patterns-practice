package com.k8port.algorithms.by_datastructure.trees.twopointers.lowestcommonancestor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LowestCommonAncestor {

    private static final Logger LOGGER = LoggerFactory.getLogger(LowestCommonAncestor.class);

    public static class EduTreeNode {
        public int data;
        public EduTreeNode left;
        public EduTreeNode right;
        public EduTreeNode parent;

        public EduTreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.parent = null;
        }
    }

    /**
     * Two pointer Switching Technique.
     * Avoids explicit computation of depth.
     * @param p
     * @param q
     * @return
     */
    public static EduTreeNode findLCA(EduTreeNode p, EduTreeNode q) {
        if (p == null || q == null) return null;
        
        EduTreeNode a = p;
        EduTreeNode b = q;


        // Traverse upward: when one pointer reaches null, switch to the other node.
        while (a != b) {
            a = (a != null) ? a.parent : q;
            b = (b != null) ? b.parent : p;
        }

        return a;
    }


   /**
    * Aligning Depths then moving up.
    * Comput depth of both nodes, bring deeper node up.
    * @param p
    * @param q
    * @return
    */
    public static EduTreeNode findLCAByDepth(EduTreeNode p, EduTreeNode q) {
        if (p == null || q == null) return null;
        
        int depthP = getDepth(p);
        int depthQ = getDepth(q);

        // Align depths
        while (depthP > depthQ) {
            p = p.parent;
            depthP--;
        }

        while (depthQ > depthP) {
            q = q.parent;
            depthQ--;
        }

        // Move up until LCA is found
        while (p != q) {
            p = p.parent;
            q = q.parent;
        }

        return p;
    }

    private static int getDepth(EduTreeNode node) {
        int depth = 0;
        while (node != null) {
            node = node.parent;
            depth++;
        }
        return depth;
    }

    /**
     * Traverse up from p until we find q's ancestor.
     * @param p
     * @param q
     * @return
     */
    private static EduTreeNode findLCAByParent(EduTreeNode p, EduTreeNode q) {
        if (p == null || q == null) return null;
        
        // Traverse up from p until we find q's ancestor
        while (p != null) {
            EduTreeNode temp = q;
            while (temp != null) {
                if (temp == p) {
                    return p;
                }
                temp = temp.parent;
            }
            p = p.parent;
        }
        return null;
    }

    /**
     * Build a binary tree from given input array (using level order) and set
     * parent pointers.
     * @param args input array of integers
     */
    public static EduTreeNode buildTree(int[] input) {
        if (input == null || input.length == 0) {
            return null;
        }

        EduTreeNode[] nodes = new EduTreeNode[input.length];
        for (int i = 0; i < input.length; i++) {
            nodes[i] = new EduTreeNode(input[i]);
        }

        for (int i = 0; i < input.length; i++) {
           int leftIndex = 2 * i + 1;
           int rightIndex = 2 * i + 2;

           if (leftIndex < input.length) {
            nodes[i].left = nodes[leftIndex];
            nodes[leftIndex].parent = nodes[i];
           }

           if (rightIndex < input.length) {
            nodes[i].right = nodes[rightIndex];
            nodes[rightIndex].parent = nodes[i];
           }
        }

        return nodes[0];
    }


    /** 
     * Find node with given target value.
     */
    public static EduTreeNode findNode(EduTreeNode root, int target) {
        if (root == null) return null;

        if (root.data == target) {
            return root;
        }

        EduTreeNode left = findNode(root.left, target);
        if (left != null) {
            return left;
        }

        return findNode(root.right, target);
    }

    public static void main(String[] args) {
       int[][] treeData = {
        {4, 3, 6, 2, 1, 7, 5},
        {1, 2, 3, 4, 5, 6},
        {12, 7, 1, 9, 10, 15},
        {1, 2},
        {3, 9, 20, 15, 7}
       };

       int[][] inputVals = {
        {5, 7},
        {1, 2},
        {1, 10},
        {1, 2},
        {3, 9}
       };

       for (int i = 0; i < treeData.length; i++) {
        EduTreeNode root = buildTree(treeData[i]);
        EduTreeNode node1 = findNode(root, inputVals[i][0]);
        EduTreeNode node2 = findNode(root, inputVals[i][1]);

        EduTreeNode lca = findLCA(node1, node2);
        if (lca != null) {
            LOGGER.info("LCA of {} and {} is {}", inputVals[i][0], inputVals[i][1], lca.data);
        } else {
            LOGGER.info("No LCA found for {} and {}", inputVals[i][0], inputVals[i][1]);
        }
       }
    }
}