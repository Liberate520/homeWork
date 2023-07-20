package GenerationTree.Person;

import java.time.LocalDate;

import GenerationTree.FileHandler.FileHandler;
import GenerationTree.Person.Comparators.PersonComparatorBySename;
import GenerationTree.Person.Structs.Gender;
import GenerationTree.Tree.GenerationTree;
import GenerationTree.Tree.Service;

public class FamilyTreeService implements Service {
    private PersonIdGenerator idPerson;
    private GenerationTree<Person> tree;
    private FileHandler<GenerationTree<Person>> fHandler;

    public FamilyTreeService() {
        this("", new PersonIdGenerator());
    }

    public FamilyTreeService(String treeName) {
        this(treeName, new PersonIdGenerator());
    }

    public FamilyTreeService(String treeName, PersonIdGenerator personIdGenerator) {
        this.tree = new GenerationTree<Person>(treeName);
        this.idPerson = personIdGenerator;
        this.fHandler = new FileHandler<>();
    }

    public int addPerson(String name, Gender gender, LocalDate dateBirth) {
        int id = idPerson.GetNewId();
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
        var person = this.tree.getPersonById(personId);
        if (person != null && spouse != null) {
            person.addSpouse(spouse, dateOfMarriage);
            return true;
        }
        return false;
    }

    public boolean addChild(int parrentId, int childId) {
        var parrent = this.tree.getPersonById(parrentId);
        var child = this.tree.getPersonById(childId);
        if (parrent != null && child != null) {
            parrent.addChild(child);
            return true;
        }
        return false;
    }

    public Person getPersonById(int id) {
        return this.tree.getPersonById(id);
    }

    public String getPersonsInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список студентов:\n");

        for (Person person : tree) {
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

    public boolean saveTree() {
        return fHandler.save(tree, "Data\\" + this.tree.getTreeName() + ".out");
    }

    public boolean loadTree(String treeName) {
        var tree = fHandler.read("Data\\" + treeName + ".out");
        if (tree != null) {
            this.tree = tree;
            return true;
        }
        return false;
    }

    @Override
    public void addTreeItem(String name, Gender gender, LocalDate dateBirth) {
        addPerson(name, gender, dateBirth);
    }
}