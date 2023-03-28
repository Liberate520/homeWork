import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        
        List<Persona> family = new ArrayList<>();

        Persona persona1 = new Persona("Сергей", "Манеров", "18.04.1996");
        
        Persona persona2 = new Persona("Оксана", "Вилкова", "12.10.1976");

        Persona persona3 = new Persona("Денис", "Манеров", "11.10.1968");

        Persona persona4 = new Persona("Вероника", "Вилкова", "04.03.2006");


        family.add(persona1);
        family.add(persona2);
        family.add(persona3);
        family.add(persona4);

        persona2.addChildren(persona1);
        persona3.addChildren(persona1);
        persona2.addChildren(persona4);

        persona1.addMother(persona2);
        persona1.addFather(persona3);

        persona4.addMother(persona2);

        persona1.getFirstName();
        persona1.getSecondName();
        persona1.getDateOfBirth();
        persona1.getMother();
        persona1.getFather();
        persona1.getChildren();

        System.out.println(persona1);
        // System.out.println(persona2);
        System.out.println(family);

    }

}