import java.util.Iterator;

public interface FamilyTreeIterator<H> extends Iterator<H> {
    boolean hasNext();
    H next();
}