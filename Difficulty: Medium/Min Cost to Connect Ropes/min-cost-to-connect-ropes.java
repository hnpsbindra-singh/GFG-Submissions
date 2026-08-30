import java.util.PriorityQueue;

class Solution {
    public int minCost(int[] arr) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i: arr){
            minHeap.add(i);
        }
        int cost = 0;
        while (minHeap.size()>1){
            int a = minHeap.poll();
            int b = 0;
            if (!minHeap.isEmpty()){
                b = minHeap.poll();
            }
            int newCost = a+b;
            cost = cost+newCost;
            minHeap.add(newCost);
        }
        return cost;

    }
}