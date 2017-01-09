import java.lang.Math;

/**
 * Created by juanyan.li on 1/8/17.
 */
public class ArrayDeque<Item> extends Deque<Item>{

    private Item[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque(){
        items = (Item[]) new Object[10];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }
    public ArrayDeque(int maxSpan){
        items = (Item[]) new Object[maxSpan];
        size = 0;
        nextFirst = 0;
        nextLast = Math.min(1, maxSpan-1);
    }
    @Override
    public void addFirst(Item item){
        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        increaseSizeByOne();
    }
    @Override
    public void addLast(Item item){
        items[nextLast] = item;
        nextLast = addOne(nextLast);
        increaseSizeByOne();
    }
    @Override
    public boolean isEmpty(){
        if (size > 0){
            return false;
        } else {
            return true;
        }
    }
    @Override
    public int size(){
        return size;
    }
    @Override
    public void printDeque(){
        if (isEmpty()){
            return;
        }
        int index = addOne(nextFirst);
        for (int i = 0; i < size; i += 1){
            System.out.print(items[index] + " ");
            index = addOne(index);
        }
    }
    @Override
    public Item removeFirst(){
        if (isEmpty()) {
            System.out.println("Deque already empty!");
            return null;
        }
        int first = addOne(nextFirst);
        Item item = items[first];
        items[first] = null;
        size -= 1;
        return item;
    }
    @Override
    public Item removeLast(){
        if (isEmpty()) {
            System.out.println("Deque already empty!");
            return null;
        }
        int last = minusOne(nextLast);
        Item item = items[last];
        items[last] = null;
        size -= 1;
        return item;
    }
    @Override
    public Item get(int index){
        if (index > size - 1 || isEmpty()){
            return null;
        }
        int first = addOne(nextFirst);
        return items[(first + index) % items.length];
    }
    private int minusOne(int index){
        if (index == 0){
            index = items.length-1;
        } else {
            index -= 1;
        }
        return index;
    }
    private int addOne(int index){
        return (index + 1) % items.length;
    }
    private void increaseSizeByOne() {
        size = Math.min(size + 1, items.length);
    }
}
