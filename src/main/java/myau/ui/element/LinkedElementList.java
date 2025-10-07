package myau.ui.element;

import javafx.util.Pair;
import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

// 这是一个 -> 方向的链表，但是 LinkedElement 的链接是 <- 方向
public class LinkedElementList implements Iterable<LinkedElement> {

    private final Node head;

    private int size = 0;

    private final IndexIterable indexIterable;

    public LinkedElementList(LinkedElement head) {
        this.head = new Node(head);
        indexIterable = new IndexIterable();
    }

    public LinkedElementList() {
        this(null);
    }

    public void add(LinkedElement element, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        Node prev = head;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        Node node = new Node(element);
        node.next = prev.next;
        prev.next = node;

        // link
        node.element.prev = prev.element;

        size++;
    }

    public void add(LinkedElement element) {
        add(element, size);
    }

    public LinkedElement get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node prev = head;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        return prev.next.element;
    }

    public void clear() {
        Node node = head.next;
        while (node != null) {
            Node temp = node.next;
            node.next = null;
            node = temp;
        }
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isNotEmpty() {
        return !isEmpty();
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head.next;
        while (current != null) {
            sb.append(current.toString());
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }

        return sb.toString();
    }

    @Override
    public @NotNull Iterator<LinkedElement> iterator() {
        return new Itr();
    }

    public Iterable<Pair<Integer, LinkedElement>> withIndex() {
        return indexIterable;
    }

    private class IndexIterable implements Iterable<Pair<Integer, LinkedElement>> {

        @Override
        public @NotNull Iterator<Pair<Integer, LinkedElement>> iterator() {
            return new IndexItr();
        }

        private class IndexItr implements Iterator<Pair<Integer, LinkedElement>> {
            private int index = 0;
            private Node current = head;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public Pair<Integer, LinkedElement> next() {
                current = current.next;
                return new Pair<>(index++, current.element);
            }
        }
    }

    private class Itr implements Iterator<LinkedElement> {
        private int index = 0;
        private Node current = head;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public LinkedElement next() {
            current = current.next;
            index++;
            return current.element;
        }
    }

    private static class Node {
        private Node next;
        private final LinkedElement element;

        Node(LinkedElement element) {
            this.element = element;
        }
    }
}
