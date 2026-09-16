class Solution {
    public ArrayList<Integer> serialize(Node root) {
        ArrayList<Integer> arr = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();

        if (root == null)
            return arr;

        q.add(root);

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (node == null) {
                arr.add(-1);
                continue;
            }

            arr.add(node.data);
            q.add(node.left);
            q.add(node.right);
        }

        while (!arr.isEmpty() && arr.get(arr.size() - 1) == -1)
            arr.remove(arr.size() - 1);

        return arr;
    }

    public Node deSerialize(ArrayList<Integer> arr) {
        if (arr.isEmpty() || arr.get(0) == -1)
            return null;

        Node root = new Node(arr.get(0));
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        int i = 1;

        while (!q.isEmpty() && i < arr.size()) {
            Node node = q.poll();

            if (arr.get(i) != -1) {
                node.left = new Node(arr.get(i));
                q.add(node.left);
            }
            i++;

            if (i < arr.size() && arr.get(i) != -1) {
                node.right = new Node(arr.get(i));
                q.add(node.right);
            }
            i++;
        }

        return root;
    }
}