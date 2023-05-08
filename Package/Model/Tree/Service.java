package Package.Model.Tree;

import Package.Model.WorkWithFiles.Writable;

import java.time.LocalDate;

public class Service {
    private int id = 1;
    private Writable writable;
    private final String filePath = "familyTree.txt";
    private Tree<Person> treeList;
    public Service(Tree<Person> treeList) {
        this.treeList = treeList;
    }

    public void addMember(String name, String surname, LocalDate birthDate, LocalDate deathDate, Integer fatherId, Integer motherId){
        treeList.addMember(new Person(id++, name, surname, birthDate, deathDate, treeList.setById(fatherId), treeList.setById(motherId)));
    }

    public void showTree(){
        System.out.println(treeList.showFamily());
    }

    public void deleteMember(int id){
        if (treeList.setById(id).getChildren() != null) {
            for (Person person: treeList.setById(id).getChildren()){
                person.setFather(null);
            }
        }
        if (treeList.setById(id - 1).getFather() != null){
            treeList.setById(id - 1).getFather().getChildren().remove(treeList.setById(id));
        }
        if (treeList.setById(id - 1).getMother() != null){
            treeList.setById(id - 1).getMother().getChildren().remove(treeList.getFamily().get(id - 1));
        }
        treeList.getFamily().remove(id - 1);
    }

    public int getSize() {
        return treeList.getFamily().size();
    }

    public void sortByName(){
        treeList.sortByName();
    }

    public void sortBySurname() {
        treeList.sortBySurname();
    }

    public void sortByBirthdate() {
        treeList.sortByBirthdate();
    }
    public boolean save(){
        if (writable == null){
            return false;
        }
        return writable.save(treeList, filePath);
    }

    public boolean load(){
        if (writable == null){
            return false;
        }
        treeList = (Tree<Person>) writable.read(filePath);
        return true;
    }
    public void setWritable(Writable writable) {
        this.writable = writable;
    }
}
