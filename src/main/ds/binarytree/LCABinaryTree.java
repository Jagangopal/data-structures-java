package src.main.ds.binarytree;

public class LCABinaryTree {
    /**
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * @param root
     * @param n1
     * @param n2
     * @return
     */
    public Node findLcaBT(Node root, int n1, int n2){
        if(root == null) return null;
        if(root.data == n1 || root.data == n2) return root;
        Node leftLca = findLcaBT(root.left, n1, n2);
        Node rightLca = findLcaBT(root.right, n1, n2);
        if(leftLca != null && rightLca != null)
            return root;
        return (leftLca != null) ? leftLca: rightLca;
    }
    public static void main(String[] args){
        LCABinaryTree lCABinaryTree = new LCABinaryTree();
        Node root = new Node(1);
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Node ans = lCABinaryTree.findLcaBT(root, 4, 5);
        if(ans == null)
            System.out.println("No common ancestor found");
        else
            System.out.println(ans.data);
    }
}
