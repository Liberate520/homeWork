package presenter;

import model.GenealogyTree;
import model.GenealogyTreeService;
import model.Person;
import view.GenealogyTreeView;

import java.io.IOException;
import java.util.List;

public class GenealogyTreePresenterImpl implements GenealogyTreePresenter {
    private GenealogyTreeView view;
    private GenealogyTreeService<Person> genealogyTreeService;

    public GenealogyTreePresenterImpl(GenealogyTreeService<Person> genealogyTreeService) {
        this.genealogyTreeService = genealogyTreeService;
    }

    @Override
    public void setView(GenealogyTreeView view) {
        this.view = view;
    }

    @Override
    public void loadGenealogyTree(String filename) {
        try {
            genealogyTreeService.loadGenealogyTree(filename);
            if (view != null) {
                view.displayGenealogyTree(genealogyTreeService.getGenealogyTree());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveGenealogyTree(String filename) {
        try {
            genealogyTreeService.saveGenealogyTree(filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addPerson(String key, Person person) {
        genealogyTreeService.addPerson(key, person);
    }

    @Override
    public void addChild(String parentKey, String childKey) {
        genealogyTreeService.addChild(parentKey, childKey);
    }

    @Override
    public void sortByNameAndDisplay() {
        if (view != null) {
            List<Person> sortedList = genealogyTreeService.sortByName();
            GenealogyTree<Person> sortedTree = createGenealogyTreeFromList(sortedList);
            view.displayGenealogyTree(sortedTree);
        }
    }

    @Override
    public void sortByDateOfBirthAndDisplay() {
        if (view != null) {
            List<Person> sortedList = genealogyTreeService.sortByDateOfBirth();
            GenealogyTree<Person> sortedTree = createGenealogyTreeFromList(sortedList);
            view.displayGenealogyTree(sortedTree);
        }
    }

    private GenealogyTree<Person> createGenealogyTreeFromList(List<Person> sortedList) {
        GenealogyTree<Person> sortedTree = new GenealogyTree<>();
        for (Person person : sortedList) {
            sortedTree.addPerson(person.getFirstName(), person);
        }
        return sortedTree;
    }
}