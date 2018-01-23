import java.util.*;
/**
 * Name: Anh Pham
 * NetID: apham5
 * Lab session: MW 1650 - 1805
 * Lab 5
 * I worked with on this lab.
 */
public interface URList<E> extends Iterable<E>
{
    boolean add(E e);
    void add(int index, E element);
    boolean addAll(Collection<? extends E> c);
    boolean addAll(int index, Collection<? extends E> c);
    void clear();
    boolean contains(Object o);
    boolean containsAll(Collection<?> c);
    boolean equals(Object o);
    E get(int index);
    int indexOf(Object o);
    boolean isEmpty();
    Iterator<E> iterator();
    E remove(int index);
    boolean remove(Object o);
    boolean removeAll(Collection<?> c);
    E set(int index, E element);
    int size();
    URList<E> subList(int fromIndex, int toIndex);
    Object[] toArray();
}
