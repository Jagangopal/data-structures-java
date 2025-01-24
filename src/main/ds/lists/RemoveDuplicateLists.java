package src.main.ds.lists;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateLists {

    public Node removeDuplicatesFromList(Node listNode){
        Set<Integer> hashSet = new HashSet<>();
        Node dummy = new Node(-1);
        Node prev = dummy;

        while(listNode != null){
            if(hashSet.contains(listNode.data)){
                prev.next = listNode.next;
            } else{
                hashSet.add(listNode.data);
                prev.next = listNode;
                prev = listNode;
            }
            listNode = listNode.next;
        }
        return dummy.next;
    }

    public static void main(String[] args){
        RemoveDuplicateLists removeDuplicateLists = new RemoveDuplicateLists();
        Node list1 = new Node(1);
        list1.next = new Node(2);
        list1.next.next = new Node(2);
        list1.next.next.next = new Node(2);
        list1.next.next.next.next = new Node(3);

        Node resultNode = removeDuplicateLists.removeDuplicatesFromList(list1);
        while(resultNode != null){
            System.out.println(resultNode.data);
            resultNode = resultNode.next;
        }
    }
}
