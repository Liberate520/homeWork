package presenter;

import model.GenealogyTreeService;
import model.Person;
import model.FamilyMember;

import java.io.IOException;
import java.util.List;

// Класс для презентации генеалогического древа
public class GenealogyTreePresenter<T extends FamilyMember> {
    private GenealogyTreeService<T> genealogyTreeService;

    public GenealogyTreePresenter(GenealogyTreeService<T> genealogyTreeService) {
        this.genealogyTreeService = genealogyTreeService;
    }

    public void loadGenealogyTree(String filename) {
        try {
            genealogyTreeService.loadGenealogyTree(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveGenealogyTree(String filename) {
        try {
            genealogyTreeService.saveGenealogyTree(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addPerson(String key, T person) {
        genealogyTreeService.addPerson(key, person);
    }

    public void addChild(String parentKey, String childKey) {
        genealogyTreeService.addChild(parentKey, childKey);
    }

    public List<T> sortByName() {
        return genealogyTreeService.sortByName();
    }

    public List<T> sortByDateOfBirth() {
        return genealogyTreeService.sortByDateOfBirth();
    }
}