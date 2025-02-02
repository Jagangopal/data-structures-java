package src.main.ds.binarytree;

public class ConvertBTMirror {

    /**
     * Binary Tree - Mirror Image Logic
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * @param binaryTree
     * @return
     */
    public Node binaryTreeMirrorImage(Node binaryTree){
        Node tmp;
        if(binaryTree != null){
            binaryTreeMirrorImage(binaryTree.left);
            binaryTreeMirrorImage(binaryTree.right);
            tmp = binaryTree.left;
            binaryTree.left = binaryTree.right;
            binaryTree.right = tmp;
        }
        return binaryTree;
    }

    public void recursiveInorderTraversal(Node root){
        if(root != null) {
            recursiveInorderTraversal(root.left);
            System.out.print(root.data +" ");
            recursiveInorderTraversal(root.right);
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

        ConvertBTMirror convertBTMirror = new ConvertBTMirror();
        convertBTMirror.recursiveInorderTraversal(root);
        System.out.println();
        convertBTMirror.binaryTreeMirrorImage(root);
        convertBTMirror.recursiveInorderTraversal(root);
    }
}
