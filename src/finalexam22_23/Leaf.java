package finalexam22_23;

public class Leaf<T> implements Node<T> {
    private T value;
    public Leaf(T value) {
        this.value = value;
    }



    public T getValue() {
        return value;
    }
    @Override
    public int size(){
        return 1;
    }
    @Override
    public T get(int i){
        if(i == 0)
            return value;
        else throw new IndexOutOfBoundsException();
    }
    @Override
    public void update(int i, T t){
        if (i == 0){
            this.value = t;
        }
        else throw new IndexOutOfBoundsException();

    }

    @Override
    public Node<T> insert(int i, T x) {
        if (i <= 0){
            return new Inner<>(new Leaf<>(x),this);
        }else
            return new Inner<>(this,new Leaf<>(x) );
    }

    @Override
    public Node<T> remove(int i) {
        if(i == 0)
            return null;
        else throw new IndexOutOfBoundsException();
    }




}
