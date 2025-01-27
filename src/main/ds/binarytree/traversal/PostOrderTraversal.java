package src.main.ds.binarytree.traversal;

import src.main.ds.binarytree.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {
    /**
     * Recursive Post Order Traversal
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * @param root
     */
    public void recursivePostOrderTraversal(Node root){
        if(root != null){
            recursivePostOrderTraversal(root.left);
            recursivePostOrderTraversal(root.right);
            System.out.print(root.data +" ");
        }
    }

    public void iterativePostOrderTraversal(Node root){
        List<Integer> resultList = new ArrayList<>();
        Stack<Node> stack = new Stack();
        stack.push(root);
        while(!stack.isEmpty()){
            Node temp = stack.pop();
            resultList.add(temp.data);
            if(temp.left != null)
                stack.add(temp.left);
            if(temp.right != null)
                stack.add(temp.right);
        }
        Collections.reverse(resultList);
        resultList.forEach(element -> System.out.print(element+" "));
    }
    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        System.out.println(
                "Post order traversal of binary tree is: ");
        PostOrderTraversal postOrderTraversal = new PostOrderTraversal();
        postOrderTraversal.recursivePostOrderTraversal(root);
        System.out.println();
        postOrderTraversal.iterativePostOrderTraversal(root);
    }
}