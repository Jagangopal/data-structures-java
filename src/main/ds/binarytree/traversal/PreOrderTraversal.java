package src.main.ds.binarytree.traversal;

import src.main.ds.binarytree.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreOrderTraversal {

    /**
     * Recursive Approach
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * @param root
     */
    public void recursivePreOrderTraversal(Node root){
        if(root != null){
            System.out.print(root.data + " ");
            recursivePreOrderTraversal(root.left);
            recursivePreOrderTraversal(root.right);
        }
    }

    /**
     *Iterative approach for Pre-Order Traversal
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * @arg root
     */
    public void iterativePreOrderTraversal(Node root){
        List<Integer> resultList = new ArrayList<>();
        Stack<Node> stack = new Stack();
        stack.push(root);
        while(!stack.isEmpty()){
            Node temp = stack.pop();
            resultList.add(temp.data);
            if(temp.right != null)
                stack.add(temp.right);
            if(temp.left != null)
                stack.add(temp.left);
        }
        resultList.forEach(element -> System.out.print(element+" "));
    }

    public static void main(String[] args){
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(2);
        PreOrderTraversal preOrderTraversal = new PreOrderTraversal();
        preOrderTraversal.recursivePreOrderTraversal(root);
        System.out.println();
        preOrderTraversal.iterativePreOrderTraversal(root);
    }
}