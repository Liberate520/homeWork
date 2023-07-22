package tree;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface Readable {
    FamilyTree readTree (String fileName) throws IOException, ClassNotFoundException;

}
