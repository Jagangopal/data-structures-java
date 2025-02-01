package src.main.ds.binarytree;

public class MaxElementInBinaryTree {
    /**
     * BinaryTree - finding max element
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * @param binaryTreeRoot
     * @return
     */
    public int caluclateMaxElementInBT(Node binaryTreeRoot){
        if(binaryTreeRoot == null) return Integer.MIN_VALUE;
        int maxElement = binaryTreeRoot.data;
        int leftMax = caluclateMaxElementInBT(binaryTreeRoot.left);
        int rightMax = caluclateMaxElementInBT(binaryTreeRoot.right);
        if(leftMax > maxElement) maxElement = leftMax;
        if(rightMax > maxElement) maxElement = rightMax;

        return maxElement;
    }
    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        MaxElementInBinaryTree maxElementInBinaryTree = new MaxElementInBinaryTree();
        System.out.println(maxElementInBinaryTree.caluclateMaxElementInBT(root));
    }
}
