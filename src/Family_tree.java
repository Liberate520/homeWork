package family_tree;

import java.util.HashSet;

public class Family_tree {

    private HashSet<Person> family;

    public Family_tree() {
        family = new HashSet<>();
    }


    public void addPerson(Person person) {

        this.family.add(person);

        if (person.getChildren() != null) {
            for (Person item : person.getChildren()) {
                this.family.add(item);
            }
        }
        if (person.getFather() != null) {
            this.family.add(person.getFather());
        }
        if (person.getMother() != null) {
            this.family.add(person.getMother());
        }
    }

    //TODO кого исключать из семейного дерева при разводе?
    public boolean divorce(Person fPartner, Person sPartner) {
        if (fPartner.divorce(sPartner)) {
            return true;
        }
        return false;
    }

    public void marriage(Person fPartner, Person sPartner) {

        if (fPartner.marriage(sPartner)) {
            this.family.add(fPartner);
            this.family.add(sPartner);
        }
    }

    public String getAllTreeStr() {

        if (this.family == null) {
            return "the tree is empty";
        } else {
            StringBuilder info = new StringBuilder();
            for (Person item : this.family) {
                info.append(item.getInfo());
                info.append("\n");
            }
            return new String(info);
        }

    }

    //TODO в процессе разработки. если удаляем человека из дерева - удаляем только его?
    public boolean removePerson(Person person){

        return this.family.remove(person);
    }


}
