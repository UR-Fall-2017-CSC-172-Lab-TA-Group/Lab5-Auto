import java.util.*;

public class URArrayList<E> implements URList<E>
{
    private E[] array;
    private static final int defaultSize = 10;
    private int maxSize;
    private int listSize;
    
    @SuppressWarnings("unchecked")
    URArrayList(int s) {
        maxSize = s;
        listSize = 0;
        array = (E[]) new Object[s];
    }
    
    @SuppressWarnings("unchecked")
    private void expand() {
        E[] temp = (E[]) new Object[array.length*2];
        for (int i = 0; i < array.length; i++)
        {
            temp[i] = array[i];
        }
        array = temp;
        maxSize = maxSize*2;
    }
    
    public void ensureCapacity(int minCapacity) {
        while (minCapacity > maxSize) { expand(); }
    }
    
    public int getCapacity() {
        return maxSize;
    }
    
    URArrayList() {
        this(defaultSize);
    }
    
    public Iterator<E> iterator() {
        return new Itr();
    }
    
    private class Itr implements Iterator<E> {
        int curr;
        public boolean hasNext() {
            return curr != listSize;
        }
        
        public E next() {
            E temp = (E) array[curr];
            curr++;
            return temp;
        }
    }
    
    public String toString() {
        Iterator it = iterator();
        String result = "";
        while (it.hasNext()) {
            result = result + "[" + it.next().toString() + "]" + " ";
        }
        return result;
    }
    
    public boolean add(E e) {
        if (listSize >= maxSize) {expand();}
        array[listSize++] = e;
        return true;
    }
    
    public void add(int index, E element) {
        if (listSize >= maxSize) {expand();}
        for (int i = listSize; i>index; i--) {
            array[i] = array[i-1];
        }
        array[index] = element;
        listSize++;
    }
    
    @SuppressWarnings("unchecked")
    public boolean addAll(Collection<? extends E> c) {
        if ((listSize+c.size() > maxSize)) {ensureCapacity(listSize+c.size());}
        Iterator it = c.iterator();
        while(it.hasNext()) {
            array[listSize] = (E) it.next();
            listSize++;
        }
        return true;
    }
    
    @SuppressWarnings("unchecked")
    public boolean addAll(int index, Collection<? extends E> c) {
        if ((listSize+c.size() > maxSize)) {ensureCapacity(listSize+c.size());}
        for (int i = listSize-1; i>=index; i--) {
            array[i+c.size()] = array[i];
        }
        Iterator it = c.iterator();
        while(it.hasNext()) {
            array[index] = (E) it.next();
            index++;
        }
        listSize = listSize + c.size();
        return true;
    }
    
    public void clear() {
        maxSize = defaultSize;
        listSize = 0;
        array = (E[]) new Object[defaultSize];
    }
    
    public boolean contains(Object o) {
        for (int i = 0; i < listSize; i++) {
            if (array[i].equals(o)) { return true; }
        }
        return false;
    }
    
    public boolean containsAll(Collection<?> c) {
        Iterator it = c.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) { return false; }
        }
        return true;
    }
    
    public boolean equals(Object o) {
        if (o == this) { return true; }
        if (!(o instanceof URList)) { return false; }
        Iterator it2 = ((URList) o).iterator();
        Iterator it1 = iterator();
        while (it1.hasNext() && it2.hasNext()) {
            E o1 = (E) it1.next();
            Object o2 = it2.next();
            if (!(o1.equals(o2))) {
                return false;
            }
        }
        return !(it1.hasNext() || it2.hasNext());
    }
    
    public E get(int index) {
        if (index<0 || index>=listSize) { return null; }
        return array[index];
    }
    
    public int indexOf(Object o) {
        for (int i = 0; i<listSize; i++) {
            if (array[i].equals(o)) {return i; }
        }
        return -1;
    }
    
    public boolean isEmpty() {
        if (listSize == 0) { return true; }
        return false;
    }
    
    public E remove(int index) {
        if (index<0 || index>=listSize) { return null; }
        E temp = array[index];
        for (int i = index; i<listSize-1; i++) {
            array[i] = array[i+1];
        }
        listSize--;
        return temp;
    }
    
    public boolean remove(Object o) {
        for (int i=0; i<listSize; i++) {
            if (array[i].equals(o)) {
                remove(i);
                return true;
            }
        }
        return false;
    }
    
    public boolean removeAll(Collection<?> c) {
        if (!containsAll(c)) { return false; }
        Iterator it = c.iterator();
        while(it.hasNext()) {
            remove(it.next());
        }
        return true;
    }
    
    public E set(int index, E element) {
        E temp = array[index];
        array[index] = element;
        return temp;
    }
    
    public int size() {
        return listSize;
    }
    
    public URList<E> subList(int fromIndex, int toIndex) {
        if (fromIndex<0) { fromIndex = 0; }
        if (toIndex > listSize) { toIndex = listSize-1; }
        URList sub = new URArrayList<E>();
        for (int i=fromIndex; i<toIndex; i++) {
            sub.add(get(i));
        }
        return sub;
    }
    
    public Object[] toArray() {
        Object[] result = new Object[listSize];
        for (int i=0; i<result.length; i++) {
            result[i] = array[i];
        }
        return result;
    }
}
