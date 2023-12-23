package model.service;


import model.creatures.Creature;
import model.creatures.Gender;
import model.creatures.Human;
import model.creatures.HumanBuilder;
import model.family_tree.FamilyTree;
import model.human_tree.HumanTree;
import writer.Writable;

import java.io.Serializable;
import java.time.LocalDate;

public class Service implements Serializable {

    private FamilyTree<Human> familyTree;
    private final HumanTree<Human> humanTree;
    private final HumanBuilder humanBuilder;
    private final Writable fileHandler;

    public Service(Writable filehandler) {
        familyTree = new FamilyTree<>();
        humanBuilder = new HumanBuilder();
        humanTree = new HumanTree<>();
        this.fileHandler = filehandler;
    }

    public FamilyTree getFamilyTree() {
        return familyTree;
    }

    public Creature<Human> getFirstMebmer() {
        return familyTree.getFirstMember();
    }

    public HumanTree getHumanTree() {
        return humanTree;
    }

    public boolean addHuman(String firstName, String lastName, Gender gender, LocalDate birthDate) {
        Human human = humanBuilder.build(firstName, lastName, gender, birthDate);
        return familyTree.addCreature(human);
    }

    public String showIsNotInTree() {
        return familyTree.showIsNotInTree();
    }

    public String showTree() {
        return familyTree.showTree();
    }


    public String showHumanTree() {
        return humanTree.showTree(familyTree);
    }

    public String showAll() {
        return familyTree.showAll();
    }

    public boolean setChild(Integer idParent, Integer idChild) {
        return familyTree.setChildren(familyTree.searchById(idParent), familyTree.searchById(idChild));
    }

    public boolean setMother(Integer idChild, Integer idMother) {
        return familyTree.setMother(familyTree.searchById(idChild), familyTree.searchById(idMother));
    }

    public boolean setFather(Integer idChild, Integer idFather) {
        return familyTree.setFather(familyTree.searchById(idChild), familyTree.searchById(idFather));
    }

    public boolean divorce(Integer idSpouce1, Integer idSpouce2) {
        return familyTree.divorce(familyTree.searchById(idSpouce1), familyTree.searchById(idSpouce2));
    }

    public boolean setSpouce(Integer idSpouce1, Integer idSpouce2) {
        return familyTree.setSpouse(familyTree.searchById(idSpouce1), familyTree.searchById(idSpouce2));
    }

    public String showAllInfo(Integer id) {
        return familyTree.searchById(id).toString();
    }

    public boolean save(String filename) {
        if (fileHandler.writeObject(familyTree, filename)) {
            fileHandler.close();
            return true;
        } else {
            return false;
        }
    }

    public boolean load(String filename) {
        familyTree = (FamilyTree) this.fileHandler.readObject(filename);
        fileHandler.close();
        return true;
    }

    public boolean emptyCheck() {
        return !familyTree.emptyCheck();
    }

    public boolean setDeathDate(Integer id, LocalDate DeathDate) {
        Human human = familyTree.searchById(id);
        if (human != null) {
            human.setDeath(human, DeathDate);
            return true;
        } else {
            return false;
        }
    }
}
