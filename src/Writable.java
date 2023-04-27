import famalyTree.Family;

public interface Writable {
    boolean save(Family serializable, String filePath);
    Object read(String filePath);
}
