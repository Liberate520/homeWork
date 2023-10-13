package Model.FamTree.Human;

public class HumanBuilder {
    int id;
    public Human createHuman(String name, String lastname, Gender sex, int age){
        return new Human(id++, name, lastname, sex, age);
    }
}
