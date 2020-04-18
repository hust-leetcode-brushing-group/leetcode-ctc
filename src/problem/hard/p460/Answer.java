package problem.hard.p460;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 460. LFU缓存
 * https://leetcode-cn.com/problems/lfu-cache/
 */
public class Answer {
    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2 /* capacity (缓存容量) */);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // 返回 1
        cache.put(3, 3);    // 去除 key 2
        System.out.println(cache.get(2));       // 返回 -1 (未找到key 2)
        System.out.println(cache.get(3));       // 返回 3
        cache.put(4, 4);    // 去除 key 1
        System.out.println(cache.get(1));       // 返回 -1 (未找到 key 1)
        System.out.println(cache.get(3));       // 返回 3
        System.out.println(cache.get(4));       // 返回 4
    }
}

class Node implements Comparable<Node> {
    public int key, value;
    public int freq;
    public long time;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        freq = 1;
        this.time = System.nanoTime();
    }

    @Override
    public int compareTo(Node o) {
        return this.freq != o.freq ? (this.freq - o.freq) : (int) (this.time - o.time);
    }
}

/**
 * 使用堆来维护
 */
class LFUCache {

    private Map<Integer, Node> items;
    private PriorityQueue<Node> heap;
    public int capacity;

    public LFUCache(int capacity) {
        items = new HashMap<>(capacity);
        if (capacity > 0)
            heap = new PriorityQueue<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        Node n = items.get(key);
        if (n != null) {
            n.freq++;
            n.time = System.nanoTime();

            // 重点！！！只有破坏堆的结构才能使它更新
            heap.remove(n);
            heap.add(n);
            return n.value;
        } else return -1;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        Node n = items.get(key);
        if (n != null) {
            n.value = value;
            n.freq++;
            n.time = System.nanoTime();
            // 重点！！！
            heap.remove(n);
            heap.add(n);
        } else {
            if (items.size() >= capacity) {
                Node rm = heap.remove();
                items.remove(rm.key);
                System.out.println("remove:" + rm.key + " time " + rm.time + " freq " + rm.freq);
            }
            n = new Node(key, value);
            items.put(key, n);
            heap.add(n);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */