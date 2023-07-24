package familly_api.savinaAnLoad;

public interface Interf<E> {
    E loadFile(String nameFile);
    void saveFile(E familyTree, String nameFile);
}