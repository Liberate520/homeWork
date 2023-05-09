
import java.io.IOException;

interface Saveandreadable {
    default void read_info (Tree<Human> o) throws IOException {

    }

    void  print_info(Tree<Human> o) throws IOException;

    abstract void readInfo (Tree family) throws IOException;
}