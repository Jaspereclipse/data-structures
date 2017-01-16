import org.apache.commons.lang3.ArrayUtils;

import java.lang.Math;
import java.util.Arrays;

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
        items = (Item[]) new Object[Math.max(2, maxSpan)];
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }
    @Override
    public void addFirst(Item item){
        if (size == items.length) { resize(); }
        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size += 1;
    }
    @Override
    public void addLast(Item item){
        if (size == items.length) { resize(); }
        items[nextLast] = item;
        nextLast = addOne(nextLast);
        size += 1;
    }
    @Override
    public boolean isEmpty(){ return (size == 0); }
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
            return null;
        }
        nextFirst = addOne(nextFirst);
        Item item = items[nextFirst];
        items[nextFirst] = null;
        size -= 1;
        return item;
    }
    @Override
    public Item removeLast(){
        if (isEmpty()) {
            return null;
        }
        nextLast = minusOne(nextLast);
        Item item = items[nextLast];
        items[nextLast] = null;
        size -= 1;
        return item;
    }
    @Override
    public Item get(int index){
        if (index > size - 1 || isEmpty()){ return null; }
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
    // Not get point, why you need to mode the length.
    private int addOne(int index){
        return (index + 1) % items.length;
    }
    private void align() {
        int first = addOne(nextFirst);
        int last = minusOne(nextLast);
        if (last - first == size - 1) { return; }
        items = ArrayUtils.addAll(Arrays.copyOfRange(items, first, size),
                Arrays.copyOfRange(items, 0, first));
    }
    private void resize(){
        align();
        items = Arrays.copyOf(items, size*2);
        nextFirst = items.length - 1;
        nextLast = size;
    }
}
