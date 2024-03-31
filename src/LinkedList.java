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
        }
        else {
            int counter=0;
            while (head != null && head.data == value) {
                head = head.next;
                counter++;
            }
            if (head==null){
                size-=counter;
                return;
            }
            Node current = head;
            while (current.next != null){
                while (current.next.data==value){
                    counter++;
                    current.next=current.next.next;
                    if (current.next==null){
                        break;
                    }
                }
                if (current.next!=null){
                    current=current.next;
                }
            }
            if (counter == 0){
                System.out.println("Nie ma takiej wartości w liście");
                return;
            }
            size-=counter;
        }
    }

    public boolean search(int value){
        Node currNode = head;
        while (currNode != null) {
            if (currNode.data == value) {
                return true;
            }
            currNode = currNode.next;
        }
        return false;
    }


    public void print() {
        Node currNode = head;

        System.out.print("LinkedList: [");

        while (currNode != null) {
            if (currNode.next!=null){
                System.out.print(currNode.data + ", ");
            }
            else {
                System.out.print(currNode.data);
            }
            currNode = currNode.next;
        }
        System.out.print("]");
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
