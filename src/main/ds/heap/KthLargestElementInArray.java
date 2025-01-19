package src.main.ds.heap;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInArray {
    /**
     * Time Complexity: O(n log(k))
     * Space Complexity: O(n)
     * @param inputArray
     * @param k
     * @return
     */
    public int findKthElement(int[] inputArray, int k){
        Queue<Integer> heap = new PriorityQueue<>();
        for(int value:inputArray){
            heap.add(value);
            if(heap.size() > k){
                heap.poll();
            }
        }
        return heap.peek();
    }
    public static void main(String[] args){
        int[] inputArray = {3,2,1,5,6,4};
        int k = 2;
        KthLargestElementInArray kthLargestElementInArray = new KthLargestElementInArray();
        int result = kthLargestElementInArray.findKthElement(inputArray, k);
        System.out.println(result);
    }
}
