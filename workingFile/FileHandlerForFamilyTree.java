package workingFile;

import tree.Node;

public abstract class FileHandlerForFamilyTree extends LoadFromFile implements SaveToFile{


    private String filePath = "text.txt";

    @Override
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public boolean save(Node tree, String filePath) {
        return super.save( tree, this.filePath);
    }

    @Override
    public Node read() {
        return null;
    }

    @Override
    public Node read(String filePath) {
        return (Node) super.read(this.filePath);
    }
}