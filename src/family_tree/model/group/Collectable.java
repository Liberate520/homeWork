package family_tree.model.group;

public interface Collectable<E> extends Iterable<E> {
    public void add(E e);
    public String getInfo();
    public int getSize();
    public E getElementByIndex(int index);
}
