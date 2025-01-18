package src.main.ds.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class LastStoneWeight {
    /**
     * Time Complexity: O(nlog(n))
     * Space Complexity: O(n)
     * @param stones
     * @return
     */
    public int calculateLastStoneWeight(int[] stones){
        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i: stones){
            pq.add(i);
        }
        while(pq.size() > 1){
            int stoneOne = pq.remove();
            int stoneTwo = pq.remove();
            if(stoneOne != stoneTwo)
                pq.add(stoneOne - stoneTwo);
        }
        return pq.isEmpty()? 0: pq.peek();
    }

    public static void main(String[] args){
        int[] stones = {2,7,4,1,8,1};
        int[] stonesTwo = {1};
        LastStoneWeight lastStoneWeight = new LastStoneWeight();
        int result = lastStoneWeight.calculateLastStoneWeight(stonesTwo);
        System.out.println(result);
    }
}
