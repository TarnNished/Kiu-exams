package finalexam22_23;

public class Inner<T> implements Node<T> {
    Node<T> left;
    Node<T> right;
    int lSize;
    int rSize;

    public Inner(Node<T> left, Node<T> right) {
        this.left = left;
        this.right = right;
        this.lSize = left.size();
        this.rSize = right.size();
    }

    @Override
    public int size(){
        return lSize+rSize;
    }
    @Override
    public T get(int i){
        if(i < 0 || i >= size()) {
            throw new IndexOutOfBoundsException();
        }
        if(i < lSize) {
            return left.get(i);
        }else
            return right.get(i - lSize);

    }
    @Override
    public void update(int i, T x){
        if (i < 0 || i >= size()) {
            throw new IndexOutOfBoundsException();
        }
        if(i < lSize) {
            left.update(i, x);
        }else
            right.update(i - lSize, x);

    }

    @Override
    public Node<T> insert(int i, T x) {
        if(i <= 0 ) {
            return new Inner<>(new Leaf<>(x),this);
        } else if (i > size()) {
            return new Inner<>(this,new Leaf<>(x));
        }else if (i < lSize){
            left = left.insert(i, x);
            lSize ++;
        }else {
            right = right.insert(i, x);
            rSize++;
        }
        return this;
    }


    @Override
    public Node<T> remove(int i) {
        if(i < 0 || i >= size()) {
            throw new IndexOutOfBoundsException();
        }
        if(i < lSize) {
            left = left.remove(i);
            lSize--;
        }else{
            right = right.remove(i);
            rSize--;
        }
        if (lSize == 0) return right;
        if (rSize == 0) return left;
        return this;
    }

}
