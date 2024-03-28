public class DoublyLinkedList {
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
            int i = 0;
            Node current = head;

            while (i != index){
                current=current.next;
                i++;
            }
            newNode.prev=current.prev;
            newNode.next=current;
            current.prev=newNode;
            if(newNode.prev==null){
                head=newNode;
            }
            else {
                newNode.prev.next=newNode;
            }
        }
    }
    public void print(){
        Node current = head;
        System.out.println("DoublyLinkedList: ");
        while (current!=null){
            System.out.println(current.data + " ");
            current = current.next;
        }
    }
}
