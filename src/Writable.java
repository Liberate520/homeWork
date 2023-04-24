public interface Writable {
    boolean save(Tree serializable, String filePath);
    Object read(String filePath);
}
