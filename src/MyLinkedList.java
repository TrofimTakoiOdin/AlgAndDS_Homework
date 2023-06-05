public class MyLinkedList {
    static Node head;

    static class Node {

        int data;
        Node next;

        Node(int d)
        {
            data = d;
            next = null;
        }
    }


    Node reverse(Node node)
    {
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }


    void printList(Node node)
    {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public int Size(Node head) {

        Node h = head;
        int counter = 1;
        if (h == null) {
            return 0;
        }
        else{

            while (h.next != null) {
            counter += 1;
            h = h.next;
            }
        }

        return counter;
    }

    public boolean Contains(int value, Node head, int ListSize) {
        Node h = head;
        for (int i = 0; i < ListSize; i++) {
            if (h.data == value){
                return true;
            }
            h = h.next;
        }
        return false;
    }
    public static void main(String[] args)
    {
        MyLinkedList list = new MyLinkedList();
        head = new Node(85);
        head.next = new Node(15);
        head.next.next = new Node(4);
        head.next.next.next = new Node(20);

        System.out.println("Дан односвязный список: ");
        list.printList(head);
        head = list.reverse(head);
        System.out.println();
        System.out.println("Односвязный список после разворота: ");
        list.printList(head);
        int listSize = list.Size(head);
        System.out.println();
        System.out.println("Размер односвязного списка: " + listSize);

        boolean isHere = list.Contains(0, head, listSize);
        System.out.println("Проверка на наличие элемента: ");
        System.out.println(isHere);
    }
}
