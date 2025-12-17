package src.main.ds.lists;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoLists {
    /**
     * Time Complexity: O(n + m)
     * Space Complexity: O(1)
     * @param list1
     * @param list2
     * @return
     */
    public Node mergeTwoLinkedLists(Node list1, Node list2){
        Node dummy = new Node(-1);
        Node prev = dummy;
        while(list1 != null && list2 != null){
            if(list1.data < list2.data){
                prev.next = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                list2 = list2.next;
            }
            prev = prev.next;
        }
        prev.next = (list1 == null)? list2: list1;
        return dummy.next;
    }

    public static void main(String[] args){
        MergeTwoLists mergeTwoLists = new MergeTwoLists();
        Node list1 = new Node(1);
        list1.next = new Node(2);

        Node list2 = new Node(3);
        list2.next = new Node(4);

        Node result = mergeTwoLists.mergeTwoLinkedLists(list1, list2);
        while(result != null){
            System.out.println(result.data);
            result = result.next;
        }
    }
}
