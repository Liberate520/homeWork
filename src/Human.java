public class Human {
    private String name;
    private int id;
    private TypeOfGender typeOfGender;
    private Human Father;
    private Human Mother;

    private Human Son;
    private Human Dauther;

    public Human(String name, int id, TypeOfGender typeOfGender, Human father, Human mother) {
        this.name = name;
        this.id = id;
        this.typeOfGender = typeOfGender;
        Father = father;
        Mother = mother;

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


}
