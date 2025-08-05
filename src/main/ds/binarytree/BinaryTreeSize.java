package src.main.ds.binarytree;

public class BinaryTreeSize {
    /**
     * Binary Tree - Calculate Size
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * @param binaryTree
     * @return
     */
    public int calculateSizeOfBT(Node binaryTree){
        int leftSize = (binaryTree.left == null)? 0: calculateSizeOfBT(binaryTree.left);
        int rightSize = (binaryTree.right == null)? 0: calculateSizeOfBT(binaryTree.right);
        return 1 + leftSize + rightSize;
    }
    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        BinaryTreeSize binaryTreeSize = new BinaryTreeSize();
        System.out.println(binaryTreeSize.calculateSizeOfBT(root));
    }
}
