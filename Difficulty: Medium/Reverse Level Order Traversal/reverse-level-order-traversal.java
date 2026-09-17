

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class Solution {
    public List<Integer> reverseLevelOrder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root==null){
            return res;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            int c = q.size();
            for (int i = 0; i<c; i++){
                Node poll = q.poll();
                res.add(0, poll.data);
                if (poll.right!=null){
                    q.add(poll.right);
                }
                if (poll.left!=null){
                    q.add(poll.left);
                }

            }

        }
        return res;

    }
}