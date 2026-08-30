import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution {
    class pair{
        int node;
        int cost;

        public pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }
    public int spanningTree(int V, int[][] edges) {
        ArrayList<ArrayList<pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] i: edges){
            int from = i[0];
            int to = i[1];
            int cost = i[2];
            adj.get(to).add(new pair(from, cost));
            adj.get(from).add(new pair(to, cost));
        }
        PriorityQueue<pair> min = new PriorityQueue<>((a, b)-> a.cost-b.cost);
        int[] vis = new int[V];
        min.add(new pair(0, 0));
        int sum = 0;

        while (!min.isEmpty()){
            pair top = min.poll();
            int node = top.node;
            int cost = top.cost;
            if (vis[node]==1){
                continue;
            }
            vis[node] = 1;
            sum = sum + cost;
            for(pair p: adj.get(node)){
                int newNode = p.node;
                int newCost = p.cost;
                if (vis[newNode]==1){
                    continue;
                }
                min.add(new pair(newNode, newCost));
            }
        }

        return sum;
    }
}
