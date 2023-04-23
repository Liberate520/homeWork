public interface Serializable {
    void save(Object obj, String fileName);
    Object load(String fileName);
}
