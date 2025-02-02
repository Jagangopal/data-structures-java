package src.main.ds.binarysearchtree;

public class SearchInBST {

    /**
     * BST - Search an element recursive
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * @param bstTree
     * @param target
     * @return
     */
    public boolean isElementPresentInBSTRecursive(Node bstTree, int target){
        if(bstTree == null) return false;
        if(bstTree.data == target) return true;
        else if (target < bstTree.data) {
            return isElementPresentInBSTRecursive(bstTree.left, target);
        } else {
            return isElementPresentInBSTRecursive(bstTree.right, target);
        }
    }

    /**
     * BST - Iterative approach to search an element
     * Time Complexity:  O(n)
     * Space Complexity: O(1)
     * @param bstTree
     * @param target
     * @return
     */
    public boolean isElementPresentInBSTIterative(Node bstTree, int target){
        if(bstTree == null) return false;
        while(bstTree != null){
            if(bstTree.data == target) return true;
            else if(target < bstTree.data){
                bstTree = bstTree.left;
            } else {
                bstTree = bstTree.right;
            }
        }
        return false;
    }

    public static void main(String[] args){
        Node tree = new Node(20);
        tree.left = new Node(8);
        tree.right = new Node(22);
        tree.left.left = new Node(4);
        tree.left.right = new Node(12);
        tree.left.right.left = new Node(10);
        tree.left.right.right = new Node(14);

        int target = 140;
        SearchInBST searchInBST = new SearchInBST();
        System.out.println("Search in BST -> Iterative: Element Found -> "+
                searchInBST.isElementPresentInBSTIterative(tree, target));
        System.out.println("Search in BST -> Recursive: Element Found -> "+
                searchInBST.isElementPresentInBSTRecursive(tree, target));
    }
}
