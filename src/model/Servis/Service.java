package Servis;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

import Enum.Gender;
import Enum.Kinship;
import FamiliTree.FamilyTree;
import FileHandler.FileHandler;
import Human.Human;
//import Presenter.GenderP;

public class Service {

    // #region Fields

    private int idHuman;
    private FamilyTree<Human> tree;
    private Human firsthuman;
    private FileHandler fileSL;
    private Gender gender;
    private Kinship kinship;

    // #endregion

    // #region Constructor

    public Service() {
        tree = new FamilyTree<>();
        fileSL = new FileHandler();
    }

    // #endregion

    // #region GetInfo

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

    // #region Metods add Human
    public void delHuman(int id){
        tree.delHuman(id);
    }
    /**
     * Метод добавления человека
     * 
     * @param name        - имя
     * @param genderP     - пол (male или female)
     * @param dataOfBirth - дата рождения
     * @param dataOfDeath - дата смерти
     */
    public void addHuman(String name, int genderP, LocalDate dataOfBirth, LocalDate dataOfDeath) {

        if (genderP == 1) {
            gender = Gender.male;
        } else if (genderP == 2) {
            gender = Gender.female;
        } else {

        }

        Human human = new Human(idHuman++, name, gender, dataOfBirth);
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
    public boolean addKinship(int idHumanAdd, int kinshipInt, int idHuman) {

        if (kinshipInt == 1) {
            kinship = Kinship.parent;
        }
        if (kinshipInt == 2) {
            kinship = Kinship.child;
        }
        this.firsthuman = tree.getById(idHuman);
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
    public void load() {
        try {
            tree=(FamilyTree<Human>) fileSL.load();
            // return fileSL.load();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("worning");
            //return null;
        } catch (IOException e) {
            System.out.println("worning2");
            e.printStackTrace();
            //return null;
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
    public void sortByBirthData() {
        tree.sortByBirthData();
    }
    // #endregion

}