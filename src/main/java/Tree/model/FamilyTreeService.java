package Tree.model;


import Tree.model.components.FamilyTree;
import Tree.model.components.Gender;
import Tree.model.components.Human;
import Tree.model.fileManager.Writable;
import Tree.model.fileManager.FileHandler;

// класс реализующий все методы работы с деревом
public class FamilyTreeService implements Service {
    private final Writable fileHandler;
    private FamilyTree<Human> familyTree;

    // конструктор
    public FamilyTreeService() {
        this.fileHandler = new FileHandler("FamilyTree.out");
        familyTree = new FamilyTree<>();
    }

    // метод вызывает метод показывающий все дерево
    @Override
    public String outputAList() {
        if (familyTree != null) {
            return familyTree.getInfo();
        }
        return "Дерево не создано!";
    }

    // метод вызывает метод очистки дерева
    public void clearTree() {
        this.familyTree.clearTree();
    }

    // метод поиска человека в дереве
    @Override
    public String searchByName(String name) {
        for (Human human : familyTree) {
            if (human.getFullName().equalsIgnoreCase(name)) {
                return familyTree.getByName(name).getInfo();
            }
        }
        return "Человек не найден!";
    }

    // метод вызывает метод чтения из файла
    @Override
    public void load() {
        familyTree = (FamilyTree<Human>) fileHandler.load();
    }

    // метод вызывает метод сохранения в файл
    @Override
    public void save() {
        fileHandler.save(familyTree);
    }

    // метод вызывает метод сортировки по алфавиту
    @Override
    public void sortAlfab() {
        familyTree.sortByName();
    }

    // метод вызывает метод сортировки по дате рождения
    @Override
    public void sortByAge() {
        familyTree.sortByAge();
    }

    // метод добавления человека
    @Override
    public void addHuman(String fullName, int dateBirth, Gender sex, String motherName, String fatherName) {
        Human father = familyTree.getByName(fatherName);
        Human mother = familyTree.getByName(motherName);
        Human child = new Human(fullName, dateBirth, sex, mother, father);
        familyTree.add(child);
    }

    // метод удаления человека по имени
    @Override
    public boolean deletePerson(String name) {
        return familyTree.deletePerson(familyTree.getByName(name));
    }
}
