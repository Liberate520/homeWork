package Tree;

import java.io.File;
import java.io.IOException;

public interface GenealogyTreeReader {
    GenealogyTree load(File file) throws IOException;
}

