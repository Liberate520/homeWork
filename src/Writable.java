public interface Writable {
    boolean save(FamilyTree serializable, String filePath);
    Object read (String filePath);
}
