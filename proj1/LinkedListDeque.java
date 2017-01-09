import sun.plugin2.applet.context.NoopExecutionContext;

import javax.xml.ws.WebEndpoint;

/**
 * Created by juanyan.li on 1/8/17.
 */
public class LinkedListDeque<Item> extends Deque<Item>{
    public class Node {
        public Item item;
        public Node prev;
        public Node next;
        public Node(Item item, Node prev, Node next){
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node sentinel;
    private int size;

    public LinkedListDeque(){
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    @Override
    public void addFirst(Item item){
        Node first = new Node(item, sentinel, sentinel.next);
        sentinel.next = first;
        first.next.prev = first;
        size += 1;
    }

    @Override
    public void addLast(Item item){
        Node last = new Node(item, sentinel.prev, sentinel);
        sentinel.prev.next = last;
        sentinel.prev = last;
        size += 1;
    }

    @Override
    public boolean isEmpty(){
        if (size > 0){
            return false;
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque(){
        if (isEmpty()){
            return;
        }
        Node current = sentinel.next;
        while (current != sentinel){
            System.out.print(current.item + " ");
            current = current.next;
        }
    }

    @Override
    public Item removeFirst(){
        if (isEmpty()) {
            System.out.println("Deque already empty!");
            return null;
        }
        Item item = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size -= 1;
        return item;
    }

    @Override
    public Item removeLast(){
        if (isEmpty()) {
            System.out.println("Deque already empty!");
            return null;
        }
        Item item = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        return item;
    }

    @Override
    public Item get(int index) {
        if (index > size - 1 || isEmpty()){
            return null;
        } else if (index >= size / 2){
            int i = 0;
            Node current = sentinel;
            while (i < size - index){
                current = current.prev;
                i += 1;
            }
            return current.item;
        } else {
            int i = 0;
            Node current = sentinel;
            while (i <= index){
                current = current.next;
                i += 1;
            }
            return current.item;
        }

    }
}
