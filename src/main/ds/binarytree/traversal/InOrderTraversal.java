package src.main.ds.binarytree.traversal;

import src.main.ds.binarytree.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {
    /**
     * Recursive InOrder Traversal
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * @param root
     */
    public void recursiveInorderTraversal(Node root){
        if(root != null) {
            recursiveInorderTraversal(root.left);
            System.out.print(root.data +" ");
            recursiveInorderTraversal(root.right);
        }
    }

    public void iterativeInorderTraversal(Node root){
        List<Integer> resultList = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node current = root;
        while(current != null || !stack.isEmpty()){
            while(current != null){
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            resultList.add(current.data);
            current = current.right;
        }
        resultList.forEach(element -> System.out.print(element+" "));
    }

    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        InOrderTraversal inOrderTraversal = new InOrderTraversal();
        System.out.println(
                "Inorder traversal of binary tree is: ");
        inOrderTraversal.recursiveInorderTraversal(root);
        System.out.println();
        inOrderTraversal.iterativeInorderTraversal(root);
    }
}
