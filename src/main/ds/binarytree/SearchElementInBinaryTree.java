package src.main.ds.binarytree;

public class SearchElementInBinaryTree {
    /**
     * Binary Tree - Search a targeted element
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * @param binaryTreeNode
     * @param target
     * @return
     */
    public boolean searchInBT(Node binaryTreeNode, int target){
        if(binaryTreeNode == null) return false;
        if(binaryTreeNode.data == target) return true;
        return searchInBT(binaryTreeNode.left, target) || searchInBT(binaryTreeNode.right, target);
    }
    public static void main(String[] args){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        int target = 13;
        SearchElementInBinaryTree searchElementInBinaryTree = new SearchElementInBinaryTree();
        System.out.println(searchElementInBinaryTree.searchInBT(root, target));
    }
}
