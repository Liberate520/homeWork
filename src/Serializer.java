public interface Serializer {
     void save(Object obj, String fileName);
     Object load(String fileName);
 }