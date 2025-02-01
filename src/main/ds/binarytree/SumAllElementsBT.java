package src.main.ds.binarytree;

public class SumAllElementsBT {

    public int calculateSum(Node binaryTree) {
        if (binaryTree == null) return 0;
        return binaryTree.data + calculateSum(binaryTree.left)
                + calculateSum(binaryTree.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        SumAllElementsBT sumAllElementsBT = new SumAllElementsBT();
        System.out.println(sumAllElementsBT.calculateSum(root));
    }
}
