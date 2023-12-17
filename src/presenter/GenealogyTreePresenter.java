package presenter;

import model.GenealogyTreeService;
import model.Person; 
import view.GenealogyTreeView;

public interface GenealogyTreePresenter {
    void setView(GenealogyTreeView view);
    void loadGenealogyTree(String filename);
    void saveGenealogyTree(String filename);
    void addPerson(String key, Person person);
    void addChild(String parentKey, String childKey);
    void sortByNameAndDisplay();
    void sortByDateOfBirthAndDisplay();
}