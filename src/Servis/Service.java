package Servis;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

import Enum.Gender;
import Enum.Kinship;
import FamiliTree.FamilyTree;
import FileHandler.FileHandler;
import Human.Human;

public class Service {

    // #region Fields

    private int idHuman;
    private FamilyTree tree;
    private Human firsthuman;
    private FileHandler fileSL;

    // #endregion

    // #region Constructor

    public Service() {
        tree = new FamilyTree();
        fileSL = new FileHandler();
    }

    // #endregion

    // #region Get

    /**
     * Метод печати в консоль дерева родства
     * 
     * @return - список людей дерева родства
     */
    public String getInfo() {
        String str = tree.getInfo();
        return str;
    }

    // #endregion

    // #region Metods add

    /**
     * Метод добавления человека
     * 
     * @param name        - имя
     * @param gender      - пол (male или female)
     * @param dataOfBirth - дата рождения
     * @param dataOfDeath - дата смерти
     * @param father      - отец
     * @param mother      - мама
     */
    public void addHuman(String name, Gender gender, LocalDate dataOfBirth, LocalDate dataOfDeath, Human father,
            Human mother) {
        Human human = new Human(idHuman++, name, gender, dataOfBirth, father, mother);
        tree.add(human);
    }

    /**
     * Метод устанавливает связь родства
     * 
     * @param idHumanAdd - id кого добавить
     * @param kinship    - родство (child или parent)
     * @param idHuman    - id кому добавит
     * 
     * @return boolean
     */
    public boolean addKinship(int idHumanAdd, Kinship kinship, int idHuman) {

        for (Human human1 : tree) {
            if (human1.getId() == idHuman) {
                this.firsthuman = human1;
            }
        }

        for (Human human : tree) {
            if (human.getId() == idHumanAdd) {
                if (kinship == Kinship.child) {
                    this.firsthuman.addChild(human);
                    return true;
                } else if (kinship == Kinship.parent) {
                    this.firsthuman.addParent(human);
                    return true;
                }
            }
        }
        return false;
    }
    // #endregion

    // #region Metods save end load

    /**
     * Метод сохранения дерева в файл
     * 
     * @param tree - дерево родства
     */
    public void save() {
        try {
            fileSL.save(tree);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Метод загрузки дерева родства
     * 
     * @return - дерево родства
     */
    public Object load() {
        try {
            return fileSL.load();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }
    // #endregion

    // #region Metods Sort
    /**
     * Сортировка по возрасту
     */
    public void sortByAge() {
        tree.sortByAge();
    }

    /**
     * Сортировка по ID
     */
    public void sortById() {
        tree.sortById();
    }

    /**
     * Сортировка по имени
     */
    public void sortByName() {
        tree.sortByName();
    }

    /**
     * Сортировка по дате рождения
     */
    public void sortByBirthData(){
        tree.sortByBirthData();
    }
    // #endregion
}