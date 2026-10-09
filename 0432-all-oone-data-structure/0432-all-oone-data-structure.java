import java.util.*;

class AllOne {

    private class Node {
        int count;
        Set<String> keys;
        Node prev, next;

        Node(int count) {
            this.count = count;
            this.keys = new HashSet<>();
        }
    }

    private Node head, tail;
    private Map<String, Node> map;

    public AllOne() {
        head = new Node(0);
        tail = new Node(0);

        head.next = tail;
        tail.prev = head;

        map = new HashMap<>();
    }

    public void inc(String key) {
        if (!map.containsKey(key)) {
            if (head.next == tail || head.next.count != 1) {
                Node node = new Node(1);
                insertAfter(head, node);
            }

            head.next.keys.add(key);
            map.put(key, head.next);
        } else {
            Node current = map.get(key);
            Node next = current.next;

            if (next == tail || next.count != current.count + 1) {
                Node node = new Node(current.count + 1);
                insertAfter(current, node);
                next = node;
            }

            next.keys.add(key);
            map.put(key, next);

            current.keys.remove(key);

            if (current.keys.isEmpty()) {
                remove(current);
            }
        }
    }

    public void dec(String key) {
        Node current = map.get(key);

        if (current.count == 1) {
            current.keys.remove(key);
            map.remove(key);

            if (current.keys.isEmpty()) {
                remove(current);
            }
        } else {
            Node prev = current.prev;

            if (prev == head || prev.count != current.count - 1) {
                Node node = new Node(current.count - 1);
                insertAfter(current.prev, node);
                prev = node;
            }

            prev.keys.add(key);
            map.put(key, prev);

            current.keys.remove(key);

            if (current.keys.isEmpty()) {
                remove(current);
            }
        }
    }

    public String getMaxKey() {
        if (tail.prev == head) {
            return "";
        }

        return tail.prev.keys.iterator().next();
    }

    public String getMinKey() {
        if (head.next == tail) {
            return "";
        }

        return head.next.keys.iterator().next();
    }

    private void insertAfter(Node prev, Node node) {
        node.next = prev.next;
        node.prev = prev;

        prev.next.prev = node;
        prev.next = node;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
} 