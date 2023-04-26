package src.main.java;
import java.io.File;
import java.io.IOException;

public interface GenealogyTreeWriter {
    void save(GenealogyTree tree, File file) throws IOException;
}
