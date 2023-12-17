package model.service;


import model.creatures.Creature;
import model.creatures.Gender;
import model.creatures.Human;
import model.creatures.HumanBuilder;
import model.family_tree.FamilyTree;
import model.human_tree.HumanTree;
import writer.FileHandler;
import writer.Writable;

import java.io.Serializable;
import java.time.LocalDate;

public class Service implements Serializable {

    private FamilyTree<Human> familyTree;
    private final HumanTree<Human> humanTree;
    private final HumanBuilder humanBuilder;

    public Service() {
        familyTree = new FamilyTree<>();
        humanBuilder = new HumanBuilder();
        humanTree = new HumanTree<>(this);
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
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        if (familyTree.getNotInTree().isEmpty()) {
            sb.append("Элементы вне дерева отсутствуют");
            return sb.toString();
        } else {
            sb.append("Еще не добавлены в дерево:\nID  Name  BirthDate\n");
            for (Creature creature : familyTree.getNotInTree()) {
                if (flag)
                    sb.append("\n");
                sb.append(creature.getId() + " " + creature.getName() + " " + creature.getBirthDate());
                flag = true;
            }
            return sb.toString();
        }
    }

    public String showTree() {
        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        if (familyTree.getFamilyTree().isEmpty()) {
            return sb.append("Дерево пустое").toString();
        } else {
            sb.append("Дерево состоит из следующих членов\n(ID)  Name  Birthdate\n");
            for (Creature creature : familyTree.getFamilyTree()) {
                if (flag)
                    sb.append("\n");
                sb.append(creature.getId() + " " + creature.getName() + " " + creature.getBirthDate());
                flag = true;
            }
        }
        return sb.toString();
    }


    public String showHumanTree() {
        return humanTree.showTree();
    }

    public String showAll() {
        StringBuilder sb = new StringBuilder();
        if (familyTree.getFamilyTree().isEmpty() && familyTree.getNotInTree().isEmpty()) {
            return sb.append("Добавленных людей нет").toString();
        } else {
            boolean flag1;
            sb.append("Все добавленные люди:\nID  Name  Birthdate");
            for (Creature creature : familyTree.getFamilyTree()) {
                sb.append("\n");
                sb.append(creature.getId() + " " + creature.getName() + " " + creature.getBirthDate());
            }
            for (Creature creature : familyTree.getNotInTree()) {
                sb.append("\n");
                sb.append(creature.getId() + " " + creature.getName() + " " + creature.getBirthDate());
            }
        }
        return sb.toString();
    }

    public boolean setChild(Integer idParent, Integer idChild) {
        Human parent = familyTree.searchById(idParent);
        Human child = familyTree.searchById(idChild);
        if (parent != null && child != null && !parent.equals(child)) {
            return familyTree.setChildren(parent, child);
        } else {
            return false;
        }
    }

    public boolean setMother(Integer idChild, Integer idMother) {
        Human child = familyTree.searchById(idChild);
        Human mother = familyTree.searchById(idMother);
        if (child != null && mother != null && !child.equals(mother)) {
            return familyTree.setMother(child, mother);
        } else {
            return false;
        }
    }

    public boolean setFather(Integer idChild, Integer idFather) {
        Human child = familyTree.searchById(idChild);
        Human father = familyTree.searchById(idFather);
        if (child != null && father != null && !child.equals(father)) {
            return familyTree.setFather(child, father);
        } else {
            return false;
        }
    }

    public boolean divorce(Integer idSpouce1, Integer idSpouce2) {
        Human spouce1 = familyTree.searchById(idSpouce1);
        Human spouce2 = familyTree.searchById(idSpouce2);
        if (spouce1 != null && spouce1 != null) {
            return familyTree.divorce(spouce1, spouce2);
        } else {
            return false;
        }
    }

    public boolean setSpouce(Integer idSpouce1, Integer idSpouce2) {
        Human spouce1 = familyTree.searchById(idSpouce1);
        Human spouce2 = familyTree.searchById(idSpouce2);
        if (spouce1 != null && spouce2 != null && !spouce1.equals(spouce2)) {
            return familyTree.setSpouse(spouce1, spouce2);
        } else {
            return false;
        }
    }

    public String showAllInfo(Integer id) {
        StringBuilder sb = new StringBuilder();
        if (familyTree.searchById(id) != null) {
            sb.append(familyTree.searchById(id));
            return sb.toString();
        } else {
            return sb.append("Человек с таким ID отсутствует").toString();
        }
    }

    public boolean save(String filename) {
        Writable fileHandler = new FileHandler();
        if (fileHandler.writeObject(familyTree, filename)) {
            fileHandler.close();
            return true;
        } else {
            return false;
        }
    }

    public boolean load(String filename) {
        Writable fileHandler = new FileHandler();
        familyTree = (FamilyTree) fileHandler.readObject(filename);
        fileHandler.close();
        return true;
    }

    public boolean emptyCheck() {
        if (familyTree.emptyCheck())
            return false;
        else {
            return true;
        }
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
