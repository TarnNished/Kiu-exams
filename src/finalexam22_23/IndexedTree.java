package finalexam22_23;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IndexedTree<T> implements Iterable<T> {
    private Node<T> tree;
    public int size(){
        if (tree == null)
            return 0;
        return tree.size();
    };
    public T get(int index){
        if (tree.get(index) == null)
            throw new IndexOutOfBoundsException();
        return tree.get(index);
    }
    public void update(int index, T value){
        if (tree == null) {
            throw new IndexOutOfBoundsException();
        }
         tree.update(index, value);
    }
    public void insert(int index, T value){
        if (tree == null) {
            tree = new Leaf<>(value);
        } else {
            tree = tree.insert(index, value);
        }
    }
    public void remove(int index){
        if (tree == null) {
            throw new IndexOutOfBoundsException();
        }
        tree.remove(index);

    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int pointer = 0;
            Node<T> next = tree;
            @Override
            public boolean hasNext() {
                return next != null;
            }

            @Override
            public T next() {
                if (!hasNext()) throw new NoSuchElementException();
                else {
                    T l = (T) tree.get(pointer);
                    pointer += 1;
                    return  l;
                }
            }
        };
    }




}
