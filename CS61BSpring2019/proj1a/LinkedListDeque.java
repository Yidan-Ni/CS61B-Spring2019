import javax.swing.undo.UndoableEdit;

public class LinkedListDeque<T> {
    public class Node {
        public T item;
        public Node prev;
        public Node next;
        public Node(T v, Node p, Node n) {
            item = v;
            prev = p;
            next = n;
        }
    }

    private Node first;
    private Node last;
    private int size;

    public LinkedListDeque() {
        first = new Node(null, null, null);
        last = first;
        size = 0;
    }

    public LinkedListDeque(T x){
        first = new Node(x, null, null);
        last = first;
        size = 1;
    }

    public void addFirst(T item){
        Node newNode = new Node(item, null, first);
        first.prev = newNode;
        first = newNode;
        size += 1;
    }

    public void addLast(T item){
        Node newNode = new Node(item, last, null);
        last.next = newNode;
        last = newNode;
        size += 1;
    }

    public boolean isEmpty(){
        if(size != 0){
            return false;
        }
        return true;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        Node curr = first;
        while (curr != null){
            System.out.print(curr.item + " ");
            curr = curr.next;
        }
        System.out.print("\n");
    }

    public T removeFirst(){
        if (size == 1) {
            T returnItem = first.item;
            first.next = null;
            last.prev = null;
            size -= 1;
            return returnItem;
        }else if (size > 1){
            T returnItem = first.item;
            first = first.next;
            first.prev = null;
            size -= 1;
            return returnItem;
        }else{
            System.out.println("There is no element in the Deque");
            return null;
        }
    }

    public T removeLast(){
        if (size == 1) {
            T returnItem = last.item;
            first.next = null;
            last.prev = null;
            size -= 1;
            return returnItem;
        }else if (size > 1){
            T returnItem = last.item;
            last = last.prev;
            last.next = null;
            size -= 1;
            return returnItem;
        }else{
            System.out.println("There is no element in the Deque");
            return null;
        }
    }

    public T get(int index){
        Node curr = first;
        if(index > size-1){
            System.out.println("index is too big");
            return null;
        }
        for(int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.item;
    }
}
