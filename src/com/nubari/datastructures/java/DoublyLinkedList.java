package com.nubari.datastructures.java;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

// all remove returns T
public class DoublyLinkedList<T> implements Iterable<T> {
    private static class Node<T> {
        T data;
        Node<T> previous;
        Node<T> next;

        public Node(T data, Node<T> previous, Node<T> next) {
            this.data = data;
            this.previous = previous;
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    private int size = 0;
    private Node<T> head = null;
    private Node<T> tail = null;


    public void clear() {
        Node<T> current = head.next;
        while (current.next != null) {
            current.previous = null;
            current = current.next;
        }
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void add(T value) {
        addLast(value);
    }

    public void addFirst(T value) {
        if (isEmpty()) {
            Node<T> newNode = new Node<T>(value, null, null);
            head = newNode;
            tail = newNode;
            return;
        }
        Node<T> newNode = new Node<>(value, null, head);
        head.previous = newNode;
        head = newNode;
        size++;
    }

    public void addLast(T value) {
        if (isEmpty()) {
            Node<T> newNode = new Node<T>(value, null, null);
            head = newNode;
            tail = newNode;
            return;
        }
        Node<T> newNode = new Node<>(value, tail, null);
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public T peekFirst() {
        if (isEmpty()) {
            throw new RuntimeException("Empty list");
        }
        return head.data;
    }

    public T peekLast() {
        if (isEmpty()) {
            throw new RuntimeException("Empty list");
        }
        return tail.data;
    }

    public T removeFirst() {
        if (isEmpty()) {
            throw new RuntimeException("Empty list");
        }
        T data = head.data;
        head = head.next;
        head.previous = null;
        return data;
    }

    public T removeLast() {
        if (isEmpty()) {
            throw new RuntimeException("Empty list");
        }
        T data = tail.data;
        tail = tail.previous;
        tail.next = null;
        return data;
    }

    public T remove(Node<T> node) {
        if (node.previous == null) {
            return removeFirst();
        }
        if (node.next == null) {
            return removeLast();
        }

        Node<T> previousNode = node.previous;
        Node<T> nextNode = node.next;
        previousNode.next = nextNode;
        nextNode.previous = previousNode;
        T data = node.data;
        node = null;
        return data;
    }

    public T removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        }
        if (index == 0) {
            return removeFirst();
        }
        if (index == size - 1) {
            return removeLast();
        }
        int counter = 1;
        Node<T> current = head.next;
        while (current.next != null) {
            if (counter == index) {
                return remove(current);
            }
            current = current.next;
            counter++;
        }
        return null;
    }

    public boolean remove(Object value) {
        Node<T> current = head;
        while (current.next != null) {
            // support searching for null
            if (value == null) {
                if (current.data == null) {
                    remove(current);
                    return true;
                }
            } else {
                if (current.data.equals(value)) {
                    remove(current);
                    return true;
                }
            }
            current = current.next;
        }
        return false;
    }

    public int indexOf(T value) {
        if (value.equals(head.data)) {
            return 0;
        }
        if (value.equals(tail.data)) {
            return size() - 1;
        }
        int index = 1;
        Node<T> current = head.next;
        while (current.next != null) {
            if (current.data.equals(value)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public boolean contains(T value) {
        if (value.equals(head.data)) {
            return true;
        }
        if (value.equals(tail.data)) {
            return true;
        }
        Node<T> current = head.next;
        while (current.next != null) {
            if (current.data.equals(value)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }


    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current.next != null;
            }

            @Override
            public T next() {
                T data = current.data;
                current = current.next;
                return data;

            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        Node<T> current = head;
        while (current != null) {
            sb.append(current.data).append(", ");
            current = current.next;
        }
        sb.append(" ]");
        return sb.toString();
    }


}
