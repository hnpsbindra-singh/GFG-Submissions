class Solution {
    class pair{
        int node;
        int cost;

        public pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        ArrayList<ArrayList<pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] i: edges) {
            int from = i[0];
            int to = i[1];
            int cost = i[2];
            adj.get(from).add(new pair(to, cost));
            adj.get(to).add(new pair(from, cost));
        }
        int city = 999;
        int min = 999;

        for (int i = 0; i < n; i++) {
            int[] dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);
            int count = 0;
            PriorityQueue<pair> q = new PriorityQueue<>((a, b)-> a.cost- b.cost);
            q.add(new pair(i, 0));
            dist[i] = 0;
            while (!q.isEmpty()){
                pair top = q.poll();
                int node = top.node;
                int cost = top.cost;
                for(pair p: adj.get(node)){
                    int newNode = p.node;
                    int newCost = p.cost + cost;
                    if (dist[newNode]> newCost){
                        dist[newNode] = newCost;
                        q.add(new pair(newNode, newCost));
                    }
                }
            }
            for (int j = 0; j < n; j++) {
                if (j!=i&&dist[j]<=distanceThreshold){
                        count++;
                }

            }
            if (count<=min){
                min = count;
                city  = i;
            }


        }
        return city;

    }
    public int findCity(int n, int[][] edges, int dis) {
        return findTheCity(n, edges, dis);
        
    }
}