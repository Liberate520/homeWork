package GenerationTree.Model.FileHandler;

public interface FileReader<T> {
    T read(String filePath);
}
