import java.util.*;

public class Main {
    public static void main(String[] args){
        Human person1 = new Human("Ivaniv", "Petr", Gender.Male);
        Human person2 = new Human("Ivanov", "Petr", Gender.Male);
        Human person3 = new Human("Ivanovа", "Nina", Gender.Female);
        Tree humanList = new Tree();
        humanList.addHuman(person1);
        humanList.addHuman(person2);
        humanList.addHuman(person3);
        System.out.println(humanList.getHumanInfo());
















    }


}


