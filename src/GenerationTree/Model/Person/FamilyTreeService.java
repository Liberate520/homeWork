package GenerationTree.Model.Person;

import java.io.File;
import java.nio.file.FileAlreadyExistsException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

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

    public int addPerson(String name, Gender gender, LocalDate dateBirth) {
        int id = idGenerator.GetNewId();
        Person person = new Person(id, name, gender, dateBirth);
        addPerson(person);

        return id;
    }

    public void addPerson(Person person) {
        tree.addOnlyPerson(person);
        person.setSurname(tree);
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

    public String getPersonsInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список студентов:\n");

        for (var person : tree) {
            stringBuilder.append(person);
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
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

    public String getDescendantsOfPerson(int idPerson) {
        Person person = this.getPersonById(idPerson);
        if (person == null) {
            return "";
        }
        return getDescendantsOfPerson(person);
    }

    public String getDescendantsOfPerson(Person person) {
        var sb = new StringBuilder();
        sb.append("Потомки: " + person.getName() + "\n\n");
        var map = tree.getAllChildren(person);
        for (int key : map.keySet()) {
            sb.append("Поколение " + key + ":\n");
            var thisPersons = map.get(key);
            for (var thisPerson : thisPersons) {
                sb.append(" " + thisPerson + "\n");
            }
        }

        return sb.toString();
    }

    @Override
    public List<String> getForest() {
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
                    treesNames.add(fileName.substring(0, lastDotIndex));
                } else {
                    treesNames.add(fileName);
                }
            }
        }
        return treesNames;
    }

    @Override
    public boolean saveTree() {
        return idFileHandler.save(idGenerator, DATA_FOLDER + ID_GENERATOR_FILE_NAME)
                && treeFileHandler.save(tree, DATA_FOLDER + this.tree.getTreeName() + FILE_TREE_EXTENSIONS);
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

    public boolean deleteTree(String name) {
        return treeFileHandler.deleteFile(DATA_FOLDER + name + FILE_TREE_EXTENSIONS);
    }

    @Override
    public void addNewTree(String name) throws FileAlreadyExistsException {
        var savedTrees = getForest();
        if (savedTrees != null && savedTrees.contains(name)) {
            throw new FileAlreadyExistsException(name);
        }
        this.tree = new GenerationTree(name);
        saveTree();
    }

    @Override
    public void addTreeItem(String name, Gender gender, LocalDate dateBirth) {
        addPerson(name, gender, dateBirth);
    }

}