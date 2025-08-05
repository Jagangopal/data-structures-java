package src.main.ds.lists;

public class ReverseLinkedList {
    public Node reverseList(Node listNode){
        Node curr = listNode, prev = null, next = null;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args){
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        Node list1 = new Node(1);
        list1.next = new Node(7);
        list1.next.next = new Node(6);
        list1.next.next.next = new Node(12);
        list1.next.next.next.next = new Node(3);

        Node resultNode = reverseLinkedList.reverseList(list1);
        while(resultNode != null){
            System.out.println(resultNode.data);
            resultNode = resultNode.next;
        }
    }
}
