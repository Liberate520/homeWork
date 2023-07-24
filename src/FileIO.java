public interface FileIO {
    void saveToFile(String filePath, GenealogyTree tree);
    GenealogyTree loadFromFile(String filePath);
}
