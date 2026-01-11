package src.main.ds.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Node{
    int data;
    Node next;
    public Node(int data){
        this.data = data;
        next = null;
    }
}
public class MergeKSortedLists {
    /**
     * Time Complexity: O(n log k)
     * Space Complexity: O(log k)
     * @param arr
     * @return
     */
    static Node mergeKLists(List<Node> arr) {
        Queue<Node> heap = new PriorityQueue<>((a,b) -> (a.data - b.data));
        for(Node node: arr)
            heap.add(node);
        Node dummy = new Node(-1);
        Node tail = dummy;
        while(!heap.isEmpty()){
            Node top = heap.poll();
            tail.next = top;
            tail = top;
            if(top.next != null)
                heap.add(top.next);
        }
        return dummy.next;
    }
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public static void main(String[] args){
        int k = 3;

        List<Node> arr = new ArrayList<>();

        arr.add(new Node(1));
        arr.get(0).next = new Node(3);
        arr.get(0).next.next = new Node(5);
        arr.get(0).next.next.next = new Node(7);

        arr.add(new Node(2));
        arr.get(1).next = new Node(4);
        arr.get(1).next.next = new Node(6);
        arr.get(1).next.next.next = new Node(8);

        arr.add(new Node(0));
        arr.get(2).next = new Node(9);
        arr.get(2).next.next = new Node(10);
        arr.get(2).next.next.next = new Node(11);

        Node head = mergeKLists(arr);

        printList(head);
    }
}
