/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 /* capacity */ );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
*/

class LRUCache {
    class Node {
        int key;
        int value;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
        } 
    }
    List<Node> list;
    int capacity;
    public LRUCache(int capacity) {
        this.list = new LinkedList<Node>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        int newkey = -1;
        int res = -1;
        int index = -1;
        
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).key == key){
                newkey = key;
                res = list.get(i).value;
                index = i;
                break;
            }
        }
        if (index != -1){
            list.remove(index);
            list.add(0,new Node(newkey,res));
        }
        return res;
    }
    
    public void put(int key, int value) {
        boolean keyinlist = false;
        int index = 0; 
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).key == key){
                keyinlist = true;
                index = i;
                break;
            }
        }
        if (keyinlist == true){
            list.remove(index);
            list.add(0, new Node(key,value));
        }
        
        
        if (keyinlist == false){ //there is no such key in the list
            if (this.list.size() == this.capacity){
                list.remove(this.capacity-1);
            }
            list.add(0,new Node(key,value));
        } 
 
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */