package src.main.ds.heap;

import java.util.*;

public class TopKthFrequentElements {
    /**
     * Find the k most frequent elements in the array
     * Time Complexity: O(N log N)
     * Space Complexity: O(N)
     * @param nums
     * @param k
     * @return
     */
    public int[] topFrequentElements(int[] nums, int k) {
        if(k == nums.length) return nums;
        Map<Integer, Integer> mapCount = new HashMap<>();
        for(int value: nums)
            mapCount.put(value, mapCount.getOrDefault(value, 0) + 1);
        System.out.println(mapCount);
        Queue<Map.Entry<Integer, Integer>> heapCount = new PriorityQueue<>(
                (a,b) -> a.getValue().equals(b.getValue())?
                            Integer.compare(a.getValue(), b.getValue()):
                            Integer.compare(b.getValue(), a.getValue())
        );
        for(Map.Entry<Integer, Integer> entry: mapCount.entrySet())
            heapCount.add(entry);
        System.out.println(heapCount);

        int[] result = new int[k];
        for(int i = 0; i <= k - 1; i++)
            result[i] = heapCount.poll().getKey();
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3,4,4,4,4,4};
        int k = 2;
        TopKthFrequentElements topKthFrequentElements = new TopKthFrequentElements();
        int[] result = topKthFrequentElements.topFrequentElements(nums, k);
        System.out.print(Arrays.toString(result));
    }
}
