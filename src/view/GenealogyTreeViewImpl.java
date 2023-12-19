package view;

import model.GenealogyTreeService;
import model.Person;
import model.GenealogyTree;
import model.FamilyMember;

import java.io.IOException;

public class GenealogyTreeViewImpl implements GenealogyTreeView {
    private GenealogyTreeService<? extends FamilyMember> genealogyTreeService;

    public GenealogyTreeViewImpl(GenealogyTreeService<? extends FamilyMember> genealogyTreeService) {
        this.genealogyTreeService = genealogyTreeService;
    }

    public void displayGenealogyTree(GenealogyTree<? extends FamilyMember> genealogyTree) {
        System.out.println("Displaying Genealogy Tree:");
        // Дополнительный код для вывода информации о генеалогическом древе
    }

    public void loadGenealogyTree(String filename) {
        try {
            genealogyTreeService.loadGenealogyTree(filename);
            displayGenealogyTree(genealogyTreeService.getGenealogyTree());
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

    public void addPerson(String key, FamilyMember person) {
        genealogyTreeService.addPerson(key, person);
    }

    public void addChild(String parentKey, String childKey) {
        genealogyTreeService.addChild(parentKey, childKey);
    }

    public void sortByNameAndDisplay() {
        genealogyTreeService.sortByName().forEach(person ->
                System.out.println(person.getFirstName() + " " + person.getLastName()));
    }

    public void sortByDateOfBirthAndDisplay() {
        genealogyTreeService.sortByDateOfBirth().forEach(person ->
                System.out.println(person.getFirstName() + " " + person.getLastName() + " - " + person.getDateOfBirth()));
    }
}