package model;

import model.familyTree.FamilyTree;
import model.familyTree.HumanComaratorByFamily;
import model.familyTree.HumanComparatorByName;
import model.human.Human;
import model.save.Writable;
import model.save.ClassWriteRead;

import java.io.IOException;

public class Service<E extends Human> {

    private Writable writable;
    private FamilyTree<E> humanLIST;
    private String nameFile;
    ClassWriteRead treeForWrite = new ClassWriteRead<>(null, nameFile);

    {
        nameFile = "familyTree.out";
    }

    public Service() {

    }

    public Service(FamilyTree<E> humanLIST) {
        this.humanLIST = humanLIST;
    }

    public void sortByName() {

        humanLIST.getHumanList().sort(new HumanComparatorByName());

    }

    public void sortByFamily() {

        humanLIST.getHumanList().sort(new HumanComaratorByFamily());

    }

    public void addNewHuman(String name, String family, String dateBirth, String father, String mother) {

        humanLIST.addNewHuman((E) new Human(name, family, dateBirth, humanLIST.getByName(father), humanLIST.getByName(mother)), null);
        //saveInFile();
    }

    public void sortObjectHum(int n) {
        if (n == 1) {
            sortByName();
            //сохраняем в файл
            //saveInFile();
        } else if (n == 2) {
            sortByFamily();
            // saveInFile();
        } else {
            System.out.println("повторите выбор");

        }

    }

    public String printHumanList() {

        return humanLIST.getInfo();
        // System.out.println(humanLIST.getInfo());

//        try {
//            return (String) treeForWrite.read(nameFile);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
    }


    public E searchHuman(String name) {

//            if (name == null || name.trim().isEmpty()) {
//                throw new IllegalArgumentException("Заполните имя!");
//            }

        if (name == null) {
            throw new IllegalArgumentException("Заполните имя!");
        }

        for (E item : humanLIST.getHumanList()) {
            if (item.getName().equalsIgnoreCase(name.trim())) {

                return item;

            }
        }
        throw new IllegalArgumentException("Человек  не найден.");
    }


    public void saveInFile() {

        //сохраняем в файл
        try {
            treeForWrite.save(humanLIST.getInfo(), nameFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public String readFile() {

        try {
            return (String) treeForWrite.read(nameFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public String checkingInput(String name, String family, String dateBirth, String father, String mother) {

        if (name.isEmpty() && family.isEmpty() && dateBirth.isEmpty() && father.isEmpty() && mother.isEmpty()) {

            return null;
        }
        return "";
    }

}



