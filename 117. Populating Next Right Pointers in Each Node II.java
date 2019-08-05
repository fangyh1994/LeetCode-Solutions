/*
Given a binary tree

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.



*/
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            Node currNode = null;
            for (int i = 0; i < size; i++) {
                if (currNode != null) {
                    currNode.next = q.poll();
                    currNode = currNode.next;
                } else {
                    currNode = q.poll();
                }
                if (currNode.left != null) q.offer(currNode.left);
                if (currNode.right != null) q.offer(currNode.right);
            }
            currNode.next = null;
        }
        return root;
    }
}