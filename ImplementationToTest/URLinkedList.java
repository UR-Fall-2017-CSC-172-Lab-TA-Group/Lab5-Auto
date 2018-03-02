import java.util.*;

public class URLinkedList<E> implements URList<E>
{
    private URNode<E> head;
    private URNode<E> tail;
    private int listSize;
    
    public URLinkedList(int size) {
        this();
    }
    
    public URLinkedList() {
        clear();
    }
    
    public void clear() {
        head = new URNode<E>(null,tail);
        tail = new URNode<E>(head, null);
        listSize = 0;
    }
    
    public Iterator<E> iterator() {
        return new Itr();
    }
    
    private class Itr implements Iterator<E> {
        URNode<E> lastReturned;
        URNode<E> next;
        private int nextIndex;
        
        public Itr() {
            lastReturned = head;
            next = head.next();
            nextIndex = 0;
        }
        
        public boolean hasNext() {
            return (nextIndex<listSize);
        }
        
        public E next() {
            E result = next.element();
            lastReturned = next;
            next = next.next();
            nextIndex++;
            return result;
        }
    }
    
    public boolean add(E e) {
        URNode newElem = new URNode<E>(e, tail.prev(), tail);
        tail.prev().setNext(newElem);
        tail.setPrev(newElem);
        listSize++;
        return true;
    }
    
    public void addLast(E e) {
        add(e);
    }
    
    public void addFirst(E e) {
        add(0,e);
    }
    
    public E peekFirst() {
        return head.next().element();
    }
    
    public E peekLast() {
        return tail.prev().element();
    }
    
    public E pollFirst() {
        return remove(0);
    }
    
    public E pollLast() {
        return remove(listSize-1);
    }
    
    public String toString() {
        Iterator it = iterator();
        String result = "";
        while (it.hasNext()) {
            result = result + "[" + it.next().toString() + "]" + " ";
        }
        return result;
    }
    
    public void add(int index, E element) {
        if ((index<0)||(index>=listSize)) { return; }
        URNode<E> ptr = head.next();
        for (int i = 0; i<index; i++) {
            ptr = ptr.next();
        }
        URNode<E> newElem = new URNode<E>(element, ptr.prev(), ptr);
        ptr.prev().setNext(newElem);
        ptr.setPrev(newElem);
        listSize++;
    }
    
    public boolean addAll(Collection<? extends E> c) {
        Iterator it = c.iterator();
        while (it.hasNext()) {
            add((E)it.next());
        }
        return true;
    }
    
    public boolean addAll(int index, Collection<? extends E> c) {
        Iterator it = c.iterator();
        while (it.hasNext()) {
            add(index,(E)it.next());
            index++;
        }
        return true;
    }
    
    public boolean contains(Object o)  {
        URNode<E> ptr = head.next();
        for (int i = 0; i<listSize; i++) {
            if (ptr.element().equals(o)) {return true; }
            ptr = ptr.next();
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
        if ((index<0)||(index>=listSize)) { return null; }
        URNode<E> ptr = head.next();
        for (int i = 0; i<index; i++) {
            ptr = ptr.next();
        }
        return ptr.element();
    }
    
    public int indexOf(Object o) {
        URNode<E> ptr = head.next();
        for (int i = 0; i<listSize; i++) {
            if (ptr.element().equals(o)) { return i; }
            ptr = ptr.next();
        }
        return -1;
    }
    
    public boolean isEmpty() {
        return (listSize == 0);
    }
    
    public E remove(int index) {
        if ((index<0)||(index>=listSize)) { return null; }
        URNode<E> ptr = head.next();
        for (int i = 0; i<index; i++) {
            ptr = ptr.next();
        }
        E temp = ptr.element();
        ptr.setElement(ptr.next().element());
        ptr.setNext(ptr.next().next());
        listSize--;
        return temp;
    }
    
    public boolean remove(Object o) {
        if (!contains(o)) {return false; }
        else {
            remove(indexOf(o));
            return true;
        }
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
        if ((index<0)||(index>=listSize)) { return null; }
        URNode<E> ptr = head.next();
        for (int i = 0; i<index; i++) {
            ptr = ptr.next();
        }
        URNode<E> newElem = new URNode<E>(element, ptr.prev(), ptr.next());
        E temp = ptr.element();
        ptr.prev().setNext(newElem);
        ptr.next().setPrev(newElem);
        return temp;
    }
    
    public int size() {
        return listSize;
    }
    
    public URList<E> subList(int fromIndex, int toIndex) {
        if (fromIndex<0) { fromIndex = 0; }
        if (toIndex > listSize) { toIndex = listSize-1; }
        URList sub = new URLinkedList<E>();
        URNode<E> ptr = head.next();
        for (int i=0; i<fromIndex-1; i++) {
            ptr = ptr.next();
        }
        for (int i = fromIndex; i<toIndex; i++) {
            sub.add(ptr.next().element());
            ptr = ptr.next();
        }
        return sub;
    }
    
    public Object[] toArray() {
        Object[] result = new Object[listSize];
        URNode<E> ptr = head.next();
        for (int i = 0; i<listSize; i++) {
            result[i] = ptr.element();
            ptr = ptr.next();
        }
        return result;
    }
}
