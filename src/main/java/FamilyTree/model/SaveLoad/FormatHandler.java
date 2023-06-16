package FamilyTree.model.SaveLoad;

public interface FormatHandler {
    void save(Object obj, String file);
    Object load(String file);
}
