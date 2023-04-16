package familyTreeApi.handler;

public interface Writable<E> {

    void save(E e, String fileName);

    E read(String fileName);
}