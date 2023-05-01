import java.util.Iterator;

public interface Iterable <H> extends Iterator<H> {

    @Override
   boolean hasNext();

}
