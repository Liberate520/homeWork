package GenerationTree.Model.Person;

import java.io.File;
import java.nio.file.FileAlreadyExistsException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import GenerationTree.Model.FileHandler.FileHandler;
import GenerationTree.Model.Person.Comparators.PersonComparatorBySename;
import GenerationTree.Model.Person.Structs.Gender;
import GenerationTree.Model.Tree.GenerationTree;
import GenerationTree.Model.Tree.Service;

public class FamilyTreeService implements Service {
    private final String DATA_FOLDER = "Data\\";
    private final String FILE_TREE_EXTENSIONS = ".out";
    private final String ID_GENERATOR_FILE_NAME = "id_gen.data";
    private PersonIdGenerator idGenerator;
    private GenerationTree tree;
    private FileHandler<GenerationTree> treeFileHandler;
    private FileHandler<PersonIdGenerator> idFileHandler;

    public FamilyTreeService() {
        this("");
    }

    public FamilyTreeService(String treeName) {
        this.tree = new GenerationTree(treeName);
        this.idGenerator = PersonIdGenerator.getIdGenerator();
        this.treeFileHandler = new FileHandler<>();
        this.idFileHandler = new FileHandler<>();
    }

    public int addPerson(String name, Gender gender, LocalDate dateBirth) throws RuntimeException {
        int id = idGenerator.GetNewId();
        Person person = new Person(id, name, gender, dateBirth);
        if (addPerson(person))
            return id;
        throw new RuntimeException("Ошибка при добавлении члена семьи в древо.");
    }

    public boolean addPerson(Person person) {
        var result = tree.addOnlyPerson(person);
        if (result)
            person.setSurname(tree);
        return result;
    }

    public void addPersonAndRelatives(Person person) {
        this.tree.addPersonAndRelatives(person);
    }

    public boolean addSpouse(int personId, Person spouse, LocalDate dateOfMarriage) {
        var person = (Person) this.tree.getPersonById(personId);
        if (person != null && spouse != null) {
            person.addSpouse(spouse, dateOfMarriage);
            return true;
        }
        return false;
    }

    public boolean addChild(int parrentId, int childId) {
        var parrent = (Person) this.tree.getPersonById(parrentId);
        var child = this.tree.getPersonById(childId);
        if (parrent != null && child != null) {
            parrent.addChild((Person) child);
            return true;
        }
        return false;
    }

    public Person getPersonById(int id) {
        return (Person) this.tree.getPersonById(id);
    }

    public Map<Integer, String> getTreeItemsInfo() {
        Map<Integer, String> info = new HashMap<>();
        for (var person : tree) {
            info.put(person.getId(), person.toString());
        }

        return info;
    }

    public void sortByName() {
        tree.sortByName();
    }

    public void sortBySename() {
        this.tree.sortOutComparator(new PersonComparatorBySename());
    }

    public void sortByAge() {
        tree.sortByAge();
    }

    @Override
    public String getItemInfoById(int idPerson) {
        Person person = this.getPersonById(idPerson);
        if (person == null) {
            return "";
        }
        var sb = new StringBuilder();
        sb.append("Имя: " + person.getName());
        sb.append("\nФамилия: " + person.getSurname());
        sb.append("\nДата рождения: " + person.getDateBirth());
        sb.append("\n\n-----------------------------------\n");
        sb.append(getDescendantsOfPerson(person));
        return sb.toString();
    }

    public String getDescendantsOfPerson(Person person) {
        var sb = new StringBuilder();
        sb.append("Потомки: \n\n");
        var map = tree.getAllChildren(person);
        for (int key : map.keySet()) {
            if (key == 1)
                sb.append("Дети" + ":\n");
            else if (key == 2)
                sb.append("Внуки:\n");
            else if (key == 3)
                sb.append("Пра-внуки:\n");
            else if (key > 3 && key < 10)
                sb.append("Пра-" + "пра-".repeat(key - 3) + "внуки:\n");
            else
                sb.append("Поколение " + key + ":\n");
            var thisPersons = map.get(key);
            for (var thisPerson : thisPersons) {
                sb.append(" " + thisPerson + "\n");
            }
        }

        return sb.toString();
    }

    @Override
    public List<String> getAllSavedTrees() {
        File directory = new File(DATA_FOLDER);
        if (!directory.isDirectory()) {
            return null;
        }
        File[] files = directory.listFiles();
        List<String> treesNames = new LinkedList<>();
        for (int i = 0; i < files.length; i++) {
            if (files[i].getName().endsWith(FILE_TREE_EXTENSIONS)) {
                String fileName = files[i].getName();
                int lastDotIndex = fileName.lastIndexOf(".");
                if (lastDotIndex > 0) {
                    fileName = fileName.substring(0, lastDotIndex);
                }
                treesNames.add(fileName.toUpperCase());

            }
        }
        return treesNames;
    }

    @Override
    public String getTreeName() {
        return tree.getTreeName();
    }

    @Override
    public boolean saveTree() {
        return idFileHandler.save(idGenerator, DATA_FOLDER + ID_GENERATOR_FILE_NAME)
                && treeFileHandler.save(tree,
                        DATA_FOLDER + this.tree.getTreeName() + FILE_TREE_EXTENSIONS);
    }

    @Override
    public boolean loadTree(String treeName) {
        var tree = treeFileHandler.read(DATA_FOLDER + treeName + FILE_TREE_EXTENSIONS);
        var idGenerator = idFileHandler.read(DATA_FOLDER + ID_GENERATOR_FILE_NAME);
        if (tree != null && idGenerator != null) {
            this.tree = tree;
            this.idGenerator = idGenerator;
            return true;
        }
        return false;
    }

    public boolean deleteSavedTree(String name) {
        return treeFileHandler.deleteFile(DATA_FOLDER + name + FILE_TREE_EXTENSIONS);
    }

    @Override
    public boolean addNewTree(String name) throws FileAlreadyExistsException {
        var savedTrees = getAllSavedTrees();
        if (savedTrees != null && savedTrees.contains(name.toLowerCase())) {
            throw new FileAlreadyExistsException(name);
        }
        this.tree = new GenerationTree(name);
        return saveTree();
    }

    @Override
    public boolean addTreeItem(String name, Gender gender, LocalDate dateBirth) {
        return addPerson(name, gender, dateBirth) > -1;
    }

}