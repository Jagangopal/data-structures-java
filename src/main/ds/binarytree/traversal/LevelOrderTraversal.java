package src.main.ds.binarytree.traversal;

import src.main.ds.binarytree.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    /**
     * Iterative Level Order Traversal
     * Time Complexity: O(n)
     * Space Complexity: O(h) height of the tree
     * @param root
     */
    public void iterativeLevelOrderTraversal(Node root){
        List<Integer> resultList = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            Node temp = queue.remove();
            resultList.add(temp.data);
            if(temp.left != null)
                queue.add(temp.left);
            if(temp.right != null)
                queue.add(temp.right);
        }
        resultList.stream().forEach(element -> System.out.print(element +" "));
    }
    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(2);
        root.right.right = new Node(4);
        root.right.right.left = new Node(6);
        root.right.right.right = new Node(5);

        LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();
        levelOrderTraversal.iterativeLevelOrderTraversal(root);
    }
}
