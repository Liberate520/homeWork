import java.util.ArrayList;
import java.util.List;

public class Human extends ObjectResearcheble {
    private String name;
    private int id;
    private TypeOfGender typeOfGender;
    private Human Father;
    private Human Mother;

    private List<Human> children;

    private List<DegreeOfKinship> relationShip;

    public Human(String name, int id, TypeOfGender typeOfGender, Human father, Human mother) {
        this.name = name;
        this.id = id;
        this.typeOfGender = typeOfGender;
        Father = father;
        Mother = mother;
        children = new ArrayList<>();
        relationShip = new ArrayList<>();

    }

    public void addChildren(Human arg){
        children.add(arg);


    }


    public void addRelationShip(Human person_first,Human person_second, TypeOfRelationship typeOfRelationship){
        TypeOfRelationship temp = TypeOfRelationship.unknown;
        relationShip.add(new DegreeOfKinship(person_first, typeOfRelationship));
        switch (typeOfRelationship){
            case Wife -> temp = TypeOfRelationship.Husband;
            case Son -> temp =(person_second.getTypeOfGender() == TypeOfGender.Male) ?
                    TypeOfRelationship.Father : TypeOfRelationship.Mother;
        }
        person_first.getRelationShip().add(new DegreeOfKinship(person_second,temp));

    }

    public List<DegreeOfKinship> getRelationShip() {
        return relationShip;
    }

    public Human getMother() {
        return Mother;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TypeOfGender getTypeOfGender() {
        return typeOfGender;
    }



    public void setTypeOfGender(TypeOfGender typeOfGender) {
        this.typeOfGender = typeOfGender;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public Human getFather() {
        return Father;
    }

    public void setFather(Human father) {
        this.Father = father;
    }

    public Human getNameMother() {
        return Mother;
    }

    public void setNameMother(Human nameMother) {
        this.Mother = nameMother;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                '}';
    }



//    @Override
//    public int compareTo(Human person) {
//        return name.compareTo(person.getName());
//    }
    @Override
    public int compareTo(Human person) {
        return name.compareTo(person.getName());
    }
    @Override
    public int compareTo(ObjectResearcheble o) {
        return name.compareTo(o.getName());
    }
}
