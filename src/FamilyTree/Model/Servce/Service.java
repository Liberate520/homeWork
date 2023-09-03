package family_tree.FamilyTree.Model.Servce;

import family_tree.FamilyTree.Model.Person.Gender;
import family_tree.FamilyTree.Model.Person.Person;
import family_tree.FamilyTree.Model.Tree.FamilyTree;
import family_tree.FamilyTree.Model.Tree.FileManager;

import java.io.IOException;
import java.time.LocalDate;


public class Service {
    private FamilyTree<Person> tree;
    private int inn;

    public Service() {
        tree = new FamilyTree<>();
    }

    public void addPerson(String fName, String lName, Gender gen, LocalDate dataB) {
        Person person = new Person(fName, lName, gen, dataB);
        person.setInn(this.inn++);
        this.tree.addPerson(person);
    }

    public String getListInfo() {
        StringBuilder listInfo = new StringBuilder();
        for (Person person : tree) {
            listInfo.append(person);
            listInfo.append("\n");
        }
        return listInfo.toString();
    }

    public void setParentForINN(int innChildren, int innParent) {
        Person children = tree.getForInn(innChildren);
        Person fParent = tree.getForInn(innParent);

        children.addParent(fParent);
        fParent.addChildren(children);

    }

    public void marriageForINN(int innFPartner, int innSPartner) {

        Person fPartner = tree.getForInn(innFPartner);
        Person sPartner = tree.getForInn(innSPartner);
        fPartner.setHusband(sPartner);
    }


    //TODO ПОДУМАТЬ как правильно и зачем
    public boolean divorceForINN(int innFPartner, int innSPartner) {
        Person fPartner = tree.getForInn(innFPartner);
        Person sPartner = tree.getForInn(innSPartner);

        if (fPartner.getHusband() == sPartner.getHusband()) {
            fPartner.deleteHusband();
            sPartner.deleteHusband();
            // пробуем удалить обоих партнеров (в функции удаления прописана проверка на оставшиеся связи)
            tree.removePerson(fPartner);
            tree.removePerson(sPartner);
            return true;
        }
        return false;
    }

    public void sortByName() {
        tree.sortByName();
    }

    public void sortByAge() {
        tree.sortByAge();
    }


    public void archiveToFile(String nameFile) throws IOException {
        FileManager arhive = new FileManager(nameFile);
        arhive.write(tree);

    }

    public void extractFromFile(String nameFile) throws IOException {
        FileManager arhive = new FileManager(nameFile);
        tree = arhive.read();
        int index = 0;
        for (Person item : tree) {
            if (item.getInn() > index) {
                index = item.getInn();
            }
        }
        this.inn = index + 1;
    }
}
