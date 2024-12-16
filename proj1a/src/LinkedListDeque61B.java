import java.util.List;

import java.util.ArrayList;

// import the ArrayList class

public class LinkedListDeque61B<T> implements Deque61B<T> {
    private Node sentinel;
    private int size;
    private T item;

    private class Node {
        public Node prev;
        public T item;
        public Node next;

        public Node(T item, Node prev, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }
    public LinkedListDeque61B() {
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    @Override
    public void addFirst(T x) {
        Node newNode = new Node(x, sentinel, sentinel.next);
        // sentinel.prev.next = newNode;
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        // newNode.prev = sentinel.prev;
        size += 1;
    }

    @Override
    public void addLast(T x) {
        Node newNode = new Node(x, sentinel.prev, sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        newNode.prev = sentinel.prev;
        size += 1;
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>(size);
        Node curr = sentinel.next;
        for (int i = 0; i < size; i++) {
            returnList.add(curr.item);
            curr = curr.next;
        }
        return returnList;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        } else {
            Node newNode = sentinel.next;
            sentinel = newNode;
            sentinel.next = newNode;
            sentinel.prev = newNode;
            size -= 1;
            return newNode.item;
        }
    }

    @Override
    public T removeLast() {
        Node newNode = sentinel.prev;
        if (size == 0) {
            return null;
        } else {
            sentinel = newNode;
            sentinel.next = newNode;
            sentinel.prev = newNode;
            size -= 1;
            return newNode.item;
        }
    }

    @Override
    public T get(int index) {
        Node curr = sentinel.next;
        if (index < 0 || index >= size) {
            return null;
        } else {
            for (int j = 0; j < index; j++) {
                curr = curr.next;
            }
            return curr.item;
        }
    }

    @Override
    public T getRecursive(int index) {
        Node curr = sentinel.next;
        if (index < 0 || index >= size) {
            return null;
        } else if (index == 0) {
            return curr.item;
        } else {
                curr = curr.prev;
                return getRecursive(index - 1);
        }
    }
}
