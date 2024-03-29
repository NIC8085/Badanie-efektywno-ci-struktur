public class DoublyLinkedList {
    public static int size = 0;
    Node head;
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

            while (true){
                if (current.data == value){
                    if (current.prev == null && current.next == null){
                        head = null;
                        size--;
                    }
                    else if (current.prev == null){
                        current.next.prev=null;
                        head=current.next;
                        size--;
                    }
                    else {
                        current.prev.next = current.next;
                        current.next.prev = current.prev;
                        size--;
                    }
                }
                current = current.next;
                if (current == null){
                    System.out.println("Nie ma takiej liczby w zbiorze");
                    return;
                }
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
    public void print(){
        Node current = head;
        System.out.println("DoublyLinkedList: ");
        while (current != null){
            System.out.println(current.data + " ");
            current = current.next;
        }
    }
}
