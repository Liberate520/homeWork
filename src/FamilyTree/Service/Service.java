package FamilyTree.Service;

import FamilyTree.Person.Gender;
import FamilyTree.Person.Person;
import FamilyTree.Tree.FamilyTree;

import java.io.Serializable;
import java.time.LocalDate;

public class Service implements Serializable {
    private FamilyTree tree;
    private String family;
    public Service(String family) {
        this.family = family;
        tree = new FamilyTree();
    }

    public void addMember(Person person){
        tree.addPerson(person);
    }
    public void addMember(String name, String surname, Gender gender, LocalDate burnData) {
        tree.addPerson(new Person(name, surname, gender, burnData));
    }
    public void addChild(Person person){tree.addChild(person);}


    public String getFamilyName() { return family; }
    public FamilyTree getTree() { return tree; }
    public void sortByName(){ tree.sortByName(); }
    public void sortByAge(){ tree.sortByAge(); }

    private Integer getCountAdults(){
        Integer ad = 0;
        for (Person ps: tree.getListFamilyTree()) {
            if ((LocalDate.now().getYear() - LocalDate.from(ps.getBurnData()).getYear()) >= 18){
                ad++;
            }
        }
        return ad;
    }
    private  Integer getCountChildren(){
        Integer ch = 0;
        for (Person ps: tree.getListFamilyTree()) {
            if ((LocalDate.now().getYear() - LocalDate.from(ps.getBurnData()).getYear()) < 18){
                ch++;
            }
        }
        return ch;
    }
    private String getInfoShort(){
        return String.format("Семья %s, состоит из %d взрослых и %d детей.", getFamilyName(), getCountAdults(), getCountChildren());
    }
    @Override
    public String toString() { return getInfoShort(); }
}
