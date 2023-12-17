package view;

import model.GenealogyTreeService;
import model.Person;
import model.GenealogyTree;

import java.io.IOException;

public class GenealogyTreeViewImpl implements GenealogyTreeView {
    private GenealogyTreeService<Person> genealogyTreeService;

    public GenealogyTreeViewImpl(GenealogyTreeService<Person> genealogyTreeService) {
        this.genealogyTreeService = genealogyTreeService;
    }

    @Override
    public void displayGenealogyTree(GenealogyTree<?> genealogyTree) {
        System.out.println("Displaying Genealogy Tree:");
        // Дополнительный код для вывода информации о генеалогическом древе
    }

    @Override
    public void loadGenealogyTree(String filename) {
        try {
            genealogyTreeService.loadGenealogyTree(filename);
            displayGenealogyTree(genealogyTreeService.getGenealogyTree());
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
        genealogyTreeService.sortByName().forEach(person ->
                System.out.println(person.getFirstName() + " " + person.getLastName()));
    }

    @Override
    public void sortByDateOfBirthAndDisplay() {
        genealogyTreeService.sortByDateOfBirth().forEach(person ->
                System.out.println(person.getFirstName() + " " + person.getLastName() + " - " + person.getDateOfBirth()));
    }
}