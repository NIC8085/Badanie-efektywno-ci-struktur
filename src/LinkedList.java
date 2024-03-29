public class LinkedList {
    public static int size = 0;
    Node head;
    static class Node {

        int data;
        Node next;


        Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }
    // dodać dodawanie po indexie
    public void add(int value){
        if(head == null){
            head = new Node(value);
        }
        else {
            Node last = head;
            while (last.next != null) {
                last = head.next;
            }
            last.next = new Node(value);
        }
        size++;
    }
    public void remove(int value){
        while (head != null && head.data == value) {
            head = head.next;
            size--;
        }
        if(head == null) {
            System.out.println("Lista jest pusta");
            return;
        }
        Node current = head.next;
        Node prev = head;

        int counter=0;
        while (current != null){
            if (current.data == value){
                prev.next=current.next;
                current=current.next;
                counter++;
            }
            prev=current;
            current=current.next;
        }
        if (counter == 0){
            System.out.println("Nie ma takiej wartości w liście");
        }
        size-=counter;
    }

    public void search(int value){
        boolean isThere = false;
        Node currNode = head;
        while (currNode != null) {
            if (currNode.data == value) {
                isThere = true;
                break;
            }
            currNode = currNode.next;
        }
        if(isThere) System.out.println("Liczba znaduje się w liście");
        else System.out.println("Ta liczba nie znajduje się w zbiorze");
    }

    public void print() {
        Node currNode = head;

        System.out.print("LinkedList: ");
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
    }


}
