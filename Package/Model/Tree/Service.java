package Package.Model.Tree;

import java.time.LocalDate;

public class Service <E extends Tree> {
    private int id;
    private E treeList;
    public Service(E treeList) {
        this.treeList = treeList;
    }

    public void addMember(String name, String surname, LocalDate birthDate, LocalDate deathDate, Person father, Person mother){
        treeList.addMember(new Person(id++, name, surname, birthDate, deathDate, father, mother));
    }

    public void showTree(){
        treeList.showFamily();
    }
}
