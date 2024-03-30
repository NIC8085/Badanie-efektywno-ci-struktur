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
    public void add(int index, int value){
        Node newNode = new Node(value);
        if(head == null){
            head = newNode;
        }
        else {
            Node current = head;
            if (index == 0){
                head = newNode;
                head.next = current;
            }
            else {
                int i = 1;
                while (i != index && current.next != null){
                    current = current.next;
                    i++;
                }
                if (current.next == null){
                    current.next = newNode;
                }
                else {
                    newNode.next = current.next;
                    current.next = newNode;
                }
            }
        }
        size++;
    }
    public void remove(int value){
        if(head == null) {
            System.out.println("Lista jest pusta");
            return;
        }
        while (head != null && head.data == value) {
            head = head.next;
            size--;
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
            return;
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
        if (isThere){
            System.out.println("Liczba znaduje się w liście");
        }
        else {
            System.out.println("Ta liczba nie znajduje się w zbiorze");
        }
    }

    public void print() {
        Node currNode = head;

        System.out.print("LinkedList: ");
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
    }

    public int get(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Indeks poza zakresem");
        }
        else {
            Node current = head;
            int i = 0;
            while (i != index){
                current = current.next;
                i++;
            }
            return current.data;
        }
    }


}
