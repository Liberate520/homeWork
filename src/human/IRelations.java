package human;

import java.util.List;

public interface IRelations<E> {
    
    List<E> parents();
    List<E> me();
    List<E> childs();
    List<E> spouse();
    List<E> brotherAndSisters();
    List<E> grandMothers();
    List<E> grandFathers();
    List<E> grandChildrens();
    String getName();
    String getSurname(); 
}
