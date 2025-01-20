package src.main.ds.binarysearchtree;

import java.util.Stack;

public class KthSmallestElementBST {

    /**
     * Time Complexity: O(H + K)
     * Space Complexity: O(H)
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(Node root, int k) {
        Stack<Node> stackNodes = new Stack<>();
        if (root == null) return -1;

        while(true) {
            while (root != null) {
                stackNodes.add(root);
                root = root.left;
            }
            root = stackNodes.removeLast();
            if (--k == 0) return root.data;
            root = root.right;
        }
        //return -1;
    }

    public static void main(String[] args) {
        KthSmallestElementBST kthSmallestElementBST = new KthSmallestElementBST();
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        int k = 3;

        System.out.println(kthSmallestElementBST.kthSmallest(root, k));
    }
}
