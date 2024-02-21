package lab3;

import java.util.*;
import java.util.concurrent.Semaphore;

public class SemaphoreList<E> implements List<E> {
    private final List<E> list = new ArrayList<>();
    private final Semaphore semaphore = new Semaphore(1);

    @Override
    public int size() {
        try {
            semaphore.acquire();
            int size = list.size();
            semaphore.release();
            return size;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean isEmpty() {
        try {
            semaphore.acquire();
            boolean isEmpty = list.isEmpty();
            semaphore.release();
            return isEmpty;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean contains(Object o) {
        try {
            semaphore.acquire();
            boolean contains = list.contains(o);
            semaphore.release();
            return contains;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Iterator<E> iterator() {
        try {
            semaphore.acquire();
            Iterator<E> iterator = list.iterator();
            semaphore.release();
            return iterator;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object[] toArray() {
        try {
            semaphore.acquire();
            Object[] array = list.toArray();
            semaphore.release();
            return array;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <T> T[] toArray(T[] a) {
        try {
            semaphore.acquire();
            T[] array = list.toArray(a);
            semaphore.release();
            return array;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean add(E e) {
        try {
            semaphore.acquire();
            boolean added = list.add(e);
            semaphore.release();
            return added;
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public boolean remove(Object o) {
        try {
            semaphore.acquire();
            boolean removed = list.remove(o);
            semaphore.release();
            return removed;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        try {
            semaphore.acquire();
            boolean containsAll = list.containsAll(c);
            semaphore.release();
            return containsAll;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        try {
            semaphore.acquire();
            boolean addedAll = list.addAll(c);
            semaphore.release();
            return addedAll;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        try {
            semaphore.acquire();
            boolean addedAll = list.addAll(index, c);
            semaphore.release();
            return addedAll;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        try {
            semaphore.acquire();
            boolean removedAll = list.removeAll(c);
            semaphore.release();
            return removedAll;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        try {
            semaphore.acquire();
            boolean retainedAll = list.retainAll(c);
            semaphore.release();
            return retainedAll;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void clear() {
        try {
            semaphore.acquire();
            list.clear();
            semaphore.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public E get(int index) {
        try {
            semaphore.acquire();
            E element = list.get(index);
            semaphore.release();
            return element;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public E set(int index, E element) {
        try {
            semaphore.acquire();
            E oldElement = list.set(index, element);
            semaphore.release();
            return oldElement;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(int index, E element) {
        try {
            semaphore.acquire();
            list.add(index, element);
            semaphore.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public E remove(int index) {
        try {
            semaphore.acquire();
            E element = list.remove(index);
            semaphore.release();
            return element;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int indexOf(Object o) {
        try {
            semaphore.acquire();
            int index = list.indexOf(o);
            semaphore.release();
            return index;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int lastIndexOf(Object o) {
        try {
            semaphore.acquire();
            int index = list.lastIndexOf(o);
            semaphore.release();
            return index;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ListIterator<E> listIterator() {
        try {
            semaphore.acquire();
            ListIterator<E> iterator = list.listIterator();
            semaphore.release();
            return iterator;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        try {
            semaphore.acquire();
            ListIterator<E> iterator = list.listIterator(index);
            semaphore.release();
            return iterator;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        try {
            semaphore.acquire();
            List<E> subList = list.subList(fromIndex, toIndex);
            semaphore.release();
            return subList;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
