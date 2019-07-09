package algocourse.lists;

import javax.xml.bind.Element;
import java.util.*;

public class CustomLinkedList<E> {

    private int[] arr = null;
    private Node<E> head;
    private int count;

    public CustomLinkedList() {
        head = null;
        count = 0;
    }

    public boolean contains(E e) {

        Node<E> node = new Node<>(e);

        Node<E> listElement = head;
        while (listElement.next != null) {

            if (listElement.next.equals(node)) {
                return true;
            }

            listElement = listElement.next;
        }

        return false;
    }

    public void add(E e) {

        Node<E> node = new Node<>(e);
        if (head == null) {
            head = node;
        } else {

            Node<E> tail = null;

            Node<E> listElement = head;
            while(listElement.next != null) {
                if (listElement.next == null) {
                    tail = listElement;
                }
                listElement = listElement.next;
            }

            tail.next = node;
        }

        count++;
    }

    public boolean remove(E e) {

        Node<E> elementToRemove = new Node<>(e);

//        if (!this.contains(elementToRemove)) throw new NoSuchElementException("Element not found");

        Node<E> listElement = head;
        while (listElement.next != null) {

            Node<E> nextElement = listElement.next;

            if (elementToRemove.equals(nextElement)) {

                listElement.next = nextElement.next;
                count--;
                return true;
            }
        }

        return false;
    }

    public int size() {
        return count;
    }

    private static class Node<E> {

        private E value;
        private Node<E> next;

        public Node(E value) {
            this.value = value;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?> node = (Node<?>) o;
            return Objects.equals(value, node.value);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }
    }


    public static void main(String[] args) {
        CustomLinkedList<Integer> myList = new CustomLinkedList<>();

        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);

        System.out.println(myList.count);

        myList.remove(3);

        System.out.println(myList.count);
    }
}
