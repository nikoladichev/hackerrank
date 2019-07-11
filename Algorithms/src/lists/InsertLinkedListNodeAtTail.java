package lists;


/**
 * https://www.hackerrank.com/challenges/insert-a-node-at-the-tail-of-a-linked-list/problem
 */
public class InsertLinkedListNodeAtTail {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;

        public SinglyLinkedList() {
            this.head = null;
        }


    }

    public static void main(String[] args) {

        int[] case1 = {5, 141, 302, 164, 530, 474};

        SinglyLinkedList llist = new SinglyLinkedList();
        for (int i: case1) {
            SinglyLinkedListNode llist_head = insertNodeAtTail(llist.head, i);
            llist.head = llist_head;
        }




    }

    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {

        SinglyLinkedListNode node;
        if (head == null) {
            node = new SinglyLinkedListNode(data);
            return node;
        }

        node = head;

        while (node.next != null) {
            node = node.next;
        }

        node.next = new SinglyLinkedListNode(data);

        return head;
    }
}
