package src.main.ds.binarytree;

public class TwoBTStructurallyIdentical {

    /**
     * Binary tree - Check if Structurally Identical
     * Time Complexity: O(n)
     * Space Complexity:O(n)
     * @param rootOne
     * @param rootTwo
     * @return
     */
    public boolean isStructurallyIdentical(Node rootOne, Node rootTwo){
        if(rootOne == null && rootTwo == null) return true;
        if(rootOne == null || rootTwo == null) return false;
        return isStructurallyIdentical(rootOne.left, rootTwo.right) &&
                isStructurallyIdentical(rootOne.right, rootTwo.right);
    }
    public static void main(String[] args) {
        Node rootOne = new Node(1);
        rootOne.left = new Node(2);
        rootOne.right = new Node(3);
        rootOne.left.left = new Node(4);
        rootOne.left.right = new Node(5);
        rootOne.right.left = new Node(6);
        rootOne.right.right = new Node(7);

        Node rootTwo = new Node(1);
        rootTwo.left = new Node(2);
        rootTwo.right = new Node(3);
        rootTwo.left.left = new Node(4);
        rootTwo.left.right = new Node(5);
        rootTwo.right.left = new Node(6);
        rootTwo.right.right = new Node(7);

        TwoBTStructurallyIdentical twoBTStructurallyIdentical = new TwoBTStructurallyIdentical();
        System.out.println(twoBTStructurallyIdentical.isStructurallyIdentical(rootOne, rootTwo));
    }
}
