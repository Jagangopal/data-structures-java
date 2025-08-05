package src.main.ds.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {

    public void invertTreeRecursive(Node root){
        if(root == null) return;
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTreeRecursive(root.left);
        invertTreeRecursive(root.right);
    }

    public void iterativeMethod(Node root){
        Queue<Node> q = new LinkedList<>();
        if(root != null) q.add(root);
        while(!q.isEmpty()){
            Node temp = q.poll();
            if(temp.left != null)
                q.add(temp.left);
            if(temp.right != null)
                q.add(temp.right);
            Node swap = temp.left;
            temp.left = temp.right;
            temp.right = swap;
        }
    }

    void treeTraversal(Node root){
        if(root != null) {
            System.out.print(root.data);
            treeTraversal(root.left);
            treeTraversal(root.right);
        }
    }
    public static void main(String[] args){
        Node root = new Node(1);
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
        invertBinaryTree.invertTreeRecursive(root);
        invertBinaryTree.iterativeMethod(root);
        if(root != null) {
            invertBinaryTree.treeTraversal(root);
        }
    }
}
