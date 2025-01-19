package src.main.ds.heap;

import java.util.*;

public class TopKthFrequentElements {

    public int[] topFrequentElements(int[] nums, int k) {
        if (k == nums.length) return nums;

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int value : nums) {
            countMap.put(value, countMap.getOrDefault(value, 0) + 1);
        }
        System.out.println(countMap.toString());

        Queue<Map.Entry<Integer,Integer>> heapCount = new PriorityQueue<>(
                (a, b) -> a.getValue().equals(b.getValue())?
                        Integer.compare(a.getValue(), b.getValue()):
                        Integer.compare(b.getValue(), a.getValue()));

        for(Map.Entry<Integer, Integer> keyValue: countMap.entrySet()){
            heapCount.add(keyValue);
        }
        System.out.println(heapCount.toString());

        int[] result = new int[k];
        for(int i=0;i<k;i++){
            result[i] = heapCount.poll().getKey();
        }
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
