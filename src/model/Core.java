package model;

import java.io.IOException;
import model.io.Reader;
import model.io.Loader;
import model.io.Writer;
import model.io.Saver;
import model.genTree.GenTree;
import model.treeItems.GenTreeItem;
import model.treeItems.Human;
import model.treeItems.enums.Gender;

public class Core {
    private Reader loader = new Loader();
    private Writer saver = new Saver();
    private GenTree<GenTreeItem> currentTree = null;
    private GenTreeItem currentItem = null;
    private boolean saved = true;

    public boolean isSaved() {
        return saved;
    }

    public String loadTree(String path) {
        if (saved) {
            try {
                loader.setPathName(path);
                Object restTree = loader.loadObj();
                if (restTree instanceof GenTree) {
                    currentTree = (GenTree<GenTreeItem>)restTree;
                    saved = true;
                    return "Древо загружено!";
                }
                return "Неверный тип файла!";
            }
            catch (IOException ioe) {
                return "IOException";
            }
            catch (ClassNotFoundException clsnfe) {
                return "Неверный тип файла!";
            }
        }
        return "Текущее древо не сохранено!";
    }

    public String saveTree(String path) {
        if (currentTree != null) {
            if (!saved) {
                try {
                    saver.setPathName(path);
                    saver.writeObj(currentTree);
                    saved = true;
                    return "Древо сохранено!";
                }
                catch (IOException ioe) {
                    return "IOException!";
                }
            }
            return "Уже сохранено!";
        }
        return "Древо не выбрано! Загрузите или создайте новое!";
    }

    public String newTree() {
        if (saved) {
            currentTree = new GenTree<GenTreeItem>();
            saved = true;
            return "Новое древо создано!";
        }
        return "Текущее древо не сохранено!";
    }

    public String getTreeFullInfo() {
        if (currentTree != null) {
            return currentTree.getTreeFullInfo();
        }
        return "Древо не выбрано! Загрузите или создайте новое!";
    }

    public String sortByHierarchyLevel() {
        if (currentTree != null) {
            currentTree.sortByHierarchyLevel();
            return "Древо отсортировано по иерархии!";
        }
        return "Древо не выбрано! Загрузите или создайте новое!";
    }

    // TODO сделать фабрику itemsFactory
    public String addNewItemInTree(String firstName,
                                   String midName,
                                   String lastName,
                                   String gender) {
        if (currentTree != null) {
            if (gender.equals("м") || gender.equals("ж")) {
                Human human = createNewItem(firstName, midName, lastName, gender);
                currentTree.addItem(human);
                saved = false;
                return "Новый человек добавлен!";
            }
            return "Указан некорректный пол!";
        }
        return "Древо не выбрано! Загрузите или создайте новое!";
    }

    // TODO сделать фабрику itemsFactory
    private Human createNewItem(String firstName,
                                String midName,
                                String lastName,
                                String gender) {
        Gender genderEnum;
        if (gender.equals("м")) {
            genderEnum = Gender.man;
        }
        else {
            genderEnum = Gender.woman;
        }
        return new Human(firstName, midName, lastName, genderEnum);
    }

    public String setCurrentItemById(int id) {
        if (currentTree != null) {
            GenTreeItem human = currentTree.getItemById(id);
            if (human != null) {
                currentItem = human;
                return "Текущий чел выбран!";
            }
            return "Чел не найден!";
        }
        return "Древо не выбрано! Загрузите или создайте новое!";
    }

    public String getCurrentItemFullInfo() {
        if (currentItem != null) {
            return currentItem.getFullInfo();
        }
        return "Текущий человек не выбран!";
    }

    public String setParentToCurrItemById(int id) {
        if (currentItem != null) {
            int currId = currentItem.getId();
            if (id != currId && !currentItem.getChildsIds().contains(currId)) {
                GenTreeItem parent = currentTree.getItemById(id);
                if (parent != null) {
                    currentItem.setParent(parent);
                    saved = false;
                    return "Родитель установлен!";
                }
                return "Чел с таким id не найден!";
            }
            return "Указан id текущего чела или ребёнка!";
        }
        return "Текущий человек не выбран!";
    }

    public String addChildToCurrItemById(int id) {
        if (currentItem != null) {
            int currId = currentItem.getId();
            int fatherId = currentItem.getFatherId();
            int motherId = currentItem.getMotherId();
            if (id != currId && id != fatherId && id != motherId) {
                GenTreeItem parent = currentTree.getItemById(id);
                if (parent != null) {
                    currentItem.setParent(parent);
                    saved = false;
                    return "Ребёнок добавлен!";
                }
                return "Чел с таким id не найден!";
            }
            return "Указан id текущего чела или родителя!";
        }
        return "Текущий человек не выбран!";
    }

    public String setBirthDateToCurrItem(int day, int month, int year) {
        if (currentItem != null) {
            try {
                currentItem.setBirthDate(day, month, year);
                return "Дата рождения установлена!";
            }
            catch (Exception e) {
                return "Дата рождения после даты смерти!";
            }
        }
        return "Текущий человек не выбран!";
    }

    public String setDeathDateToCurrItem(int day, int month, int year) {
        if (currentItem != null) {
            try {
                currentItem.setDeathDate(day, month, year);
                return "Дата смерти установлена!";
            }
            catch (Exception e) {
                return "Дата смерти перед датой рождения!";
            }
        }
        return "Текущий человек не выбран!";
    }



    public GenTree<Human> example() {
        GenTree<Human> tree = new GenTree<Human>();

        Human sashka = new Human("Кондратьев", "Сашка", "Антонович", Gender.man);
        try {sashka.setBirthDate(15, 07, 2022);}
        catch (Exception e) {System.out.println("Дата рождения после даты смерти!");}
        tree.addItem(sashka);

        Human anton = new Human("Кондратьев", "Антон", "Викторович", Gender.man);
        try {anton.setBirthDate(31, 07, 1992);}
        catch (Exception e) {System.out.println("Дата рождения после даты смерти!");}
        tree.addItem(anton);
        anton.addChild(sashka);

        Human nastya = new Human("Кондратьева", "Настя", "Юрьевна", Gender.woman);
        try {nastya.setBirthDate(18, 10, 1993);}
        catch (Exception e) {System.out.println("Дата рождения после даты смерти!");}
        tree.addItem(nastya);
        nastya.addChild(sashka);

        Human yuri = new Human("Нудненко", "Юрий", "Васильевич", Gender.man);
        try {yuri.setBirthDate(02, 02, 1958);}
        catch (Exception e) {System.out.println("Дата рождения после даты смерти!");}
        try {yuri.setDeathDate(23, 06, 2012);}
        catch (Exception e) {System.out.println("Дата смерти перед датой рождения!");}
        tree.addItem(yuri);
        yuri.addChild(nastya);

        Human sveta = new Human("Нудненко", "Светлана", "Юрьевна", Gender.woman);
        try {sveta.setBirthDate(14, 04, 1962);}
        catch (Exception e) {System.out.println("Дата рождения после даты смерти!");}
        tree.addItem(sveta);
        sveta.addChild(nastya);

        Human viktor = new Human("Кондратьев", "Виктор", "Юрьевич", Gender.man);
        try {viktor.setBirthDate(16, 05, 1972);}
        catch (Exception e) {System.out.println("Дата рождения после даты смерти!");}
        tree.addItem(viktor);
        viktor.addChild(anton);

        Human tanya = new Human("Кондратьева", "Татьяна", "Александровна", Gender.woman);
        try {tanya.setBirthDate(26, 04, 1973);}
        catch (Exception e) {System.out.println("Дата рождения после даты смерти!");}
        tree.addItem(tanya);
        anton.setParent(tanya);

        Human ivan = new Human("Нудненко", "Иван", "Юрьевич", Gender.man);
        try {ivan.setBirthDate(18, 10, 1993);}
        catch (Exception e) {System.out.println("Дата рождения после даты смерти!");}
        tree.addItem(ivan);
        ivan.setParent(yuri);
        ivan.setParent(sveta);

        return tree;
    }
}