public class ArrayDeque<T> {
    private int size;
    private int capacity;
    private T[] newArray;

    public ArrayDeque(){
        size = 0;
        capacity = 8;
        newArray = new T[capacity];
    }

    public ArrayDeque(ArrayDeque other){
        size = other.size;
        capacity = other.capacity;
        T[] newArray = new T[capacity];
        System.arraycopy(newArray, 0, other, 0, size);
    }

    public void add(T item){
        if (size == capacity){
            capacity *= 2;
            T[] temp = new T[capacity];
            System.arraycopy(temp, 0, newArray, 0, size);
            newArray = temp;
        }
        newArray[size] = item;
        size += 1;
    }

    public T remove(){
        T returnItem = newArray[size-1];
        newArray[size-1] = null;
        size -= 1;
        return returnItem;
    }

    public T get(int index){
        return newArray[index];
    }

    public int size(){
        return size;
    }
}
