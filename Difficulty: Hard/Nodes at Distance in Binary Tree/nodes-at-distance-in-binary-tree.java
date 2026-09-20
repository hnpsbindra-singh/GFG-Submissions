import java.util.*;


class Solution {
    class pair{
        Node node;
        int dist;

        public pair(Node node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }
    void createParent(Node root, Map<Integer, Node> parent) {
        if (root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.left != null) {
                parent.put(node.left.data, node);
                q.add(node.left);
            }
            if (node.right != null) {
                parent.put(node.right.data, node);
                q.add(node.right);
            }
        }
    }

    public ArrayList<Integer> distanceK(Node root, Node target, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        Queue<pair> q = new LinkedList<>();
        Set<Integer> vis = new HashSet<>();
        Map<Integer, Node> parent = new HashMap<>();
        createParent(root, parent);
        q.add(new pair(target, 0));
        vis.add(target.data);
        while(!q.isEmpty()){
            pair top = q.poll();
            Node node = top.node;
            int dist = top.dist;
            if (dist==k){
                res.add(node.data);
                continue;
            }
            if (node.left!=null&&!vis.contains(node.left.data)){
                q.add(new pair(node.left, dist+1));
                vis.add(node.left.data);
            }
            if (node.right!=null&&!vis.contains(node.right.data)){
                q.add(new pair(node.right, dist+1));
                vis.add(node.right.data);
            }
            if(parent.get(node.data)!=null&&!vis.contains(parent.get(node.data).data)){
                Node node1 = parent.get(node.data);
                q.add(new pair(node1, dist+1));
                vis.add(node1.data);
            }

        }
        return res;
    }
    Node findNode(Node root, int data) {
        if (root == null) {
            return null;
        }
        if (root.data == data) {
            return root;
        }
        Node left = findNode(root.left, data);
        if (left != null) {
            return left;
        }
        return findNode(root.right, data);
    }
    public ArrayList<Integer> kDistanceNodes(Node root, int target, int k) {
        Node tgt = findNode(root, target);
        ArrayList<Integer> res =  distanceK(root, tgt, k);
        Collections.sort(res);
        return res;

    }
}