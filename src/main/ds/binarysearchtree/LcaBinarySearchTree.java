package src.main.ds.binarysearchtree;

public class LcaBinarySearchTree {

    /**
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * @param root
     * @param n1
     * @param n2
     * @return
     */
    public Node lcaBstMethod(Node root, int n1, int n2){
        while(root != null){
            if(root.data > n1 && root.data > n2)
                root = root.left;
            else if(root.data < n1 && root.data < n2)
                root = root.right;
            else
                break;
        }

        return root;
    }
    public static void main(String[] args){
        LcaBinarySearchTree lcaBinarySearchTree = new LcaBinarySearchTree();

        Node tree = new Node(20);
        tree.left = new Node(8);
        tree.right = new Node(22);
        tree.left.left = new Node(4);
        tree.left.right = new Node(12);
        tree.left.right.left = new Node(10);
        tree.left.right.right = new Node(14);

        int n1 = 10, n2 = 14;
        Node t = lcaBinarySearchTree.lcaBstMethod(tree, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2
                + " is " + t.data);
        n1 = 14;
        n2 = 8;
        t = lcaBinarySearchTree.lcaBstMethod(tree, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2
                + " is " + t.data);

        n1 = 10;
        n2 = 22;
        t = lcaBinarySearchTree.lcaBstMethod(tree, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2
                + " is " + t.data);
    }
}
