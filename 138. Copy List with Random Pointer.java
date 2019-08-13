/*
A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list.

Example 1:

Input:
{"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}

Explanation:
Node 1's value is 1, both of its next and random pointer points to Node 2.
Node 2's value is 2, its next pointer points to null and its random pointer points to itself.
*/
/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node copyHead = new Node();
        Node cur = head;
        Node copy = copyHead;
        while (cur != null) {
            //cur is current node, copy is the copy of the current node
            //map contains a mapping between cur and copy
            copy.next = new Node(cur.val, cur.next, cur.random);
            copy = copy.next;
            map.put(cur, copy);
            cur = cur.next;
        }
        cur = copyHead;
        // through the list and substitute old random references with new ones.
        while (cur != null) {
            if (cur.random != null) cur.random = map.get(cur.random);
            cur = cur.next;
        }
        return copyHead.next;
    }
}