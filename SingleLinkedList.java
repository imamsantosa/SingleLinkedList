public class SingleLinkedList {
    /**
     * class node
     */
    class Node {
        int Element;
        Node next;

        public Node(int Element, Node next) {
            this.Element = Element;
            this.next = next;
        }
        
    }
    
    protected Node tail = null;
    protected Node head = null;
    protected int size = 0;
    
    /**
     * to check SLL is Empty
     * @return true/false
     */    
    public boolean isEmpty(){
        return size == 0;
    }
    
    /**
     * to get size atribute
     * @return 
     */
    public int getSize(){
        return size;
    }
    
    /**
     * create new node to first SLL
     * @param newElement 
     */
    public void addFirst(int newElement){
        head = new Node(newElement, head);
        if (isEmpty()) {
            tail=head;
        }
        size++;
    }
    
    /**
     * create new node to last SLL
     * @param newElement 
     */
    public void addLast(int newElement){
        if (isEmpty()) {
            addFirst(newElement);
            return;
        }
        tail.next = new Node(newElement, null);
        tail = tail.next;
        size++;
    }
    
    /**
     * create new node after node Element
     * @param Element
     * @param newElement 
     */
    public void add(int Element, int newElement){
        if (isEmpty()) {
            addFirst(newElement);
            return;
        }
        Node pointer = head; 
        while(pointer.Element != Element && pointer.next != null){
            pointer = pointer.next;
        }
        if (pointer.Element == Element) {
            pointer.next = new Node(newElement, pointer.next);
            size++;
        } 
    }
    
    /**
     * remove first node
     */
    public void removeFirst(){
        if (isEmpty()) {
            return;
        }
        head = head.next;
        size--;
    }
    
    /**
     * remove last node
     */
    public void removeLast(){
        if (size < 2) {
            removeFirst();
        }
        int counter = size;
        Node pointer = head;
        while(counter != 2){
            pointer = pointer.next;
            counter--;
        }
        tail = pointer;
        size--;
    }
    
    /**
     * remove node element
     * @param Element 
     */
    public void remove(int Element){
        if (isEmpty()) {
            return;
        }
        Node pointer1 = head;
        while(pointer1 != null){
            if(pointer1.Element == Element){
                break;
            }
            pointer1 = pointer1.next;
        }
        if(pointer1 == null){
            return;
        } else if (pointer1 == head || size == 1) {
            removeFirst();
            return;
        }
        
        Node pointer2 = head;
        while(pointer2.next != pointer1){
            pointer2 = pointer2.next;
        }
        pointer2.next = pointer1.next;
        size--;
    }
    
    /**
     * join two SLL into one SLL
     * @param L1
     * @param L2
     * @return 
     */
    public static SingleLinkedList Join(SingleLinkedList L1, SingleLinkedList L2){
        SingleLinkedList result = new SingleLinkedList();
        Node temp1 = L1.head;
        while(temp1 != null){
            result.addLast(temp1.Element);
            temp1 = temp1.next;
        }
        Node temp2 = L2.head;
        while(temp2 != null){
            result.addLast(temp2.Element);
            temp2 = temp2.next;
        }
        return result;
    }
    
    /**
     * print SLL node
     * @param comm 
     */
    public void print(String comm) {
        System.out.println(comm);
        
        Node temp = head;
        while (temp != null) {
            System.out.print( temp.Element+ "->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
}
