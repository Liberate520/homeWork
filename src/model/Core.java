package model;

import model.io.Loader;
import model.io.Saver;
import java.io.IOException;
import model.interfaces.Loadable;
import model.genTree.GenTree;
import model.treeItems.Human;
import model.treeItems.enums.Gender;

public class Core {
    private GenTree<Human> currentTree = null;
    private Human currentHuman = null;
    private boolean saved = true;

    public boolean isSaved() {
        return saved;
    }

    public String loadTree(String path) {
        if (saved) {
            Loader loader = new Loader();
            try {
                Loadable restTree = loader.loadObj(path);
                if (restTree instanceof GenTree) {
                    currentTree = (GenTree<Human>)restTree;
                    saved = true;
                    return "Древо загружено!";
                }
                return "Неправильный тип файла!";
            }
            catch (IOException ioe) {
                return "IOException";
            }
            catch (ClassNotFoundException clsnfe) {
                return "Неправильный тип файла!";
            }
        }
        return "Текущее древо не сохранено!";
    }

    public String saveTree(String path) {
        if (currentTree != null) {
            if (!saved) {
                Saver saver = new Saver();
                try {
                    saver.writeObj(currentTree, path);
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
            currentTree = new GenTree<Human>();
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

    public String addNewHumanInTree(String firstName,
                                    String midName,
                                    String lastName,
                                    String gender) {
        if (currentTree != null) {
            if (gender.equals("м") || gender.equals("ж")) {
                Human human = createNewHuman(firstName, midName, lastName, gender);
                currentTree.addItem(human);
                saved = false;
                return "Новый человек добавлен!";
            }
            return "Указан некорректный пол!";
        }
        return "Древо не выбрано! Загрузите или создайте новое!";
    }

    private Human createNewHuman(String firstName,
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

    public String setCurrentHumanById(int id) {
        if (currentTree != null) {
            Human human = currentTree.getItemById(id);
            if (human != null) {
                currentHuman = human;
                return "Текущий чел выбран!";
            }
            return "Чел не найден!";
        }
        return "Древо не выбрано! Загрузите или создайте новое!";
    }

    public String getCurrentHumanFullInfo() {
        if (currentHuman != null) {
            return currentHuman.getFullInfo();
        }
        return "Текущий человек не выбран!";
    }

    public String setParentToCurrHumanById(int id) {
        if (currentHuman != null) {
            int currId = currentHuman.getId();
            if (id != currId && !currentHuman.getChildsIds().contains(currId)) {
                Human parent = currentTree.getItemById(id);
                if (parent != null) {
                    currentHuman.setParent(parent);
                    saved = false;
                    return "Родитель установлен!";
                }
                return "Чел с таким id не найден!";
            }
            return "Указан id текущего чела или ребёнка!";
        }
        return "Текущий человек не выбран!";
    }

    public String addChildToCurrHumanById(int id) {
        if (currentHuman != null) {
            int currId = currentHuman.getId();
            int fatherId = currentHuman.getFatherId();
            int motherId = currentHuman.getMotherId();
            if (id != currId && id != fatherId && id != motherId) {
                Human parent = currentTree.getItemById(id);
                if (parent != null) {
                    currentHuman.setParent(parent);
                    saved = false;
                    return "Ребёнок добавлен!";
                }
                return "Чел с таким id не найден!";
            }
            return "Указан id текущего чела или родителя!";
        }
        return "Текущий человек не выбран!";
    }

    public String setBirthDateToCurrHuman(int day, int month, int year) {
        if (currentHuman != null) {
            try {
                currentHuman.setBirthDate(day, month, year);
                return "Дата рождения установлена!";
            }
            catch (ArithmeticException e) {
                return "Дата рождения после даты смерти!";
            }
        }
        return "Текущий человек не выбран!";
    }

    public String setDeathDateToCurrHuman(int day, int month, int year) {
        if (currentHuman != null) {
            try {
                currentHuman.setDeathDate(day, month, year);
                return "Дата смерти установлена!";
            }
            catch (ArithmeticException e) {
                return "Дата смерти перед датой рождения!";
            }
        }
        return "Текущий человек не выбран!";
    }



    public GenTree<Human> example() {
        GenTree<Human> tree = new GenTree<Human>();

        Human sashka = new Human("Кондратьев", "Сашка", "Антонович", Gender.man);
        sashka.setBirthDate(15, 07, 2022);
        tree.addItem(sashka);

        Human anton = new Human("Кондратьев", "Антон", "Викторович", Gender.man);
        anton.setBirthDate(31, 07, 1992);
        tree.addItem(anton);
        anton.addChild(sashka);

        Human nastya = new Human("Кондратьева", "Настя", "Юрьевна", Gender.woman);
        nastya.setBirthDate(18, 10, 1993);
        tree.addItem(nastya);
        nastya.addChild(sashka);

        Human yuri = new Human("Нудненко", "Юрий", "Васильевич", Gender.man);
        yuri.setBirthDate(02, 02, 1958);
        yuri.setDeathDate(23, 06, 2012);
        tree.addItem(yuri);
        yuri.addChild(nastya);

        Human sveta = new Human("Нудненко", "Светлана", "Юрьевна", Gender.woman);
        sveta.setBirthDate(14, 04, 1962);
        tree.addItem(sveta);
        sveta.addChild(nastya);

        Human viktor = new Human("Кондратьев", "Виктор", "Юрьевич", Gender.man);
        viktor.setBirthDate(16, 05, 1972);
        tree.addItem(viktor);
        viktor.addChild(anton);

        Human tanya = new Human("Кондратьева", "Татьяна", "Александровна", Gender.woman);
        tanya.setBirthDate(26, 04, 1973);
        tree.addItem(tanya);
        anton.setParent(tanya);

        Human ivan = new Human("Нудненко", "Иван", "Юрьевич", Gender.man);
        ivan.setBirthDate(18, 10, 1993);
        tree.addItem(ivan);
        ivan.setParent(yuri);
        ivan.setParent(sveta);

        return tree;
    }
}