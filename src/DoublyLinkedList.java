public class DoublyLinkedList {
    public static int size = 0;
    public static int howLess;
    Node head;
    Node tail;
    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data)
        {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    public void add(int index, int value){
        Node newNode = new Node(value);
        if(head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            Node current = head;
            if (index == 0){
                current.prev = newNode;
                newNode.next=current;
                head=newNode;
            }
            else {
                int i = 1;
                while (i != index && current.next != null){
                    current = current.next;
                    i++;
                }
                if (current.next != null){
                    current.next.prev=newNode;
                }
                newNode.next=current.next;
                newNode.prev=current;
                current.next=newNode;
                if (newNode.next==null){
                    tail=newNode;
                }
            }
        }
        size++;
    }
    public void remove(int value){
        if (head == null){
            System.out.println("Lista jest pusta");
        }
        else {
            Node current = head;

            int counter = 0;
            while (current!=null){
                if (current.data == value){
                    if (current.prev == null && current.next == null){
                        head = null;
                        tail = null;
                        size--;
                        counter++;
                    }
                    else if (current.prev == null){
                        current.next.prev=null;
                        head=current.next;
                        size--;
                        counter++;
                    } else if (current.next == null) {
                        current.prev.next=null;
                        tail=current.prev;
                        size--;
                        counter++;
                    } else {
                        current.prev.next = current.next;
                        current.next.prev = current.prev;
                        size--;
                        counter++;
                    }
                }
                current = current.next;
            }
            if (counter==0){
                System.out.println("Nie ma takiej liczby w zbiorze");
            }

        }
    }
    public void removeFromEnd(int value){
        if (head == null){
            System.out.println("Lista jest pusta");
        }
        else {
            Node current = tail;

            int counter = 0;
            while (current!=null){
                if (current.data == value){
                    if (current.prev == null && current.next == null){
                        head = null;
                        tail = null;
                        size--;
                        counter++;
                    }
                    else if (current.next == null){
                        current.prev.next = null;
                        tail=current;
                        size--;
                        counter++;
                    }else if (current.prev == null){
                        current.next.prev=null;
                        head = current.next;
                        size--;
                        counter++;
                    }
                    else {
                        current.prev.next = current.next;
                        current.next.prev = current.prev;
                        size--;
                        counter++;
                    }
                }
                current = current.prev;
            }
            if (counter==0){
                System.out.println("Nie ma takiej liczby w zbiorze");
            }
        }
    }
    public void search(int value){
        Node current = head;
        while(current != null){
            if (current.data==value){
                System.out.println("Liczba znajduje się w zbiorze");
                return;
            }
            current=current.next;
        }
        System.out.println("Liczba nie znajduje się w zbiorze");
    }
    public void print() {
        Node currNode = head;

        System.out.print("DoublyLinkedList: [");

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
}